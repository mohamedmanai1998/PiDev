/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationmap;

/**
 *
 * @author Walid Boulima
 */
public interface InterfaceSociete {

    public void ajouterEmployeDepartement(Employee e, Departement d);

    public void supprimerEmploye(Employee e);

    public void afficherLesEmployesLeursDepartements();

    public void afficherLesEmployes();

    public void afficherLesDepartements();

    public void afficherDepartement(Employee e);

    public boolean rechercherEmploye(Employee e);

    public boolean rechercherDepartement(Departement e);

}
