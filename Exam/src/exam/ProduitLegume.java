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
public class ProduitLegume extends ProduitAgricole {

    public ProduitLegume(String type, float quantite, String saison, int id, String libelle, String marque, float prix) {
        super(type, quantite, saison, id, libelle, marque, prix);
    }

    @Override
    public boolean estFrais(String saison) {
        return this.saison.equals(saison);
    }
    
}
