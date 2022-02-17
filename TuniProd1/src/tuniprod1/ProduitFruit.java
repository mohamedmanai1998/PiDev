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
public class ProduitFruit extends ProduitAgricole implements Critere {
    
    public ProduitFruit(int id, String type, String libelle, float quantite, String saison) {
        super(id,type,libelle,quantite,saison);
    }
      public ProduitFruit(String saison, String type, float quantite) {
    super(saison, type, quantite);
  }

    @Override
    public boolean estFrais(String saison) {
        return saison == this.saison;
    }
   
      
}
