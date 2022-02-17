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
public class Employe {
    int id;
    String nom;
    String adresse;
    float nbrheure;

    public Employe(int id, String nom, String adresse, float nbrheure) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nbrheure = nbrheure;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", nbrheure=" + nbrheure +  '}';
    }
    
    
    
}
