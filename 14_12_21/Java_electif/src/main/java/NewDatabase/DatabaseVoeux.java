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
public class DatabaseVoeux {
    
    public static final double COUT_VOEUX_1 = -500;
    public static final double COUT_VOEUX_2 = -200;
    public static final double COUT_VOEUX_INS = 1000;
    
    private List<Etudiant> etudiants;
    private List<Module> modules;
    public List<Module> voeux1G1;
    public List<Module> voeux2G1;
    public List<Module> voeux1G2;
    public List<Module> voeux2G2;

    public DatabaseVoeux() {
        this.etudiants = new ArrayList<>();
        this.voeux1G1 = new ArrayList<>();
        this.voeux2G1 = new ArrayList<>();
        this.voeux1G2 = new ArrayList<>();
        this.voeux2G2 = new ArrayList<>();

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
    
    private static int getRandomNumberinRange(int min, int max){
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }
    
    public String[][] createVoeuxGroupe1(){
        String [][] voeuxG1 = new String[100][2];
        String [] modulesIntitule = new String[5];        
        int [] moduleNbrPlaces = new int[5];
        
        
        DatabaseModule intitule = DatabaseModule.create(DatabaseModule.DATABASE_MODULE);
        for (int i = 0; i <5; i++){
            modulesIntitule[i] = intitule.get(0).get(i).getIntitule();
            moduleNbrPlaces[i] = intitule.get(0).get(i).getNbrPlace();
        }
        
        for (int i = 0; i < 100; i++){
            int r1 = 0;
            int r2 = 0;
            do {
                r1 = getRandomNumberinRange(0, 4);
                r2 = getRandomNumberinRange(0, 4);
            } while (r1 == r2);
            voeuxG1[i][0] = modulesIntitule[r1];
            voeuxG1[i][1] = modulesIntitule[r2];
        }
        return voeuxG1;
    }
    
    public String[][] createVoeuxGroupe2(){
        String [][] voeuxG2 = new String[100][2];
        String [] modulesIntitule = new String[5];        
        int [] moduleNbrPlaces = new int[5];
        
        
        DatabaseModule intitule = DatabaseModule.create(DatabaseModule.DATABASE_MODULE);
        for (int i = 0; i <5; i++){
            modulesIntitule[i] = intitule.get(1).get(i).getIntitule();
            moduleNbrPlaces[i] = intitule.get(1).get(i).getNbrPlace();
        }
        
        for (int i = 0; i < 100; i++){
            int r1 = 0;
            int r2 = 0;
            do {
                r1 = getRandomNumberinRange(0, 4);
                r2 = getRandomNumberinRange(0, 4);
            } while (r1 == r2);
            voeuxG2[i][0] = modulesIntitule[r1];
            voeuxG2[i][1] = modulesIntitule[r2];
        }
        return voeuxG2;
    }
    
    private String toStringDetail(String[][] voeuxG1, String[][] voeuxG2) {
        StringBuilder res = new StringBuilder();
        String[][] matCouts = new String[this.etudiants.size()+2][5];
        matCouts[0][0] = "Etudiants";
        matCouts[0][1] = "Voeux 1 G1";
        matCouts[0][2] = "Voeux 2 G1";
        matCouts[0][3] = "Voeux 1 G2";
        matCouts[0][4] = "Voeux 2 G2";
        for (int ne = 0 ; ne < this.etudiants.size() ; ne ++) {
            Etudiant e = this.etudiants.get(ne);
            matCouts[ne+1][0] = e.getNom() + " " + e.getPrenom();
            matCouts[ne+1][1] = voeuxG1[ne][0];
            matCouts[ne+1][2] = voeuxG1[ne][1];
            matCouts[ne+1][3] = voeuxG2[ne][0];
            matCouts[ne+1][4] = voeuxG2[ne][1];

        }
        res.append("----------------- Tableau des voeux -----------------\n");
        res.append(MatriceToText.formatMat(matCouts, true));
        return res.toString();
    }
    
    public String[][] listVoeux(){
        String[][] listVoeux = new String[100][5];
        String [] listEtudiant = new String[this.etudiants.size()];
        DatabaseVoeux voeux = new DatabaseVoeux();
        voeux.createColonneEtudiant();
        for (int ne=0; ne < this.etudiants.size(); ne++){
            Etudiant e = this.etudiants.get(ne);
            listEtudiant[ne] = e.getNom() + " " + e.getPrenom();
        }
        String[][] groupe1 = voeux.createVoeuxGroupe1();
        String[][] groupe2 = voeux.createVoeuxGroupe2();
        for (int i=0; i<this.etudiants.size(); i++){
            listVoeux[i][0]=listEtudiant[i];
            listVoeux[i][1]=groupe1[i][0];
            listVoeux[i][2]=groupe1[i][1];
            listVoeux[i][3]=groupe2[i][0];
            listVoeux[i][4]=groupe2[i][1];
        }
        return listVoeux;
    }
    
    public static void main(String[] args){
        //Affectation solution = new Affectation();
        DatabaseVoeux voeux = new DatabaseVoeux();
        voeux.createColonneEtudiant();
        String[][] listVoeux = voeux.listVoeux();
        String[][] voeuxG1 = voeux.createVoeuxGroupe1();
        String[][] voeuxG2 = voeux.createVoeuxGroupe2();
        System.out.println(voeux.toStringDetail(voeuxG1, voeuxG2));
        System.out.println(listVoeux[0][0] + " " + listVoeux[0][1]);
    }
}
