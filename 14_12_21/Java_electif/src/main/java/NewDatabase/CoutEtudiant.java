/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDatabase;

import java.util.List;

/**
 *
 * @author hnguyen01
 */
public class CoutEtudiant {
    
    public static final double COUT_VOEUX_1 = -500;
    public static final double COUT_VOEUX_2 = -200;
    public static final double COUT_VOEUX_INS = 1000;    
    
    private List<Etudiant> etudiants;
    private List<Module> modules;
    
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
    
    public int calculCE(int CM, int CI){
        int CE = CM + CI;
        return CE;
    }
    
    public CoutEtudiant(){
        DatabaseCM CM = new DatabaseCM();
        DatabaseVoeux CI = new DatabaseVoeux();
        Affectation affectation = new Affectation();
        String[][] listAff = affectation.listAffectation();  
    }
    
    
}
