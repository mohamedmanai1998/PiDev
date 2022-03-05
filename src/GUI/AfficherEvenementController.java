/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.evenement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import service.evenementservice;
 
/**
 * FXML Controller class
 *
 * @author medom
 */
public class AfficherEvenementController implements Initializable {
   
    static evenement selectedItem ;

    @FXML
    private TextField list;
    @FXML
    private TextField id;
    @FXML
    private Button supprimerbtn;
    @FXML
    private Button modifierbtn;
    @FXML
    private Button ajouterbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void selList (String list){
        this.list.setText(list);
    }
    
   
   
    @FXML
    private void SupprimerEvenement(ActionEvent event) {
        evenement ev =new evenement();
        evenementservice es =new evenementservice();
        es.supprimer(Integer.parseInt(id.getText()));
        
    }

    @FXML
    private void ModifierEvenement(ActionEvent event) {
        try {
            
             FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEvenement.fxml"));
            Parent root = loader.load();
            ModifierEvenementController ac =loader.getController();
            
            
            id.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void AjouterEvenement(ActionEvent event) {
         try {
            
             FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEvenement.fxml"));
            Parent root = loader.load();
            AjouterEvenementController ac =loader.getController();
            
            
            id.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void index2(KeyEvent event) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Commentaire.fxml"));
            Parent root = loader.load();
            CommentaireController ac =loader.getController(); 
            id.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void index(MouseEvent event) {
       /* selectedItem = list.getSelectionModel().getSelectedItem();
        id.setText(String.valueOf(selectedItem.getId()));
        nom.setText(selectedItem.getNom());
        description.setText(selectedItem.getDescription());
        adresse.setText(selectedItem.getAdresse());*/
        
    }
    }
    

