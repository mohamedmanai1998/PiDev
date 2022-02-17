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
public class Caissier extends Employe{
    int numeroDeCaisse;
    
    public Caissier(int id, String nom, String adresse, float nbr_heures, int numeroDeCaisse){
        super(id,nom,adresse,nbr_heures);
        this.numeroDeCaisse = numeroDeCaisse;
    }
    public float calculSalaire(){
        float salaire = 0;
        float heures_base = super.getNbr_heures();
        float heures_sup;
        if(heures_base > 180 ){
            heures_sup = heures_base - 180;
            heures_base = 180;
            salaire = (float) (5 * (heures_base) + 5.75 * (heures_sup));
            return salaire;
        }
        salaire = 5 * heures_base;
        return salaire;
    }
}
