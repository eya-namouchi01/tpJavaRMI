package serverpackage;

import java.io.Serializable;

public class Espece implements Serializable {

    private String nom;
    private int dureeDeVie;

    public Espece(String nom, int dureeDeVie){
        this.nom = nom;
        this.dureeDeVie= dureeDeVie;
    }


    public String getNom() {
        return nom;
    }

    public int getDureeDeVie() {
        return dureeDeVie;
    }
}
