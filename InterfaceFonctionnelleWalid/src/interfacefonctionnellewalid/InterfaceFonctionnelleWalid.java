/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacefonctionnellewalid;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
/**
 *
 * @author Walid Boulima
 */
public class InterfaceFonctionnelleWalid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Etudiant e1 = new Etudiant(4, 30, "Walid");
        Etudiant e2 = new Etudiant(18, 5, "sami");
        Etudiant e3 = new Etudiant(45, 20, "youssef");
        Etudiant e4 = new Etudiant(13, 12, "ali");
        Etudiant e5 = new Etudiant(18, 7, "said");

        List<Etudiant> listt = new ArrayList<Etudiant>();

        listt.add(e1);
        listt.add(e2);
        listt.add(e3);
        listt.add(e4);
        listt.add(e5);

        ListEtudiant lsted = new ListEtudiant();
        
        lsted.afficherEtudiants(listt,
                new Consumer<Etudiant>() {
                    
            @Override
            public void accept(Etudiant e) {

                System.out.println(e.toString());

            }
        }
        );

        lsted.afficherEtudiantSelonFiltre(listt,
                x -> x.getAge() > 21,
                y -> System.out.println(y.toString()));

        String st = lsted.afficherNomEtudiant(listt,
                etd -> etd.getNom());
        System.out.println(st);

        System.out.println(  
                lsted.creeEtudiant( () -> new Etudiant(15, 24, "Mohamed Ali")).toString());

                lsted.creeEtudiant(Etudiant :: new);   
    }
    }
    

