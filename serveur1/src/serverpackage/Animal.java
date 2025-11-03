package serverpackage;

import commonpackage.*;

import java.io.Serializable;
import java.rmi.RemoteException;
// Si vous voulez que cette classe sera distribuée
//public class serverpackage.Animal extends UnicastRemoteObject implements AnimalInterface {
    public class Animal implements Serializable, AnimalInterface {

    private Espece espece;
    private String nom;
    private String race;
    private String nomMaitre;
    private DossierSuivi dossier;

    public Animal() throws RemoteException{}

    public Animal(String nom, Espece espece,String race,String nomMaitre, DossierSuivi dossier) throws RemoteException{
        this.nom = nom;
        this.race= race;
        this.espece= espece;
        this.nomMaitre= nomMaitre;
        this.dossier=dossier;
    }
    public Animal(String nom, String nomMaitre,String nomEspece, int dureeVie,String race,String description) throws RemoteException{
        this.nom = nom;
        this.race= race;
        this.nomMaitre= nomMaitre;
        this.dossier=new DossierSuivi(description);
        this.espece= new Espece(nomEspece, dureeVie);
    }

    public String identite()  {
        return "----- Identité de l'animal -----------\n" +
                "Nom              : " + nom + "\n" +
                "Nom du maître    : " + nomMaitre + "\n" +
                "Espèce           : " + espece.getNom() + "\n" +
                "Race             : " + race + "\n" +
                "Dossier de suivi : " + (dossier != null ? dossier.getDescription() : "Aucun dossier") + "\n" +
                "--------------------------------------\n";
    }

    public void afficheIdentite() {
        System.out.println("----- Identité de l'animal -----------\n" +
                "Nom              : " + nom + "\n" +
                "Nom du maître    : " + nomMaitre + "\n" +
                "Espèce           : " + espece.getNom() + "\n" +
                "Race             : " + race + "\n" +
                "Dossier de suivi : " + (dossier != null ? dossier.getDescription() : "Aucun dossier") + "\n" +
                "--------------------------------------\n");
    }
    public void modifierDossier(String description){if (this.getDossier() == null) {
        this.setDossier(new DossierSuivi(description));
    }
        this.getDossier().setDescription(description);}

    public DossierSuivi getDossier() {
        return dossier;
    }
    public void setDossier(DossierSuivi dossier ) {
        this.dossier = dossier;
    }

    public Espece getEspece() {
        return espece;
    }
    public String getRace() {
        return race;
    }
    public String getNomMaitre() {
        return nomMaitre;
    }
    public String getNom() {
        return nom;
    }

}
