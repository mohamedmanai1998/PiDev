/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Arbitre;
import entities.Match;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ServiceArb;
import services.ServiceMatch;

/**
 * FXML Controller class
 *
 * @author Amirov
 */
public class ArbitreController implements Initializable {

    @FXML
    private TextField idMatchh;
    @FXML
    private TextField typeMatchh;
    @FXML
    private TextField dateMatchh;
    @FXML
    private TextField idArb;
    @FXML
    private Button su;
    @FXML
    private Button aj;
    @FXML
    private Button mod;
    @FXML
    private Button aff;
    @FXML
    private Label liss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supp(ActionEvent event) throws IOException {
        
         ServiceMatch sm = new ServiceMatch() ;   

            

      StringBuilder errors=new StringBuilder();
        
        if(idMatchh.getText().trim().isEmpty()){
            errors.append("Please enter an id\n");
        }
     
     if(errors.length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        }
     
                   sm.supprimermatch(Integer.parseInt(idMatchh.getText()));

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Arbitre is added successfully!");
            alert.show();              
               
    }
        
        
    


    @FXML
    private void ajt(ActionEvent event) throws IOException {
        
         ServiceMatch sm = new ServiceMatch() ;   
     /*  Match m = new Match(typeMatchh.getText(),Date.parse(dateMatchh.getText()),idArb.getText());
        
        String sDate1="31/12/1998";  
    Date date1=new Date("dd/MM/yyyy").parse(sDate1);  
    
            
        sm.ajouter(m); */
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Match is added successfully!");
            alert.show();
            typeMatchh.setText("");
            dateMatchh.setText("");
            idArb.setText("");
            
                  StringBuilder errors=new StringBuilder();

  if(typeMatchh.getText().trim().isEmpty()&&dateMatchh.getText().trim().isEmpty()&&idArb.getText().trim().isEmpty()){
            errors.append("svp enter un typeMatchh et dateMatchh et un id Arbitre\n");
        }
     
     if(errors.length()>0){
            Alert alt=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        }
        
        
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
    }

    @FXML
    private void affich(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/affMatch.fxml"));
                Parent root = loader.load();
                AffMatchController aa = loader.getController();
                typeMatchh.getScene().setRoot(root);
    }
    }
    

