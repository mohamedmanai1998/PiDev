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
public class Responsable extends Employe {
    float prime;
    
    public Responsable(int id, String nom, String adresse, float nbrheure, float prime){
        super(id,nom,adresse,nbrheure);
        this.prime=prime;
    }
    
}
