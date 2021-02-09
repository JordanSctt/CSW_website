package fr.csw.java.devis;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class DevisPDFExporter {

    private Optional<Devis> devis;

    public DevisPDFExporter(Optional<Devis> devis) {
        this.devis = devis;
    }


    //---------------TABLE MURS-----------------------
    private void writeTableHeaderMurs(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.LIGHT_GRAY);
        cell.setPadding(5);
        Font fontHeaderTable = FontFactory.getFont(FontFactory.HELVETICA);

        cell.setPhrase(new Phrase("Qualitée presta. mur(s)", fontHeaderTable));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Prix M2 presta. mur(s)", fontHeaderTable));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Surface mur(s)", fontHeaderTable));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Prix total presta. mur(s)", fontHeaderTable));
        table.addCell(cell);
    }
    private void writeTableDataMurs(PdfPTable table) {
        table.addCell(devis.get().getQualitePrestationMurs().toString());
        table.addCell(String.valueOf(devis.get().getPrixMetreCarrePrestationMurs()) + " €");
        table.addCell(String.valueOf(devis.get().getSurfaceMurs()) + " m2");
        table.addCell(String.valueOf(devis.get().getPrixTotalPrestationMurs()) + " €");
    }

    //---------------TABLE PLAFONDS-----------------------
    private void writeTableHeaderPlafonds(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.LIGHT_GRAY);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);

        cell.setPhrase(new Phrase("Qualitée presta. plafond(s)", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Prix M2 presta. plafond(s)", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Surface plafond(s)", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Prix total presta. plafond(s)", font));
        table.addCell(cell);
    }
    private void writeTableDataPlafonds(PdfPTable table) {
        table.addCell(devis.get().getQualitePrestationPlafonds().toString());
        table.addCell(String.valueOf(devis.get().getPrixMetreCarrePrestationPlafonds()) + " €");
        table.addCell(String.valueOf(devis.get().getSurfacePlafonds()) + " m2");
        table.addCell(String.valueOf(devis.get().getPrixTotalPrestationPlafonds()) + " €");
    }

    //---------------TABLE BOISERIES-----------------------
    private void writeTableHeaderBoiseries(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.LIGHT_GRAY);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);

        cell.setPhrase(new Phrase("Qualitée presta. Boiserie(s)", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Prix M2 presta. Boiserie(s)", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Surface Boiserie(s)", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Prix total presta. Boiserie(s)", font));
        table.addCell(cell);
    }
    private void writeTableDataBoiseries(PdfPTable table) {
        table.addCell(devis.get().getQualitePrestationBoiseries().toString());
        table.addCell(String.valueOf(devis.get().getPrixMetreCarrePrestationBoiseries()) + " €");
        table.addCell(String.valueOf(devis.get().getSurfaceBoiseries()) + " m2");
        table.addCell(String.valueOf(devis.get().getPrixTotalPrestationBoiseries()) + " €");
    }
    //------------------------------------------------------

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setColor(Color.BLACK);
        fontTitle.setSize(20);
        Paragraph title = new Paragraph("Détail de votre estimation de devis sur le site CSW Peinture", fontTitle);
        title.setSpacingAfter(20);
        title.setAlignment(1);
        document.add(title);

        Font fontSecTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontSecTitle.setColor(Color.BLACK);
        fontSecTitle.setSize(15);

        Paragraph secTitleInfo = new Paragraph("Informations personnel:", fontSecTitle);
        secTitleInfo.setSpacingBefore(15);
        secTitleInfo.setSpacingAfter(10);
        document.add(secTitleInfo);

        Font fontInfo = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontInfo.setColor(Color.BLACK);
        fontInfo.setSize(10);
        fontInfo.setStyle(2);
        Paragraph prenomInfo = new Paragraph("Prénom: " + devis.get().getPrenom(), fontInfo);
        prenomInfo.setSpacingAfter(5);
        document.add(prenomInfo);
        Paragraph nomInfo = new Paragraph("Nom: " + devis.get().getNom(), fontInfo);
        nomInfo.setSpacingAfter(5);
        document.add(nomInfo);
        Paragraph emailInfo = new Paragraph("Email: " + devis.get().getEmail(), fontInfo);
        emailInfo.setSpacingAfter(5);
        document.add(emailInfo);

        Font fontInfoCsw = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontInfoCsw.setColor(Color.BLACK);
        fontInfoCsw.setSize(10);
        fontInfoCsw.setStyle(2);
        Paragraph prenomNomInfo = new Paragraph("Samuel-Weis Colin ", fontInfoCsw);
        prenomNomInfo.setSpacingAfter(5);
        prenomNomInfo.setAlignment(2);
        document.add(prenomNomInfo);
        Paragraph roleInfo = new Paragraph("Peintre applicateur de revêtement", fontInfoCsw);
        roleInfo.setSpacingAfter(5);
        roleInfo.setAlignment(2);
        document.add(roleInfo);
        Paragraph emailCswInfo = new Paragraph("colinsw@hotmail.fr", fontInfoCsw);
        emailCswInfo.setSpacingAfter(5);
        emailCswInfo.setAlignment(2);
        document.add(emailCswInfo);
        Paragraph telCswInfo = new Paragraph("06 14 26 31 83", fontInfoCsw);
        telCswInfo.setSpacingAfter(5);
        telCswInfo.setAlignment(2);
        document.add(telCswInfo);
        Paragraph adresseCswInfo = new Paragraph("Rue St Eloi 13480 Cabries", fontInfoCsw);
        adresseCswInfo.setSpacingAfter(5);
        adresseCswInfo.setAlignment(2);
        document.add(adresseCswInfo);

        Paragraph secTitleMurs = new Paragraph("Détail prestation mur(s):", fontSecTitle);
        secTitleMurs.setSpacingBefore(15);
        secTitleMurs.setSpacingAfter(5);
        secTitleMurs.setAlignment(1);
        document.add(secTitleMurs);

        PdfPTable tableMurs = new PdfPTable(4);
        tableMurs.setWidthPercentage(100);
        tableMurs.setSpacingBefore(5);
        tableMurs.setWidths(new float[] {4f, 1.5f, 1.5f, 1.5f});
        writeTableHeaderMurs(tableMurs);
        writeTableDataMurs(tableMurs);
        document.add(tableMurs);

        Paragraph secTitlePlafonds = new Paragraph("Détail prestation plafond(s):", fontSecTitle);
        secTitlePlafonds.setSpacingBefore(15);
        secTitlePlafonds.setSpacingAfter(5);
        secTitlePlafonds.setAlignment(1);
        document.add(secTitlePlafonds);

        PdfPTable tablePlafonds = new PdfPTable(4);
        tablePlafonds.setWidthPercentage(100);
        tablePlafonds.setSpacingBefore(5);
        tablePlafonds.setWidths(new float[] {4f, 1.5f, 1.5f, 1.5f});
        writeTableHeaderPlafonds(tablePlafonds);
        writeTableDataPlafonds(tablePlafonds);
        document.add(tablePlafonds);

        Paragraph secTitleBoiseries = new Paragraph("Détail prestation boiserie(s):", fontSecTitle);
        secTitleBoiseries.setSpacingBefore(15);
        secTitleBoiseries.setSpacingAfter(5);
        secTitleBoiseries.setAlignment(1);
        document.add(secTitleBoiseries);

        PdfPTable tableBoiseries = new PdfPTable(4);
        tableBoiseries.setWidthPercentage(100);
        tableBoiseries.setSpacingBefore(5);
        tableBoiseries.setWidths(new float[] {4f, 1.5f, 1.5f, 1.5f});
        writeTableHeaderBoiseries(tableBoiseries);
        writeTableDataBoiseries(tableBoiseries);
        document.add(tableBoiseries);

        Font fontPrixtotal = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontPrixtotal.setColor(Color.BLACK);
        fontPrixtotal.setSize(15);
        Paragraph prixTotal = new Paragraph("Prix total de l'estimation de devis: " + devis.get().getPrixTotalDevis() + " €", fontPrixtotal);
        prixTotal.setSpacingBefore(10);
        prixTotal.setAlignment(1);
        document.add(prixTotal);

        document.close();

    }
}
