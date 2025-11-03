package serverpackage;
import commonpackage.AnimalInterface;
import commonpackage.CabinetInterface;
import commonpackage.ClientInterface;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Cabinet extends UnicastRemoteObject implements CabinetInterface {
    private List<AnimalInterface> animaux;
    private List<ClientInterface> clients;

    public Cabinet() throws RemoteException {
        this.animaux = new ArrayList<>();
        this.clients = new ArrayList<>();
    }


    public String rechercherAnimal(String nom) throws RemoteException {
        for (AnimalInterface animal : animaux) {
            if (animal.getNom().equals(nom)) return animal.identite();
        }
        return ("Animal "+ nom+ " non trouvé");

    }

    public void ajouterAnimal(String nomAnimal,String nomMaitre, String nomEspece, int dureeVie, String nomRace
                              , String descriptionDossier) throws RemoteException {
        Animal animal = new Animal(nomAnimal,nomMaitre,nomEspece,dureeVie,nomRace,descriptionDossier);
        this.animaux.add(animal);
        System.out.println("L'animal a été ajouté");
        if(animaux.size()>=3){
          for (ClientInterface client : this.clients){
                client.alerterClient("On a plus de 100 animaux dans le cabinet!");
            }
        }
    }

    public void ajouterAnimal(AnimalInterface animal) throws RemoteException {
        this.animaux.add(animal);
        System.out.println("L'animal a été ajouté");
        if(animaux.size()>=3){
            for (ClientInterface client : this.clients){
                client.alerterClient("On a plus de 100 animaux dans le cabinet!");
            }
        }
    }

    public void ajouterClient(ClientInterface client) throws RemoteException{
        this.clients.add(client);
    }

    public void deleteClient(ClientInterface client) throws RemoteException{
        for (int i = 0; i < clients.size(); i++) {
            if (client.equals(clients.get(i))) {
                clients.remove(i);
            }
        }
    }

    public List<AnimalInterface> getAnimaux() throws RemoteException {
        return this.animaux;
    }

}