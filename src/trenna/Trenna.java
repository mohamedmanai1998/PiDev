/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna;

import java.util.ArrayList;
import java.util.List;
import trenna.entities.User;
import trenna.services.UserService;

/**
 *
 * @author moham
 */
public class Trenna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user = new User("manai", "ahmed","manai@esprit.tn",24,"ahmeDA@1hmed","",false);
        UserService userservice = new UserService();
        userservice.ajouter(user);
       
//        userservice.afficher();
//        userservice.supprimer(user);
//        userservice.update(user);
//        userservice.afficher();
//        userservice.login(user);
//          userservice.rechercherParEmail(user);
//          userservice.rechercherParName(user);
                 }
    
}
