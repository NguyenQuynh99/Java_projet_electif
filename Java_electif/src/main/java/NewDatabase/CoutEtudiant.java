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
    
    public String[] getCI(){
        CoutEtudiant test = new CoutEtudiant();
        String[][] listVoeux = test.getVoeux();
        String[][] listAff = test.getAffectation();
        String[] coutCI = new String[100];
        double coutCI1 = 0;
        double coutCI2 = 0;     
        double cout = 0;
        for (int i=0; i<100; i++){
            if (listAff[i][1] == listVoeux[i][1]){
                coutCI1 = COUT_VOEUX_1;
            }
            else if (listAff[i][1] == listVoeux[i][2]){
                coutCI1 = COUT_VOEUX_2;
            }
            else if ((listAff[i][1] != listVoeux[i][1])&(listAff[i][1] != listVoeux[i][2])){
                coutCI1 = COUT_VOEUX_INS;
            }
            if (listAff[i][2] == listVoeux[i][3]){
                coutCI2 = COUT_VOEUX_1;
            }
            else if (listAff[i][2] == listVoeux[i][4]){
                coutCI2 = COUT_VOEUX_2;
            }
            else if ((listAff[i][2] != listVoeux[i][3])&(listAff[i][2] != listVoeux[i][4])){
                coutCI2 = COUT_VOEUX_INS;
            }
            cout = coutCI1 + coutCI2;
            coutCI[i] = " "+cout;
        }
        return coutCI;
    }
    public CoutEtudiant(){
        DatabaseCM CM = new DatabaseCM();
        DatabaseVoeux CI = new DatabaseVoeux();
        Affectation affectation = new Affectation();
        String[][] listAff = affectation.listAffectation();  
    }
    
    
}
