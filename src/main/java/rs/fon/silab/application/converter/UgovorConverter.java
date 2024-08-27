/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.converter;

import org.springframework.stereotype.Component;
import rs.fon.silab.application.dto.UgovorDto;
import rs.fon.silab.application.model.Ugovor;

/**
 *
 * @author Korisnik
 */
@Component
public class UgovorConverter implements GenericConverter<UgovorDto, Ugovor> {

    @Override
    public Ugovor toEntity(UgovorDto dto) {
        return new Ugovor(dto.getBrojUgovora(),dto.getAdresaNekretnine(),dto.getPovrsinaNepokretnosti(),dto.getSprat(),dto.getDatumZakljucenja(),dto.getCena(),dto.getKlijent());
    }

    @Override
    public UgovorDto toDto(Ugovor entity) {
        return new UgovorDto(entity.getKlijent(),entity.getBrojUgovora(),entity.getAdresaNekretnine(),entity.getPovrsinaNepokretnosti(),entity.getSprat(),entity.getDatumZakljucenja(),entity.getCena());
    }
    
}
