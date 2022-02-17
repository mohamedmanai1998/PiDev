/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacefonctionnellewalid;
import java.util.function.Consumer;


/**
 *
 * @author Walid Boulima
 */
public class Consumerr implements Consumer<Etudiant>{

    public void accept(Etudiant e) {

        System.out.println(e.toString());

    }
    
}
