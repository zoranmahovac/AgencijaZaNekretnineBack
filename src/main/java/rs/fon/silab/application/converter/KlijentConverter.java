/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.converter;

import org.springframework.stereotype.Component;
import rs.fon.silab.application.dto.ApplicationDto;
import rs.fon.silab.application.dto.KlijentDto;
import rs.fon.silab.application.model.ApplicationEntity;
import rs.fon.silab.application.model.Klijent;

/**
 *
 * @author Korisnik
 */
@Component
public class KlijentConverter implements GenericConverter<KlijentDto,Klijent>{

    @Override
    public Klijent toEntity(KlijentDto dto) {
        return new Klijent(dto.getJmbgKlijenta(), dto.getImeKlijenta(), dto.getPrezimeKlijenta(),dto.getTipKlijenta(),dto.getUgovori());
    }

    @Override
    public KlijentDto toDto(Klijent entity) {
        return new KlijentDto(entity.getJmbgKlijenta(), entity.getImeKlijenta(), entity.getPrezimeKlijenta(),entity.getTipKlijenta(), entity.getUgovori());
    }

  
    
}
