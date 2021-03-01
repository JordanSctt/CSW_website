package fr.csw.java.devis;

import javax.persistence.*;

@Entity
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    //------------------INFO PERSO---------------------------
    private String prenom;
    private String nom;
    private String email;

    //------------------PRESTA MURS--------------------------
    private boolean detapissage;
    private int prixMetreCarreDetapissage;
    private int prixTotalDetapissage;
    private int surfaceDetapissageMurs;
    @Enumerated(EnumType.STRING)
    private QualitePrestationMurs qualitePrestationMurs;
    private int prixMetreCarrePrestationMurs;
    private int surfaceMurs;
    private int prixTotalPrestationMurs;

    //------------------PRESTA PLAFONDS----------------------
    @Enumerated(EnumType.STRING)
    private QualitePrestationPlafonds qualitePrestationPlafonds;
    private int prixMetreCarrePrestationPlafonds;
    private int surfacePlafonds;
    private int prixTotalPrestationPlafonds;

    //------------------PRESTA BOISERIES----------------------
    @Enumerated(EnumType.STRING)
    private QualitePrestationBoiseries qualitePrestationBoiseries;
    private int prixMetreCarrePrestationBoiseries;
    private int surfaceBoiseries;
    private int prixTotalPrestationBoiseries;


    private int prixTotalDevis;


    //-----------------------------------------------


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDetapissage() {
        return detapissage;
    }

    public String valueOfisDetapissage() {
        if (detapissage) {
            return "Détapissage choisi";
        } else {
            return "Détapissage non choisi";
        }
    }

    public void setDetapissage(boolean détapissage) {
        this.detapissage = détapissage;
    }

    public int getPrixMetreCarreDetapissage() {
        return prixMetreCarreDetapissage;
    }

    public void setPrixMetreCarreDetapissage(int prixMetreCarreDetapissage) {
        this.prixMetreCarreDetapissage = prixMetreCarreDetapissage;
    }

    public int getPrixTotalDetapissage() {
        return prixTotalDetapissage;
    }

    public void setPrixTotalDetapissage(int prixTotalDetapissage) {
        this.prixTotalDetapissage = prixTotalDetapissage;
    }

    public int getSurfaceDetapissageMurs() {
        return surfaceDetapissageMurs;
    }

    public void setSurfaceDetapissageMurs(int surfaceDetapissageMurs) {
        this.surfaceDetapissageMurs = surfaceDetapissageMurs;
    }

    public QualitePrestationMurs getQualitePrestationMurs() {
        return qualitePrestationMurs;
    }

    public void setQualitePrestationMurs(QualitePrestationMurs qualitePrestationMurs) {
        this.qualitePrestationMurs = qualitePrestationMurs;
    }

    public int getPrixMetreCarrePrestationMurs() {
        return prixMetreCarrePrestationMurs;
    }

    public void setPrixMetreCarrePrestationMurs(int prixMetreCarrePrestationMurs) {
        this.prixMetreCarrePrestationMurs = prixMetreCarrePrestationMurs;
    }

    public int getSurfaceMurs() {
        return surfaceMurs;
    }

    public void setSurfaceMurs(int surfaceMurs) {
        this.surfaceMurs = surfaceMurs;
    }

    public int getPrixTotalPrestationMurs() {
        return prixTotalPrestationMurs;
    }

    public void setPrixTotalPrestationMurs(int prixTotalPrestationMurs) {
        this.prixTotalPrestationMurs = prixTotalPrestationMurs;
    }

    public QualitePrestationPlafonds getQualitePrestationPlafonds() {
        return qualitePrestationPlafonds;
    }

    public void setQualitePrestationPlafonds(QualitePrestationPlafonds qualitePrestationPlafonds) {
        this.qualitePrestationPlafonds = qualitePrestationPlafonds;
    }

    public int getPrixMetreCarrePrestationPlafonds() {
        return prixMetreCarrePrestationPlafonds;
    }

    public void setPrixMetreCarrePrestationPlafonds(int prixMetreCarrePrestationPlafonds) {
        this.prixMetreCarrePrestationPlafonds = prixMetreCarrePrestationPlafonds;
    }

    public int getSurfacePlafonds() {
        return surfacePlafonds;
    }

    public void setSurfacePlafonds(int surfacePlafonds) {
        this.surfacePlafonds = surfacePlafonds;
    }

    public int getPrixTotalPrestationPlafonds() {
        return prixTotalPrestationPlafonds;
    }

    public void setPrixTotalPrestationPlafonds(int prixTotalPrestationPlafonds) {
        this.prixTotalPrestationPlafonds = prixTotalPrestationPlafonds;
    }

    public QualitePrestationBoiseries getQualitePrestationBoiseries() {
        return qualitePrestationBoiseries;
    }

    public void setQualitePrestationBoiseries(QualitePrestationBoiseries qualitePrestationBoiseries) {
        this.qualitePrestationBoiseries = qualitePrestationBoiseries;
    }

    public int getPrixMetreCarrePrestationBoiseries() {
        return prixMetreCarrePrestationBoiseries;
    }

    public void setPrixMetreCarrePrestationBoiseries(int prixMetreCarrePrestationBoiseries) {
        this.prixMetreCarrePrestationBoiseries = prixMetreCarrePrestationBoiseries;
    }

    public int getSurfaceBoiseries() {
        return surfaceBoiseries;
    }

    public void setSurfaceBoiseries(int surfaceBoiseries) {
        this.surfaceBoiseries = surfaceBoiseries;
    }

    public int getPrixTotalPrestationBoiseries() {
        return prixTotalPrestationBoiseries;
    }

    public void setPrixTotalPrestationBoiseries(int prixTotalPrestationBoiseries) {
        this.prixTotalPrestationBoiseries = prixTotalPrestationBoiseries;
    }

    public int getPrixTotalDevis() {
        return prixTotalDevis;
    }

    public void setPrixTotalDevis(int prixTotalDevis) {
        this.prixTotalDevis = prixTotalDevis;
    }

    @Override
    public String toString() {
        return "Devis{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", detapissage=" + detapissage +
                ", prixMetreCarreDetapissage=" + prixMetreCarreDetapissage +
                ", prixTotalDetapissage=" + prixTotalDetapissage +
                ", surfaceDetapissageMurs=" + surfaceDetapissageMurs +
                ", qualitePrestationMurs=" + qualitePrestationMurs +
                ", prixMetreCarrePrestationMurs=" + prixMetreCarrePrestationMurs +
                ", surfaceMurs=" + surfaceMurs +
                ", prixTotalPrestationMurs=" + prixTotalPrestationMurs +
                ", qualitePrestationPlafonds=" + qualitePrestationPlafonds +
                ", prixMetreCarrePrestationPlafonds=" + prixMetreCarrePrestationPlafonds +
                ", surfacePlafonds=" + surfacePlafonds +
                ", prixTotalPrestationPlafonds=" + prixTotalPrestationPlafonds +
                ", qualitePrestationBoiseries=" + qualitePrestationBoiseries +
                ", prixMetreCarrePrestationBoiseries=" + prixMetreCarrePrestationBoiseries +
                ", surfaceBoiseries=" + surfaceBoiseries +
                ", prixTotalPrestationBoiseries=" + prixTotalPrestationBoiseries +
                ", prixTotalDevis=" + prixTotalDevis +
                '}';
    }
}
