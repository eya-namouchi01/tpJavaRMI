package serverpackage;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Serveur {
    public Serveur(){}
    public static void main(String [] args){
        try{

            System.setProperty("java.security.policy", "./security.policy");
            SecurityManager securityManager = new SecurityManager();
            System.setSecurityManager(securityManager);
            System.setProperty("java.rmi.server.codebase", "http://localhost:8000/");

            Animal a1 = new Animal("Rex", "Dupont Julien", "Chien",13, "Berger Allemand", "Vacciné et en bonne santé");

            Cabinet cabinet = new Cabinet(){};
            cabinet.ajouterAnimal(a1);
            Registry registry = LocateRegistry.createRegistry(1099);
            if (registry==null){
            System.err.println("RmiRegistry not found");
            }
           else {
            registry.bind("Cabinet", cabinet);
            System.err.println("Server is ready");
        }
    }
    catch(Exception e){
            System.err.println("Server exception"+e);
        }
    }

}
