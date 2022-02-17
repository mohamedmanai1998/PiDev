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
public class Employe {
    int id;
    String nom;
    String adresse;
    float nbr_heures;
    
    public Employe(){}
    public Employe(int id, String nom, String adresse, float nbr_heures){
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nbr_heures = nbr_heures;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id ) {
        this.id = id;
    }
    
    public String getNom() {
       return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }
 public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
 
    public float getNbr_heures() {
        return nbr_heures;
    }

    public void setNbr_heures(float nbr_heures) {
        this.nbr_heures = nbr_heures;
    }
    
    @Override
    public String toString(){
        return "id est " +this.id+ " nom est " +this.nom+ " adresse est " +this.adresse+ " nbrheures est " +this.nbr_heures ;
    }
    
}
