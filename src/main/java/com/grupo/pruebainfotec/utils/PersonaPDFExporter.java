package com.grupo.pruebainfotec.utils;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.grupo.pruebainfotec.entity.Direccion;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import jakarta.servlet.http.HttpServletResponse;

public class PersonaPDFExporter {
    private List<Direccion> direcciones;

    public PersonaPDFExporter(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(8);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("calle", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("numero interior", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("número exterior", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("código postal", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("colonia", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("ciudad", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("id estado", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        direcciones.stream().forEach(d->{
            table.addCell(String.valueOf(d.getId()));
            table.addCell(d.getCalle());
            table.addCell(d.getNumeroInterior());
            table.addCell(d.getNumeroExterior());
            table.addCell(String.valueOf(d.getCodigoPostal()));
            table.addCell(d.getColonia());
            table.addCell(String.valueOf(d.getIdCiudad()));
            table.addCell(String.valueOf(d.getIdEstado()));
        });

    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Directions", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
