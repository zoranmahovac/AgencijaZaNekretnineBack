/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.service;

import java.util.List;
import java.util.Optional;
import rs.fon.silab.application.dto.MenadzerDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Menadzer;

/**
 *
 * @author Korisnik
 */
public interface MenadzerService {
    
   List<MenadzerDto> findAll();
   
   List<MenadzerDto> findAll(Integer pageNo, Integer pageSize,  String sortBy);
   
   Optional<MenadzerDto> findById(Long id);
    
   MenadzerDto save(MenadzerDto agentDto) throws EntityExistsException; 
    
   void deleteById(Long id) throws InvalidEntityException;
   
   Menadzer authenticate(String username,String passowrd);
}
