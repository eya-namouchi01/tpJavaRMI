package clientpackage;

import commonpackage.AnimalInterface;
import serverpackage.Animal;

import java.io.Serializable;
import java.rmi.RemoteException;

public class AnimalEnExtinction  extends Animal implements Serializable, AnimalInterface {
    private boolean protege; // S’il est sous protection légale ou non
    private String paysOrigine;


    public AnimalEnExtinction (String nom,String nomMaitre,String nomEspece,int dureeVie,
                               String race,String description, String paysOrigine, boolean protege) throws RemoteException {
        super(nom, nomMaitre,nomEspece, dureeVie, race, description);
        this.paysOrigine= paysOrigine;
        this.protege= protege;
    }

    public String identite()  {
        return "----- Identité de l'animal -----------\n" +
                "Nom              : " + getNom() + "\n" +
                "Nom du maître    : " + getNomMaitre() + "\n" +
                "Espèce           : " + getEspece().getNom() + "\n" +
                "Race             : " + getRace() + "\n" +
                "Pays d'origine : " +paysOrigine + "\n" +
                "Protégé par la loi : " + protege+ "\n" +
                "Dossier de suivi : " + (getDossier() != null ? getDossier().getDescription() : "Aucun dossier") + "\n" +
                "--------------------------------------\n";
    }
}