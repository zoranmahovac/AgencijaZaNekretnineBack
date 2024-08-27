/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.silab.application.converter;

import org.springframework.stereotype.Component;
import rs.fon.silab.application.dto.AgentDto;
import rs.fon.silab.application.dto.ApplicationDto;
import rs.fon.silab.application.model.Agent;
import rs.fon.silab.application.model.ApplicationEntity;

/**
 *
 * @author Korisnik
 */
@Component
public class AgentConverter implements GenericConverter<AgentDto, Agent>{

    @Override
    public Agent toEntity(AgentDto dto) {
        return new Agent(dto.getRedniBrojURegistruPosrednika(),dto.getImeAgenta(), dto.getPrezimeAgenta(),dto.getAdresaAgenta(),dto.getUspesnostRealizacije(),dto.getBrojDodeljenihKlijenata());
    }

    @Override
    public AgentDto toDto(Agent entity) {
        return new AgentDto(entity.getRedniBrojURegistruPosrednika(),entity.getImeAgenta(),entity.getPrezimeAgenta(),entity.getAdresaAgenta(),entity.getUspesnostRealizacije(),entity.getBrojDodeljenihKlijenata());
    }

    
}
