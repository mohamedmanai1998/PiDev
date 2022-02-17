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
public class ProduitLegume extends ProduitAgricole implements Critere {
    
    public ProduitLegume(int id, String type, String libelle, float quantite, String saison) {
        super(id,type,libelle,quantite,saison);
    }
      public ProduitLegume(String saison, String type, float quantite) {
    super(saison, type, quantite);
  }
      @Override
      public boolean estFrais(String saison){
        
         
           String[] mois = {"jan", "fev", "mars", "avr", "mai", "juin", "juill", "aout", "sept","oct","nov","dec"};
        int j = 0;
        for (int i = 0; i < mois.length - 1; i++) {
          if (mois[i].equals(this.saison)) {
            j = i;
            break;
          }
        }
        if (saison.equals(mois[j]) || saison.equals(mois[j + 1])) {
          return true;
        }
        return false;
    }
      }
         