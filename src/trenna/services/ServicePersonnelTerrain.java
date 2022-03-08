/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.services;

import trenna.entities.PersonnelTerrain;
import trenna.entities.Terrain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trenna.utils.DBConnexion ;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author Walid Boulima
 */
public class ServicePersonnelTerrain implements IService_2<PersonnelTerrain> {
 private Connection cnx;
    
    public ServicePersonnelTerrain(){
        cnx = DBConnexion.getInstance().getCnx();
    }
    
    @Override
    public void ajouter(PersonnelTerrain p) {
        try {
           String querry="INSERT INTO `personnel_terrain`(`idPersonnel`, `nom`,`poste`, `idTerrain`) VALUES (' "+p.getIdPersonnel()+" ',' "+p.getNom()+" ',' "+p.getPoste()+" ',' "+p.getTerrainn().getIdTerrain()+" ') ";
           Statement stm = cnx.createStatement();
           int x = stm.executeUpdate(querry);
           System.out.println(x + " ajouté avec succées");
       } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<PersonnelTerrain> afficher() {
          List<PersonnelTerrain> personnelterrain = new ArrayList();
        
        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM `personnel_terrain` ";
            
            ResultSet rs1 = stm.executeQuery(querry);

            while(rs1.next()){
                PersonnelTerrain p = new PersonnelTerrain();
                p.setIdPersonnel(rs1.getInt(1));
                p.setNom(rs1.getString("nom"));
                p.setPoste(rs1.getString("poste"));
                              
                personnelterrain.add(p);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnelterrain;
        
    }

    @Override
    public boolean modifier(PersonnelTerrain p) {
          try {
           String querry = "SELECT * FROM personnel_terrain WHERE personnel_terrain.`idPersonnel`=" +p.getIdPersonnel() + ";";
           Statement stm = cnx.createStatement();
           ResultSet rs1 = stm.executeQuery(querry);        
           querry = "UPDATE `personnel_terrain` SET `idPersonnel`='" + p.getIdPersonnel() + " ', `nom`='" + p.getNom() + " ', `poste`='" +p.getPoste() + " ', `idTerrain`='" +p.getTerrainn().getIdTerrain() + " ' WHERE personnel_terrain.`idPersonnel`=" + p.getIdPersonnel() + ";" ; 
           int x = stm.executeUpdate(querry);
           System.out.println(x + " modifié avec succées");
           return true;
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
                   return false;
        
    }
    }

    @Override
    public boolean supprimer(PersonnelTerrain p) {
        try {
            String querry = "SELECT * FROM personnel_terrain WHERE personnel_terrain.`idPersonnel`=" +p.getIdPersonnel() + ";";
            Statement stm = cnx.createStatement();
             ResultSet rs1 = stm.executeQuery(querry);
             
             querry = "DELETE FROM `personnel_terrain` WHERE personnel_terrain.`idPersonnel`=" + p.getIdPersonnel() + ";";
              int x = stm.executeUpdate(querry);
           System.out.println(x + " supprimé avec succées");
           return true;
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
             return false;
        
    }  
    }
     public List<PersonnelTerrain> triIdPersonnel(){
        List<PersonnelTerrain> pt = afficher();
        List<PersonnelTerrain> pt1 = pt.stream().sorted(Comparator.comparing(PersonnelTerrain ::getIdPersonnel)).collect(Collectors.toList());
        return pt1;
    }
    
      public List<PersonnelTerrain> triNom(){
        List<PersonnelTerrain> pt = afficher();
        List<PersonnelTerrain> pt1 = pt.stream().sorted(Comparator.comparing(PersonnelTerrain ::getNom)).collect(Collectors.toList());
        return pt1;
    }
      
       public List<PersonnelTerrain> triPoste(){
        List<PersonnelTerrain> pt = afficher();
        List<PersonnelTerrain> pt1 = pt.stream().sorted(Comparator.comparing(PersonnelTerrain ::getPoste)).collect(Collectors.toList());
        return pt1;
    }
     /*
        public List<PersonnelTerrain> triTerrainn(){ 
        List<PersonnelTerrain> pt = afficher();
        List<PersonnelTerrain> pt1 = pt.stream().sorted(Comparator.comparing(PersonnelTerrain ::getTerrainn)).collect(Collectors.toList());
        return pt1;
    }
     
   */
    public PersonnelTerrain rechercherIdPersonnel(int idPersonnel){
        PersonnelTerrain pt = new PersonnelTerrain();
        try {
            Statement stm = cnx.createStatement();
            String sql = "SELECT * FROM `personnel_terrain` WHERE idPersonnel ="+idPersonnel;
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                pt.setIdPersonnel(rs.getInt(1));
                pt.setNom(rs.getString(2));
                pt.setPoste(rs.getString(3));
                
                
            }
            rs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pt;
    }
    
   public PersonnelTerrain rechercherNom(String nom){
        PersonnelTerrain pt = new PersonnelTerrain();
        try {
            Statement stm = cnx.createStatement();
            String sql = "SELECT * FROM `personnel_terrain` WHERE nom ="+nom;
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                pt.setIdPersonnel(rs.getInt(1));
                pt.setNom(rs.getString(2));
                pt.setPoste(rs.getString(3));
                
                
            }
            rs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pt;
    }
   
   public PersonnelTerrain rechercherPoste(String poste){
        PersonnelTerrain pt = new PersonnelTerrain();
        List<PersonnelTerrain> terrains = new ArrayList<>();
        try {
            Statement stm = cnx.createStatement();
            String sql = "SELECT * FROM `personnel_terrain` WHERE poste ="+poste;
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                pt.setIdPersonnel(rs.getInt(1));
                pt.setNom(rs.getString(2));
                pt.setPoste(rs.getString(3));
                terrains.add(pt);
                System.out.println(terrains.toString());
                
            }
            rs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pt;
   }
   
         public PersonnelTerrain rechercherTerrainn(Terrain terrainn){
        PersonnelTerrain pt = new PersonnelTerrain();
        try {
            Statement stm = cnx.createStatement();
            String sql = "SELECT * FROM `personnel_terrain` WHERE idTerrain ="+terrainn;
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                pt.setIdPersonnel(rs.getInt(1));
                pt.setNom(rs.getString(2));
                pt.setPoste(rs.getString(3));
                
                
            }
            rs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pt;
    }
}
