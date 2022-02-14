/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trenna.entities;

import trenna.enumerations.Activite;

/**
 *
 * @author moham
 */
public class Client extends User {
    private int id_Client;
    private Activite activite;
    private Club id_Club;

    public Client() {
    }

    public Client(int id_Client, Activite activite, Club id_Club, int id, String nom, String prenom, String email, int age, String mdp) {
        super(nom, prenom, email, age, mdp);
        this.id_Client = id_Client;
        this.activite = activite;
        this.id_Club = id_Club;
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public Club getId_Club() {
        return id_Club;
    }

    public void setId_Club(Club id_Club) {
        this.id_Club = id_Club;
    }

    @Override
    public String toString() {
        return "Client{"+super.toString()+ "id_Client=" + id_Client + ", activite=" + activite + ", id_Club=" + id_Club + '}';
    }
    
    

}
