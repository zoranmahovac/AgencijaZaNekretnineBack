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
import rs.fon.silab.application.converter.TipKlijentaConverter;
import rs.fon.silab.application.dto.TipKlijentaDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.TipKlijenta;
import rs.fon.silab.application.service.TipKlijentaService;

/**
 *
 * @author Korisnik
 */
@RestController
@RequestMapping("/tipklijenta")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.TRACE,RequestMethod.PATCH})
public class TipKlijentaRestController {

    private final TipKlijentaService tipKlijentaService;
    private final TipKlijentaConverter tipKlijentaConverter;

    public TipKlijentaRestController(TipKlijentaService tks, TipKlijentaConverter tkc) {
        this.tipKlijentaService = tks;
        this.tipKlijentaConverter = tkc;
    }
    
    @GetMapping("/all")
    public List<TipKlijentaDto> findAll(){
        return tipKlijentaService.findAll();
    }
    
    @GetMapping("/get/{id}") // prvo moras da zaustavis server, pa da ga opet pokrenes da bi ovo isprobao
    public ResponseEntity<Object> findById(@PathVariable Long id){
        Optional<TipKlijentaDto> tipKlijentaDto = tipKlijentaService.findById(id);
        if (tipKlijentaDto.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(tipKlijentaDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid TipKlijenta!");
    }
    //Integer pageNo, Integer pageSize, String sortBy
    @GetMapping("all_paginated")
    public ResponseEntity<List<TipKlijentaDto>> findAll(@RequestParam(defaultValue="0") Integer pageNo, @RequestParam(defaultValue="1") Integer pageSize, @RequestParam(defaultValue="nazivTipa") String sortBy){
        return ResponseEntity.ok(tipKlijentaService.findAll(pageNo,pageSize,sortBy));
    }
    
    @PostMapping("/save")
    public ResponseEntity<TipKlijentaDto> save(@Valid @RequestBody TipKlijentaDto tipKlijentaDto) throws EntityExistsException{
        TipKlijenta tipKlijenta = new TipKlijenta();
        tipKlijenta.setSifraTipa(tipKlijentaDto.getSifraTipa());
        tipKlijenta.setNazivTipa(tipKlijentaDto.getNazivTipa());
        TipKlijentaDto saveTipKlijenta = tipKlijentaConverter.toDto(tipKlijenta);
        this.tipKlijentaService.save(saveTipKlijenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveTipKlijenta);
    }
    
    @PostMapping("/delete/{id}") 
    public void deleteById(@PathVariable Long id) throws InvalidEntityException{
        tipKlijentaService.deleteById(id);
    }
}

