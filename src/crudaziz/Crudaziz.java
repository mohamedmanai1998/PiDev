/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudaziz;

import entite.evenement;
import java.sql.Date;
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
        
        evenement e = new evenement(8,"mohamed", new Date(2022, 3, 30), 22, 22);
        evenementservice es = new evenementservice();
//        es.ajouterEvenement(e);
//        es.supprimer(e);
        es.modifier(e);
        es.readAll();
        
    }
        
    
}
