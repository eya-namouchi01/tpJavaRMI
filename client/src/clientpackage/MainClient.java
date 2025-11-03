package clientpackage;

import java.rmi.RemoteException;
import java.util.Scanner;

public class MainClient {
    public static void main(String [] args) throws RemoteException {
        Client client = new Client();
        client.startClient();
        System.out.println("         BIENVENU A BORD         ");
        System.out.println("--------------------------------------");
        int choix=-1;
        while (choix<6){
            System.out.println("TAPER:");
            System.out.println("1: Apercu cabinet, 2: Ajouter animal, 3: Ajouter animal SPECIAL, 4:Rechercher Animal, 5:Quitter");
            Scanner in = new Scanner(System.in);
            choix = in.nextInt();
            switch(choix){
                case 1:
                    client.displayCabinet();
                    System.out.println("--------------------------------------");
                    break;
                case 2:
                    System.out.println("Passer les informations de l'animal");
                    Scanner input = new Scanner(System.in);
                    System.out.println("Nom animal:");
                    String nomAnimal = input.nextLine().trim();
                    System.out.println("Espece:");
                    String espece = input.nextLine().trim();
                    System.out.println("Durée de vie:");
                    int dureeVie = input.nextInt();
                    input.nextLine();
                    System.out.println("Race:");
                    String race = input.nextLine().trim();
                    System.out.println("Nom Maitre:");
                    String nomMaitre = input.nextLine().trim();
                    System.out.println("Descriptions");
                    String dossier = input.nextLine().trim();
                    client.ajouterAnimal(nomAnimal, nomMaitre,espece,dureeVie, race, dossier);
                    System.out.println("--------------------------------------");
                    break;
                case 4:
                    System.out.println("Passer le nom de l'animal");
                    in.nextLine();
                    nomAnimal = in.nextLine().trim();
                    client.recupererAnimal(nomAnimal);
                    System.out.println("--------------------------------------");
                    break;
                    case 3:
                    System.out.println("Passer les informations de l'animal");
                    in.nextLine();
                    System.out.println("Nom animal:");
                    nomAnimal = in.nextLine().trim();
                    System.out.println("Espece:");
                    espece = in.nextLine().trim();
                    System.out.println("Durée de vie:");
                    dureeVie = in.nextInt();
                    in.nextLine();
                    System.out.println("Race:");
                    race = in.nextLine().trim();
                    System.out.println("Nom Maitre:");
                    nomMaitre = in.nextLine().trim();
                    System.out.println("Descriptions");
                    dossier = in.nextLine().trim();
                    System.out.println("Pays d'origine");
                    String paysOrigine = in.nextLine().trim();
                    System.out.println("Est-ce que cet animal est protégé par la loi dans son pays ou au niveau international ?\n(oui/non)");
                    String reponse = in.next().trim().toLowerCase();
                    boolean protege = reponse.equals("oui") || reponse.equals("o") || reponse.equals("yes");

                    AnimalEnExtinction animalspecial= new AnimalEnExtinction(nomAnimal, nomMaitre, espece, 20, race,dossier,paysOrigine,protege);
                    client.ajouterAnimal(animalspecial);
                    System.out.println("--------------------------------------");
                    break;

                    case 5:
                client.exitClient();
                System.exit(0);
                break;


            }

        }


        //
    }
}
