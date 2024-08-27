/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import rs.fon.silab.application.model.TipKlijenta;
import rs.fon.silab.application.model.Ugovor;

/**
 *
 * @author Korisnik
 */
public class KlijentDto implements ApplicationDto{
    
    @NotNull
    @NotEmpty
    private String jmbgKlijenta;
    @NotEmpty
    private String imeKlijenta;
    
    @NotEmpty
    private String prezimeKlijenta;
    
    @NotNull
    private TipKlijenta tipKlijenta;
    private List<Ugovor> ugovori = new ArrayList<>(); 

    public KlijentDto() {
    }

    public KlijentDto(String jmbgKlijenta, String imeKlijenta, String prezimeKlijenta, TipKlijenta tipKlijenta, List<Ugovor> ugovori) {
        this.jmbgKlijenta = jmbgKlijenta;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.tipKlijenta = tipKlijenta;
        this.ugovori = ugovori;
    }

    public String getJmbgKlijenta() {
        return jmbgKlijenta;
    }

    public void setJmbgKlijenta(String jmbgKlijenta) {
        this.jmbgKlijenta = jmbgKlijenta;
    }

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public String getPrezimeKlijenta() {
        return prezimeKlijenta;
    }

    public void setPrezimeKlijenta(String prezimeKlijenta) {
        this.prezimeKlijenta = prezimeKlijenta;
    }

    public TipKlijenta getTipKlijenta() {
        return tipKlijenta;
    }

    public void setTipKlijenta(TipKlijenta tipKlijenta) {
        this.tipKlijenta = tipKlijenta;
    }

    public List<Ugovor> getUgovori() {
        return ugovori;
    }

    public void setUgovori(List<Ugovor> ugovori) {
        this.ugovori = ugovori;
    }

    @Override
    public String toString() {
        return "KlijentDto{" + "jmbgKlijenta=" + jmbgKlijenta + ", imeKlijenta=" + imeKlijenta + ", prezimeKlijenta=" + prezimeKlijenta + ", tipKlijenta=" + tipKlijenta + ", ugovori=" + ugovori + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.jmbgKlijenta);
        hash = 97 * hash + Objects.hashCode(this.imeKlijenta);
        hash = 97 * hash + Objects.hashCode(this.prezimeKlijenta);
        hash = 97 * hash + Objects.hashCode(this.tipKlijenta);
        hash = 97 * hash + Objects.hashCode(this.ugovori);
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
        final KlijentDto other = (KlijentDto) obj;
        return Objects.equals(this.jmbgKlijenta, other.jmbgKlijenta);
    }
    
    
    
}
