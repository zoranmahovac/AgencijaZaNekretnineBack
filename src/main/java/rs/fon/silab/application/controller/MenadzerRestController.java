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
import rs.fon.silab.application.converter.MenadzerConverter;
import rs.fon.silab.application.dto.MenadzerDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Menadzer;
import rs.fon.silab.application.service.MenadzerService;

/**
 *
 * @author Korisnik
 */
@RestController
@RequestMapping("/menadzer")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.TRACE,RequestMethod.PATCH})
public class MenadzerRestController {
    
    private final MenadzerService menadzerService;
    
    private final MenadzerConverter menadzerConverter;

    public MenadzerRestController(MenadzerService menadzerService, MenadzerConverter menadzerConverter) {
        this.menadzerService = menadzerService;
        this.menadzerConverter = menadzerConverter;
    }
  
    
    @GetMapping("/all")
    public List<MenadzerDto> findAll(){
        return menadzerService.findAll();
    }
    
       @GetMapping("all_paginated")
    public ResponseEntity<List<MenadzerDto>> findAll(@RequestParam(defaultValue="0") Integer pageNo, @RequestParam(defaultValue="1") Integer pageSize, @RequestParam(defaultValue="imeMenadzera") String sortBy){
        return ResponseEntity.ok(menadzerService.findAll(pageNo,pageSize,sortBy));
    } 
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        Optional<MenadzerDto> agentDto = menadzerService.findById(id);
        if (agentDto.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(agentDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID of Agent!");
    }
    
    @PostMapping("/save")
    public ResponseEntity<MenadzerDto> save(@Valid @RequestBody MenadzerDto menadzerDto) throws EntityExistsException {
        this.menadzerService.save(menadzerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(menadzerDto);
    
    }
    
    @PostMapping("/delete/{id}") 
    public void deleteById(@PathVariable Long id) throws InvalidEntityException{
        menadzerService.deleteById(id);
    }
    
    @GetMapping("/login")
    public ResponseEntity<Menadzer> login(@RequestParam String username,@RequestParam String password){
        Menadzer menadzer = menadzerService.authenticate(username, password);
        if (menadzer!=null){
            return ResponseEntity.ok(menadzer);
        }
        return ResponseEntity.status(401).build(); //Unauthorized
    }
    
}
