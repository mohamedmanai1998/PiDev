/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.controller;

import trenna.entities.PDF_2;
import trenna.entities.Terrain;
import trenna.services.ServiceTerrain;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author Walid Boulima
 */
public class TerrainController implements Initializable {

    @FXML
    private TextField idt;
    @FXML
    private TextField tt;
    @FXML
    private Button btnafficher;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Label listterrain;
    @FXML
    private ListView<Terrain> listTerrain;
    @FXML
    private Button pdf;
    @FXML
    private ComboBox<?> choisir;
    @FXML
    private TextField rec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // ServiceTerrain st = new ServiceTerrain();
       // listTerrain.setOnMouseClicked(e->{
         //   Terrain terrain = st.rechercherTypeTerrain(listTerrain.getSelectionModel().getSelectedItem().toString());
         //   idt.setText(String.valueOf(terrain.getIdTerrain()));
          //  tt.setText(terrain.getTypeTerrain());
//            agee.add(user.getAge());
            
       // });
    }    

    
     @FXML
    private void afficher(ActionEvent event) {
        ServiceTerrain st = new ServiceTerrain();
        List<Terrain> terrains = st.afficher();
        ObservableList<Terrain> observableArrayListUser = 
        FXCollections.observableArrayList(terrains);
        listTerrain.setItems(observableArrayListUser);
        
    } 

    @FXML
    private void ajouter(ActionEvent event) {
        
        int idTerrain = Integer.parseInt(idt.getText());
        String TypeTerrain = tt.getText();
        
        Terrain t = new Terrain(idTerrain,TypeTerrain);
        ServiceTerrain st = new ServiceTerrain();
        st.ajouter(t);
         Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("terrain ajouté").graphic(null).position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    @FXML
    private void modifier(ActionEvent event) {
        int idTerrain = Integer.parseInt(idt.getText());
        String TypeTerrain = tt.getText();
        Terrain t = new Terrain(idTerrain,TypeTerrain);
        ServiceTerrain st = new ServiceTerrain();
        st.modifier(t);    
         Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("terrain modifié").graphic(null).position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int idTerrain = Integer.parseInt(idt.getText());
        String TypeTerrain = tt.getText();
        Terrain t = new Terrain(idTerrain,TypeTerrain);
        ServiceTerrain st = new ServiceTerrain();
        st.supprimer(t);   
         Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("terrain supprimé").graphic(null).position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    
   @FXML
    private void pdf(ActionEvent event) throws DocumentException, BadElementException, IOException, FileNotFoundException, InterruptedException, SQLException {
        PDF_2 pd=new PDF_2();
        try{
        pd.GeneratePdf("list of Terrain");
            System.out.println("impression done");
        } catch (Exception ex) {
            Logger.getLogger(ServiceTerrain.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

   // @FXML
  //  private void rec(KeyEvent event) {
           //      ServiceTerrain st = new ServiceTerrain() ;  
   
  //  listTerrain.setText(st.RechercherTer(choisir.getSelectionModel().getSelectedItem(),rec.getText()).toString());
  //  }
    
   
    
}
