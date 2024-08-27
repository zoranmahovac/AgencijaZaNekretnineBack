/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name="agent")
public class Agent implements ApplicationEntity{
    @Id
    @Column(name="redni_broj_u_registru_posrednika")
    private long redniBrojURegistruPosrednika;
    @Column(name="ime_agenta")
    private String imeAgenta;
    @Column(name="prezime_agenta")
    private String prezimeAgenta;
    @Column(name="adresa_agenta")
    private String adresaAgenta;
    @Column(name="uspesnost_realizacije")
    private double uspesnostRealizacije;
    @Column(name="broj_dodeljenih_klijenata")
    private int brojDodeljenihKlijenata;

    //private HashSet<TipKlijenta> tipoviKlijenata = new HashSet<>();
    @OneToMany(mappedBy="agent",cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<StatistikaTipaKlijenta> statistike = new HashSet<>();
    
    @OneToMany(mappedBy="agent", cascade=CascadeType.ALL) // kad izbrises  agenta brisu se kaskadno i njegova angazovanja 
    @JsonIgnore
    private Set<Angazovanje> angazovanja = new HashSet<>(); // prazna lista
    
    
    public Agent() {
    }

    public Agent(long redniBrojURegistruPosrednika, String imeAgenta, String prezimeAgenta, String adresaAgenta, double uspesnostRealizacije, int brojDodeljenihKlijenata) {
        this.redniBrojURegistruPosrednika = redniBrojURegistruPosrednika;
        this.imeAgenta = imeAgenta;
        this.prezimeAgenta = prezimeAgenta;
        this.adresaAgenta = adresaAgenta;
        this.uspesnostRealizacije = uspesnostRealizacije;
        this.brojDodeljenihKlijenata = brojDodeljenihKlijenata;
    }
    
      public Agent(long redniBrojURegistruPosrednika, String imeAgenta, String prezimeAgenta, String adresaAgenta, double uspesnostRealizacije, int brojDodeljenihKlijenata, Set<StatistikaTipaKlijenta> stk) {
        this.redniBrojURegistruPosrednika = redniBrojURegistruPosrednika;
        this.imeAgenta = imeAgenta;
        this.prezimeAgenta = prezimeAgenta;
        this.adresaAgenta = adresaAgenta;
        this.uspesnostRealizacije = uspesnostRealizacije;
        this.brojDodeljenihKlijenata = brojDodeljenihKlijenata;
        this.statistike = stk;
    }

    public Set<Angazovanje> getAngazovanja() {
        return angazovanja;
    }

    public void setAngazovanja(Set<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }
    
      

    public Set<StatistikaTipaKlijenta> getStatistike() {
        return statistike;
    }

    public void setStatistike(Set<StatistikaTipaKlijenta> statistike) {
        this.statistike = statistike;
    }
    
    
    

    public long getRedniBrojURegistruPosrednika() {
        return redniBrojURegistruPosrednika;
    }

    public void setRedniBrojURegistruPosrednika(long redniBrojURegistruPosrednika) {
        this.redniBrojURegistruPosrednika = redniBrojURegistruPosrednika;
    }

    public String getImeAgenta() {
        return imeAgenta;
    }

    public void setImeAgenta(String imeAgenta) {
        this.imeAgenta = imeAgenta;
    }

    public String getPrezimeAgenta() {
        return prezimeAgenta;
    }

    public void setPrezimeAgenta(String prezimeAgenta) {
        this.prezimeAgenta = prezimeAgenta;
    }

    public String getAdresaAgenta() {
        return adresaAgenta;
    }

    public void setAdresaAgenta(String adresaAgenta) {
        this.adresaAgenta = adresaAgenta;
    }

    public double getUspesnostRealizacije() {
        return uspesnostRealizacije;
    }

    public void setUspesnostRealizacije(double uspesnostRealizacije) {
        this.uspesnostRealizacije = uspesnostRealizacije;
    }

    public int getBrojDodeljenihKlijenata() {
        return brojDodeljenihKlijenata;
    }

    public void setBrojDodeljenihKlijenata(int brojDodeljenihKlijenata) {
        this.brojDodeljenihKlijenata = brojDodeljenihKlijenata;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.redniBrojURegistruPosrednika ^ (this.redniBrojURegistruPosrednika >>> 32));
        hash = 97 * hash + Objects.hashCode(this.imeAgenta);
        hash = 97 * hash + Objects.hashCode(this.prezimeAgenta);
        hash = 97 * hash + Objects.hashCode(this.adresaAgenta);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.uspesnostRealizacije) ^ (Double.doubleToLongBits(this.uspesnostRealizacije) >>> 32));
        hash = 97 * hash + this.brojDodeljenihKlijenata;
        return hash;
    }

    @Override
    public String toString() {
        return "Agent{" + "redniBrojURegistruPosrednika=" + redniBrojURegistruPosrednika + ", imeAgenta=" + imeAgenta + ", prezimeAgenta=" + prezimeAgenta + ", adresaAgenta=" + adresaAgenta + ", uspesnostRealizacije=" + uspesnostRealizacije + ", brojDodeljenihKlijenata=" + brojDodeljenihKlijenata + '}';
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
        final Agent other = (Agent) obj;
        return this.redniBrojURegistruPosrednika == other.redniBrojURegistruPosrednika;
    }

    

    
    
    
}
