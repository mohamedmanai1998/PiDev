/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.services;

import java.util.List;
/**
 *
 * @author Walid Boulima
 */


public interface IService_2<T> {

    public void ajouter(T t);
    public List<T> afficher();
    public boolean modifier(T t);
    public boolean supprimer(T t);
    
    
}