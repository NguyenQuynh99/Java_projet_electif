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
public class Module {
    
    private int id;
    private String intitule;
    private int nbrPlace;

    public Module(int id,String intitule, int nbrPlace) {
        this.id = id;
        this.intitule = intitule;
        this.nbrPlace = nbrPlace;
    }

    /**
     * @return the intitule
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * @return the nbrPlace
     */
    public int getNbrPlace() {
        return nbrPlace;
    }

    /**
     * @param nbrPlace the nbrPlace to set
     */
    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    @Override
    public String toString() {
        return "Module{" + "id=" + id + " , intitule=" + intitule + ", nbrPlace=" + nbrPlace + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.intitule);
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
        final Module other = (Module) obj;
        if (!Objects.equals(this.intitule, other.intitule)) {
            return false;
        }
        return true;
    }
    
    
    
}
