package commonpackage;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CabinetInterface extends Remote {
     void ajouterClient (ClientInterface client) throws RemoteException;
     void deleteClient (ClientInterface client) throws RemoteException;
     String rechercherAnimal(String nom) throws RemoteException;
     void ajouterAnimal(String nomAnimal,String nomMaitre, String nomEspece, int dureeVie, String nomRace
             , String descriptionDossier) throws RemoteException;
     void ajouterAnimal(AnimalInterface animal) throws RemoteException;
    List<AnimalInterface> getAnimaux() throws RemoteException;
}
