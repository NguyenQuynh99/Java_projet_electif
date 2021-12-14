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
    
    public CoutEtudiant(){
        DatabaseCM CM = new DatabaseCM();
        DatabaseVoeux CI = new DatabaseVoeux();
        Affectation affectation = new Affectation();
        
    }
    
    public int calculCE(int CM, int CI){
        int CE = CM + CI;
        return CE;
    }
    
    
    
}
