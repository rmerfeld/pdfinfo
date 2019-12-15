/*
 * pdfinfo
 * (c) 2010 by io.droidme
 */
package io.droidme.pdfinfo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

/**
 *
 * @author droidme
 */
public class App {

    public static void main(String[] args) {
        for (String s : args) {
            try {
                showInfo(s);
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void showInfo(String sUrl) throws IOException {

        PDDocument doc = PDDocument.load(new File(sUrl));

        System.out.println("==========================");
        System.out.println("File: " + sUrl);
        System.out.println("==========================");

        PDDocumentInformation info = doc.getDocumentInformation();

        System.out.println("Page Count=" + doc.getNumberOfPages());
        System.out.println("Title=" + info.getTitle());
        System.out.println("Author=" + info.getAuthor());
        System.out.println("Subject=" + info.getSubject());
        System.out.println("Keywords=" + info.getKeywords());
        System.out.println("Creator=" + info.getCreator());
        System.out.println("Producer=" + info.getProducer());

    }

}
