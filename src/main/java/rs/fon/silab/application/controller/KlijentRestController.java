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
import org.springframework.web.bind.annotation.RestController;
import rs.fon.silab.application.converter.KlijentConverter;
import rs.fon.silab.application.dto.KlijentDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Ugovor;
import rs.fon.silab.application.service.KlijentService;

/**
 *
 * @author Korisnik
 */
@RestController
@RequestMapping("/klijent")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.TRACE,RequestMethod.PATCH})
public class KlijentRestController {
    
    private final KlijentService klijentService;
    
    private final KlijentConverter klijentConverter;

    public KlijentRestController(KlijentService klijentService, KlijentConverter klijentConverter) {
        this.klijentService = klijentService;
        this.klijentConverter = klijentConverter;
    }
    
    @GetMapping("/all")
    public List<KlijentDto> findAll(){
        return klijentService.findAll();
    }
    
    @GetMapping("get/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        Optional<KlijentDto> klijentDto = klijentService.findById(id);
        if (klijentDto.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(klijentDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID for Klijent!");
    }
    @PostMapping("/delete/{id}") // kad obrisemo klijenta, brisu se i svi njegovi ugovori!!! 
    public void deleteById(@PathVariable Long id) throws InvalidEntityException{
        klijentService.deleteById(id);
    }
    
    @PostMapping("/{jmbg}/ugovori") //pazi: ovde u post zahtevu nema get!!!
    public Ugovor addUgovorToKlijent(@PathVariable Long jmbg, @RequestBody Ugovor ugovor){
        return klijentService.addUgovorToKlijent(jmbg, ugovor);
    }
    
    
    @PostMapping("/delete/{jmbg}/{broj_ugovora}")
    public Ugovor deleteUgovor(@PathVariable Long jmbg, @PathVariable Long broj_ugovora) throws InvalidEntityException{
        return klijentService.delete(jmbg, broj_ugovora);
    }
    
    @PostMapping("/save")
    public ResponseEntity<KlijentDto> save(@Valid @RequestBody KlijentDto klijentDto) throws EntityExistsException{
        klijentService.save(klijentDto);
        return ResponseEntity.status(HttpStatus.OK).body(klijentDto);
    }
    
    
}
