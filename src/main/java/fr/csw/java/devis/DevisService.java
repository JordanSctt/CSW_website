package fr.csw.java.devis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevisService {

    @Autowired
    private DevisRepository devisRepository;


    public Devis save(Devis devisRequest) {
        Devis newDevis = new Devis();
        newDevis.setPrenom(devisRequest.getPrenom());
        newDevis.setNom(devisRequest.getNom());
        newDevis.setEmail(devisRequest.getEmail());

        //------------------PRESTA MURS--------------------------
        newDevis.setQualitePrestationMurs(devisRequest.getQualitePrestationMurs());
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.PEINTURE_DE_PROPRETE) {
            newDevis.setPrixMetreCarrePrestationMurs(8);
        }
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationMurs(11);
        }
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.REPRISE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationMurs(12);
        }
        if (devisRequest.getQualitePrestationMurs() == QualitePrestationMurs.ENDUISAGE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationMurs(16);
        }
        newDevis.setSurfaceMurs(devisRequest.getSurfaceMurs());

        newDevis.setDetapissage(devisRequest.isDetapissage());
        newDevis.setSurfaceDetapissageMurs(devisRequest.getSurfaceDetapissageMurs());
        if (devisRequest.isDetapissage()) {
            newDevis.setPrixMetreCarreDetapissage(4);
            newDevis.setPrixTotalDetapissage(newDevis.getPrixMetreCarreDetapissage() * newDevis.getSurfaceDetapissageMurs());
        }
        newDevis.setPrixTotalPrestationMurs((newDevis.getPrixMetreCarrePrestationMurs() * newDevis.getSurfaceMurs()));

        //------------------PRESTA PLAFONDS----------------------
        newDevis.setQualitePrestationPlafonds(devisRequest.getQualitePrestationPlafonds());
        if (devisRequest.getQualitePrestationPlafonds() == QualitePrestationPlafonds.PEINTURE_DE_PROPRETE) {
            newDevis.setPrixMetreCarrePrestationPlafonds(9);
        }
        if (devisRequest.getQualitePrestationPlafonds() == QualitePrestationPlafonds.MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationPlafonds(12);
        }
        if (devisRequest.getQualitePrestationPlafonds() == QualitePrestationPlafonds.REPRISE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationPlafonds(13);
        }
        if (devisRequest.getQualitePrestationPlafonds() == QualitePrestationPlafonds.ENDUISAGE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationPlafonds(17);
        }
        newDevis.setSurfacePlafonds(devisRequest.getSurfacePlafonds());
        newDevis.setPrixTotalPrestationPlafonds(newDevis.getPrixMetreCarrePrestationPlafonds() * newDevis.getSurfacePlafonds());

        //------------------PRESTA BOISERIES----------------------
        newDevis.setQualitePrestationBoiseries(devisRequest.getQualitePrestationBoiseries());
        if (devisRequest.getQualitePrestationBoiseries() == QualitePrestationBoiseries.PEINTURE_DE_PROPRETE) {
            newDevis.setPrixMetreCarrePrestationBoiseries(10);
        }
        if (devisRequest.getQualitePrestationBoiseries() == QualitePrestationBoiseries.PONCAGE_ET_PEINTURE_DE_PROPRETE) {
            newDevis.setPrixMetreCarrePrestationBoiseries(13);
        }
        if (devisRequest.getQualitePrestationBoiseries() == QualitePrestationBoiseries.PONCAGE_ET_MISE_EN_PEINTURE) {
            newDevis.setPrixMetreCarrePrestationBoiseries(15);
        }
        newDevis.setSurfaceBoiseries(devisRequest.getSurfaceBoiseries());
        newDevis.setPrixTotalPrestationBoiseries(newDevis.getPrixMetreCarrePrestationBoiseries() * newDevis.getSurfaceBoiseries());

        //------------------PRIX TOTAL DEVIS--------------------
        newDevis.setPrixTotalDevis(newDevis.getPrixTotalDetapissage() + newDevis.getPrixTotalPrestationMurs() + newDevis.getPrixTotalPrestationPlafonds() + newDevis.getPrixTotalPrestationBoiseries());
        devisRepository.save(newDevis);
        return newDevis;
    }


}
