/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.service;

import java.util.List;
import java.util.Optional;
import rs.fon.silab.application.dto.AgentDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;

/**
 *
 * @author Korisnik
 */
public interface AgentService {
    
    List<AgentDto> findAll();
    
    List<AgentDto> findAll(Integer pageNo, Integer pageSize, String sortBy); ///paginacija +  sort + page size 
    
    Optional<AgentDto> findById(Long id);
    
    AgentDto save(AgentDto agentDto) throws EntityExistsException; 
    
    void deleteById(Long id) throws InvalidEntityException;
    
}
