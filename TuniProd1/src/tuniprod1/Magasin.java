/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuniprod1;

import tuniprod1.Produit;

/**
 *
 * @author Walid Boulima
 */
public class Magasin {
    int id;
    String adresse;
    int capacite;
    Produit [] produits;
    Employe [] employes;
    int nbemp;
    
    public Magasin () {};
    public Magasin (int id, String adresee) {
        this.id = id;
        this.adresse = adresse;
        this.capacite = 0;
        this.produits = new Produit[50];
        this.employes = new Employe[20];
        this.nbemp = 0;
    }
    
    @Override
    public String toString() {
        String str = "";
        String str2 ="";
        for(int i=0;i<50;i++)
        {
            if(produits[i] != null ) {
            str=str+produits[i];
            }
            
                }
        for(int j=0;j<20;j++){
                if(employes[j] != null){
                    str2 = str2+employes[j];
            }
        }
        return "identifiant est " + this.id + " adresse est " + this.adresse + " capacite est " + this.capacite + " les produits sont " +str +"nombre employe est" +this.nbemp+ "qui sont" +str2 ;
    }
    public void ajouterProduit(Produit p) {
        produits[capacite] = p;
        this.capacite++;
    }
    public String nbrproduits(){
        return "le nombre des produits est " + this.capacite;
    }
  
    public boolean chercher(Produit p){
        for(int i=0; i<this.capacite; i++){
            if (p.comparer1(this.produits[i])) {
                return true;
            }
            
        }
    return false;
    }
    
    public void ajouterProduit2(Produit p){
        if(!chercher(p)){
            produits[capacite] = p;
            this.capacite++;
        }
    }
    public void supprimerProduit(Produit p) {
        if(this.capacite == 50 && p.comparer1(this.produits[49])) {
            this.produits[49] = null;
            
        }
        for(int i=0; i<this.capacite;i++){
            if(p.comparer1(this.produits[i])){
                this.produits[i]=this.produits[i+1];
            }
        }
    }
    public Magasin supProduit(Magasin m){
        if (m.capacite > this.capacite) {
            return m;
        }
        else return this;
    }
    
    public void ajouterEmploye(Employe E){
        employes[nbemp] = E;
        this.nbemp++;
    }
    
    public float calculStock(){
        float qte = 0;
        for(int i=0; i<capacite;i++){
        if(this.produits[i].determinerTypeProduit().equals("Produit Fruit")){
            qte += ((ProduitFruit) this.produits[i]).quantite;
        }
            
        }
        
        return qte;
    }
    
}
