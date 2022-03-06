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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import service.evenementservice;

/**
 * FXML Controller class
 *
 * @author medom
 */
public class AjouterEvenementController implements Initializable {

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
    @FXML
    private ListView<evenement> liste;
     static evenement selectedItemm;
    @FXML
    private TextField date;
    ObservableList<String> listeTypeRecherchee = FXCollections.observableArrayList("Tout", "Nom", "IdEven", "Prix", "Recompense");
    @FXML
    private TextField txtRecherchee;
    @FXML
    private ComboBox<String> typeRecherchee;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        evenementservice cs = new evenementservice();
        liste.getItems().addAll(cs.readAll());
        typeRecherchee.setItems(listeTypeRecherchee);
        typeRecherchee.setValue("Tout");
       
       
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
        evenement ev = new evenement();
        evenementservice es = new evenementservice();
         
         ev.setNom(nom.getText());
         ev.setDateEven(new Date(2022, 3, 30));
         ev.setPrix(Integer.parseInt(prix.getText()));
         ev.setRecompense(Integer.parseInt(recompense.getText()));
         es.modifier(ev);
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
        evenement ev =new evenement();
        evenementservice es =new evenementservice();
        es.supprimer(selectedItemm.getIdEven());
        
    
        
        
        
    }

    @FXML
    private void index3(MouseEvent event) {
        selectedItemm = liste.getSelectionModel().getSelectedItem();
        nom.setText(String.valueOf(selectedItemm.getNom()));
        date.setText(String.valueOf(selectedItemm.getDateEven()));
        prix.setText(String.valueOf(selectedItemm.getPrix()));
        recompense.setText(String.valueOf(selectedItemm.getRecompense()));
    }
     @FXML
    private void rechercher(KeyEvent event) {
        evenementservice ps= new evenementservice();
        ObservableList observableList = FXCollections.observableArrayList(ps.rechercheevenement(typeRecherchee.getValue(),txtRecherchee.getText()));   
        liste.setItems(observableList);
    }

    
    
}
