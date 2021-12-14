/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author hnguyen01
 */
public class DatabaseCM {

    public static final double COUT_PROHIBITIF = 10000;
    
    private List<Etudiant> etudiants;
    private List<Module> modules;
    private List<CoutInscriptionEtudiantModule> coutsInscription;
    
    public DatabaseCM() {
        this.etudiants = new ArrayList<>();
        this.modules = new ArrayList<>();
        this.coutsInscription = new ArrayList<>();
    }
    
    public void createColonneEtudiant(){
        
        for (int i= 0; i < 100; i ++) {
            int id = Integer.parseInt(ExemplePersonnesAlea.PERSONNES_ALEA[i][0]);
            String nom = ExemplePersonnesAlea.PERSONNES_ALEA[i][1];
            String prenom = ExemplePersonnesAlea.PERSONNES_ALEA[i][2];
            Etudiant etudiant = new Etudiant(id, nom, prenom);
            this.etudiants.add(etudiant);
        } 
    }
    
    public String [] createGroupe1(){
        
        DatabaseModule groupe1 = DatabaseModule.create(DatabaseModule.DATABASE_MODULE);
        int NbrModuleG1 = groupe1.get(0).size();
        String[] modGroupe1 = new String[NbrModuleG1];
        for (int i= 0; i < NbrModuleG1; i ++) {
            String intitule = groupe1.get(0).get(i).getIntitule();
            int nbrPlaces = groupe1.get(0).get(i).getNbrPlace();
            modGroupe1[i] = intitule;
        }
         return modGroupe1;
    }
    
    public String [] createGroupe2(){
        
        DatabaseModule groupe2 = DatabaseModule.create(DatabaseModule.DATABASE_MODULE);
        int NbrModuleG2 = groupe2.get(0).size();
        String[] modGroupe2 = new String[NbrModuleG2];
        for (int i= 0; i < NbrModuleG2; i ++) {
            String intitule = groupe2.get(1).get(i).getIntitule();
            int nbrPlaces = groupe2.get(1).get(i).getNbrPlace();
            modGroupe2[i] = intitule;
        }   
        
        return modGroupe2;
    }
    
    
    private static int getRandomNumberinRange(int min, int max){
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }
    
    public double coutAlea(Random r) {              // Calculer le cout
        double cout;
        double alea = r.nextDouble();
        if (alea < 0.3) {
            // 30% des modules "interdits"
            cout = COUT_PROHIBITIF;
        } else if (alea < 0.8) {
            // 50% inscription normale
            cout = 0;
        } else if (alea < 0.9) {
            // 10% inscription deconseillée
            cout = 100;
        } else {
            // 10% inscription prioritaire
            cout = -100;
        }
        return cout;
    }
    
    
    public String toStringDetails(String[] groupe1, String[] groupe2) {
        
        StringBuilder res = new StringBuilder();
        
        res.append("---------------- Database des modules ---------------------\n");
        res.append(DatabaseModule.create(DatabaseModule.DATABASE_MODULE));
        
        DatabaseModule module = DatabaseModule.create(DatabaseModule.DATABASE_MODULE);
        int NbrModulesG1 = module.get(0).size();
        int NbrModulesG2 = module.get(1).size();
        int NbrModulesTotal = NbrModulesG1 + NbrModulesG2;
        
        String[][] CoutCM = new String[this.etudiants.size()+1][NbrModulesG1 + NbrModulesG2 + 1];
        CoutCM[0][0] = "Etudiants";
        for(int nm = 0 ; nm < NbrModulesTotal ; nm ++) {
            if (nm < NbrModulesG1) {
                CoutCM[0][nm+1] = groupe1[nm];
            } else {
                int nm2 = nm-5;
                CoutCM[0][nm+1] = groupe2[nm2];
            }
        }
        
        for (int ne = 0 ; ne < this.etudiants.size() ; ne ++) {
            Etudiant e = this.etudiants.get(ne);
            CoutCM[ne+1][0] = e.getNom() + " " + e.getPrenom();
            for (int nm = 0 ; nm < NbrModulesTotal ; nm ++) {
                double cout = coutAlea(new Random());
                if (nm < NbrModulesG1){
                    Module m = module.get(0).get(nm);
                    
                    CoutCM[ne+1][nm+1] = "" + cout;      

                } else {
                    int nm2 = nm - 5;
                    Module m = module.get(1).get(nm2);
                    CoutCM[ne+1][nm+1] = "" + cout;      

                }
            }
        }
        res.append("----------------- couts d'inscription -----------------\n");
        res.append(MatriceToText.formatMat(CoutCM, true));
        return res.toString();
    }
    
    public static void main(String[] args){
        DatabaseCM databaseCM = new DatabaseCM();
        databaseCM.createColonneEtudiant();
        String[] groupe1 = databaseCM.createGroupe1();
        String[] groupe2 = databaseCM.createGroupe2();
        System.out.println(databaseCM.toStringDetails(groupe1, groupe2));
    }
    
}
