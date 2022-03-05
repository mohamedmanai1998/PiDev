/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Commentaire;
import entite.evenement;
import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.CommentaireService;
import service.evenementservice;

/**
 * FXML Controller class
 *
 * @author medom
 */
public class ListEvenementController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Button Ajouterbtn;
    evenementservice ps= new evenementservice();
   List<evenement> evenements =ps.readAll();
       private MyListener myListener;
    @FXML
    private VBox Pubdetail;
    @FXML
    private TextField id_even;
    @FXML
    private TextField comment;
    @FXML
    private TextField note;
    @FXML
    private Button Ajouterbtncomment;
    @FXML
    private TextField id_guest;
       
       
          
       public  void setChosenEvent(evenement e) {
           
         nom.setText(e.getNom());
         date.setText(String.valueOf(e.getDateEven()));
         prix.setText(String.valueOf( e.getPrix()));
         //recompense.setText(String.valueOf( e.getRecompense()));
         id_even.setText(String.valueOf( e.getIdEven()));
     
     }
    @FXML
    private TextField nom;
    @FXML
    private TextField date;
    @FXML
    private TextField prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         grid.getChildren().clear();
         
             if (evenements.size() > 0) {
            setChosenEvent(evenements.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(evenement e) {
                    setChosenEvent(e);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < evenements.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EventCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventCardController itemController= fxmlLoader.getController();
                itemController.setData(evenements.get(i),myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(20));
            }
        } catch (IOException e) {
        }
        
    }    

    @FXML
    private void AjouterEvenement(ActionEvent event) {
      
  try {
            Parent parent = FXMLLoader.load(getClass().getResource("AjouterEvenement.fxml"));
            Scene scene =new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
           
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void rechaff(List<evenement> evenements)
    {
     int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < evenements.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EventCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventCardController itemController= fxmlLoader.getController();
                itemController.setData(evenements.get(i),myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(20));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    
    }

    @FXML
    private void AjouterCommentaire(ActionEvent event) {
         evenement pub = new evenement();
        evenementservice pubService = new evenementservice();
        Commentaire c= new Commentaire();
        CommentaireService cs = new CommentaireService();
        c.setId_even(Integer.parseInt(id_even.getText()));
        c.setNom(nom.getText());       
        c.setComment(comment.getText());
        c.setDate_com(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        //c.setId(Integer.parseInt(id.getText()));
        c.setId_guest(Integer.parseInt(id_guest.getText()));
        c.setNote(Integer.parseInt(note.getText()));
        
        
 
        cs.ajouterCommentaire(c);
    }

    
    
}
