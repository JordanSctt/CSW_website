package fr.csw.java.devis;

public enum QualitePrestationBoiseries {

    PEINTURE_DE_PROPRETE, PONCAGE_ET_PEINTURE_DE_PROPRETE, PONCAGE_ET_MISE_EN_PEINTURE, NO_CHOICE;

    public String labelQualiteBois() {
        switch (this) {
            case PEINTURE_DE_PROPRETE:
                return "Peinture de propreté";
            case PONCAGE_ET_PEINTURE_DE_PROPRETE:
                return "Ponçage et peinture de propreté";
            case PONCAGE_ET_MISE_EN_PEINTURE:
                return "Ponçage et mise en peinture";
            case NO_CHOICE:
                return "Non renseigné";
            default:
                return "";
        }
    }

}
