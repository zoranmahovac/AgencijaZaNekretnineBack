/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.model;

import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class CreateStatistikaModel {
    
    Long id;
    int brojKlijenata;

    public CreateStatistikaModel() {
    }

    public CreateStatistikaModel(Long id, int brojKlijenata) {
        this.id = id;
        this.brojKlijenata = brojKlijenata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBrojKlijenata() {
        return brojKlijenata;
    }

    public void setBrojKlijenata(int brojKlijenata) {
        this.brojKlijenata = brojKlijenata;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + this.brojKlijenata;
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
        final CreateStatistikaModel other = (CreateStatistikaModel) obj;
        if (this.brojKlijenata != other.brojKlijenata) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "CreateStatistikaModel{" + "id=" + id + ", brojKlijenata=" + brojKlijenata + '}';
    }
    
    
}
