/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.model;

import jakarta.persistence.Entity;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */

public class CreateAngazovanjeModel {
    
    Long id;
    double provizija;
    boolean realizovano;

    public CreateAngazovanjeModel() {
    }

    public CreateAngazovanjeModel(Long id, double provizija, boolean realizovano) {
        this.id = id;
        this.provizija = provizija;
        this.realizovano = realizovano;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.provizija) ^ (Double.doubleToLongBits(this.provizija) >>> 32));
        hash = 97 * hash + (this.realizovano ? 1 : 0);
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
        final CreateAngazovanjeModel other = (CreateAngazovanjeModel) obj;
        return Objects.equals(this.id, other.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getProvizija() {
        return provizija;
    }

    public void setProvizija(double provizija) {
        this.provizija = provizija;
    }

    public boolean isRealizovano() {
        return realizovano;
    }

    public void setRealizovano(boolean realizovano) {
        this.realizovano = realizovano;
    }

    @Override
    public String toString() {
        return "CreateAngazovanjeModel{" + "id=" + id + ", provizija=" + provizija + ", realizovano=" + realizovano + '}';
    }
    
    
}
