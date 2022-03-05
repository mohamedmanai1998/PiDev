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
    public void supprimer(int idEven ) {
        try {
            String sql = "DELETE FROM evenement WHERE idEven=?;";
            
            pst=conn.prepareStatement(sql);
			
			pst.setInt(1,idEven);
			
			int executeUpdate = pst.executeUpdate();
			
			if(executeUpdate ==1){
				System.out.println("evenement supprimé avec ID::"+idEven);
			}
		} catch (SQLException e) {
		}
	
	}

    
    
    
    public List<evenement> trierpublication(){
        List<evenement> evenements = new ArrayList<>();
        String sql="select * from evenement ORDER BY dateeven DESC";
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(sql);
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
            System.out.println(ex.getMessage());
        }
        
        return evenements;
    }
    
   
      public List<evenement> Rechercheevenement(String nom) {
        List<evenement> myList = new ArrayList<evenement>();

        try {
            String requete3 = "SELECT * From evenement where nom like '%" + nom + "%'";
            Statement st3 = DataSource.getInstance().getCnx().createStatement();
            ResultSet rs = st3.executeQuery(requete3);
            while (rs.next()) {
                evenement p = new evenement();
                p.setIdEven(rs.getInt("IdEven"));
               p.setNom(rs.getString("Nom"));
               p.setDateEven(rs.getDate("DateEven"));
               p.setPrix(rs.getInt("Prix"));
               p.setRecompense(rs.getInt("Recompense"));
                
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myList;

    }

    
    
    
}
