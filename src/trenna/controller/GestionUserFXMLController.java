/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import trenna.services.UserService;
import trenna.entities.User;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import trenna.entities.Role;
import trenna.services.RoleService;
import trenna.services.UserRoleService;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class GestionUserFXMLController implements Initializable {

    @FXML
    private ListView<User> list;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private ComboBox<?> age;
    @FXML
    private PasswordField mdp;
//    private ComboBox<?> role;
   
    final ObservableList rolee = FXCollections.observableArrayList();
    
    final ObservableList agee = FXCollections.observableArrayList(10,11,12,13,14,15,16,17,18,19,20
    ,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50);
    
    UserService userService = UserService.getInstance();
    
    @FXML
    private TextField email;
    @FXML
    private RadioButton admin;
    @FXML
    private RadioButton client;
    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
//        role.setItems(rolee);
        if(admin.isSelected()){
            client.setSelected(false);
        }else if(client.isSelected()){
            admin.setSelected(false);
        }
        age.setItems(agee);
        afficher();
        fill();                      
    }        
    private void afficher() {
        List<User> users = userService.afficher();
        ObservableList<User> observableArrayListUser = 
           FXCollections.observableArrayList(users);
        list.setItems(observableArrayListUser);
        
    }   
    private void fill(){
        list.setOnMouseClicked(e->{
            User user = userService.rechercherParEmail(list.getSelectionModel().getSelectedItem());
            nom.setText(user.getNom());
            prenom.setText(user.getPrenom());
//            agee.add(user.getAge());
            age.setItems(agee);
            age.setPromptText(String.valueOf(user.getAge()));
            mdp.setText(user.getMdp());
            rolee.add(user.getRole().getName());
            if(user.getRole().getName().equals("ADMINISTRATOR")){
                admin.setSelected(true);
                client.setSelected(false);
            }else{
                client.setSelected(true);
                admin.setSelected(false);
            }
            email.setText(user.getEmail());
        });
    }
    @FXML
    private void modifier(ActionEvent event) {
        User user = new User();
        User u = userService.rechercherParEmail(list.getSelectionModel().getSelectedItem());
        user.setId(u.getId());
        user.setEmail(u.getEmail());
        user.setNom(nom.getText());
        user.setPrenom(prenom.getText());
        user.setMdp(mdp.getText());
        user.setAge(age.getSelectionModel().getSelectedIndex());
        Role r = new Role();
        RoleService serviceRole = new RoleService();
        if(admin.isSelected()){
            r = serviceRole.getById(1);
            client.setSelected(false);
        }else if(client.isSelected()){
             r = serviceRole.getById(2);
            admin.setSelected(false);
        }
        user.setRole(r);
        userService.update(user);
        afficher();
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        User u = new User();
        UserRoleService  userRoleService = new UserRoleService();
        u.setEmail(email.getText());
        User user = userService.rechercherParEmail(u);
        userRoleService.getById(user.getId());
        userService.supprimer(user);
        afficher();
    }
    
}
