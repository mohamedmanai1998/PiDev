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
public class Vendeur extends Employe {
    float tauxdevente;
    
    public Vendeur(int id, String nom, String adresse, float nbrheure,float tauxdevente) {
        super(id, nom, adresse, nbrheure);
        this.tauxdevente=tauxdevente;
    }
    
}
