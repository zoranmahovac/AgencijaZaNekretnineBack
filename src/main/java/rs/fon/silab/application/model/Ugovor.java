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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name="ugovor")
public class Ugovor implements ApplicationEntity{
    
    //@Id
    @ManyToOne
    @JoinColumn(name="jmbg_klijenta") // zato sto ugovor u sebi ima jmbg klijenta, ovime se spaja jmbg klijenta sa odg ugovorom iz ugovora gde je isto jmbg klijenta
    @JsonIgnore
    //@PrimaryKeyJoinColumn(name="jmbg_klijenta")
    private Klijent klijent; //link to the Klijent entity
    
    @Column(name="broj_ugovora")
    //@PrimaryKeyJoinColumn(name="broj_ugovora")
    @Id
    private Long brojUgovora;
    
    @Column(name="adresa_nekretnine")
    private String adresaNekretnine;
    
    @Column(name="povrsina_nepokretnosti")
    private double povrsinaNepokretnosti;
    
    @Column(name="sprat")
    private int sprat;
    
    @Column(name="datum_zakljucenja")
    private Date datumZakljucenja;
    
    @Column(name="cena")
    private double cena;
    
    @OneToMany(mappedBy="ugovor",cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<Angazovanje> angazovanja = new HashSet<>(); // referenca na sva postojeca angazovanja po osnovu tog ugovora, hocu da kada se izbrise ugovor da nestane i angazovanje
    

    public Ugovor() {
    }

    public Ugovor(Long brojUgovora, String adresaNekretnine, double povrsinaNepokretnosti, int sprat, Date datumZakljucenja, double cena, Klijent klijent) {
        this.brojUgovora = brojUgovora;
        this.adresaNekretnine = adresaNekretnine;
        this.povrsinaNepokretnosti = povrsinaNepokretnosti;
        this.sprat = sprat;
        this.datumZakljucenja = datumZakljucenja;
        this.cena = cena;
        this.klijent = klijent;
    }

    public Set<Angazovanje> getAngazovanja() {
        return angazovanja;
    }

    public void setAngazovanja(Set<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }

    
    
    public Long getBrojUgovora() {
        return brojUgovora;
    }

    public void setBrojUgovora(Long brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

    public String getAdresaNekretnine() {
        return adresaNekretnine;
    }

    public void setAdresaNekretnine(String adresaNekretnine) {
        this.adresaNekretnine = adresaNekretnine;
    }

    public double getPovrsinaNepokretnosti() {
        return povrsinaNepokretnosti;
    }

    public void setPovrsinaNepokretnosti(double povrsinaNepokretnosti) {
        this.povrsinaNepokretnosti = povrsinaNepokretnosti;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public Date getDatumZakljucenja() {
        return datumZakljucenja;
    }

    public void setDatumZakljucenja(Date datumZakljucenja) {
        this.datumZakljucenja = datumZakljucenja;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    @Override
    public String toString() {
        return "Ugovor{" + "brojUgovora=" + brojUgovora + ", adresaNekretnine=" + adresaNekretnine + ", povrsinaNepokretnosti=" + povrsinaNepokretnosti + ", sprat=" + sprat + ", datumZakljucenja=" + datumZakljucenja + ", cena=" + cena + ", klijent=" + klijent + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.brojUgovora);
        hash = 41 * hash + Objects.hashCode(this.adresaNekretnine);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.povrsinaNepokretnosti) ^ (Double.doubleToLongBits(this.povrsinaNepokretnosti) >>> 32));
        hash = 41 * hash + this.sprat;
        hash = 41 * hash + Objects.hashCode(this.datumZakljucenja);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.cena) ^ (Double.doubleToLongBits(this.cena) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.klijent);
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
        final Ugovor other = (Ugovor) obj;
        if (!Objects.equals(this.brojUgovora, other.brojUgovora)) {
            return false;
        }
        return Objects.equals(this.klijent, other.klijent);
    }
    
    
    
    
    
}
