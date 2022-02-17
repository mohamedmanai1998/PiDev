package tplist;
/**
 *
 * @author Walid Boulima
 */
import java.util.List;
import java.util.Vector;

public class EspritVector implements University{
  List<Etudiant> etudiantVector = new Vector<>();
  @Override
  public void ajouterEtudiant(Etudiant e) {
  }

  @Override
  public boolean rechercherEtudiant(Etudiant e) {
    return false;
  }

  @Override
  public boolean rechercherEtudiant(String nom) {
    return false;
  }

  @Override
  public void supprimerEtudiant(Etudiant e) {

  }

  @Override
  public void displayEtudiants() {

  }

  @Override
  public void trierEtudiantsParId() {

  }

  @Override
  public void trierEtudiantsParNom() {

  }
}
