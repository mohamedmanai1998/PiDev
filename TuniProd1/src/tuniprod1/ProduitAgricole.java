/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuniprod1;

/**
 *
 * @author Walid Boulima
 */
public class ProduitAgricole extends Produit {
     String type;
     String saison;
     float quantite;
    
    
    public ProduitAgricole(int id, String libelle, String marque, float prix, String type, String saison, float quantite) {
        super(id,libelle,marque);
        this.type= type;
        this.saison = saison;
        this.quantite = quantite;
    }
    
    public ProduitAgricole(int id, String type, String libelle , float quantite, String saison){
        super(id,libelle);
        this.type= type;
        this.saison = saison;
        this.quantite = quantite;
    }

    public ProduitAgricole(String type, String saison, float quantite) {
        this.type = type;
        this.saison = saison;
        this.quantite = quantite;
    }
    public float getQuantite(){
        return quantite;
    }
    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }
    
}
