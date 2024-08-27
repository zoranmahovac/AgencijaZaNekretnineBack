/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.fon.silab.application.model.Klijent;
import rs.fon.silab.application.model.Menadzer;

/**
 *
 * @author Korisnik
 */
@Repository
public interface MenadzerRepository extends JpaRepository<Menadzer, Long>{
    
   //@Query("select k from Klijent k where k.jmbgKlijenta=?1")
   //Optional<Klijent> findKlijentByJmbg(String jmbg);
    @Query("select m from Menadzer m where m.korisnickoIme=?1")
    Menadzer findByUsername(String username);
}
