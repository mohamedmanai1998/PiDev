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
public class Terrain {
    private int idTerrain;
    private String typeTerrain;
    
    public Terrain(){}
    
    public Terrain(int idTerrain, String typeTerrain){
        this.idTerrain = idTerrain;
        this.typeTerrain = typeTerrain;
    }
    
    public int getIdTerrain(){
        return idTerrain;
    }
    
    public void setIdTerrain(int idTerrain){
        this.idTerrain = idTerrain;
    }
    
    public String getTypeTerrain(){
        return typeTerrain;
    }
    
    public void setTypeTerrain(String typeTerrain){
        this.typeTerrain = typeTerrain;
    }

    @Override
    public String toString() {
        return "Terrain{" + "idTerrain=" + idTerrain + ", typeTerrain=" + typeTerrain + '}';
    }
    
}
