package com.project.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {
    
    public static void addTableHeader(PdfPTable table, String[] headers) throws DocumentException {
        // Create the header row cell style
        PdfPCell h;


        for (String header : headers) {
            h = new PdfPCell(new Phrase(header, new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
            h.setFixedHeight(23f);
            h.setBackgroundColor(BaseColor.LIGHT_GRAY);
            h.setBorderWidth(1f);
            h.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(h);
        }

        table.setHeaderRows(1);
    }


    public static Document getDocument(String filePath) throws Exception {
        Document document = new Document();
        OutputStream outputStream = new FileOutputStream(filePath);
        PdfWriter.getInstance(document, outputStream);
        document.open();
        return document;
    }

    public static void addTable(Document document, String[] imagesPath, int columnCount, float width, float height) throws Exception {
        PdfPTable table = new PdfPTable(columnCount);
        int counter = 0;
        for (String imagePath : imagesPath) {
            if (imagePath.equals("")) {
                PdfPCell imageCell = new PdfPCell(new Phrase(" "));
                imageCell.setBorderWidth(0);
                table.addCell(imageCell);
            } else {
                Image img = Image.getInstance(imagePath);
                img.scaleAbsolute(width, height);
                PdfPCell imageCell = new PdfPCell(img);
                imageCell.setBorderWidth(0);
                table.addCell(imageCell);
            }
            counter++;
            if (counter % columnCount == 0) {
                for (int i = 0; i < columnCount; i++) {
                    PdfPCell blank = new PdfPCell(new Phrase(" "));
                    blank.setBorderWidth(0);
                    table.addCell(blank);
                }
            }
        }
        document.add(table);
    }

    public static PdfPTable getTable(String[] imagesPath, int columnCount, float width, float height) throws Exception {
        PdfPTable table = new PdfPTable(columnCount);
        int counter = 0;
        for (String imagePath : imagesPath) {
            if (imagePath.equals("")) {
                PdfPCell imageCell = new PdfPCell(new Phrase(" "));
                // imageCell.setBorderWidth(0);
                table.addCell(imageCell);
            } else {
                Image img = Image.getInstance(imagePath);
                img.scaleAbsolute(width, height);
                PdfPCell imageCell = new PdfPCell(img);
                // imageCell.setBorderWidth(0);
                table.addCell(imageCell);
            }
            counter++;
            if (counter % columnCount == 0) {
                for (int i = 0; i < columnCount; i++) {
                    PdfPCell blank = new PdfPCell(new Phrase(" "));
                    // blank.setBorderWidth(0);
                    table.addCell(blank);
                }
            }
        }
        return table;
    }

    
    public static void addTable(Document document, String[] texts, int columnCount, BaseColor backgroundColor, BaseColor fontColor, float height) throws Exception {
        PdfPTable table = new PdfPTable(columnCount);
        int counter = 0;
        for (String text : texts) {
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, fontColor);
            PdfPCell cell = new PdfPCell(new Phrase(text));
            if (font != null) {
                cell = new PdfPCell(new Phrase(text, font));
            }
            cell.setFixedHeight(height);
            cell.setBorderWidth(0);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(backgroundColor);
            table.addCell(cell);
            counter = counter + 1;
            if (counter % columnCount == 0) {
                for (int i = 0; i < columnCount; i++) {
                    PdfPCell blank = new PdfPCell(new Phrase(" "));
                    blank.setBorderWidth(0);
                    table.addCell(blank);
                }
            }
        }
        document.add(table);
    }

    public static PdfPTable getTable(String[] texts, int columnCount, BaseColor backgroundColor, BaseColor fontColor, float height) throws Exception {
        PdfPTable table = new PdfPTable(columnCount);
        int counter = 0;
        for (String text : texts) {
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, fontColor);
            PdfPCell cell = new PdfPCell(new Phrase(text));
            if (font != null) {
                cell = new PdfPCell(new Phrase(text, font));
            }
            cell.setFixedHeight(height);
            cell.setBorderWidth(0);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(backgroundColor);
            table.addCell(cell);
            counter = counter + 1;
            if (counter % columnCount == 0) {
                for (int i = 0; i < columnCount; i++) {
                    PdfPCell blank = new PdfPCell(new Phrase(" "));
                    blank.setBorderWidth(0);
                    table.addCell(blank);
                }
            }
        }
        return table;
    }

    public static Document getDocument(HttpServletResponse response) throws Exception{
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        return document;
    }

    public static void downloadDocument(String filePath, HttpServletResponse response, String pdfName) throws Exception{
        File file = new File(filePath);

        // Configurez la réponse HTTP pour le téléchargement du fichier
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + pdfName + ".pdf");

        // Copiez le contenu du fichier PDF vers le flux de sortie de la réponse HTTP
        try (OutputStream outputStream = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(file)) {
            IOUtils.copy(fileInputStream, outputStream);
            outputStream.flush();
        }

        // Supprimez le fichier temporaire après l'avoir renvoyé en réponse HTTP
        file.delete();
    }

    















    public static void createInvoice(HttpServletResponse response, String name, String type, double price, Date date) throws Exception {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        // Ajouter le contenu de la facture
        addInvoiceContent(document, name, type, price, date);

        document.close();

        // Télécharger le document PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=facture.pdf");
    }

    private static void addInvoiceContent(Document document, String name, String label, double price, Date date) throws Exception {
        // Ajouter le titre de la facture
        Paragraph title = new Paragraph("FACTURE", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Ajouter le nom
        Paragraph nameParagraph = new Paragraph("Nom du patient: " + name, new Font(Font.FontFamily.HELVETICA, 12));
        document.add(nameParagraph);

        // Ajouter le libellé
        Paragraph labelParagraph = new Paragraph("Type d'acte: " + label, new Font(Font.FontFamily.HELVETICA, 12));
        document.add(labelParagraph);

        // Ajouter le prix
        Paragraph priceParagraph = new Paragraph("Prix : " + price+" Ar", new Font(Font.FontFamily.HELVETICA, 12));
        document.add(priceParagraph);

        // Ajouter la date
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Paragraph dateParagraph = new Paragraph("Date : " + dateFormat.format(date), new Font(Font.FontFamily.HELVETICA, 12));
        document.add(dateParagraph);
    }


}
