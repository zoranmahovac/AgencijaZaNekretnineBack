/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.converter;

import org.springframework.stereotype.Component;
import rs.fon.silab.application.dto.AngazovanjeDto;
import rs.fon.silab.application.model.Angazovanje;

/**
 *
 * @author Korisnik
 */
@Component
public class AngazovanjeConverter implements GenericConverter<AngazovanjeDto, Angazovanje>{

    @Override
    public Angazovanje toEntity(AngazovanjeDto dto) {
        return new Angazovanje(dto.getRbAngazovanja(),dto.getProvizija(),dto.isRealizovano(),dto.getAgent(),dto.getMenadzer(),dto.getUgovor(), dto.getKlijent());
    }

    @Override
    public AngazovanjeDto toDto(Angazovanje entity) {
        return new AngazovanjeDto(entity.getRbAngazovanja(), entity.getProvizija(),entity.isRealizovano(),entity.getAgent(),entity.getMenadzer(),entity.getUgovor(), entity.getKlijent());
    }
    
}
