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
public class JavaApplicationMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee e = new Employee(12,15,"Walid","Boulima");
        Departement d = new Departement(1,"BD");
        
        System.out.println(e.toString());
        System.out.println(d.toString());
    }
    
}
