/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Walid Boulima
 */
public class Stream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList();
        personnes.add(new Personne(1, "Walid", "Boulima"));
        personnes.add(new Personne(2, "hama", "salem"));
        personnes.add(new Personne(3, "oussema", "jaziri"));
        personnes.add(new Personne(4, "wael", "narjes"));
        personnes.add(new Personne(5, "amir", "oueslati"));
        personnes.add(new Personne(6, "aymen", "amine"));

        personnes.stream().filter((f) -> f.getNom().contains("d"))
                .map((e)-> e.getNom())
                .forEach((e)->System.out.println(e));
            
                   

        }
    
    }
