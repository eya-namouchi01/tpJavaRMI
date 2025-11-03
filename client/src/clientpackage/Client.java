package clientpackage;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import commonpackage.*;

import javax.swing.*;


public class Client implements ClientInterface, Serializable {
    private Registry registry;
    private CabinetInterface cabinet;

    protected Client() throws RemoteException {
        registry = null;
        cabinet = null;
    }

    public void startClient() throws RemoteException {
        try {
            this.registry = LocateRegistry.getRegistry();
            this.cabinet = (CabinetInterface) registry.lookup("Cabinet");
            this.cabinet.ajouterClient(this);
            System.out.println("VOUS ETES MAINTENANT CONNECTE!.\n");
        } catch (NotBoundException e){
            e.printStackTrace();
        }
    }
    public void exitClient() throws RemoteException{
            cabinet.deleteClient(this);
            System.out.println("EXITED, MERCI. \n");
    }
    public void displayCabinet() throws RemoteException {
        if(cabinet != null){
            System.out.println("         ANIMAUX DU CABINET         ");
            System.out.println("--------------------------------------");
            int i = 1;
            for (AnimalInterface animal : cabinet.getAnimaux()) {
                System.out.println("-------------ANIMAL " + i + "---------------");
                System.out.println(animal.identite());
                i++;
            }
        }
        else{System.out.println("PAS D'ANIMAUX DANS LE CABINET");}
    }
    public void ajouterAnimal(String nomAnimal, String nomMaitre, String espece, int dureeVie, String race, String dossier) throws RemoteException {
        this.cabinet.ajouterAnimal(nomAnimal,nomMaitre,espece,dureeVie,race,dossier);
        System.out.println(nomAnimal + " est ajouté au cabinet\n");
    }
    public void ajouterAnimal(AnimalInterface animal) throws RemoteException {
        this.cabinet.ajouterAnimal(animal);
        System.out.println(animal.getNom() + " est ajouté au cabinet\n");}

    public void recupererAnimal(String nomAnimal) throws RemoteException{
        System.out.println(cabinet.rechercherAnimal(nomAnimal));
    }
    public void alerterClient(String message)  {
        JDialog dialog = new JOptionPane(
                message,
                JOptionPane.INFORMATION_MESSAGE
        ).createDialog("Server Alert");

        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);


    }

}
