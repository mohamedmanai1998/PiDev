/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Arbitre;
import entities.Match;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import utils.MyDB;
/**
 *
 * @author Amirov
 */
public class ServiceArb implements ISA<Arbitre> {
private Connection cnx ;
 
public ServiceArb() {
    cnx = MyDB.getInstance().getcnx();
}
    @Override
    public void ajouterArb(Arbitre a) {
        
        try {
             String querry="INSERT INTO `arbitre_match`(`nomArb`, `specialite` ) VALUES ('"+a.getNomArb()+"','"+a.getSpecialite()+"')";
            Statement stm =cnx.createStatement();
        
        stm.executeUpdate(querry);
        System.out.println("arbitre ajouter au match");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
        
    }

    @Override
    public List<Arbitre> afficherArb() {
List<Arbitre> arbitre = new ArrayList();
    
        try {
        Statement stm =cnx.createStatement();
        String querry ="SELECT * FROM `arbitre_match`";
     
        ResultSet rs= stm.executeQuery(querry);
        
        while(rs.next()){
            Arbitre a = new Arbitre();
            a.setIdArb(rs.getInt(1));
            a.setNomArb(rs.getString(2));
            a.setSpecialite(rs.getString(3));

            
            
            arbitre.add(a);
        }
        
    } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
    
    }
   
        return arbitre;

    }
    
    
    public void supprimerArb(int idArb) {
        try {
            String querry = "DELETE FROM `arbitre_match` WHERE idArb="+idArb;
            Statement stm =cnx.createStatement();
            stm.executeUpdate(querry);
            System.out.println("Arbitre supprimée ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
    public Arbitre FindArb(int idArb){
      Arbitre a = new Arbitre();
      try {
            Statement stmt = cnx.createStatement();
            String sql = "SELECT * FROM `arbitre_match` where idArb ="+idArb;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                 
    
              //  int id = rs.getInt("id");
                a.setIdArb(rs.getInt(1));
                a.setNomArb(rs.getString(2));
                a.setSpecialite(rs.getString(3));
           
               
                
                
                
            }
            rs.close();
            } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
      return a;
  }

    @Override
    public List<Arbitre> sortByNom() {

         List<Arbitre> users=afficherArb();
         List<Arbitre> resultat=users.stream().sorted(Comparator.comparing(Arbitre::getNomArb)).collect(Collectors.toList());
         return resultat;
     }

    }
    
    
    

