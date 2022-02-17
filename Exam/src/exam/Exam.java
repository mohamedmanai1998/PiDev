/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Date;


/**
 *
 * @author Walid Boulima
 */
public class Exam {

   
    public static void main(String[] args) throws MagasinPleinException, PrixNegatifException {
        Produit p1 = new Produit();
        Produit p2 = new Produit(1021,"Yaourt","Delice");
        Produit p3 = new Produit(2510,"Yaourt","Vitalait");
        Produit p4 = new Produit(3250,"Tomate","Sicame",1.200f);
        
         
        
        
        p2.affecterPrix(-1.7f);
     //   System.out.println(p2.toString());
        p4.affecterDate(new Date(1377249026));
       // p2.afficher();
       // System.out.println(p4.toString());
       //System.out.println(p2);
       
       Magasin m1 = new Magasin(1,"ariana");
       Magasin m2 = new Magasin(2,"manouba");
       //System.out.println(m1.toString());
       m1.ajouterProduit(p2);
       m1.ajouterProduit(p3);
       m1.ajouterProduit(p4);
       m2.ajouterProduit(p3);
        //System.out.println(m1.toString());
      //  System.out.println(m1.totalProduits());
       // System.out.println("---------------------------------");
      //  System.out.println(p4.comparer1(p3));
       // System.out.println(Produit.comparer2(p3,p4));
        //m1.ajouterProduit(p2);  ---existant
        
     //   m1.supprimerProduit(p2);
        //m1.supprimerProduit(p3);
        //System.out.println(m1.toString());
       // System.out.println(m1.totalProduits());
      //  System.out.println(m2.totalProduits());
       // System.out.println(m1.comparerM(m2));
       
       Magasin m11 = new Magasin(1,"carrefour","centreville");
       Magasin m22 = new Magasin(2,"monoprix","menzeh 6");
       Caissier c1 = new Caissier(1,"ariana","mohamed",36f,2);
       Caissier c2 = new Caissier(2,"manouba","youssef",37f,3);
       Vendeur v1 = new Vendeur(3,"aouina","amine",37f,20f);
       Responsable r1 = new Responsable(4,"mestir","hama",34f,40f);
       
       Caissier c4 = new Caissier(55,"nabeul","ahmed",35f,4);
       Vendeur v2 = new Vendeur(44,"benarous","amen",48f,50f);
       Responsable r2 = new Responsable(5,"ghazella","lamjed",85f,46f);
      
           
       
       m11.ajouterEmploye(c1);
        m11.ajouterEmploye(c2);
         m11.ajouterEmploye(v1);
          m11.ajouterEmploye(r1);
          
          m22.ajouterEmploye(c4);
          m22.ajouterEmploye(v2);
          m22.ajouterEmploye(r2);
      
       System.out.println(m11.toString());
       m11.afficherEmploye();
        try {
       m22.ajouterProduit(p4);
       m11.ajouterProduit(p2);
        } catch (MagasinPleinException ex){
           System.out.println("une exception est levé");
           System.err.println(ex.getMessage());
           ex.printStackTrace();
       }
       
       System.out.println(m11.toString());
              System.out.println(m22.toString());
              
              ProduitFruit pf1 = new ProduitFruit("fruit",12.f,"mars",10,"fraise","",0f);
              ProduitFruit pf2 = new ProduitFruit("fruit",13.f,"juin",11,"fev","",0.1f);
              ProduitLegume pl1 = new ProduitLegume("legume",14.f,"juin",10,"artichaux","",0f);
              m11.ajouterProduit(pf1);
              m11.ajouterProduit(pf2);
              //m11.ajouterProduit(pf1);
              System.out.println(pf1.determinerType());
              System.out.println(pl1.determinerType());
              System.out.println(m11.calculStock());
       
    }
    
}
