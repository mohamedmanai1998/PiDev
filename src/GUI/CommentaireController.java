/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Commentaire;
import entite.evenement;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.CommentaireService;
import service.evenementservice;
import static GUI.AfficherEvenementController.selectedItem;
import static GUI.ListEvenementController.selectedItem5;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author medom
 */
public class CommentaireController implements Initializable {

    private TextField id_guest;
    @FXML
    private TextField nomc;
    @FXML
    private TextField comment;
    private TextField id;
    private TextField nom;
    @FXML
    private TextField date;
    private TextField prix;
    private TextField recompense;
    //static Commentaire selectedItem5;
    @FXML
    private VBox Pubdetail;
    @FXML
    private TextField idEven;
    @FXML
    private TextField note;
    @FXML
    private Button Ajouterbtncomment;

 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       
        idEven.setText(String.valueOf(selectedItem5.getId_even()));
        nomc.setText(selectedItem5.getNom());
        date.setText(String.valueOf(selectedItem5.getDate_com()));
        comment.setText(String.valueOf(selectedItem5.getComment()));
        note.setText(String.valueOf(selectedItem5.getNote()));
        
// TODO
    }    

    @FXML
    private void AjouterCommentaire(ActionEvent event) {
         evenement pub = new evenement();
        evenementservice pubService = new evenementservice();
        Commentaire c= new Commentaire();
        CommentaireService cs = new CommentaireService();
        c.setId_even(Integer.parseInt(id.getText()));
        c.setNom(nomc.getText());       
        c.setComment(comment.getText());
        c.setDate_com(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        //c.setId(Integer.parseInt(id.getText()));
        c.setId_guest(Integer.parseInt(id_guest.getText()));
        
        
 
        cs.ajouterCommentaire(c);
        
        
        
    }
    
}
