/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.evenement;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.evenementservice;

/**
 * FXML Controller class
 *
 * @author medom
 */
public class AjouterEvenementController implements Initializable {

    @FXML
    private TextField idevenement;
    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
    @FXML
    private TextField recompense;
    @FXML
    private Button ajouterbtn;
    @FXML
    private Button modifierbtn;
    @FXML
    private Button affichetbtn;
    @FXML
    private Button supprimerbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterEvenement(ActionEvent event) {
        evenement ev = new evenement();
        evenementservice es = new evenementservice();
        ev.setIdEven(Integer.parseInt(idevenement.getText()));
        ev.setNom(nom.getText());
        ev.setDateEven(new Date(2022, 3, 30));
        ev.setPrix(Integer.parseInt(prix.getText()));
        ev.setRecompense(Integer.parseInt(recompense.getText()));
        es.ajouterEvenement(ev);
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEvenement.fxml"));
            Parent root = loader.load();
            AfficherEvenementController ac =loader.getController();
            ac.selList(es.readAll().toString());
            
            nom.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
    }

    @FXML
    private void ModifierEvenement(ActionEvent event) {
        try {
            
             FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEvenement.fxml"));
            Parent root = loader.load();
            ModifierEvenementController ac =loader.getController();
            
            
            nom.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void AfficherEvenement(ActionEvent event) {
        try {
//            Parent parent = FXMLLoader.load(getClass().getResource("DetailPublication.fxml"));
//            Scene scene =new Scene(parent);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.initStyle(StageStyle.UTILITY);
//            stage.show();
             FXMLLoader loader = new FXMLLoader(getClass().getResource("ListEvenement.fxml"));
            Parent root = loader.load();
            ListEvenementController ac =loader.getController(); 
            nom.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void SupprimerEvenement(ActionEvent event) {
         try {
             evenement ev = new evenement();
        evenementservice es = new evenementservice();
             FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEvenement.fxml"));
            Parent root = loader.load();
            AfficherEvenementController ac =loader.getController();
            ac.selList(es.readAll().toString());
            
            
            nom.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
    }
    
}
