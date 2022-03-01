/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import services.ServiceMatch;

/**
 * FXML Controller class
 *
 * @author Amirov
 */
public class AffMatchController implements Initializable {

    @FXML
    private Label list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aff(ActionEvent event) {
         ServiceMatch sm = new ServiceMatch() ;   
        
            list.setText(sm.afficher().toString());
     //  aff.setVisible(true);
     //  af.setVisible(false);
    }
    
}
