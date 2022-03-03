/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna;

import trenna.entities.User;
import trenna.services.UserService;
import trenna.utils.JavaMailUtils;

/**
 *
 * @author moham
 */
public class Trenna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        User user = new User("manai", "ahmed","aaaaa@bb.cc",24,"q2uu6MNSuuxbJ+pQsknRoS38gdqtA9reY2J1zQ2UrkY=","65108837");
        UserService userservice = new UserService();
        
        
//        userservice.ajouter(user);
        JavaMailUtils.sendMail("manai.mohamed@esprit.tn");
//        userservice.afficher();
//        userservice.supprimer(user);
//        userservice.update(user);
//        userservice.afficher();
//        userservice.login(user);
//          userservice.rechercherParEmail(user);
//          userservice.rechercherParName(user);
                 }
    
}
