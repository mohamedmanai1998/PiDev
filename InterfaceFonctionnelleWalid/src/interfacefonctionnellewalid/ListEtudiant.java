/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacefonctionnellewalid;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
/**
 *
 * @author Walid Boulima
 */
public class ListEtudiant implements GestionEtudiant {

    public ListEtudiant() {
    }

    @Override
    public void afficherEtudiants(List<Etudiant> etudiants, Consumer<Etudiant> consumer) {

        for (Etudiant e : etudiants) {
            consumer.accept(e);
        }

    }

    @Override
    public void afficherEtudiantSelonFiltre(List<Etudiant> etudiants, Predicate<Etudiant> predicate, Consumer<Etudiant> cons) {

        for (Etudiant e : etudiants) {
            if (predicate.test(e)) {
                cons.accept(e);
            }
        }

    }

    @Override
    public String afficherNomEtudiant(List<Etudiant> etudiants, Function<Etudiant, String> f) {
        String ch = "";
        for (Etudiant e : etudiants) {
            ch = ch + " -- " + f.apply(e);
        }
        return ch;
    }

    @Override
    public Etudiant creeEtudiant(Supplier<Etudiant> supp) {
        return supp.get();

    }

    @Override
    public Stream convertListStream(List<Etudiant> l) {

   return l.stream();

    }

}
