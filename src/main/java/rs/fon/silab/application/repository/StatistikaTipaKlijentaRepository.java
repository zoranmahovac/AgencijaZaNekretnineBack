/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.fon.silab.application.repository;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.fon.silab.application.model.Agent;
import rs.fon.silab.application.model.StatistikaTipaId;
import rs.fon.silab.application.model.StatistikaTipaKlijenta;

/**
 *
 * @author Korisnik
 */
public interface StatistikaTipaKlijentaRepository extends JpaRepository<StatistikaTipaKlijenta,StatistikaTipaId> {

    @Query("select st from StatistikaTipaKlijenta st where st.tipKlijenta.sifraTipa=?1 and st.agent.redniBrojURegistruPosrednika=?2")
    public List<StatistikaTipaKlijenta> findStatistike(Long sifra_tipa, Long rburp);
 

}
