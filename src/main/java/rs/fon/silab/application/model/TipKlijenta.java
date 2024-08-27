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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Korisnik
 */

@Entity
@Table(name="tip_klijenta")
public class TipKlijenta implements ApplicationEntity{
    @Id
    @Column(name="sifra_tipa")
    private long sifraTipa;
    @Column(name="naziv_tipa")
    private String nazivTipa;

    @OneToMany(mappedBy="tipKlijenta", fetch = FetchType.LAZY, orphanRemoval=true,cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<StatistikaTipaKlijenta> statistike = new HashSet<>();
    
    public TipKlijenta() {
    }

    public TipKlijenta(long sifraTipa, String nazivTipa) {
        this.sifraTipa = sifraTipa;
        this.nazivTipa = nazivTipa;
    }
     public TipKlijenta(long sifraTipa, String nazivTipa, Set<StatistikaTipaKlijenta> stk) {
        this.sifraTipa = sifraTipa;
        this.nazivTipa = nazivTipa;
        this.statistike = stk;
    }


    
    
    
    public long getSifraTipa() {
        return sifraTipa;
    }

    public void setSifraTipa(long sifraTipa) {
        this.sifraTipa = sifraTipa;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.sifraTipa ^ (this.sifraTipa >>> 32));
        hash = 97 * hash + Objects.hashCode(this.nazivTipa);
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
        final TipKlijenta other = (TipKlijenta) obj;
        return this.sifraTipa == other.sifraTipa;
    }

    public Set<StatistikaTipaKlijenta> getStatistike() {
        return statistike;
    }

    public void setStatistike(Set<StatistikaTipaKlijenta> statistike) {
        this.statistike = statistike;
    }

    
    
    
    
    
    
}
