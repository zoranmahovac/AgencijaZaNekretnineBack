/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class TipKlijentaDto implements ApplicationDto{
    
    @NotNull
    @Min(value=1)
    private long sifraTipa;
    @NotBlank
    private String nazivTipa;

    public TipKlijentaDto() {
    }

    public TipKlijentaDto(long sifraTipa, String nazivTipa) {
        this.sifraTipa = sifraTipa;
        this.nazivTipa = nazivTipa;
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
        hash = 73 * hash + (int) (this.sifraTipa ^ (this.sifraTipa >>> 32));
        hash = 73 * hash + Objects.hashCode(this.nazivTipa);
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
        final TipKlijentaDto other = (TipKlijentaDto) obj;
        return this.sifraTipa == other.sifraTipa;
    }

    @Override
    public String toString() {
        return "TipKlijentaDto{" + "sifraTipa=" + sifraTipa + ", nazivTipa=" + nazivTipa + '}';
    }
    
    
    
    
    


}
