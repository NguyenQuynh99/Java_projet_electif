/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trucq
 */
public class test {
    
    public test(){
        
    }
    
    public String[][] getAffectation(){
        Affectation aff = new Affectation();
        aff.createColonneEtudiant();
        String[][] listAff = aff.listAffectation();
        return listAff;
    }
    
    public String[][] getVoeux(){
        DatabaseVoeux voeux = new DatabaseVoeux();
        voeux.createColonneEtudiant();
        String[][] listVoeux = voeux.listVoeux();
        return listVoeux;
    }
    
    public String[][] getCM(){
        DatabaseCM cm = new DatabaseCM();
        cm.createColonneEtudiant();
        String[][] listCM = cm.listCM();
        return listCM;
    }
    
    public static void main(String[] args){
        test test = new test();
        test.getAffectation();
        String[][] listCM = test.getCM();
        test.getVoeux();
        System.out.println(listCM[0][0]+ " " + listCM[0][1] + " " + listCM[1][1]);
    }
}
