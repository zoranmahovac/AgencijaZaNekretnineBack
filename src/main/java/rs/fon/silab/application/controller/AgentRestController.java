/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.fon.silab.application.converter.AgentConverter;
import rs.fon.silab.application.dto.AgentDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Agent;
import rs.fon.silab.application.service.AgentService;

/**
 *
 * @author Korisnik
 */
@RestController
@RequestMapping("/agent")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.TRACE,RequestMethod.PATCH})
public class AgentRestController {

    private final AgentService agentService;
    private final AgentConverter agentConverter;

    public AgentRestController(AgentService agentService, AgentConverter agentConverter) {
        this.agentService = agentService;
        this.agentConverter = agentConverter;
    }

    @GetMapping("/all")
    public List<AgentDto> findAll(){
        return agentService.findAll();
    }
    
    @GetMapping("all_paginated")
    public ResponseEntity<List<AgentDto>> findAll(@RequestParam(defaultValue="0") Integer pageNo, @RequestParam(defaultValue="1") Integer pageSize, @RequestParam(defaultValue="imeAgenta") String sortBy){
        return ResponseEntity.ok(agentService.findAll(pageNo,pageSize,sortBy));
    } 
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        Optional<AgentDto> agentDto = agentService.findById(id);
        if (agentDto.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(agentDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID of Agent!");
    }
    @PostMapping("/save")
    public ResponseEntity<AgentDto> save(@Valid @RequestBody AgentDto agentDto) throws EntityExistsException{
      Agent agent = new Agent();
      agent.setRedniBrojURegistruPosrednika(agentDto.getRedniBrojURegistruPosrednika());
      agent.setImeAgenta(agentDto.getImeAgenta());
      agent.setPrezimeAgenta(agentDto.getPrezimeAgenta());
      agent.setAdresaAgenta(agentDto.getAdresaAgenta());
      agent.setBrojDodeljenihKlijenata(agentDto.getBrojDodeljenihKlijenata());
      agent.setUspesnostRealizacije(agentDto.getUspesnostRealizacije());
      
      AgentDto saveAgent = agentConverter.toDto(agent);
      this.agentService.save(saveAgent);
      return ResponseEntity.status(HttpStatus.CREATED).body(saveAgent);
    } 
    
    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) throws InvalidEntityException{
        agentService.deleteById(id);
    }
    
}
