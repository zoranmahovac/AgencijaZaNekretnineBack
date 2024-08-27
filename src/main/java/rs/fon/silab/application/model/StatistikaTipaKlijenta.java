/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name="statistika_tipa_klijenta")
public class StatistikaTipaKlijenta implements ApplicationEntity{
   
   @EmbeddedId
   StatistikaTipaId id;
   
   @ManyToOne
   @JoinColumn(name="sifra_tipa",insertable=false, updatable=false)
   //@PrimaryKeyJoinColumn(name="sifra_tipa")
   @JsonIgnore
   private  TipKlijenta tipKlijenta;
   
  
   @ManyToOne
   @JoinColumn(name="redni_broj_u_registru_posrednika",insertable=false, updatable=false)
   @JsonIgnore
   //@PrimaryKeyJoinColumn(name="redni_broj_u_registru_posrednika")
   private Agent agent;
   
   @Column(name="broj_dodeljenih_klijenata_tipa")
   private int brojDodeljenihKLijenataTipa;

    public StatistikaTipaKlijenta() {
    }

    public StatistikaTipaKlijenta(StatistikaTipaId id, TipKlijenta tipKlijenta, Agent agent, int brojDodeljenihKLijenataTipa) {
        this.id = id;
        this.tipKlijenta = tipKlijenta;
        this.agent = agent;
        this.brojDodeljenihKLijenataTipa = brojDodeljenihKLijenataTipa;
    }

    
    
   

    public TipKlijenta getTipKlijenta() {
        return tipKlijenta;
    }

    public void setTipKlijenta(TipKlijenta tipKlijenta) {
        this.tipKlijenta = tipKlijenta;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public int getBrojDodeljenihKLijenataTipa() {
        return brojDodeljenihKLijenataTipa;
    }

    public void setBrojDodeljenihKLijenataTipa(int brojDodeljenihKLijenataTipa) {
        this.brojDodeljenihKLijenataTipa = brojDodeljenihKLijenataTipa;
    }

    @Override
    public String toString() {
        return "StatistikaTipaKlijenta{" + "tipKlijenta=" + tipKlijenta + ", agent=" + agent + ", brojDodeljenihKLijenataTipa=" + brojDodeljenihKLijenataTipa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.tipKlijenta);
        hash = 17 * hash + Objects.hashCode(this.agent);
        hash = 17 * hash + this.brojDodeljenihKLijenataTipa;
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
        final StatistikaTipaKlijenta other = (StatistikaTipaKlijenta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.tipKlijenta, other.tipKlijenta)) {
            return false;
        }
        return Objects.equals(this.agent, other.agent);
    }

    public StatistikaTipaId getId() {
        return id;
    }

    public void setId(StatistikaTipaId id) {
        this.id = id;
    }

    
   
   
}
 