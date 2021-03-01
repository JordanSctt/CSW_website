package fr.csw.java.devis;

public enum QualitePrestationMurs {

    PEINTURE_DE_PROPRETE, MISE_EN_PEINTURE, REPRISE_ET_MISE_EN_PEINTURE, ENDUISAGE_ET_MISE_EN_PEINTURE, NO_CHOICE;

    public String labelQualiteMurs() {
        switch (this) {
            case PEINTURE_DE_PROPRETE:
                return "Peinture de propreté";
            case MISE_EN_PEINTURE:
                return "peinture en trois couches";
            case REPRISE_ET_MISE_EN_PEINTURE:
                return "Reprises et peinture en trois couches";
            case ENDUISAGE_ET_MISE_EN_PEINTURE:
                return "Enduisage et peinture en trois couches";
            case NO_CHOICE:
                return "Non renseigné";
            default:
                return "";
        }
    }

}
