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
import rs.fon.silab.application.converter.MenadzerConverter;
import rs.fon.silab.application.dto.MenadzerDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Menadzer;
import rs.fon.silab.application.repository.MenadzerRepository;
import rs.fon.silab.application.service.MenadzerService;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional
public class MenadzerServiceImpl implements MenadzerService{

    
    private final MenadzerRepository menadzerRepository;
    private final MenadzerConverter menadzerConverter;

    public MenadzerServiceImpl(MenadzerRepository menadzerRepository, MenadzerConverter menadzerConverter) {
        this.menadzerRepository = menadzerRepository;
        this.menadzerConverter = menadzerConverter;
    }
    
    
    
    @Override
    public List<MenadzerDto> findAll() {
    return menadzerRepository.findAll().stream().map(entity ->{
            return menadzerConverter.toDto(entity);
        }).collect(Collectors.toList());
    }

    @Override
    public List<MenadzerDto> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
        Page<Menadzer> page = menadzerRepository.findAll(pageable);
        if (page.hasContent()){
            return page.getContent().stream().map(entity->{
                return menadzerConverter.toDto(entity);
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<MenadzerDto> findById(Long id) {
            Optional<Menadzer> entity = menadzerRepository.findById(id);
        if(entity.isPresent()){
            return Optional.of(menadzerConverter.toDto(entity.get()));
           
        }
        return Optional.empty();
    }

    @Override
    public MenadzerDto save(MenadzerDto menadzerDto) throws EntityExistsException {
          Optional<Menadzer> entity  =menadzerRepository.findById(menadzerDto.getId());
        if(entity.isPresent()){
            throw new EntityExistsException(entity.get(),"Agent already exists!");
        }
        Menadzer menadzer = menadzerRepository.save(menadzerConverter.toEntity(menadzerDto));
        return menadzerConverter.toDto(menadzer);
    }

    @Override
    public void deleteById(Long id) throws InvalidEntityException {
        Optional<Menadzer> menadzer = menadzerRepository.findById(id);
        if (menadzer.isEmpty())
            throw new InvalidEntityException("Entitet sa ID-om " + id + " ne postoji.");
        else
            menadzerRepository.deleteById(id);

    }

    @Override
    public Menadzer authenticate(String username, String password) {
        Menadzer menadzer = menadzerRepository.findByUsername(username);
        if (menadzer!=null && menadzer.getLozinka().equals(password)){
            return menadzer;
        }
        return null;
    }
    
}
