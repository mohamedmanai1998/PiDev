/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuniprod1;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Walid Boulima
 */
public class Main {
   
    public static void main(String[] args) throws ParseException {
         SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
       Produit p1 = new Produit();
       Produit p2 = new Produit(1021,"Lait","Vitalait");
       Produit p3 = new Produit(2510,"Yaourt","Vitalait");
       Produit p4 = new Produit(3250,"Tomate","Sicam",1.200f);
       
       
       
       
       p2.setPrix(0.7f);
       p1.setId(1000);
       p1.setLibelle("baguette");
       p1.setMarque("bg");
       p1.setPrix(0.200f);
       p3.setPrix(5.000f);
       p1.afficherProduit();
       p2.afficherProduit();
       p3.afficherProduit();
       p4.afficherProduit();
       System.out.println(p4.toString());
        p1.setDateexper(dateFormat.parse("01/09/2020"));
        
        
        
       // p2.dateexper = dateFormat.parse("02/02/2025");
        //p3.dateexper = dateFormat.parse("05/05/2005");
       // p4.dateexper = dateFormat.parse("05/02/2010"); 
        
        Magasin m1 = new Magasin(1,"ariana");
        m1.ajouterProduit(p1);
        m1.ajouterProduit(p2);
        //System.out.println(m1);
        System.out.println(m1.nbrproduits());
        
        Magasin m2 = new Magasin(1,"Carrefour");
        Magasin m3 = new Magasin(2,"Monoprix");
        
        Caissier c1 = new Caissier(1,"foulen1","ariana",190f,1);
        Caissier c2 = new Caissier(2,"foulen2","ariana",13.1f,2);
        Vendeur v1 = new Vendeur(1,"foulen3","mahdeya",14.1f,45.1f);
        Responsable r1 = new Responsable(1,"foulen2","manouba",15f,3.1f);
        m2.ajouterEmploye(c1);
        m2.ajouterEmploye(c2);
        m2.ajouterEmploye(v1);
        m2.ajouterEmploye(r1);
        
        Caissier c3 = new Caissier(3,"foulen1","ariana",12.1f,1);
        Vendeur v2 = new Vendeur(1,"foulen3","ariana",16.1f,2.1f);
        Vendeur v3 = new Vendeur(1,"foulen3","ariana",17.1f,2.1f);
        Vendeur v4 = new Vendeur(1,"foulen3","ariana",18.1f,2.1f);
        Responsable r2 = new Responsable(1,"foulen2","ariana",19.1f,3.1f);
        m3.ajouterEmploye(c3);
        m3.ajouterEmploye(v2);
        m3.ajouterEmploye(v3);
        m3.ajouterEmploye(v4);
        m3.ajouterEmploye(r2);
        
        System.out.println(c1.toString());
        System.out.println(v1.toString());
        System.out.println(r1.toString());
        
        
        Produit p11 = new Produit(10,"gateau","ben yeder",1);     
        Produit p22 = new Produit(20,"framboise","delice",2.5f);
        
        
        m2.ajouterProduit(p11);
        m3.ajouterProduit(p22);
        
        
        System.out.println(m2.toString());
        System.out.println(m3.toString());
        
        System.out.println(r1.calculSalaire());
        System.out.println(c1.calculSalaire());
        System.out.println(v1.calculSalaire());
        
        ProduitFruit pf1 = new ProduitFruit(1254,"Fruit","Fraise",12.3f,"Mars");
        ProduitFruit pf2 = new ProduitFruit(1224,"Fruit","Pastèque",50f,"Juin");
        ProduitFruit pf3 = new ProduitFruit(1254,"Fruit","Mandarine",25.6f,"Décembre");
        ProduitLegume pl4 = new ProduitLegume(8521,"Légumes","Artichauts",14f,"Janvier");
        
        m2.ajouterProduit(pf1);
        m2.ajouterProduit(pf2);
        m3.ajouterProduit(pf3);
        m3.ajouterProduit(pl4);
        
        
    }
    
}
