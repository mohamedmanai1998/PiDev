/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.controller;

import trenna.entities.PDF_2;
import trenna.entities.PersonnelTerrain;
import trenna.services.ServicePersonnelTerrain;
import trenna.services.ServiceTerrain;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;
import trenna.entities.Terrain;

/**
 * FXML Controller class
 *
 * @author Walid Boulima
 */
public class PersonnelTerrainController implements Initializable {

    @FXML
    private TextField idp;
    @FXML
    private TextField np;
    @FXML
    private TextField pp;
    @FXML
    private TextField idttt;
    @FXML
    private Button btnafficher;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    
    @FXML
    private ListView<PersonnelTerrain> listPersonnel;
    @FXML
    private Button pdf1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficher(ActionEvent event) {
        ServicePersonnelTerrain sp = new ServicePersonnelTerrain();
        List<PersonnelTerrain> personnel = sp.afficher();
        ObservableList<PersonnelTerrain> observableArrayListUser = 
        FXCollections.observableArrayList(personnel);
        listPersonnel.setItems(observableArrayListUser);
        
    } 
    @FXML
    private void ajouter(ActionEvent event) {
        int idPersonnel = Integer.parseInt(idp.getText());
        ServiceTerrain serviceTerrain = new ServiceTerrain();
        String nom = np.getText();
        String poste = pp.getText();
        int idTerrainn = Integer.parseInt(idttt.getText());
        Terrain terrain = serviceTerrain.rechercherIdTerrain(idTerrainn);
       PersonnelTerrain pt = new PersonnelTerrain(idPersonnel,nom,poste,terrain);
       ServicePersonnelTerrain sp = new ServicePersonnelTerrain();
       sp.ajouter(pt);
        Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("personnel ajouté").graphic(null).position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    @FXML
    private void modifier(ActionEvent event) {
        int idPersonnel = Integer.parseInt(idp.getText());
        ServiceTerrain serviceTerrain = new ServiceTerrain();
        String nom = np.getText();
        String poste = pp.getText();
        int idTerrainn = Integer.parseInt(idttt.getText());
        Terrain terrain = serviceTerrain.rechercherIdTerrain(idTerrainn);
       PersonnelTerrain pt = new PersonnelTerrain(idPersonnel,nom,poste,terrain);
        ServicePersonnelTerrain sp = new ServicePersonnelTerrain();
       sp.modifier(pt);  
        Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("personnel modifié").graphic(null).position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int idPersonnel = Integer.parseInt(idp.getText());
        ServiceTerrain serviceTerrain = new ServiceTerrain();
        String nom = np.getText();
        String poste = pp.getText();
        int idTerrainn = Integer.parseInt(idttt.getText());
       Terrain terrain = serviceTerrain.rechercherIdTerrain(idTerrainn);
       PersonnelTerrain pt = new PersonnelTerrain(idPersonnel,nom,poste,terrain);
        ServicePersonnelTerrain sp = new ServicePersonnelTerrain();
      sp.supprimer(pt);     
      Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("personnel supprimé").graphic(null).position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    } 
    
   

    @FXML
    private void pdff(ActionEvent event)  throws DocumentException, BadElementException, IOException, FileNotFoundException, InterruptedException, SQLException {
        
        PDF_2 pdf1=new PDF_2();
        try{
        pdf1.GeneratePdff("list of Personnel");
            System.out.println("impression done");
        } catch (Exception ex) {
            Logger.getLogger(ServiceTerrain.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
