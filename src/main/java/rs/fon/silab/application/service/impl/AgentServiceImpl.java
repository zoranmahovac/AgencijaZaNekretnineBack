/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import rs.fon.silab.application.converter.AgentConverter;
import rs.fon.silab.application.dto.AgentDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Agent;
import rs.fon.silab.application.repository.AgentRepository;
import rs.fon.silab.application.service.AgentService;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional
public class AgentServiceImpl implements AgentService{

    private final AgentRepository agentRepository;
    
    private final AgentConverter agentConverter;
    
    public AgentServiceImpl(AgentRepository agentRepository,AgentConverter agentConverter) {
        this.agentRepository = agentRepository;
        this.agentConverter = agentConverter;
    }
    
    
    @Override
    public List<AgentDto> findAll() {
        return agentRepository.findAll().stream().map(entity ->{
            return agentConverter.toDto(entity);
        }).collect(Collectors.toList());
    }

    @Override
    public List<AgentDto> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
        Page<Agent> page = agentRepository.findAll(pageable);
        if (page.hasContent()){
            return page.getContent().stream().map(entity->{
                return agentConverter.toDto(entity);
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<AgentDto> findById(Long id) {
        Optional<Agent> entity = agentRepository.findById(id);
        if(entity.isPresent()){
            return Optional.of(agentConverter.toDto(entity.get()));
           
        }
        return Optional.empty();
    }

    @Override
    public AgentDto save(AgentDto agentDto) throws EntityExistsException {
        Optional<Agent> entity  =agentRepository.findById(agentDto.getRedniBrojURegistruPosrednika());
        if(entity.isPresent()){
            throw new EntityExistsException(entity.get(),"Agent already exists!");
        }
        Agent agent = agentRepository.save(agentConverter.toEntity(agentDto));
        return agentConverter.toDto(agent);
    }

    @Override
    public void deleteById(Long id) throws InvalidEntityException {
        
        Optional<Agent> agentOpt  = agentRepository.findById(id);
        if (agentOpt.isEmpty()){
            throw new InvalidEntityException("Agent ne postoji u bazi podataka!");
        }
        else
            agentRepository.deleteById(id);
    }
    
}
