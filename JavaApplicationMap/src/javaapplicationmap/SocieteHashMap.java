/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationmap;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Walid Boulima
 */
public class SocieteHashMap implements InterfaceSociete {
    Map<Employee,Departement> societe;
    
    public SocieteHashMap(){
        this.societe = new HashMap();
    }

    @Override
    public void ajouterEmployeDepartement(Employee e, Departement d) {
        societe.put(e,d);
    }

    @Override
    public void supprimerEmploye(Employee e) {
        societe.remove(e);
    }

    @Override
    public void afficherLesEmployesLeursDepartements() {
        System.out.println(societe);
    }

    @Override
    public void afficherLesEmployes() {
        System.out.println(societe.keySet());
        
        //2eme methode
        //  for(EntrySet<Employe,Departement> s : societe.entrySet()){
        // System.out.println(s.getKey());
    }

    @Override
    public void afficherLesDepartements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afficherDepartement(Employee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean rechercherEmploye(Employee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean rechercherDepartement(Departement e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
