/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.fon.silab.application.converter.AgentConverter;
import rs.fon.silab.application.converter.AngazovanjeConverter;
import rs.fon.silab.application.converter.KlijentConverter;
import rs.fon.silab.application.converter.MenadzerConverter;
import rs.fon.silab.application.converter.UgovorConverter;
import rs.fon.silab.application.dto.AgentDto;
import rs.fon.silab.application.dto.AngazovanjeDto;
import rs.fon.silab.application.dto.KlijentDto;
import rs.fon.silab.application.dto.MenadzerDto;
import rs.fon.silab.application.dto.UgovorDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Agent;
import rs.fon.silab.application.model.Angazovanje;
import rs.fon.silab.application.model.CreateAngazovanjeModel;
import rs.fon.silab.application.model.Klijent;
import rs.fon.silab.application.model.Menadzer;
import rs.fon.silab.application.model.Ugovor;
import rs.fon.silab.application.repository.AgentRepository;
import rs.fon.silab.application.repository.AngazovanjeRepository;
import rs.fon.silab.application.repository.KlijentRepository;
import rs.fon.silab.application.repository.MenadzerRepository;
import rs.fon.silab.application.repository.UgovorRepository;
import rs.fon.silab.application.service.AngazovanjeService;

/**
 *
 * @author Korisnik
 */
@Transactional
@Service
public class AranzmanServiceImpl implements AngazovanjeService{

    private final AngazovanjeRepository angazovanjeRepository;
    private final AngazovanjeConverter angazovanjeConverter;
    private final KlijentRepository klijentRepository;
    private final KlijentConverter klijentConverter;
    private final UgovorRepository ugovorRepository;
    private final UgovorConverter ugovorConverter;
    private final MenadzerRepository menadzerRepository;
    private final MenadzerConverter menadzerConverter;
    private final AgentRepository agentRepository;
    private final AgentConverter agentConverter;

    public AranzmanServiceImpl(AngazovanjeRepository angazovanjeRepository, AngazovanjeConverter angazovanjeConverter, KlijentRepository klijentRepository, KlijentConverter klijentConverter, UgovorRepository ugovorRepository, UgovorConverter ugovorConverter, MenadzerRepository menadzerRepository, MenadzerConverter menadzerConverter, AgentRepository agentRepository, AgentConverter agentConverter) {
        this.angazovanjeRepository = angazovanjeRepository;
        this.angazovanjeConverter = angazovanjeConverter;
        this.klijentRepository = klijentRepository;
        this.klijentConverter = klijentConverter;
        this.ugovorRepository = ugovorRepository;
        this.ugovorConverter = ugovorConverter;
        this.menadzerRepository = menadzerRepository;
        this.menadzerConverter = menadzerConverter;
        this.agentRepository = agentRepository;
        this.agentConverter = agentConverter;
    }
    
    
    
    @Override
    public List<AngazovanjeDto> findAll() {
        return angazovanjeRepository.findAll().stream().map(entity ->{
            return angazovanjeConverter.toDto(entity);
        }).collect(Collectors.toList());
                
    }

    @Override
    public Optional<AngazovanjeDto> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public void deleteById(Long id) throws InvalidEntityException {
        
        Optional<Angazovanje> angazovanje = angazovanjeRepository.findById(id);
        
        if (angazovanje.isPresent()){
            angazovanjeRepository.deleteById(id);
        }
        else
            throw new InvalidEntityException("Entitet sa ID-om " + id + " ne postoji.");
    }


    @Override
    public List<AngazovanjeDto> findFilter(Long menadzer_id, Long rburp,Long ugovor_id){
        List<Angazovanje> angazovanja  = angazovanjeRepository.findFilter(menadzer_id, rburp, ugovor_id);
        return angazovanja.stream().map(entity ->{return angazovanjeConverter.toDto(entity);}).collect(Collectors.toList());
    }

    @Override
    public List<AngazovanjeDto> findUgovorFilter(Long menadzer_id, Long rubp) {
        List<Angazovanje> angazovanja  = angazovanjeRepository.findUgovorFilter(menadzer_id, rubp);
        return angazovanja.stream().map(entity ->{return angazovanjeConverter.toDto(entity);}).collect(Collectors.toList());
    
    }

    @Override
    public void createAngazovanje(Long menadzer_id, Long rburp, Long ugovor_id, String jmbg, CreateAngazovanjeModel createAngazovanje) {
        KlijentDto klijentOpt = getValidKlijent(jmbg);
        MenadzerDto menadzerOpt = getValidMenadzer(menadzer_id);
        UgovorDto ugovorOpt = getValidUgovor(jmbg, ugovor_id);
        AgentDto agentOpt = getValidAgent(rburp);
        
        if (klijentOpt!=null && menadzerOpt!=null && ugovorOpt != null && agentOpt!=null){
            ugovorOpt.setKlijent(klijentConverter.toEntity(klijentOpt));
            AngazovanjeDto angazovanjeDto = new AngazovanjeDto();
            angazovanjeDto.setAgent(agentConverter.toEntity(agentOpt));
            angazovanjeDto.setMenadzer(menadzerConverter.toEntity(menadzerOpt));
            angazovanjeDto.setUgovor(ugovorConverter.toEntity(ugovorOpt));
            angazovanjeDto.setRbAngazovanja(createAngazovanje.getId());
            angazovanjeDto.setProvizija(createAngazovanje.getProvizija());
            angazovanjeDto.setRealizovano(createAngazovanje.isRealizovano());
            angazovanjeDto.setKlijent(klijentConverter.toEntity(klijentOpt));
            angazovanjeRepository.save(angazovanjeConverter.toEntity(angazovanjeDto));
        }       
    }
    
    private AgentDto getValidAgent(Long rburp){
        Optional<Agent> agentOpt = agentRepository.findById(rburp);
        if (!agentOpt.isPresent()){
            System.out.println("Agent ne postoji!");
            return null;
        }
        return agentConverter.toDto(agentOpt.get());
    }
    
    private KlijentDto getValidKlijent(String jmbg){
        Optional<Klijent> klijentOpt = klijentRepository.findById(Long.valueOf(jmbg));
        if (!klijentOpt.isPresent()){
            System.out.println("Klijent ne postoji!");
            return null;
        }
        return klijentConverter.toDto(klijentOpt.get());
    }
   
    private MenadzerDto getValidMenadzer(Long menadzer_id){
        Optional <Menadzer> menadzer = menadzerRepository.findById(menadzer_id);
        if (!menadzer.isPresent()){
            System.out.println("Menadzer sa prosledjenim IDjem ne postoji!");
            return null;
        }
        return menadzerConverter.toDto(menadzer.get());
    }
    
    private UgovorDto getValidUgovor(String jmbg, Long ugovor_id){
       Optional<Ugovor> ugovor = ugovorRepository.findUgovor(jmbg, ugovor_id);
       if (!ugovor.isPresent()){
           System.out.println("Ugovor ne postoji!");
           return null;
       }
       return ugovorConverter.toDto(ugovor.get()); 
    }
    
}
