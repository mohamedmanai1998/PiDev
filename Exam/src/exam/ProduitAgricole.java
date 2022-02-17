/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

/**
 *
 * @author Walid Boulima
 */
public abstract class ProduitAgricole extends Produit implements Critere {
    //int id;
    String type;
    //String libelle;
    float quantite;
    String saison;

    public ProduitAgricole(String type, float quantite, String saison, int id, String libelle, String marque, float prix) {
        super(id, libelle, marque, prix);
        
        this.type = type;
        this.quantite = quantite;
        this.saison = saison;
    }

    public ProduitAgricole(String type, float quantite, String saison) {
        this.type = type;
        this.quantite = quantite;
        this.saison = saison;
    }

   
    
}
