/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDatabase;

import NewDatabase.ExemplePersonnesAlea;
import NewDatabase.MatriceToText;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author hnguyen01
 */
public class MainProgram {

    private List<Etudiant> etudiants;
    private DatabaseModule modules;
    private List<CoutInscriptionEtudiantModule> coutsInscription;

    public MainProgram() {
        this.etudiants = new ArrayList<>();
        this.modules = new DatabaseModule();
        this.coutsInscription = new ArrayList<>();
    }
    
    

    @Override
    public String toString() {
        return "Database{" + "etudiants=" + etudiants.size() + ", modules=" + modules.size() + 
                ", coutsInscription=" + coutsInscription.size() + '}';
    }

    
    public String toStringDetails() {
        StringBuilder res = new StringBuilder();
        res.append("---------------- les étudiants ---------------------\n");
        for (Etudiant e : this.etudiants) {
            res.append(e.toString());
            res.append("\n");
        }
        res.append("---------------- les modules ---------------------\n");
        res.append(this.modules);
        String[][] matCouts = new String[this.etudiants.size()+1][this.modules.size()+1];
        matCouts[0][0] = "";
        List<Module> lesMods = this.modules.tousLesModules();
        for(int nm = 0 ; nm < lesMods.size() ; nm ++) {
            matCouts[0][nm+1] = lesMods.get(nm).getIntitule();
        }
        for (int ne = 0 ; ne < this.etudiants.size() ; ne ++) {
            Etudiant e = this.etudiants.get(ne);
            matCouts[ne+1][0] = e.getNom() + " " + e.getPrenom();
            for (int nm = 0 ; nm < this.modules.size() ; nm ++) {
                Module m = lesMods.get(nm);
                matCouts[ne+1][nm+1] = "" + this.findCout(e, m);
            }
        }
        res.append("----------------- couts d'inscription -----------------\n");
        res.append(MatriceToText.formatMat(matCouts, true));
        return res.toString();
 
// TODO
//     String[][] matModule = new String[11][3];
//        matCouts[0][0] = "";
//        for(int nm = 0 ; nm < this.modules.size() ; nm ++) {
//            matCouts[0][nm+1] = this.modules.get(nm).getIntitule();
//        }
//        for (int ne = 0 ; ne < this.etudiants.size() ; ne ++) {
//            Etudiant e = this.etudiants.get(ne);
//            matCouts[ne+1][0] = e.getNom() + " " + e.getPrenom();
//            for (int nm = 0 ; nm < this.modules.size() ; nm ++) {
//                Module m = this.modules.get(nm);
//                matCouts[ne+1][nm+1] = "" + this.findCout(e, m);
//            }
//        }
//        res.append("----------------- Base de donnée de module -----------------\n");
//        res.append(MatriceToText.formatMat(matCouts, true));
//        return res.toString();
    }

    /**
     * @return the etudiants
     */
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * @return the modules
     */
    public DatabaseModule getModules() {
        return modules;
    }

    public boolean addEtudiant(Etudiant e) {
        if (this.etudiants.contains(e)) {
            return false;
        } else {
            this.etudiants.add(e);
            return true;
        }
    }

    public Double findCout(Etudiant e,Module m) {
        int pos = this.coutsInscription.indexOf(new CoutInscriptionEtudiantModule(e, m, 0));
        if (pos == -1) {
            return null;
        } else {
            return this.coutsInscription.get(pos).getCout();
        }
    }

    public void addEtudiantAlea(int nbr, Random r) {
        List<String> noms = ExemplePersonnesAlea.nomsAlea();
        List<String> prenoms = ExemplePersonnesAlea.nomsAlea();
        int i = 0;
        while (i < nbr) {
            Etudiant alea = new Etudiant(
                    i+1,
                    noms.get(r.nextInt(noms.size())),
                    prenoms.get(r.nextInt(prenoms.size()))
            );
            if (this.addEtudiant(alea)) {
                i++;
            }
        }
    }

// TODO : a modifier et mettre dans DatabaseModule
//    public void addModulesAlea(int nbr, Random r) {
//        int i = 0;
//        while (i < nbr) {
//            Module alea = new Module(
//                    i+1,
//                    "Module " + i,
//                    20 + r.nextInt(20));
//            if (this.addModule(alea)) {
//                i++;
//            }
//        }
//    }

    public void generateCoutsAlea(Random r) {
        this.coutsInscription.clear();
        for (Etudiant e : this.etudiants) {
            for (Module m : this.modules.tousLesModules()) {
                this.coutsInscription.add(
                        CoutInscriptionEtudiantModule.coutAlea(e, m, r));
            }
        }
    }
    
    // CM
    public static MainProgram databaseAlea(int nbrEtudiants, int nbrModules, Random r) {
        MainProgram res = new MainProgram();
        res.addEtudiantAlea(nbrEtudiants, r);
        // TODO appel à la méthode de DatabaseModule
//        res.addModulesAlea(nbrModules, r);
        res.generateCoutsAlea(r);
        return res;
    }

    public static void test1() {
        MainProgram dbalea = MainProgram.databaseAlea(10, 8, new Random());
        System.out.println("database aléa : \n" + dbalea.toStringDetails());
    }

        public static void test2() {
        MainProgram dbalea = MainProgram.databaseAlea(10, 8, new Random());
        System.out.println("database aléa : \n" + dbalea.toStringDetails());
    }
        
    public static void main(String[] args) {
        MainProgram.test1();

    }

}
