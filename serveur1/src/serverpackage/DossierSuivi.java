package serverpackage;

import java.io.Serializable;

public class DossierSuivi implements Serializable {
    private String description;
    public DossierSuivi(String description){this .description= description;}


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
