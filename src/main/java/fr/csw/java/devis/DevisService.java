package fr.csw.java.devis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevisService {

    @Autowired
    private DevisRepository devisRepository;

    private final int prixMcMursProprete = 8;
    private final int prixMcMursPeinture = 11;
    private final int prixMcMursReprisePeinture = 12;
    private final int prixMcMursEnduitPeinture = 16;
    private final int prixMcMursDetapissage = 4;

    private final int prixMcPlafondsProprete = 9;
    private final int prixMcPlafondsPeinture = 12;
    private final int prixMcPlafondsReprisePeinture = 13;
    private final int prixMcPlafondsEnduitPeinture = 17;

    private final int prixMcBoisProprete = 10;
    private final int prixMcBoisPoncageProprete = 13;
    private final int prixMcBoisPoncagePeinture = 15;

    private final int prixPrestaNul = 0;



    public Devis save(Devis devisRequest) {
        Devis newDevis = new Devis();
        newDevis.setPrenom(devisRequest.getPrenom());
        newDevis.setNom(devisRequest.getNom());
        newDevis.setEmail(devisRequest.getEmail());

        //------------------PRESTA MURS--------------------------
        newDevis.setQualitePrestationMurs(devisRequest.getQualitePrestationMurs());
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.NO_CHOICE) {
            newDevis.setPrixMetreCarrePrestationMurs(prixPrestaNul);
        }
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.PEINTURE_DE_PROPRETE) {
            newDevis.setPrixMetreCarrePrestationMurs(prixMcMursProprete);
        }
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationMurs(prixMcMursPeinture);
        }
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.REPRISE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationMurs(prixMcMursReprisePeinture);
        }
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.ENDUISAGE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationMurs(prixMcMursEnduitPeinture);
        }
        newDevis.setSurfaceMurs(devisRequest.getSurfaceMurs());

        newDevis.setDetapissage(devisRequest.isDetapissage());
        newDevis.setSurfaceDetapissageMurs(devisRequest.getSurfaceDetapissageMurs());
        if (devisRequest.isDetapissage()) {
            newDevis.setPrixMetreCarreDetapissage(prixMcMursDetapissage);
            newDevis.setPrixTotalDetapissage(newDevis.getPrixMetreCarreDetapissage() * newDevis.getSurfaceDetapissageMurs());
        }
        newDevis.setPrixTotalPrestationMurs((newDevis.getPrixMetreCarrePrestationMurs() * newDevis.getSurfaceMurs()));

        //------------------PRESTA PLAFONDS----------------------
        newDevis.setQualitePrestationPlafonds(devisRequest.getQualitePrestationPlafonds());
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.NO_CHOICE) {
            newDevis.setPrixMetreCarrePrestationMurs(prixPrestaNul);
        }
        if (devisRequest.getQualitePrestationPlafonds() == QualitePrestationPlafonds.PEINTURE_DE_PROPRETE) {
            newDevis.setPrixMetreCarrePrestationPlafonds(prixMcPlafondsProprete);
        }
        if (devisRequest.getQualitePrestationPlafonds() == QualitePrestationPlafonds.MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationPlafonds(prixMcPlafondsPeinture);
        }
        if (devisRequest.getQualitePrestationPlafonds() == QualitePrestationPlafonds.REPRISE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationPlafonds(prixMcPlafondsReprisePeinture);
        }
        if (devisRequest.getQualitePrestationPlafonds() == QualitePrestationPlafonds.ENDUISAGE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationPlafonds(prixMcPlafondsEnduitPeinture);
        }
        newDevis.setSurfacePlafonds(devisRequest.getSurfacePlafonds());
        newDevis.setPrixTotalPrestationPlafonds(newDevis.getPrixMetreCarrePrestationPlafonds() * newDevis.getSurfacePlafonds());

        //------------------PRESTA BOISERIES----------------------
        newDevis.setQualitePrestationBoiseries(devisRequest.getQualitePrestationBoiseries());
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.NO_CHOICE) {
            newDevis.setPrixMetreCarrePrestationMurs(prixPrestaNul);
        }
        if (devisRequest.getQualitePrestationBoiseries() == QualitePrestationBoiseries.PEINTURE_DE_PROPRETE) {
            newDevis.setPrixMetreCarrePrestationBoiseries(prixMcBoisProprete);
        }
        if (devisRequest.getQualitePrestationBoiseries() == QualitePrestationBoiseries.PONCAGE_ET_PEINTURE_DE_PROPRETE) {
            newDevis.setPrixMetreCarrePrestationBoiseries(prixMcBoisPoncageProprete);
        }
        if (devisRequest.getQualitePrestationBoiseries() == QualitePrestationBoiseries.PONCAGE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationBoiseries(prixMcBoisPoncagePeinture);
        }
        newDevis.setSurfaceBoiseries(devisRequest.getSurfaceBoiseries());
        newDevis.setPrixTotalPrestationBoiseries(newDevis.getPrixMetreCarrePrestationBoiseries() * newDevis.getSurfaceBoiseries());

        //------------------PRIX TOTAL DEVIS--------------------
        newDevis.setPrixTotalDevis(newDevis.getPrixTotalDetapissage() + newDevis.getPrixTotalPrestationMurs() + newDevis.getPrixTotalPrestationPlafonds() + newDevis.getPrixTotalPrestationBoiseries());
        devisRepository.save(newDevis);
        return newDevis;
    }


}
