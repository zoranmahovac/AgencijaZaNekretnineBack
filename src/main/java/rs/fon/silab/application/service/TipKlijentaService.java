/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.service;

import java.util.List;
import java.util.Optional;
import rs.fon.silab.application.dto.TipKlijentaDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;

/**
 *
 * @author Korisnik
 */
public interface TipKlijentaService {
    
    List<TipKlijentaDto> findAll();
    
    List<TipKlijentaDto> findAll(Integer pageNo, Integer pageSize, String sortBy); ///paginacija +  sort + page size 
    
    Optional<TipKlijentaDto> findById(Long id);
    
    
    TipKlijentaDto save(TipKlijentaDto tipKlijentaDto) throws EntityExistsException; 
    
    void deleteById(Long id) throws InvalidEntityException;
    
    
}
