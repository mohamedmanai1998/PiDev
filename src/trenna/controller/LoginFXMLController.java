/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import trenna.entities.User;
import trenna.services.UserService;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField mdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        User user = new User();
        UserService userService = new UserService();
        user.setEmail(email.getText());
        user.setMdp(mdp.getText());
        
        User u = userService.rechercherParEmail(user);
        if(userService.login(user)==true){
            if(u.getRole().getName().equals("ADMINISTRATOR")){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/trenna/fxml/GestionUserFXML.fxml"));
                Parent root = loader.load();            
                GestionUserFXMLController ac =loader.getController();
               
                email.getScene().setRoot(root);
            }
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/trenna/fxml/UserFXML.fxml"));
        Parent root = loader.load();
        UserFXMLController ac =loader.getController();
        email.getScene().setRoot(root);
    }
    
}
