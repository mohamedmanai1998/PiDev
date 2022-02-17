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
public class Responsable extends Employe {
    float prime;
    public Responsable(int id, String nom, String adresse, float nbr_heures, float prime ) {
        super(id,nom,adresse,nbr_heures);
        this.prime = prime;
    }
    
    public float calculSalaire(){
        float salaire =0;
        float heures_sup = 0;
        float heures_base = super.getNbr_heures();
        if(heures_base > 160 ) {
            heures_sup = heures_base - 160;
            heures_base = 160;
            salaire = prime + 10 * (heures_base) + 20 * (heures_sup);
            return salaire;
        }
        salaire = prime + 10 * (heures_base);
        return salaire;
    }
    
}
