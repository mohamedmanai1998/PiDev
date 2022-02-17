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
public class Caissier extends Employe {
    int numcaisse;
    public Caissier(int id, String nom, String adresse, float nbrheure, int numcaisse) {
        super(id, nom, adresse, nbrheure);
        this.numcaisse=numcaisse;
    }

    @Override
    public String toString() {
        return "Caissier{" + "numcaisse=" + numcaisse + '}'+super.toString();
    }
    
    
}
