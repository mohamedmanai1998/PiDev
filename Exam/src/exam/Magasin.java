/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

/**
 *
 * @author Walid Boulima
 */
public class Magasin {

    String nom;
    int identifiant;
    String adresse;
    int capacite;
    Produit [] produits = new Produit[2];
    Employe [] employees = new Employe[20];
    int nbremp;
    
    public Magasin(int identifiant, String adresse){
        this.identifiant=identifiant;
        this.adresse=adresse;
       
        //this.produits= new Produit[50];
    }

    public Magasin(int identifiant,String nom,  String adresse) {
        this.nom = nom;
        this.identifiant = identifiant;
        this.adresse = adresse;
    }
    
      @Override
     public String toString(){
      String s = "identifiant est "+this.identifiant+ "\n adresse est " +this.adresse+ "\n capacite est " +this.capacite;
       String prod = "";
        for(int i=0; i<this.capacite;i++){
           prod+=this.produits[i];
            }
        String e= "";
        for(int i=0;i<this.nbremp;i++){
            e=e+this.employees[i];
        }
           return s+prod +"\n" +e;
       
    }
   public void ajouterProduit(Produit p) throws MagasinPleinException {
       if(this.capacite == 2){
          throw (new MagasinPleinException("magasin plein !!"));
       }
       if(this.chercher(p)){
           System.out.println("produit existant");
       }
       else {
      
      this.produits[capacite]=p;
       this.capacite++;
   }
   }
       
public int totalProduits(){
    return this.capacite;
    
}
public boolean chercher(Produit p){
    for(int i=0;i<this.capacite;i++){
        if(p.comparer1(this.produits[i])){
            return true;
            
        }
            
    }
    return false;
}
public int getIndexOfProduit(Produit p){
    for(int i=0;i<this.capacite;i++){
        if(this.produits[i].comparer1(p)){
          return i;
        }
    }
        
        return -1;
}
public void supprimerProduit(Produit p){
    int index = getIndexOfProduit(p);
    if(index != -1){
        for(int i=index; i<this.capacite;i++){
        this.produits[index] = this.produits[index+1];
        this.produits[capacite]=null;
        this.capacite--;
    }
}
}
public Magasin comparerM(Magasin m){
    if(this.capacite > m.capacite){
        return this;
    }
    else {
        return m;
    }
}
public void ajouterEmploye(Employe e){
    this.employees[nbremp]=e;
    this.nbremp++;
    
}
public void afficherEmploye(){
    for(int i=0;i<nbremp;i++){
        System.out.println(employees[i]);
    }
}
 public float calculStock() {
     float total=0;
     for(int i=0;i<this.capacite;i++){
         if(produits[i].determinerType().equals("fruit")){
             total+= ((ProduitFruit) this.produits[i]).quantite;
                     }
             
         
     }
     return total;
 }

}

