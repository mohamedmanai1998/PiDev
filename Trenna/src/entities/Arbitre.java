/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Amirov
 */
public class Arbitre {
       private int idArb;
       private String nomArb;
       private String specialite;

    public Arbitre() {
    }

    public Arbitre(int idArb, String nomArb, String specialite) {
        this.idArb = idArb;
        this.nomArb = nomArb;
        this.specialite = specialite;
    }

    public Arbitre(String nomArb, String specialite) {
        this.nomArb = nomArb;
        this.specialite = specialite;
    }

    public int getIdArb() {
        return idArb;
    }

    public void setIdArb(int idArb) {
        this.idArb = idArb;
    }

    public String getNomArb() {
        return nomArb;
    }

    public void setNomArb(String nomArb) {
        this.nomArb = nomArb;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "Arbitre{" + "idArb=" + idArb + ", nomArb=" + nomArb + ", specialite=" + specialite + '}';
    }
       
       


}
