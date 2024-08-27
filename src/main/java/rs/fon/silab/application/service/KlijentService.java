/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.service;

import java.util.List;
import java.util.Optional;
import rs.fon.silab.application.dto.KlijentDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Ugovor;

/**
 *
 * @author Korisnik
 */
public interface KlijentService {
    
    List<KlijentDto> findAll();    
    
    Optional<KlijentDto> findById(Long id);
    
    void deleteById(Long id) throws InvalidEntityException;
   
    Ugovor addUgovorToKlijent(Long jmbg, Ugovor ugovor);
     

    Ugovor delete(Long jmbg, Long ugovorId) throws InvalidEntityException;
    
    // mozda da ovde dodam dodavanje klijenta, to je svakako ispisivanje jsona 
    
    KlijentDto save(KlijentDto klijentDto) throws EntityExistsException;    
}
