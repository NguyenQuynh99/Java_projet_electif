/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewDatabase;

/**
 *
 * @author trucq
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Personnes "aléatoires" générées sur https://www.fakenamegenerator.com. pour
 * passer de la sortie csv à un String[][] java, par pattern :  * {@code 
 * ([^"]),  --> $1",  : ajout de " avant virgules (sauf si déjà)
 * ,([^"])  --> ,"$1  : ajout de " après virgules (sauf si déjà)
 *
 * (?m)^(.*)$    --> {"$1"},   : ajout de {" en début et "}, en fin de ligne  (?m) pour forcer le match multi-ligne
 *}
  * @author francois
 */
public class DatabaseModule extends ArrayList<List<Module>>{

    public static final String[][] DATABASE_MODULE = new String[][]{
        {"1", "BigDATA", "G1"},
        {"2", "Machine Learning", "G2"},
        {"3", "Theatre","G2"},
        {"4", "Negociate", "G1"},
        {"5", "Allemand", "G2"},
        {"6", "Anglais", "G2"},
        {"7", "ChampEM", "G2"},
        {"8", "Informatique", "G1"},
        {"9", "PSC1", "G1"},
        {"10", "Aviation", "G1"},};
    
    public static DatabaseModule create(String[][] datas) {
        DatabaseModule res = new DatabaseModule();
        int nbrGroupe = 0;
        for (int i = 0 ; i < datas.length; i ++) {
            String gr = datas[i] [2].substring(1);
            int grVal = Integer.parseInt(gr);
            if(nbrGroupe < grVal) {
                nbrGroupe = grVal;
            }
        }
        for (int i = 0 ; i < nbrGroupe ; i ++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0 ; i < datas.length; i ++) {
            Module m = new Module(Integer.parseInt(datas[i][0]),datas[i][1], 20);  //TODO nbr places
            String gr = datas[i] [2].substring(1);
            int grVal = Integer.parseInt(gr);
            res.get(grVal-1).add(m);
        }        
        return res;
    }
    
    public List<Module> tousLesModules() {
        List<Module> res = new ArrayList<>();
        for(int i = 0 ; i < this.size() ; i ++) {
            res.addAll(this.get(i));
        }
        return res;
    }
    
    public static void testBDDModule() {
        DatabaseModule bdd = create(DATABASE_MODULE);
        System.out.println(bdd);
    }
    
    public String toString(){
        String res = "";
        res = res + "base de modules : \n";
        for(int i = 0 ; i < this.size() ; i ++) {
            List<Module> modDuGroupe = this.get(i);
            for(int j = 0 ; j < modDuGroupe.size() ; j ++) {
                res = res + (i+1) + " : " + modDuGroupe.get(j) + "\n";
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        testBDDModule();
    }
    
    // ?? TODO ??
//    public static List<String> numeroModule() {
//        return Arrays.stream(DATABASE_MODULE).map((t) -> {
//            return t[0];
//        }).unordered().distinct().collect(Collectors.toList());
//    }
//
//    public static List<String> intituleModule() {
//        return Arrays.stream(DATABASE_MODULE).map((t) -> {
//            return t[1];
//        }).unordered().distinct().collect(Collectors.toList());
//    }
//    
//    public static List<String> groupeModule() {
//        return Arrays.stream(DATABASE_MODULE).map((t) -> {
//            return t[2];
//        }).unordered().distinct().collect(Collectors.toList());
//    }
}
