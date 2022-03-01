/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Arbitre;
import entities.Match;

import java.util.List;

/**
 *
 * @author Amirov
 */
public interface ISA<T> {
        public void ajouterArb(T a);
        public List<T> afficherArb();
        public List<Arbitre> sortByNom();

    
}
