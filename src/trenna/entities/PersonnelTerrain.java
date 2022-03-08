/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.entities;

/**
 *
 * @author Walid Boulima
 */
public class PersonnelTerrain {
    
    private int idPersonnel;
    private String nom;
    private String poste;
    private Terrain terrainn;
    
    public PersonnelTerrain(){}
    
    public PersonnelTerrain(int idPersonnel, String nom, String poste, Terrain terrainn){
        this.idPersonnel = idPersonnel;
        this.nom=nom;
       this.poste=poste;
       this.terrainn=terrainn;
    }
    public PersonnelTerrain(int idPersonnel, String nom, String poste, int terrainnn){
        this.idPersonnel = idPersonnel;
        this.nom=nom;
       this.poste=poste;
       this.terrainn=terrainn;
    }
    
    public int getIdPersonnel(){
        return idPersonnel;
    }
  
    public String getNom() {
        return nom;
    }

    public String getPoste() {
        return poste;
    }

    public Terrain getTerrainn() {
        return terrainn;
    }

    public void setTerrainn(Terrain terrainn) {
        this.terrainn = terrainn;
    }
    
      public void setIdPersonnel(int idPersonnel){
        this.idPersonnel = idPersonnel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    

    @Override
    public String toString() {
        return "personnelTerrain{" + "idPersonnel=" + idPersonnel + ", nom=" + nom + ", poste=" + poste + ", idTerrain=" + terrainn + '}';
    }
}
