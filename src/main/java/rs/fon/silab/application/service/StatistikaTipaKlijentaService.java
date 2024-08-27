/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.service;

import java.util.List;
import java.util.Optional;
import rs.fon.silab.application.dto.StatistikaTipaKlijentaDto;
import rs.fon.silab.application.exception.EntityExistsException;
import rs.fon.silab.application.exception.InvalidEntityException;
import rs.fon.silab.application.model.StatistikaTipaId;

/**
 *
 * @author Korisnik
 */
public interface StatistikaTipaKlijentaService {
    
    List<StatistikaTipaKlijentaDto> findAll();
    
    List<StatistikaTipaKlijentaDto> findAll(Integer pageNo, Integer pageSize, String sortBy);
    
    Optional<StatistikaTipaKlijentaDto> findById(StatistikaTipaId id);
    
    StatistikaTipaKlijentaDto save(Long sifra_tipa, Long rburp, int brojKlijenata,Long id) throws EntityExistsException;

    void deleteById(StatistikaTipaId id) throws InvalidEntityException;//sifra_tipa, rburp, brojKlijenata, id

    public List<StatistikaTipaKlijentaDto> findStatistike(Long sifra_tipa, Long rburp);
}
