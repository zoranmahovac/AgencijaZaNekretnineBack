/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.converter;

import org.springframework.stereotype.Component;
import rs.fon.silab.application.dto.MenadzerDto;
import rs.fon.silab.application.model.Menadzer;

/**
 *
 * @author Korisnik
 */
@Component 
public class MenadzerConverter implements GenericConverter<MenadzerDto,Menadzer>{

    @Override
    public Menadzer toEntity(MenadzerDto dto) {
        return new Menadzer(dto.getId(),dto.getImeMenadzera(),dto.getPrezimeMenadzera(),dto.getKorisnickoIme(),dto.getLozinka());
    }

    @Override
    public MenadzerDto toDto(Menadzer entity) {
        return new MenadzerDto(entity.getId(),entity.getImeMenadzera(),entity.getPrezimeMenadzera(),entity.getKorisnickoIme(),entity.getLozinka());
    }
    
}
