package tplist;
/**
 *
 * @author Walid Boulima
 */

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EspritArrayList implements University {

  List<Etudiant> etudiantList = new ArrayList<>();

  @Override
  public void ajouterEtudiant(Etudiant e) {
    etudiantList.add(e);
  }

  @Override
  public boolean rechercherEtudiant(Etudiant e) {
    for (int i = 0; i < etudiantList.size(); i++) {
      if (etudiantList.get(i).equals(e)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean rechercherEtudiant(String nom) {
    for (int i = 0; i < etudiantList.size(); i++) {
      //      Etudiant e= (Etudiant) etudiantList.get(i);
      if (etudiantList.get(i).getNom() == nom) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void supprimerEtudiant(Etudiant e) {
    etudiantList.remove(e);
  }

  @Override
  public void displayEtudiants() {
    for (int i = 0; i < etudiantList.size(); i++) {
      System.out.println(etudiantList.get(i).toString());
    }
  }

  Comparator<Etudiant> comparator1 = new Comparator<Etudiant>() {
    @Override
    public int compare(Etudiant e1, Etudiant e2) {
      return e1.getId() - e2.getId();
    }
  };

  @Override
  public void trierEtudiantsParId() {
    Collections.sort(etudiantList, comparator1);
  }

  Comparator<Etudiant> comparator2 = new Comparator<Etudiant>() {
    @Override
    public int compare(Etudiant e1, Etudiant e2) {
      return e1.getNom().compareTo(e2.getNom());
    }
  };

  @Override
  public void trierEtudiantsParNom() {
    Collections.sort(etudiantList, comparator2);

  }
}
