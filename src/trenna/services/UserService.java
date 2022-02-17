/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trenna.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trenna.common.RegexValidation;
import trenna.entities.Administrateur;
import trenna.entities.User;
import trenna.exceptions.BadRequestException;
import trenna.utils.DBConnexion;

/**
 *
 * @author moham
 */
public class UserService implements IService<User>{

    private Connection cnx ;
    
    public UserService(){
        cnx =DBConnexion.getInstance().getCnx();
    }
    @Override
    public void ajouter(User u) {
        try {
            String querry="INSERT INTO `utilisateur`(`nom`, `prenom`,`email`,`age`,`mdp`) "
                    + "VALUES ('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getEmail()+"','"+u.getAge()+"','"+u.getMdp()+"')";
            Statement stm =cnx.createStatement();
        if (null != u.getMdp() && (u.getMdp().length()) < 8
	        || !RegexValidation.checkPasswordFormat(RegexValidation.CHAR_PATTERN, u.getMdp())
		|| !RegexValidation.checkPasswordFormat(RegexValidation.NUMERIC_PATTERN, u.getMdp())
		|| !RegexValidation.checkPasswordFormat(RegexValidation.NOT_CHAR_PATTERN, u.getMdp())) {
            System.err.println("");
            throw new BadRequestException("Mot de passe incorrect, il faut saisir au minimum "
                    + "une chiffre, un caratere et une lettre avec un totale de 8 au minimum svp ");
	}    
        if(!RegexValidation.isValidEmail(u.getEmail())){
//            System.err.println("le compte email est incorrect !! ");
            throw new BadRequestException("le compte email est incorrect !! ");
        }
        
        stm.executeUpdate(querry);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        } catch (BadRequestException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    @Override
    public List<User> afficher() {
         List<User> users = new ArrayList<>();
    
        try {
        Statement stm =cnx.createStatement();
        String querry ="SELECT * FROM `utilisateur`";
     
            ResultSet rs= stm.executeQuery(querry);
        
        while(rs.next()){
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setAge(rs.getInt("age"));
            u.setMdp(rs.getString("mdp"));
            
            
            users.add(u);
            System.out.println(u.toString()); 
        }
        
    } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
    
    }
   
         return  users;
    }

    @Override
    public Boolean update(User t) {
        boolean update= true;
        String query = "UPDATE `utilisateur` SET nom='"+t.getNom()+"', prenom='"+t.getPrenom()+"',"
                + " age='"+t.getAge()+"', email='"+t.getEmail()+"', mdp='"+t.getMdp()+"' "
                + "WHERE id ='"+t.getId()+"'"; 
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(query);
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            update = false;
        }
        return update;
    }

    @Override
    public Boolean supprimer(User t) {
        boolean suppression = true;
        try {
            String query = "DELETE FROM `utilisateur` WHERE id ='"+t.getId()+"'";     
            Statement stm = cnx.createStatement();
            stm.executeUpdate(query);
            System.out.println("l'utilisateur a été bien supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
            suppression = false;
        }   
        return suppression;
       
    }
    

}
