/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.entities;

import com.itextpdf.text.Document;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import trenna.services.ServiceTerrain;
import trenna.services.ServicePersonnelTerrain;
/**
 *
 * @author Walid Boulima
 */
public class PDF_2 {
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document() {};
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
      
        ServiceTerrain st = new ServiceTerrain();
        List<Terrain> list=st.afficher();    
        document.add(new Paragraph("La liste des Terrains :"));
        document.add(new Paragraph("     "));
         for(Terrain t:list)
        {
            
        document.add(new Paragraph("ID :"+t.getIdTerrain()));
        document.add(new Paragraph("Type de Terrain :"+t.getTypeTerrain()));
      

        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        }
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }
    
     public void GeneratePdff(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document() {};
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
      
        ServicePersonnelTerrain sp = new ServicePersonnelTerrain();
        List<PersonnelTerrain> list=sp.afficher();    
        document.add(new Paragraph("La liste des personnel :"));
        document.add(new Paragraph("     "));
         for(PersonnelTerrain p:list)
        {
            
        document.add(new Paragraph("ID :"+p.getIdPersonnel()));
        document.add(new Paragraph("Nom :"+p.getNom()));
        document.add(new Paragraph("Poste :"+p.getPoste()));
       //document.add(new Paragraph("IdTerrain :"+p.getTerrainn()));
      

        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        }
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }
}
