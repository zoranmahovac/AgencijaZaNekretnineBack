/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.converter;

import org.springframework.stereotype.Component;
import rs.fon.silab.application.dto.TipKlijentaDto;
import rs.fon.silab.application.model.ApplicationEntity;
import rs.fon.silab.application.model.TipKlijenta;

/**
 *
 * @author Korisnik
 */
@Component
public class TipKlijentaConverter implements GenericConverter<TipKlijentaDto, TipKlijenta>{
    // konverzije iz entity u dto i obrnuto 
    @Override
    public TipKlijenta toEntity(TipKlijentaDto dto) {
        return new TipKlijenta(dto.getSifraTipa(), dto.getNazivTipa());
    }

    @Override
    public TipKlijentaDto toDto(TipKlijenta entity) {
        return new TipKlijentaDto(entity.getSifraTipa(), entity.getNazivTipa());
    }
    
    
}
