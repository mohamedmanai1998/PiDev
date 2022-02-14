/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trenna.entities;

import trenna.enumerations.Poste;

/**
 *
 * @author moham
 */
public class Administrateur extends User{
    private int id_Admin;
    private Poste poste;
    private Club id_Club;

    public Administrateur() {
    }

    public Administrateur(int id_Admin, Poste poste, Club id_Club, int id, String nom, String prenom, String email, int age, String mdp) {
        super(nom, prenom, email, age, mdp);
        this.id_Admin = id_Admin;
        this.poste = poste;
        this.id_Club = id_Club;
    }

    /**
     * @return the id_Admin
     */
    public int getId_Admin() {
        return id_Admin;
    }

    /**
     * @param id_Admin the id_Admin to set
     */
    public void setId_Admin(int id_Admin) {
        this.id_Admin = id_Admin;
    }

    /**
     * @return the poste
     */
    public Poste getPoste() {
        return poste;
    }

    /**
     * @param poste the poste to set
     */
    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    /**
     * @return the id_Club
     */
    public Club getId_Club() {
        return id_Club;
    }

    /**
     * @param id_Club the id_Club to set
     */
    public void setId_Club(Club id_Club) {
        this.id_Club = id_Club;
    }

    @Override
    public String toString() {
        return "Administrateur{" +super.toString()+ "id_Admin=" + id_Admin + ", poste=" + poste + ", id_Club=" + id_Club + '}';
    }


}
