/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewDatabase;

import java.util.Objects;

/**
 *
 * @author hnguyen01
 */
public class Etudiant {
    
    private int id;
    private String nom;
    private String prenom;

    public Etudiant(int id,String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "nom=" + nom + ", prenom=" + prenom + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.prenom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Etudiant other = (Etudiant) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        return true;
    }
    
    
    
}