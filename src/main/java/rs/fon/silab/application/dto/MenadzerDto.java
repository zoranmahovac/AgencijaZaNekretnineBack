/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.dto;

import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 *
 * @author Korisnik
 */
public class MenadzerDto implements ApplicationDto{
    
    private Long id; 
    private String imeMenadzera;
    private String prezimeMenadzera;
    private String korisnickoIme;
    private String lozinka;

    public MenadzerDto() {
    }

    public MenadzerDto(Long id, String imeMenadzera, String prezimeMenadzera, String korisnickoIme, String lozinka) {
        this.id = id;
        this.imeMenadzera = imeMenadzera;
        this.prezimeMenadzera = prezimeMenadzera;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
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
    public String toString() {
        return "MenadzerDto{" + "id=" + id + ", imeMenadzera=" + imeMenadzera + ", prezimeMenadzera=" + prezimeMenadzera + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.imeMenadzera);
        hash = 17 * hash + Objects.hashCode(this.prezimeMenadzera);
        hash = 17 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 17 * hash + Objects.hashCode(this.lozinka);
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
        final MenadzerDto other = (MenadzerDto) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
    
}
