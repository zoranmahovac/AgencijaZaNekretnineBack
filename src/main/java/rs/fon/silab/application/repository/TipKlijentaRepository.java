/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.fon.silab.application.model.TipKlijenta;

/**
 *
 * @author Korisnik
 */
@Repository // kaze: TipKlijentaRepository je komponenta za pristup podacima. Omogucuje springu da upravlja instancama ovog interfejsa i povezuje ga sa servisima
public interface TipKlijentaRepository extends JpaRepository<TipKlijenta, Long>{
    //Java interfejs koji koristi Spring Data JPA za pristup i upravljanje entitetima u bazi podataka 
    // JpaRepository je deo Spring Data JPA i pruza set metoda za rad sa entitetima u bazi podataka
    //TipKlijenta - tip entiteta sa kojim ovaj repozitorijum radi 
    // Long - tip podatka za primarni kljuc entiteta 
    
    // Sta ovaj Repository koji implementira JpaRepository ima na raspolaganju: 
    // save(S entity) - sacuvaj ili azuriraj entitet
    // findById(ID id) - Nađi entitet po ID-u.
    // findAll() - Nađi sve entitete.
    // deleteById(ID id) - Obriši entitet po ID-u.
    // delete(S entity) - Obriši dati entitet.
    // findAll(Specification<T> spec) omogućavaju pretragu sa specifičnim uslovima.
    // findAll(Pageable pageable) i findAll(Sort sort) omogućavaju paginaciju i sortiranje rezultata.
    
    
    
    
}
