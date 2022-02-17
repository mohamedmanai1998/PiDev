/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.evenement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;


/**
 *
 * @author medom
 */
public class evenementservice implements IService<evenement> {
     private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection conn;

    public evenementservice() {
        
          conn = DataSource.getInstance().getCnx();
    }
    
//    public void ajouterevenement(evenement e) {
//        String req = "insert into personne (ideEven,nom,dateEven,prix,recompense) values ('" +e.getIdEven() + "','" + e.getNom()+"','"+ e.getDateEven()+"','"+e.getPrix()+"','"+e.getRecompense()+ "')";
//
//        try {
//            ste = conn.createStatement();
//            ste.executeUpdate(req);
//        } catch (SQLException ex) {
//            Logger.getLogger(evenementservice.class.getName()).log(Level.SEVERE, null, ex);
//        }

        
        
        
        
//    }
    
    
     public void ajouterEvenement(evenement e ) {
        String req = "insert into evenement (idEven,nom,dateEven,prix,recompense) values (?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, e.getIdEven());
            pst.setString(2, e.getNom());
            pst.setDate(3, e.getDateEven());
            pst.setInt(4, e.getPrix());
            pst.setInt(5, e.getRecompense());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    

    @Override
    public void insert(evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<evenement> readAll() {
        String req = "select * from evenement";

        List<evenement> evenements=new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               evenement e = new evenement();
               e.setIdEven(rs.getInt("IdEven"));
               e.setNom(rs.getString("Nom"));
               e.setDateEven(rs.getDate("DateEven"));
               e.setPrix(rs.getInt("Prix"));
               e.setRecompense(rs.getInt("Recompense"));
               evenements.add(e);
               System.out.println(e.toString());
           }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage()); ;
        }
        return evenements;
    }

    @Override
    public boolean modifier(evenement t) {
      
        boolean update= true;
        String query = "UPDATE evenement SET nom='"+t.getNom()+"',"
                + " dateEven='"+t.getDateEven()+"', prix='"+t.getPrix()+"', recompense='"+t.getRecompense()+"' "
                + "WHERE idEven ='"+t.getIdEven()+"'"; 
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("l'evenement a été bien modifier");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            update = false;
        }
        return update;
    }

    @Override
    public boolean supprimer(evenement t) {
        boolean suppression = true;
        try {
            String query = "DELETE FROM evenement WHERE idEven ='"+t.getIdEven()+"'";     
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("l'evenement a été bien supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            suppression = false;
        }   
        return suppression;
    }

    
    
    
}
