/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.services;

import trenna.entities.Terrain;
import trenna.entities.PersonnelTerrain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trenna.utils.DBConnexion;
import java.util.Comparator;
import java.util.stream.Collectors;



/**
 *
 * @author Walid Boulima
 */
public class ServiceTerrain implements IService_2<Terrain>{
    private Connection cnx;
    
    public ServiceTerrain(){
        cnx = DBConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Terrain t) {
       try {
           String querry="INSERT INTO `terrain`(`idTerrain`, `typeTerrain`) VALUES (' "+t.getIdTerrain()+" ',' "+t.getTypeTerrain()+" ') ";
           Statement stm = cnx.createStatement();
           int x = stm.executeUpdate(querry);
           System.out.println(x + " ajouté avec succées");
       } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    

    @Override
    public List<Terrain> afficher() {
        List<Terrain> terrains = new ArrayList();
        
        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM `terrain` ";
            
            ResultSet rs = stm.executeQuery(querry);
            
            while(rs.next()){
                Terrain t = new Terrain();
                t.setIdTerrain(rs.getInt(1));
                t.setTypeTerrain(rs.getString("typeTerrain"));
                
                terrains.add(t);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return terrains;
    }
    
    

    @Override
    public boolean modifier(Terrain t) {
       try {
           String querry = "SELECT * FROM terrain WHERE terrain.`idTerrain`=" +t.getIdTerrain() + ";";
           Statement stm = cnx.createStatement();
           ResultSet rs = stm.executeQuery(querry);
           
           querry = "UPDATE `terrain` SET `idTerrain`='" + t.getIdTerrain() + " ', `typeTerrain`='" +t.getTypeTerrain() + " ' WHERE terrain.`idTerrain`=" + t.getIdTerrain() + ";" ; 
           int x = stm.executeUpdate(querry);
           System.out.println(x + " modifié avec succées");
           return true;
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
                   return false;

    }   
    }
    

        
    @Override
    public boolean supprimer(Terrain t) {
        try {
            String querry = "SELECT * FROM terrain WHERE terrain.`idTerrain`=" +t.getIdTerrain() + ";";
            Statement stm = cnx.createStatement();
             ResultSet rs = stm.executeQuery(querry);
             
             querry = "DELETE FROM `terrain` WHERE terrain.`idTerrain`=" + t.getIdTerrain() + ";";
              int x = stm.executeUpdate(querry);
           System.out.println(x + " supprimé avec succées");
           return true;
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
             return false;
    }
        }
    
   
    public List<Terrain> triIdTerrain(){
        List<Terrain> ter = afficher();
        List<Terrain> ter1 = ter.stream().sorted(Comparator.comparing(Terrain ::getIdTerrain)).collect(Collectors.toList());
        return ter1;
    }
    
     public List<Terrain> triTypeTerrain(){
        List<Terrain> ter = afficher();
        List<Terrain> ter2 = ter.stream().sorted(Comparator.comparing(Terrain ::getTypeTerrain)).collect(Collectors.toList());
        return ter2;
    }
    
    public Terrain rechercherIdTerrain(int idTerrain){
        Terrain t = new Terrain();
        try {
            Statement stm = cnx.createStatement();
            String sql = "SELECT * FROM `terrain` WHERE idTerrain ="+idTerrain;
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                t.setIdTerrain(rs.getInt(1));
                t.setTypeTerrain(rs.getString(2));
                
            }
            rs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return t;
    }
    public Terrain rechercherTypeTerrain(String typeTerrain){
        Terrain t = new Terrain();
        try {
            Statement stm = cnx.createStatement();
            String sql = "SELECT * FROM `terrain` WHERE typeTerrain ="+typeTerrain;
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                t.setIdTerrain(rs.getInt(1));
                t.setTypeTerrain(rs.getString(2));
                
            }
            rs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return t;
    }
    
    /*
    public List<Terrain> RechercherTer(String critere,String rec) {
     
        List<Terrain> terrains = new ArrayList();
   
        try {
        Statement stm =cnx.createStatement();
        String querry ="SELECT * FROM terrain where "+critere+" like '"+rec+"%'";
     
        ResultSet rs= stm.executeQuery(querry);
       
        while(rs.next()){
            Terrain t = new Terrain();
            t.setIdTerrain(rs.getInt(1));
            t.setTypeTerrain(rs.getString(2));
           
           
           
           
            terrains.add(t);
        }
       
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
   
    }
   
        return terrains;
   
    }
*/
    }

