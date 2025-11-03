package commonpackage;
import serverpackage.*;

public  interface AnimalInterface {
     String getNom();
     String identite() ;
     void afficheIdentite();
     DossierSuivi getDossier()  ;
     void modifierDossier(String description);
     Espece getEspece();
    }
