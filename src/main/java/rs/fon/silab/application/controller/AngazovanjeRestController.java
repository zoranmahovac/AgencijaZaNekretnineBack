/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.fon.silab.application.converter.AngazovanjeConverter;
import rs.fon.silab.application.dto.AngazovanjeDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.CreateAngazovanjeModel;
import rs.fon.silab.application.service.AngazovanjeService;

/**
 *
 * @author Korisnik
 */
@RestController
@RequestMapping("/angazovanje")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.TRACE,RequestMethod.PATCH})
public class AngazovanjeRestController {
    
    private final AngazovanjeService angazovanjeService;
    
    private final AngazovanjeConverter angazovanjeConverter;

    public AngazovanjeRestController(AngazovanjeService angazovanjeService, AngazovanjeConverter angazovanjeConverter) {
        this.angazovanjeService = angazovanjeService;
        this.angazovanjeConverter = angazovanjeConverter;
    }
    
    @GetMapping("/all")
    public List<AngazovanjeDto> findAll(){
        return angazovanjeService.findAll();
    }
    
    //za jednog menadzera i agenta prikazuje zeljeni ugovor
    @GetMapping("/get/{menadzer_id}/{rburp}/{ugovor_id}")
    public List<AngazovanjeDto> findFilter(@PathVariable Long menadzer_id, @PathVariable Long rburp, @PathVariable Long ugovor_id){
        return angazovanjeService.findFilter(menadzer_id, rburp,ugovor_id);
    }

    //svi ugovori koje je jedan menadzer dodelio jednom agentu.
    @GetMapping("/get/{menadzer_id}/{rburp}")
    public List<AngazovanjeDto> findUgovoriFilter(@PathVariable Long menadzer_id, @PathVariable Long rburp){
        return angazovanjeService.findUgovorFilter(menadzer_id, rburp);
    }
    
    
    @PostMapping("create/{menadzer_id}/{rburp}/{ugovor_id}/{jmbg}")
    public void createAngazovanje(@PathVariable Long menadzer_id, @PathVariable Long rburp, @PathVariable Long ugovor_id, @PathVariable String jmbg, @RequestBody CreateAngazovanjeModel modelAngazovanje){
        angazovanjeService.createAngazovanje(menadzer_id,rburp,ugovor_id,jmbg, modelAngazovanje);
        
    }
    
    @PostMapping("delete/{angazovanje_id}")
    public void deleteAngazovanje(@PathVariable Long angazovanje_id) throws InvalidEntityException{
        angazovanjeService.deleteById(angazovanje_id);
    }
    
 
    
    
    
}
