/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import org.springframework.stereotype.Component;
import rs.fon.silab.application.model.Klijent;

/**
 *
 * @author Korisnik
 */
 // ovo izbrisi ako ne valja ugovor nesto
public class UgovorDto implements ApplicationDto{
    //@Id
    @NotNull
    private Klijent klijent; //link to the Klijent entity
    
    @NotNull
    private Long brojUgovora;
    
    
    @NotEmpty
    private String adresaNekretnine;
    
    @Min(value=0)
    private double povrsinaNepokretnosti;
    
    @Min(value=0)
    private int sprat;
    
    private Date datumZakljucenja;
    
    @Min(value=0)
    private double cena;

    public UgovorDto() {
    }

    public UgovorDto(Klijent klijent, Long brojUgovora, String adresaNekretnine, double povrsinaNepokretnosti, int sprat, Date datumZakljucenja, double cena) {
        this.klijent = klijent;
        this.brojUgovora = brojUgovora;
        this.adresaNekretnine = adresaNekretnine;
        this.povrsinaNepokretnosti = povrsinaNepokretnosti;
        this.sprat = sprat;
        this.datumZakljucenja = datumZakljucenja;
        this.cena = cena;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
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

    @Override
    public String toString() {
        return "UgovorDto{" + "klijent=" + klijent + ", brojUgovora=" + brojUgovora + ", adresaNekretnine=" + adresaNekretnine + ", povrsinaNepokretnosti=" + povrsinaNepokretnosti + ", sprat=" + sprat + ", datumZakljucenja=" + datumZakljucenja + ", cena=" + cena + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.klijent);
        hash = 97 * hash + Objects.hashCode(this.brojUgovora);
        hash = 97 * hash + Objects.hashCode(this.adresaNekretnine);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.povrsinaNepokretnosti) ^ (Double.doubleToLongBits(this.povrsinaNepokretnosti) >>> 32));
        hash = 97 * hash + this.sprat;
        hash = 97 * hash + Objects.hashCode(this.datumZakljucenja);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.cena) ^ (Double.doubleToLongBits(this.cena) >>> 32));
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
        final UgovorDto other = (UgovorDto) obj;
        if (!Objects.equals(this.klijent, other.klijent)) {
            return false;
        }
        return Objects.equals(this.brojUgovora, other.brojUgovora);
    }
    
    
    
}
