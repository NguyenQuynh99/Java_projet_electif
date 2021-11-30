/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author trucq
 */
public class Affectation {
    

    private List<Etudiant> etudiants;
    private List<Module> modulesGroup1;
    private List<Module> modulesGroup2;

    public Affectation() {
        this.etudiants = new ArrayList<>();
        this.modulesGroup1 = new ArrayList<>();
        this.modulesGroup2 = new ArrayList<>();
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
    public String [] creatieColonneGroupe1(){
        String [] affectationModules = new String[100];
        String [] modulesIntitule = new String[5];        
        int [] moduleNbrPlaces = new int[5];
        
        
        DatabaseModule intitule = DatabaseModule.create(DatabaseModule.DATABASE_MODULE);
        for (int i = 0; i <5; i++){
            modulesIntitule[i] = intitule.get(0).get(i).getIntitule();
            moduleNbrPlaces[i] = intitule.get(0).get(i).getNbrPlace();
        }
        
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < moduleNbrPlaces[j]; i++) {
               int r = 0;
               do {
                    r = getRandomNumberinRange(0, 99);
               } while (affectationModules[r] != null);
               // r = 0; r = 0????
               affectationModules[r] = modulesIntitule[j];
            }
        }
        return affectationModules;
    }
    
    public String [] creatieColonneGroupe2(){
        String [] affectationModules = new String[100];
        String [] modulesIntitule = new String[5];        
        int [] moduleNbrPlaces = new int[5];
        
        
        DatabaseModule intitule = DatabaseModule.create(DatabaseModule.DATABASE_MODULE);
        for (int i = 0; i <5; i++){
            modulesIntitule[i] = intitule.get(1).get(i).getIntitule();
            moduleNbrPlaces[i] = intitule.get(1).get(i).getNbrPlace();
        }
        
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < moduleNbrPlaces[j]; i++) {
               int r = 0;
               do {
                    r = getRandomNumberinRange(0, 99);
               } while (affectationModules[r] != null);
               // r = 0; r = 0????
               affectationModules[r] = modulesIntitule[j];
            }
        }
        return affectationModules;
    }
    
    private String toStringDetail(String[] groupe1, String[] groupe2) {
        StringBuilder res = new StringBuilder();
        String[][] matCouts = new String[this.etudiants.size()+1][3];
        matCouts[0][0] = "Etudiants";
        matCouts[0][1] = "Groupe 1";
        matCouts[0][2] = "Groupe 2";
        for (int ne = 0 ; ne < this.etudiants.size() ; ne ++) {
            Etudiant e = this.etudiants.get(ne);
            matCouts[ne+1][0] = e.getNom() + " " + e.getPrenom();
            matCouts[ne+1][1] = groupe1[ne];
            matCouts[ne+1][2] = groupe2[ne];

        }
        res.append("----------------- Affectation -----------------\n");
        res.append(Database.MatriceToText.formatMat(matCouts, true));
        return res.toString();
    }
    
    public static void main(String[] args){
        //Affectation solution = new Affectation();
        Affectation affectation = new Affectation();
        affectation.createColonneEtudiant();
        String[] groupe1 = affectation.creatieColonneGroupe1();
        String[] groupe2 = affectation.creatieColonneGroupe2();
        System.out.println(affectation.toStringDetail(groupe1, groupe2));
        }
    }
    
