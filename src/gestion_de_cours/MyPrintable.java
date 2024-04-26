package gestion_de_cours;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class MyPrintable implements Printable {
    private String fileText;

    public MyPrintable(String fileText) {
        this.fileText = fileText;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // Définir la police et la taille de la police
        graphics.setFont(new Font("Arial", Font.PLAIN, 12));

        // Définir les marges
        int margin = 20;
        int x = (int) pageFormat.getImageableX() + margin;
        int y = (int) pageFormat.getImageableY() + margin;

        // Diviser le texte en lignes
        String[] lines = fileText.split("\\r?\\n");

        // Dessiner chaque ligne sur la page
        for (String line : lines) {
            graphics.drawString(line, x, y);
            y += graphics.getFontMetrics().getHeight(); // Déplacer vers le bas pour la prochaine ligne
        }

        return Printable.PAGE_EXISTS;
    }

}
