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
import rs.fon.silab.application.converter.StatistikaTipaKlijentaConverter;
import rs.fon.silab.application.dto.StatistikaTipaKlijentaDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.CreateStatistikaModel;
import rs.fon.silab.application.model.StatistikaTipaId;
import rs.fon.silab.application.model.StatistikaTipaKlijenta;
import rs.fon.silab.application.repository.StatistikaTipaKlijentaRepository;
import rs.fon.silab.application.service.StatistikaTipaKlijentaService;

/**
 *
 * @author Korisnik
 */
@RestController
@RequestMapping("/statistikatipa")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.TRACE,RequestMethod.PATCH})
public class StatistikaTipaKlijentaRestController {
    
    private final StatistikaTipaKlijentaService statistikaService;
    private final StatistikaTipaKlijentaConverter statistikaConverter;

    public StatistikaTipaKlijentaRestController(StatistikaTipaKlijentaService statistikaService, StatistikaTipaKlijentaConverter statistikaConverter) {
        this.statistikaService = statistikaService;
        this.statistikaConverter = statistikaConverter;
    }

    @GetMapping("/all")
    public List<StatistikaTipaKlijentaDto> findAll(){
        return statistikaService.findAll();
    }
    
    @GetMapping("/all_paginated")
    public ResponseEntity<List<StatistikaTipaKlijentaDto>> findAll(@RequestParam(defaultValue="0") Integer pageNo, @RequestParam(defaultValue="1") Integer pageSize, @RequestParam(defaultValue="brojDodeljenihKLijenataTipa") String sortBy){
        return ResponseEntity.ok(statistikaService.findAll(pageNo,pageSize,sortBy));
    }
    
    @GetMapping("/get/{sifra_tipa}/{rburp}/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long sifra_tipa,@PathVariable Long rburp,@PathVariable Long id){
        StatistikaTipaId statTipaId= new StatistikaTipaId(sifra_tipa,rburp,id);
        Optional <StatistikaTipaKlijentaDto> stat = statistikaService.findById(statTipaId);
        if (stat.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(stat.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID!");
    }
    
    @GetMapping("/get/{sifra_tipa}/{rburp}")
    public List<StatistikaTipaKlijentaDto> findById(@PathVariable Long sifra_tipa,@PathVariable Long rburp){
       List<StatistikaTipaKlijentaDto> statistike = this.statistikaService.findStatistike(sifra_tipa,rburp);
       return statistike;
    }
    
    
    
    
    @PostMapping("/save/{sifra_tipa}/{rburp}")
    public ResponseEntity<StatistikaTipaKlijentaDto> save(@PathVariable Long sifra_tipa,@PathVariable Long rburp, @Valid @RequestBody CreateStatistikaModel cModel) throws EntityExistsException {
        int brojKlijenata = cModel.getBrojKlijenata();
        Long id = cModel.getId();
        StatistikaTipaKlijentaDto result = this.statistikaService.save(sifra_tipa, rburp, brojKlijenata, id);
        if (result!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(new StatistikaTipaKlijentaDto());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StatistikaTipaKlijentaDto());
    }
    
    
    @PostMapping("/delete/{sifra_tipa}/{rburp}/{id}") 
    public void deleteById(@PathVariable Long sifra_tipa,@PathVariable Long rburp,@PathVariable Long id) throws InvalidEntityException{
        StatistikaTipaId statTipaId= new StatistikaTipaId(sifra_tipa,rburp,id);
        statistikaService.deleteById(statTipaId);
    }
        
    
}
