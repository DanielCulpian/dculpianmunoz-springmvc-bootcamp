package net.aspanc.bootcamp.springmvc.facades;

import com.ibasco.agql.protocols.valve.steam.webapi.pojos.StoreAppDetails;
import net.aspanc.bootcamp.springmvc.dtos.GameDto;

import java.util.List;
import java.util.Optional;

public interface GameFacade {

    List<GameDto> findAll();

    Optional<GameDto> findById(Long id);

    List<GameDto> findByTitle(String title);

    void delete(Long id);

    GameDto save(GameDto gameDto);

    Boolean existsById(Long id);

    StoreAppDetails getSteamGameById(Integer id);

}
