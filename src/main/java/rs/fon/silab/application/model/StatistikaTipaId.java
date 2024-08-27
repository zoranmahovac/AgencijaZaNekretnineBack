/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
@Embeddable
public class StatistikaTipaId implements Serializable{
    @Column(name="sifra_tipa")
    private Long sifraTipa;
    @Column(name="redni_broj_u_registru_posrednika")
    private Long redniBrojURegistruPosrednika;
    @Column(name="id")
    private Long id;

    public StatistikaTipaId() {
    }

    public StatistikaTipaId(Long sifraTipa, Long redniBrojURegistruPosrednika, Long id) {
        this.sifraTipa = sifraTipa;
        this.redniBrojURegistruPosrednika = redniBrojURegistruPosrednika;
        this.id = id;
    }

    public Long getSifraTipa() {
        return sifraTipa;
    }

    public void setSifraTipa(Long sifraTipa) {
        this.sifraTipa = sifraTipa;
    }

    public Long getRedniBrojURegistruPosrednika() {
        return redniBrojURegistruPosrednika;
    }

    public void setRedniBrojURegistruPosrednika(Long redniBrojURegistruPosrednika) {
        this.redniBrojURegistruPosrednika = redniBrojURegistruPosrednika;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.sifraTipa);
        hash = 83 * hash + Objects.hashCode(this.redniBrojURegistruPosrednika);
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final StatistikaTipaId other = (StatistikaTipaId) obj;
        if (!Objects.equals(this.sifraTipa, other.sifraTipa)) {
            return false;
        }
        if (!Objects.equals(this.redniBrojURegistruPosrednika, other.redniBrojURegistruPosrednika)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "StatistikaTipaId{" + "sifraTipa=" + sifraTipa + ", redniBrojURegistruPosrednika=" + redniBrojURegistruPosrednika + ", id=" + id + '}';
    }
    
    
    
}
