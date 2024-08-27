/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.service;

import java.util.List;
import java.util.Optional;
import rs.fon.silab.application.dto.AngazovanjeDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.CreateAngazovanjeModel;

/**
 *
 * @author Korisnik
 */
public interface AngazovanjeService {
    List<AngazovanjeDto> findAll();
        
    Optional<AngazovanjeDto> findById(Long id);
    
    void deleteById(Long id) throws InvalidEntityException;

    public List<AngazovanjeDto> findFilter(Long menadzer_id, Long rburp,Long ugovor_id);
    
    public List<AngazovanjeDto> findUgovorFilter(Long menadzer__id,Long rubp);

    public void createAngazovanje(Long menadzer_id, Long rburp, Long ugovor_id, String jmbg, CreateAngazovanjeModel createAngazovanje);
}
