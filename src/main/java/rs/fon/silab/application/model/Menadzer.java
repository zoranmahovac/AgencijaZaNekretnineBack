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
@Entity // klasa mapirana na tabelu Baze podataka menadzer. Svaka njena instanca jedan je red te tabele.
@Table(name="menadzer")
public class Menadzer implements ApplicationEntity{
    @Id // polje koje je primarni kljuc tabele 
    @Column(name="id") // kolona na koju se mapira atribut 
    private Long id; 
    @Column(name="ime_menadzera")
    private String imeMenadzera;
    @Column(name="prezime_menadzera")
    private String prezimeMenadzera;
    @Column(name="korisnicko_ime")
    private String korisnickoIme;
    @Column(name="lozinka")
    private String lozinka;

    @OneToMany(mappedBy="menadzer", cascade=CascadeType.ALL) // kad izbrises menadzera brisu se kaskadno i njegova angazovanja 
    @JsonIgnore
    private Set<Angazovanje> angazovanja = new HashSet<>(); // prazna lista
    
    public Menadzer() {
    }

    public Menadzer(Long id, String imeMenadzera, String prezimeMenadzera, String korisnickoIme, String lozinka) {
        this.id = id;
        this.imeMenadzera = imeMenadzera;
        this.prezimeMenadzera = prezimeMenadzera;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Set<Angazovanje> getAngazovanja() {
        return angazovanja;
    }

    public void setAngazovanja(Set<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImeMenadzera() {
        return imeMenadzera;
    }

    public void setImeMenadzera(String imeMenadzera) {
        this.imeMenadzera = imeMenadzera;
    }

    public String getPrezimeMenadzera() {
        return prezimeMenadzera;
    }

    public void setPrezimeMenadzera(String prezimeMenadzera) {
        this.prezimeMenadzera = prezimeMenadzera;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Menadzer other = (Menadzer) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Menadzer{" + "id=" + id + ", imeMenadzera=" + imeMenadzera + ", prezimeMenadzera=" + prezimeMenadzera + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + '}';
    }
    
    
    
    

    
    
    
    
    
}
