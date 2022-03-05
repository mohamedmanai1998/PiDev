/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudaziz;

import entite.Commentaire;
import entite.evenement;
import java.sql.Date;
import service.CommentaireService;
import service.evenementservice;

/**
 *
 * @author medom
 */
public class Crudaziz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // evenement e = new evenement(10,"aziz", new Date(2022, 3, 30), 10, 9);
        evenementservice es = new evenementservice();
      //  es.ajouterEvenement(e);
      //  es.supprimer(e);
        //es.modifier(e);
        //es.readAll();
        Commentaire e = new Commentaire(2,2, 5, "mlds", "ez", new Date(2022, 3, 30));
        CommentaireService cs = new CommentaireService();
        cs.ajouterCommentaire(e);
        //int id, int id_guest, int id_publication, String nom, String comment, Date date_com
        
        //es.trierpublication();
        //System.out.println(es.Rechercheevenement("mohamed"));
        
    }
        
    
}
