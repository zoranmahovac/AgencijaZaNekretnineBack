/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name="klijent")
public class Klijent implements ApplicationEntity{
    
    @Id
    @Column(name="jmbg_klijenta")
    private String jmbgKlijenta;
    
    @Column(name="ime_klijenta")
    private String imeKlijenta;
    
    @Column(name="prezime_klijenta")
    private String prezimeKlijenta;
    
    @ManyToOne
    @JoinColumn(name="tip_klijenta")
    @JsonIgnore
    private TipKlijenta tipKlijenta;
    
    @OneToMany(mappedBy="klijent", fetch = FetchType.LAZY, orphanRemoval = true,cascade=CascadeType.ALL) // jedan klijent na vise ugovora
    //@JoinColumn(name="jmbg_klijenta")
    @JsonIgnore
    private List<Ugovor> ugovori = new ArrayList<>();

    public Klijent() {
    }

    public Klijent(String jmbgKlijenta, String imeKlijenta, String prezimeKlijenta, TipKlijenta tipKlijenta, List<Ugovor> ugovori) {
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
        return "Klijent{" + "jmbgKlijenta=" + jmbgKlijenta + ", imeKlijenta=" + imeKlijenta + ", prezimeKlijenta=" + prezimeKlijenta + ", tipKlijenta=" + tipKlijenta + ", ugovori=" + ugovori + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.jmbgKlijenta);
        hash = 47 * hash + Objects.hashCode(this.imeKlijenta);
        hash = 47 * hash + Objects.hashCode(this.prezimeKlijenta);
        hash = 47 * hash + Objects.hashCode(this.tipKlijenta);
        hash = 47 * hash + Objects.hashCode(this.ugovori);
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
        final Klijent other = (Klijent) obj;
        return Objects.equals(this.jmbgKlijenta, other.jmbgKlijenta);
    }
    
    
    public void addUgovor(Ugovor ugovor){
        ugovor.setKlijent(this);
        //prima ugovor i setuje na njega ovog klijenta? 
    }
    
    
    
    
    
    
    
 
    
}
