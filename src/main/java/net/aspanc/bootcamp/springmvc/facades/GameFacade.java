package net.aspanc.bootcamp.springmvc.facades;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamNewsDto;

import java.util.List;
import java.util.Optional;

public interface GameFacade {

    List<GameDto> findAll();

    Optional<GameDto> findById(Long id);

    List<GameDto> findByTitle(String title);

    void delete(Long id);

    GameDto save(GameDto gameDto);

    Boolean existsById(Long id);

    String getSteamGameById(Integer id, String countryCode, String language);

    List<SteamNewsDto> getSteamNewsById(Integer id);

}
