/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import trenna.common.RegexValidation;
import trenna.entities.Role;
import trenna.entities.User;
import trenna.entities.UserRole;
import trenna.exceptions.BadRequestException;
import trenna.services.UserService;
import trenna.utils.JavaMailUtils;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class UserFXMLController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField age;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private PasswordField mdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void Ajouter(ActionEvent event) throws IOException, Exception {
        User user = new User();
        Role role = new Role();
        role.setIdRole(1);
        UserService userService = new UserService();
        user.setNom(nom.getText());
        user.setPrenom(prenom.getText());
        
        user.setEmail(email.getText());
        
        user.setMdp(mdp.getText());
        user.setRole(role);
        
//        JavaMailUtils.sendMail(user.getEmail());
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (null != mdp.getText() && (mdp.getText().length()) < 8
	        || !RegexValidation.checkPasswordFormat(RegexValidation.CHAR_PATTERN, mdp.getText())
		|| !RegexValidation.checkPasswordFormat(RegexValidation.NUMERIC_PATTERN, mdp.getText())
		|| !RegexValidation.checkPasswordFormat(RegexValidation.NOT_CHAR_PATTERN, mdp.getText())) {
           
            alert.setTitle("Mot de passe incorrect");
            alert.setHeaderText("Veuillez saisir le mot de passe correctement");
            alert.setContentText("Il faut saisir au minimum "
                    + "une chiffre, un caratere et une lettre avec un totale de 8 au minimum svp ");
            alert.showAndWait();                        
	}
        if(!RegexValidation.isValidEmail(email.getText())){
//            System.err.println("le compte email est incorrect !! ");
//            throw new BadRequestException("le compte email est incorrect !! ");
            
            alert.setTitle("le compte email est incorrect !!");
            alert.setHeaderText("Veuillez saisir l'email correctement");
            alert.setContentText("Il faut saisir le compte email pour pouvoir s'inscrire");
            alert.showAndWait();
        }
        if (null == nom.getText() || null == prenom.getText() || null == age.getText() || null == email.getText() ){
             alert.setTitle("champ vide !!");
            alert.setHeaderText("Veuillez remplir tous les champs");
            alert.setContentText("Il faut remplir tous les champs pour pouvoir s'inscrire");
            alert.showAndWait();
        }else {
            user.setAge(Integer.parseInt(age.getText()));
            userService.ajouter(user);
            
//            userService.rechercherParEmail(user);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/trenna/fxml/ActiveAccountUserFXML.fxml"));
            Parent root = loader.load();
            ActiveAccountUserFXMLController ac =loader.getController();
            nom.getScene().setRoot(root);
        }        
    }

    @FXML
    private void pageLogin(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/trenna/fxml/LoginFXML.fxml"));
        Parent root = loader.load();
        LoginFXMLController ac =loader.getController();
        email.getScene().setRoot(root);
    }
    
}