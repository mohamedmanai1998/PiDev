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
public class Produit {
    private int id;
     private String libelle;
    private  String marque;
     private float prix;
     Date dateex;

  public Produit(){

 }
  public Produit(int id, String libelle, String marque){
      this.id=id;
      this.libelle=libelle;
      this.marque=marque;
  }
   public Produit(int id, String libelle, String marque, float prix){
      this.id=id;
      this.libelle=libelle;
      this.marque=marque;
      this.prix=prix;
  }
    public Produit(int id, String libelle, String marque, float prix, Date dateex){
      this.id=id;
      this.libelle=libelle;
      this.marque=marque;
      this.prix=prix;
      this.dateex=dateex;
  }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getMarque() {
        return marque;
    }

    public float getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    
public void affecterDate(Date date){
    this.dateex=date;
}
    public void afficher(){
        System.out.println("id est " +this.id+ " \n libelle est  " +this.libelle+ " \n marque est " +this.marque+ "\n prix est " +this.prix);
    }
 
    @Override
    public String toString(){
       return "\n id est " +this.id+ " \n libelle est  " +this.libelle+ " \n marque est " +this.marque+ "\n prix est " +this.prix+ "\n date est " +this.dateex;
   }
    public void affecterPrix(float price) throws PrixNegatifException {
        if(price>=0){
        this.prix=price;
        }
        else{
            throw (new PrixNegatifException("prix negativeeee"));
    }
}
    public boolean comparer1(Produit p){
        return this.id == p.id && this.prix == p.prix && this.libelle == p.libelle;
    }
    public static boolean comparer2(Produit p1, Produit p2){
        if(p1.getId() == p2.getId() && p1.getLibelle() == p2.getLibelle() ){
            return true;
        }
        return false;
        }
    public String determinerType(){
        String retour;
        if(this instanceof ProduitFruit){
            retour = "fruit";
        }
            else if(this instanceof ProduitLegume){
        retour = "legume";
                    
                    }
            else{
                retour= "autre";
        }
        return retour;
    }
    
}