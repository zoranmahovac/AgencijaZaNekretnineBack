/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.dto;

import java.util.Objects;
import rs.fon.silab.application.model.Agent;
import rs.fon.silab.application.model.Klijent;
import rs.fon.silab.application.model.Menadzer;
import rs.fon.silab.application.model.Ugovor;

/**
 *
 * @author Korisnik
 */

public class AngazovanjeDto implements ApplicationDto{
    
    private Long rbAngazovanja;
    private double provizija;
    private boolean realizovano;
    private Agent agent;
    private Menadzer menadzer;
    private Ugovor ugovor;
    private Klijent klijent;

    public AngazovanjeDto() {
    }

    public AngazovanjeDto(Long rbAngazovanja, double provizija, boolean realizovano, Agent agent, Menadzer menadzer, Ugovor ugovor, Klijent klijent) {
        this.rbAngazovanja = rbAngazovanja;
        this.provizija = provizija;
        this.realizovano = realizovano;
        this.agent = agent;
        this.menadzer = menadzer;
        this.ugovor = ugovor;
        this.klijent = klijent;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    
    public Long getRbAngazovanja() {
        return rbAngazovanja;
    }

    public void setRbAngazovanja(Long rbAngazovanja) {
        this.rbAngazovanja = rbAngazovanja;
    }

    public double getProvizija() {
        return provizija;
    }

    public void setProvizija(double provizija) {
        this.provizija = provizija;
    }

    public boolean isRealizovano() {
        return realizovano;
    }

    public void setRealizovano(boolean realizovano) {
        this.realizovano = realizovano;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    public Ugovor getUgovor() {
        return ugovor;
    }

    public void setUgovor(Ugovor ugovor) {
        this.ugovor = ugovor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.rbAngazovanja);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.provizija) ^ (Double.doubleToLongBits(this.provizija) >>> 32));
        hash = 97 * hash + (this.realizovano ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.agent);
        hash = 97 * hash + Objects.hashCode(this.menadzer);
        hash = 97 * hash + Objects.hashCode(this.ugovor);
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
        final AngazovanjeDto other = (AngazovanjeDto) obj;
        if (!Objects.equals(this.rbAngazovanja, other.rbAngazovanja)) {
            return false;
        }
        if (!Objects.equals(this.agent, other.agent)) {
            return false;
        }
        if (!Objects.equals(this.menadzer, other.menadzer)) {
            return false;
        }
        return Objects.equals(this.ugovor, other.ugovor);
    }

    @Override
    public String toString() {
        return "AngazovanjeDto{" + "rbAngazovanja=" + rbAngazovanja + ", provizija=" + provizija + ", realizovano=" + realizovano + ", agent=" + agent + ", menadzer=" + menadzer + ", ugovor=" + ugovor + '}';
    }
    
    
    
}
