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
public class Vendeur extends Employe{
    float tauxDeVente;
    
    public Vendeur(int id, String nom, String adresse,float nbr_heures, float tauxDeVente){
        super(id,nom,adresse,nbr_heures);
                this.tauxDeVente = tauxDeVente;
    }
    
    public float calculSalaire() {
        return 450 + 450 * (tauxDeVente/100);
    }
}
