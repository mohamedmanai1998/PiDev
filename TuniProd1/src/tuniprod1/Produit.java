/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuniprod1;
import java.util.Date;

/**
 *
 * @author Walid Boulima
 */
public class Produit {
      private int id;
       private String libelle;
       private String marque;
       private float prix; 
       private Date dateexper;
    
       
    public Produit (){};
    public Produit(int id, String libelle){
        this.id= id;
        this.libelle= libelle;
    }
    
    public Produit (int id, String libelle, String marque ) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
    }
    public Produit (int id, String libelle, String marque, float prix) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
       //if(this.prix > 0) {
        this.prix = prix;
       // }
    }
     public int getId(){
         return id;
     }
     public void setId(int id) {
         this.id = id;
     }
      public String getLibelle() {
          return libelle;
      }
      
      public void setLibelle(String libelle) {
          this.libelle = libelle;
      }
      
      public String getMarque(){
          return marque;
      }
      
      public void setMarque (String marque) {
          this.marque = marque;
      }
    public float getPrix(){
        return prix;
    }
    
    public void setPrix(float prix){
        //if(prix < 0) {
        this.prix = prix;
        //}
    }
    public Date getDateexper(){
        return dateexper;
    }
    
    public void setDateexper(Date dateexper){
        this.dateexper = dateexper;
    }
    public void afficherProduit() {
      System.out.println("id= " + this.id + " libelle= " + this.libelle + " marque= " + this.marque + " prix= " + this.prix + " date= " + this.dateexper);
  }
    @Override
  public String toString() {
    return "id= " + this.id + " libelle= " + this.libelle + " marque= " + this.marque + " prix= " + this.prix + " date= " + this.dateexper;
  }
  public boolean comparer1(Produit p ) {
      if(p.id == this.id && p.libelle == this.libelle && p.prix == this.prix) {
          return true;
      }
      return false;
  }
  public boolean comparer2(Produit p1, Produit p2) {
      if(p1.getId() == p2.getId() && p1.getLibelle() == p2.getLibelle() && p1.getPrix() == p2.getPrix()) {
          return true;
      }
      return false;
  }
  
  public String determinerTypeProduit() {
      if(this instanceof ProduitFruit){
      return "Produit Fruit";
  } else {
      return "Produit Legume";
  }
  }
}

 
