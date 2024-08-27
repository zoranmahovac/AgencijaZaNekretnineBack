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
import rs.fon.silab.application.converter.AgentConverter;
import rs.fon.silab.application.converter.StatistikaTipaKlijentaConverter;
import rs.fon.silab.application.converter.TipKlijentaConverter;
import rs.fon.silab.application.dto.StatistikaTipaKlijentaDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Agent;
import rs.fon.silab.application.model.StatistikaTipaId;
import rs.fon.silab.application.model.StatistikaTipaKlijenta;
import rs.fon.silab.application.model.TipKlijenta;
import rs.fon.silab.application.repository.AgentRepository;
import rs.fon.silab.application.repository.StatistikaTipaKlijentaRepository;
import rs.fon.silab.application.repository.TipKlijentaRepository;
import rs.fon.silab.application.service.StatistikaTipaKlijentaService;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional
public class StatistikaTipaKlijentaServiceImpl implements StatistikaTipaKlijentaService{

    private final StatistikaTipaKlijentaRepository statistikaRepository;
    private final StatistikaTipaKlijentaConverter statistikaConverter;
    private final TipKlijentaRepository tipRepository;
    private final TipKlijentaConverter tipConverter;
    private final AgentRepository agentRepository;
    private final AgentConverter agentConverter;

    public StatistikaTipaKlijentaServiceImpl(StatistikaTipaKlijentaRepository statistikaRepository, StatistikaTipaKlijentaConverter statistikaConverter, TipKlijentaRepository tipRepository, TipKlijentaConverter tipConverter,AgentRepository agentRepository,AgentConverter agentConverter) {
        this.statistikaRepository = statistikaRepository;
        this.statistikaConverter = statistikaConverter;
        this.tipConverter = tipConverter;
        this.tipRepository = tipRepository;
        this.agentConverter = agentConverter;
        this.agentRepository = agentRepository;
    }
    
    
    
    
    @Override
    public List<StatistikaTipaKlijentaDto> findAll() {
        return statistikaRepository.findAll().stream().map(entity->{
            return statistikaConverter.toDto(entity);
        }).collect(Collectors.toList());
    
    }

    @Override
    public List<StatistikaTipaKlijentaDto> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
        Page<StatistikaTipaKlijenta> page = statistikaRepository.findAll(pageable);
        if (page.hasContent()){
            return page.getContent().stream().map(entity->{
                return statistikaConverter.toDto(entity);  
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<StatistikaTipaKlijentaDto> findById(StatistikaTipaId id) { //Long
        Optional<StatistikaTipaKlijenta> entity = statistikaRepository.findById(id);
        if (entity.isPresent()){
            return Optional.of(statistikaConverter.toDto(entity.get()));
        }
        return Optional.empty();
    }

    @Override
    public StatistikaTipaKlijentaDto save(Long sifra_tipa, Long rburp, int brojKlijenata,Long id) throws EntityExistsException {
    
        Optional<Agent> agOpt = findAgent(rburp);
        Optional<TipKlijenta> tipOpt = findTip(sifra_tipa);
        
        if(agOpt!=null && tipOpt!=null){
            StatistikaTipaId idStat = new StatistikaTipaId(sifra_tipa,rburp,id);
            StatistikaTipaKlijenta statTipa = new StatistikaTipaKlijenta(idStat,tipOpt.get(),agOpt.get(),brojKlijenata);
            statistikaRepository.save(statTipa);
            return statistikaConverter.toDto(statTipa);
        }
        System.out.println("Neuspesan unos!");
        return null;
    }
    
    public Optional<Agent> findAgent(Long rburp){
        Optional<Agent> agentOpt = agentRepository.findById(rburp);
        if (agentOpt.isEmpty())
            return null;
        return agentOpt;
    }
      public Optional<TipKlijenta> findTip(Long tip){
        Optional<TipKlijenta> tipOpt = tipRepository.findById(tip);
        if (tipOpt.isEmpty())
            return null;
        return tipOpt;
    }
    
    

    @Override
    public void deleteById(StatistikaTipaId id) throws InvalidEntityException {
        Optional<StatistikaTipaKlijenta> entity = statistikaRepository.findById(id);
        if (!entity.isPresent()){
            throw new InvalidEntityException( "TipKlijenta already exists!");     
        }  else{
            statistikaRepository.deleteById(id);
        }
        
    }

    @Override
    public List<StatistikaTipaKlijentaDto> findStatistike(Long sifra_tipa, Long rburp) {
        List<StatistikaTipaKlijenta> statistike = statistikaRepository.findStatistike(sifra_tipa,rburp);
        List<StatistikaTipaKlijentaDto> results = new ArrayList<>();
        for(StatistikaTipaKlijenta st:statistike){
            results.add(statistikaConverter.toDto(st));
        }
        return results;
        //return statistikaConverter.toDto(statistike);
    }
    
    
}
