/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationmap;

/**
 *
 * @author Walid Boulima
 */
public class Employee {
    private int cin;
    private int matricule;
    private String nom;
    private String prenom;
    
    public Employee(){}
    public Employee(int cin, int matricule, String nom, String prenom){
        this.cin = cin;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public int getCin(){
        return cin;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    public void setCin(int cin){
        this.cin = cin;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
    @Override
    public String toString(){
        return "cin employe est " +this.cin+ " matricule employe est " +this.matricule+ " nom employe est " +this.nom+ " prenom employe est " +this.prenom;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.cin != other.cin) {
            return false;
        }
        return true;
    }
    
   
    
}
