/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna;

import trenna.entities.Role;
import trenna.entities.User;
import trenna.services.UserService;
import trenna.utils.JavaMailUtils;
import trenna.utils.PasswordUtils;

/**
 *
 * @author moham
 */
public class Trenna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Role role = new Role(1,"aaaa","Admin");
        User user = new User("manai", "ahmed","manai.mohamed@esprit.tn",24,"Mohamed@2020",role);
        UserService userservice = UserService.getInstance();
//        userservice.ajouter(user);
//        userservice.ajouter(user);
//        JavaMailUtils.sendMail("manai.mohamed@esprit.tn");
//        userservice.afficher();
//        userservice.supprimer(user);
//        userservice.update(user);
//        userservice.afficher();
        userservice.login(user);
        System.out.println(PasswordUtils.getCurrentUser().toString());
//        userservice.validateLogin();
//          userservice.rechercherParEmail(user);
//          userservice.rechercherParName(user);
                 }
    
}
