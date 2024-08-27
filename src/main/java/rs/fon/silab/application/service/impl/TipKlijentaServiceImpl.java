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
import rs.fon.silab.application.converter.TipKlijentaConverter;
import rs.fon.silab.application.dto.TipKlijentaDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.TipKlijenta;
import rs.fon.silab.application.repository.TipKlijentaRepository;
import rs.fon.silab.application.service.TipKlijentaService;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional
public class TipKlijentaServiceImpl implements TipKlijentaService{
    
    private final TipKlijentaRepository tipKlijentaRepository;
    
    private final TipKlijentaConverter tipKlijentaConverter;

    public TipKlijentaServiceImpl(TipKlijentaRepository tipKlijentaRepository, TipKlijentaConverter tipKlijentaConverter) {
        this.tipKlijentaRepository = tipKlijentaRepository;
        this.tipKlijentaConverter = tipKlijentaConverter;
    }
    
    
    
    @Override
    public List<TipKlijentaDto> findAll() {
        return tipKlijentaRepository.findAll().stream().map(entity ->{
            return tipKlijentaConverter.toDto(entity);
        }).collect(Collectors.toList());
    }

    @Override
    public List<TipKlijentaDto> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
        Page<TipKlijenta> page = tipKlijentaRepository.findAll(pageable);
        if(page.hasContent()){
            return page.getContent().stream().map(entity->{ //page.getContent() vraca List<TipKlijenta> pa tu listu mapiramo u listu Dto objekata
                return tipKlijentaConverter.toDto(entity); // pomocu lambda izraza u kojem pozivamo konverzioni objekat i metodu koju smo napravili toDto()
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<TipKlijentaDto> findById(Long id) {
        Optional<TipKlijenta> entity = tipKlijentaRepository.findById(id);
        if (entity.isPresent()){
            return Optional.of(tipKlijentaConverter.toDto(entity.get())); //pretvara entity -> dto 
        }
        return Optional.empty();
    }   

    @Override
    public TipKlijentaDto save(TipKlijentaDto tipKlijentaDto) throws EntityExistsException {
        //on je vec primio jedan TipKlijentaDto
        Optional<TipKlijenta> entity = tipKlijentaRepository.findById(tipKlijentaDto.getSifraTipa());
        if (entity.isPresent()){
            throw new EntityExistsException(entity.get(), "TipKlijenta already exists!");     
        }  
        TipKlijenta tipKlijenta = tipKlijentaRepository.save(tipKlijentaConverter.toEntity(tipKlijentaDto));
        return tipKlijentaConverter.toDto(tipKlijenta);
    }

    @Override
    public void deleteById(Long id)throws InvalidEntityException{
    try {
        // Pokušajte da obrišete entitet prema ID-u
        tipKlijentaRepository.deleteById(id);
    } catch (EmptyResultDataAccessException ex) {
        // Ako entitet ne postoji, bacite specifičan izuzetak
        throw new InvalidEntityException("Entitet sa ID-om " + id + " ne postoji.");
    } catch (Exception ex) {
        // Obrađuje sve ostale izuzetke
        throw new RuntimeException("Došlo je do greške prilikom brisanja entiteta: " + ex.getMessage());
    }
    }
    
    
}
