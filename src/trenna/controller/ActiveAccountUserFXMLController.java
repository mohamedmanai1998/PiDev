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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import trenna.entities.User;
import trenna.services.UserService;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class ActiveAccountUserFXMLController implements Initializable {

    private TextField code;
    @FXML
    private TextField email;
    @FXML
    private Button aa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        User u = new User();
        UserService userService = new UserService();
        
        u.setVerificationCode(code.getText());
        userService.activerAccountUser(u);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/trenna/fxml/UserFXML.fxml"));
            Parent root = loader.load();
            UserFXMLController ac =loader.getController();
            aa.getScene().setRoot(root);
    }
    
}
