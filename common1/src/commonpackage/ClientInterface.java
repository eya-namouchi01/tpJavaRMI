package commonpackage;

import java.rmi.RemoteException;

public interface ClientInterface {
     void startClient() throws RemoteException;
     void ajouterAnimal(AnimalInterface animal) throws RemoteException;
     void ajouterAnimal(String nomAnimal, String nomMaitre, String espece, int dureeVie, String race, String dossier) throws RemoteException;
     void recupererAnimal(String nomAnimal) throws RemoteException;
     void alerterClient(String message);
     void displayCabinet() throws RemoteException;
     void exitClient() throws RemoteException;
}
