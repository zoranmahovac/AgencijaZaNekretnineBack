/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.fon.silab.application.model.Angazovanje;

/**
 *
 * @author Korisnik
 */
@Repository
public interface AngazovanjeRepository extends JpaRepository<Angazovanje,Long>{
    
    @Query("select a from Angazovanje a WHERE a.menadzer.id=?1 and a.agent.redniBrojURegistruPosrednika=?2 and a.ugovor.brojUgovora=?3")
    List<Angazovanje> findFilter(Long menadzer_id, Long rburp,Long ugovor_id);
    
    @Query("select a from Angazovanje a WHERE a.menadzer.id=?1 and a.agent.redniBrojURegistruPosrednika=?2")
    List<Angazovanje> findUgovorFilter(Long menazder_id, Long rubp);
    
    
}
