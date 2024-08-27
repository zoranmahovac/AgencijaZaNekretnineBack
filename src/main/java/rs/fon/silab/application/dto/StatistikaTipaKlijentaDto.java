/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import rs.fon.silab.application.model.Agent;
import rs.fon.silab.application.model.StatistikaTipaId;
import rs.fon.silab.application.model.TipKlijenta;

/**
 *
 * @author Korisnik
 */

public class StatistikaTipaKlijentaDto implements ApplicationDto{

   @NotNull
   private StatistikaTipaId id;
   @NotNull
   private  TipKlijenta tipKlijenta;
   
   @NotNull
   private Agent agent;
   
   @Min(value=0)
   private int brojDodeljenihKLijenataTipa;

    public StatistikaTipaKlijentaDto() {
    }

    public StatistikaTipaKlijentaDto(StatistikaTipaId id, TipKlijenta tipKlijenta, Agent agent, int brojDodeljenihKLijenataTipa) {
        this.id = id;
        this.tipKlijenta = tipKlijenta;
        this.agent = agent;
        this.brojDodeljenihKLijenataTipa = brojDodeljenihKLijenataTipa;
    }

    public StatistikaTipaId getId() {
        return id;
    }

    public void setId(StatistikaTipaId id) {
        this.id = id;
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
        return "StatistikaTipaKlijentaDto{" + "id=" + id + ", tipKlijenta=" + tipKlijenta + ", agent=" + agent + ", brojDodeljenihKLijenataTipa=" + brojDodeljenihKLijenataTipa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.tipKlijenta);
        hash = 83 * hash + Objects.hashCode(this.agent);
        hash = 83 * hash + this.brojDodeljenihKLijenataTipa;
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
        final StatistikaTipaKlijentaDto other = (StatistikaTipaKlijentaDto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.tipKlijenta, other.tipKlijenta)) {
            return false;
        }
        return Objects.equals(this.agent, other.agent);
    }
   
     
    
    
    
}
