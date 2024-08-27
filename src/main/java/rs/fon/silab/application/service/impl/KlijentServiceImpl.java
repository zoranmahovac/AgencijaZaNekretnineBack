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
import rs.fon.silab.application.converter.KlijentConverter;
import rs.fon.silab.application.dto.KlijentDto;
import rs.fon.silab.application.dto.UgovorDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.Klijent;
import rs.fon.silab.application.model.Ugovor;
import rs.fon.silab.application.repository.KlijentRepository;
import rs.fon.silab.application.repository.UgovorRepository;
import rs.fon.silab.application.service.KlijentService;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional
public class KlijentServiceImpl implements KlijentService{

    private final KlijentRepository klijentRepository;
    private final KlijentConverter klijentConverter;
    private final UgovorRepository ugovorRepository; 
    
    public KlijentServiceImpl(KlijentRepository klijentRepository, KlijentConverter klijentConverter, UgovorRepository ugovorRepository) {
        this.klijentRepository = klijentRepository;
        this.klijentConverter = klijentConverter;
        this.ugovorRepository = ugovorRepository;
    }
    
    @Override
    public List<KlijentDto> findAll() {
        return klijentRepository.findAll().stream().map(entity ->{
            return klijentConverter.toDto(entity);
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<KlijentDto> findById(Long id) {
        Optional<Klijent> entity = klijentRepository.findById(id);
        if (entity.isPresent()){
            return Optional.of(klijentConverter.toDto(entity.get()));
        } 
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) throws InvalidEntityException {
        try {
        // Pokušajte da obrišete entitet prema ID-u
        klijentRepository.deleteById(id);
    } catch (EmptyResultDataAccessException ex) {
        // Ako entitet ne postoji, bacite specifičan izuzetak
        throw new InvalidEntityException("Entitet sa ID-om " + id + " ne postoji.");
    } catch (Exception ex) {
        // Obrađuje sve ostale izuzetke
        throw new RuntimeException("Došlo je do greške prilikom brisanja entiteta: " + ex.getMessage());
    }
    }
    
    @Override
    public Ugovor addUgovorToKlijent(Long jmbg, Ugovor ugovor){
        Klijent klijent = klijentRepository.findById(jmbg).orElse(null);
        if (klijent!=null){
            ugovor.setKlijent(klijent);
            return ugovorRepository.save(ugovor);
        }
        return null;
    }


    @Override
    public Ugovor delete(Long jmbg, Long ugovorBroj) throws InvalidEntityException {
        Klijent klijent = klijentRepository.findById(jmbg).orElse(null); // nasao klijenta
        System.out.println("KLIJENT:" + klijent.getImeKlijenta()+"Broj ugovora: "+ klijent.getUgovori().size());
        Ugovor toDelete = null;
        if (klijent!=null){
            boolean ugovorIndicator = klijent.getUgovori().stream().anyMatch(ugovor->ugovor.getBrojUgovora().equals(ugovorBroj)); //.contains(ugovor);
            System.out.println("INDIKATOR:" + ugovorIndicator);
            if (ugovorIndicator){
                for (Ugovor u: klijent.getUgovori()){
                    if (u.getBrojUgovora().equals(ugovorBroj)){
                        System.out.println("Obrisace ugovor...");
                        toDelete = u;    //detektovan ugovor za brisanje
                    }
                }
                System.out.println("Obrisao je ugovor");
                ugovorRepository.delete(toDelete); // brisanje ugovora
                klijent.getUgovori().remove(toDelete); 
// brisanje b objekta iz ugovora preko ugovor repository, ali klijent i dalje ima referencu na obrisani ugovor
// kako moj jak objekat ima cascade.ALL opciju, Ugovr ce se vratiti u kontekst ako nije obrisan iz liste ugovora koja se odnosi na tog klijenta
//tj. ponistice se brisanje.  Da nije ovo uradjeno, doslo bi do nekonzistentnosti i objekat bi morao ponovo biti vracen u kontekst 
            }
        }
        return null;
    
    }

    @Override
    public KlijentDto save(KlijentDto klijentDto) throws EntityExistsException {
        System.out.println(klijentDto.toString());
        //Optional<Klijent> entity = klijentRepository.findOne();
        Optional<Klijent> k = klijentRepository.findKlijentByJmbg(klijentDto.getJmbgKlijenta());
        if (k.isPresent()){
            throw new EntityExistsException(k.get(), "Klijent already exists!");
        }
        Klijent klijentEntity = klijentConverter.toEntity(klijentDto);
        for (Ugovor u:klijentEntity.getUgovori()){
            System.out.println(u.toString());
            u.setKlijent(klijentEntity);
        }
        //System.out.println("NAKON DODAVANJA KLIJENTA SVIM UGOVORIMA, KLIJENT"); // REKRUZIVNI POZIVI ZA OVO DOLE
        //System.out.println(klijentEntity.toString()); // ovde je nastao problem, pri setovanju  - rekurzivno ponavljanje jer su sad hvala bog valjda klij setovani na ugovore
        
        Klijent klijent = klijentRepository.save(klijentEntity);
        return klijentConverter.toDto(klijent);
    }
        
}
