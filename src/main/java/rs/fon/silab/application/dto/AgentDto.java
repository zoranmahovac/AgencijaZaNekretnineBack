/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class AgentDto implements ApplicationDto{
    @NotNull
    private long redniBrojURegistruPosrednika;
    @NotBlank
    private String imeAgenta;
    @NotBlank
    private String prezimeAgenta;
    @NotBlank
    private String adresaAgenta;
    @Min(value=0)
    @Max(value=100)
    private double uspesnostRealizacije;
    @Min(value=0)
    private int brojDodeljenihKlijenata;

    public AgentDto() {
    }

    public AgentDto(long redniBrojURegistruPosrednika, String imeAgenta, String prezimeAgenta, String adresaAgenta, double uspesnostRealizacije, int brojDodeljenihKlijenata) {
        this.redniBrojURegistruPosrednika = redniBrojURegistruPosrednika;
        this.imeAgenta = imeAgenta;
        this.prezimeAgenta = prezimeAgenta;
        this.adresaAgenta = adresaAgenta;
        this.uspesnostRealizacije = uspesnostRealizacije;
        this.brojDodeljenihKlijenata = brojDodeljenihKlijenata;
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
    public String toString() {
        return "AgentDto{" + "redniBrojURegistruPosrednika=" + redniBrojURegistruPosrednika + ", imeAgenta=" + imeAgenta + ", prezimeAgenta=" + prezimeAgenta + ", adresaAgenta=" + adresaAgenta + ", uspesnostRealizacije=" + uspesnostRealizacije + ", brojDodeljenihKlijenata=" + brojDodeljenihKlijenata + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.redniBrojURegistruPosrednika ^ (this.redniBrojURegistruPosrednika >>> 32));
        hash = 29 * hash + Objects.hashCode(this.imeAgenta);
        hash = 29 * hash + Objects.hashCode(this.prezimeAgenta);
        hash = 29 * hash + Objects.hashCode(this.adresaAgenta);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.uspesnostRealizacije) ^ (Double.doubleToLongBits(this.uspesnostRealizacije) >>> 32));
        hash = 29 * hash + this.brojDodeljenihKlijenata;
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
        final AgentDto other = (AgentDto) obj;
        return this.redniBrojURegistruPosrednika == other.redniBrojURegistruPosrednika;
    }


    

}


