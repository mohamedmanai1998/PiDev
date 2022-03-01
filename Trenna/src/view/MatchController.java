/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import services.ServiceArb;
import entities.Arbitre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import services.ServiceArb;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amirov
 */
public class MatchController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    @FXML
    private TextField specialite;
    @FXML
    private Button ajt;
    @FXML
    private Label listP;
    @FXML
    private Button afficher;
    @FXML
    private AnchorPane af;
    @FXML
    private Button supp;
    @FXML
    private Button nx;
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /*private void AddArbitre(ActionEvent event) {
       ServiceArb sa = new ServiceArb() ;   
       Arbitre a = new Arbitre(nom.getText(),specialite.getText());
        
            
        sa.ajouterArb(a);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Arbitre is added successfully!");
            alert.show();
            nom.setText("");
            specialite.setText("");
            
        
        
        
    }
*/
 

    @FXML
    private void ajouter(ActionEvent event) {
          
        
  /*            StringBuilder errors=new StringBuilder();
        //.trim ==> tna7ili les espace khater ken fama espace twali ma aadech empty hors lezem tkoun empty donc naamlou trim
        //.append ==> ken par exemple ma ktebtech adresse w email donc ijibli ken lekhrenya donc .append yaamle aala l lkoll 
        //kima une list kol ma nektebech tzid'ha f lista w baeed yaffichili ili ma ktebtech fih
        if(nom.getText().trim().isEmpty()){
            errors.append("Please enter an name\n");
        }
        if(specialite.getText().trim().isEmpty() ){
            errors.append("Please enter an specialite\n");
       
        if(errors.length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        }
        else{
                    ServiceArb sa = new ServiceArb() ;

            Arbitre a =new Arbitre();
            a.setNomArb(nom.getText());
            a.setSpecialite(specialite.getText());
            sa.ajouterArb(a);

        }


        
    
    
    }*/
  
     ServiceArb sa = new ServiceArb() ;   
       Arbitre a = new Arbitre(nom.getText(),specialite.getText());
        
            
        sa.ajouterArb(a);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Arbitre is added successfully!");
            alert.show();
            nom.setText("");
            specialite.setText("");
            
                  StringBuilder errors=new StringBuilder();

  if(nom.getText().trim().isEmpty()&&specialite.getText().trim().isEmpty()){
            errors.append("svp enter un nom et specialité\n");
        }
     
     if(errors.length()>0){
            Alert alt=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        }
  
    }
    
    /*   private void ListArbitre(ActionEvent event) {
               ServiceArb sa = new ServiceArb() ;   
        try {
            ListP.setText(sa.afficherArb().toString());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/

    @FXML
    private void afficher(ActionEvent event) throws IOException {
                 ServiceArb sa = new ServiceArb() ;   
        
            listP.setText(sa.afficherArb().toString());
     //  aff.setVisible(true);
     //  af.setVisible(false);
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
                         ServiceArb sa = new ServiceArb() ;   

            

      StringBuilder errors=new StringBuilder();
        
        if(id.getText().trim().isEmpty()){
            errors.append("Please enter an id\n");
        }
     
     if(errors.length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        }
     
                   sa.supprimerArb(Integer.parseInt(id.getText()));

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Arbitre is added successfully!");
            alert.show();
     
     
     
     
     /* 
    if(emailadmin.getText().trim().isEmpty()  && roleadmin.getText().trim().isEmpty()&& mdpadmin.getText().trim().isEmpty())
    {
    Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" modifier au moins un atrubut !");
            alert.setContentText(errors.toString());
            alert.showAndWait();
    
    }
    }*/
        
        
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        
        
//nx.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/arbitre.fxml"));
                Parent root = loader.load();
                ArbitreController af = loader.getController();
                nom.getScene().setRoot(root);
//                Stage mainStage = new Stage();
//                Scene scene = new Scene(root);
//                mainStage.setScene(scene);
//                mainStage.show();
    }

}
