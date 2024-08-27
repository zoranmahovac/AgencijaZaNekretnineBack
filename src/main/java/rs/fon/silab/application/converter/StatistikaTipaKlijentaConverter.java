/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.converter;

import org.springframework.stereotype.Component;
import rs.fon.silab.application.dto.StatistikaTipaKlijentaDto;
import rs.fon.silab.application.model.StatistikaTipaKlijenta;

/**
 *
 * @author Korisnik
 */
@Component
public class StatistikaTipaKlijentaConverter implements GenericConverter<StatistikaTipaKlijentaDto, StatistikaTipaKlijenta>{

    @Override
    public StatistikaTipaKlijenta toEntity(StatistikaTipaKlijentaDto dto) {
        return new StatistikaTipaKlijenta(dto.getId(),dto.getTipKlijenta(),dto.getAgent(),dto.getBrojDodeljenihKLijenataTipa());
    }

    @Override
    public StatistikaTipaKlijentaDto toDto(StatistikaTipaKlijenta entity) {
        return new StatistikaTipaKlijentaDto(entity.getId(), entity.getTipKlijenta(), entity.getAgent(),entity.getBrojDodeljenihKLijenataTipa());
    }
    
}
