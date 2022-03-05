/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Commentaire;
import entite.evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author medom
 */
public class CommentaireService implements IService<Commentaire> {
   private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection conn;

    public CommentaireService() {
        conn = DataSource.getInstance().getCnx();
    }
    
    public void ajouterCommentaire(Commentaire e){
        String req = "insert into commentaire (id,id_guest,id_even,nom,comment,date_com,note) values (?,?,?,?,?,?,?)";
     

        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, e.getId());
            pst.setInt(2, e.getId_guest());
            pst.setInt(3, e.getId_even());
            pst.setString(4, e.getNom());
            pst.setString(5, e.getComment());
            pst.setDate(6, e.getDate_com());
            pst.setInt(7,e.getNote());
            
            pst.executeUpdate();
            System.out.println("le commentaire a été bien ajouter ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
     
    
     
     

    @Override
    public void insert(Commentaire t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> readAll() {
       String req = "select * from commentaire";

        List<Commentaire> commentaire=new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               Commentaire e = new Commentaire();
               e.setId(rs.getInt("id"));
               e.setId_guest(rs.getInt("id_guest"));
               e.setId_even(rs.getInt("id_even"));
               e.setNom(rs.getString("nom"));
               e.setComment(rs.getString("comment"));
               e.setDate_com(rs.getDate("date_com"));
               commentaire.add(e);
               System.out.println(e.toString());
           }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage()); ;
        }
        return commentaire;
    }

    @Override
    public boolean modifier(Commentaire t) {
          boolean update= true;
        String query = "UPDATE Commentaire SET id_guest='"+t.getId_guest()+"',"
                + "id_even='"+t.getId_even()+"', nom='"+t.getNom()+"', comment='"+t.getComment()+"', date_com='"+t.getDate_com()+"' "
                + "WHERE id ='"+t.getId()+"'"; 
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("le commentaire a été bien modifier");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            update = false;
        }
        return update;
        
        
        
    }

    @Override
    public void supprimer(int id) {
       try {
            String sql = "DELETE FROM commentaire WHERE id=?;";
            
            pst=conn.prepareStatement(sql);
			
			pst.setInt(1,id);
			
			int executeUpdate = pst.executeUpdate();
			
			if(executeUpdate ==1){
				System.out.println("Commentaire supprimé avec ID::"+id);
			}
		} catch (SQLException e) {
		}
	
	}
    }
   






    
   


     
     




