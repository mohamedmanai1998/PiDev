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
public class Departement {
    private int id;
    private String nom;
    
    public Departement(){}
    public Departement(int id, String nom){
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Override
    public String toString(){
        return "id departement est " +this.id+ " nom deparement est " +this.nom;
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
        final Departement other = (Departement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
