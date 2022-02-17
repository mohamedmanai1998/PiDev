/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tplist;

/**
 *
 * @author Walid Boulima
 */
public class TpList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Etudiant e = new Etudiant();
    Etudiant e1 = new Etudiant(1, "Walid", "Boulima");
    Etudiant e2 = new Etudiant(4, "mohamed", "hama");
    Etudiant e3 = new Etudiant(3, "hamadi ", "mohamed");

    System.out.println(e1.toString());
    if (e1.equals(e2)) {
      System.out.println("equals");
    } else {
      System.out.println("not equals");
    }

    EspritArrayList espritArrayList = new EspritArrayList();
    espritArrayList.ajouterEtudiant(e1);
    espritArrayList.ajouterEtudiant(e2);
    espritArrayList.ajouterEtudiant(e3);
    espritArrayList.displayEtudiants();
    
    espritArrayList.supprimerEtudiant(e1);
    espritArrayList.displayEtudiants();
    

    if (espritArrayList.rechercherEtudiant(e1)) {
      System.out.println("existant");
    } else {
      System.out.println("Not existant");
    }
    if (espritArrayList.rechercherEtudiant(e2)) {
      System.out.println("existant");
    } else {
      System.out.println("Not existant");
    }
    
    if (espritArrayList.rechercherEtudiant("Walid")) {
      System.out.println("existant");
    } else {
      System.out.println("Not existant");
    }
    if (espritArrayList.rechercherEtudiant("Hamadi")) {
      System.out.println("existant");
    } else {
      System.out.println("Not existant");
    }
    

    espritArrayList.trierEtudiantsParId();
    espritArrayList.displayEtudiants();
    espritArrayList.trierEtudiantsParNom();
    espritArrayList.displayEtudiants();

  }

    }
    

