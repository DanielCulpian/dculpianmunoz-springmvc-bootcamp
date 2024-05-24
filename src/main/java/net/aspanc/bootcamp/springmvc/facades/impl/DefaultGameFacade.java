package net.aspanc.bootcamp.springmvc.facades.impl;

import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamNews;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamStorefront;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamNewsItem;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.StoreAppDetails;
import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamNewsDto;
import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import net.aspanc.bootcamp.springmvc.models.GameModel;
import net.aspanc.bootcamp.springmvc.services.GameService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DefaultGameFacade implements GameFacade {

    @Resource
    private Converter<GameModel, GameDto> gameModelToDataConverter;
    @Resource
    private Converter<GameDto, GameModel> gameDataToModelConverter;
    @Resource
    private Converter<StoreAppDetails, SteamGameDto> gameSteamDtoConverter;
    @Resource
    private Converter<SteamNewsItem, SteamNewsDto> gameSteamNewsDtoConverter;
    @Resource
    private GameService gameService;
    @Resource
    private SteamStorefront steamStorefront;
    @Resource
    private SteamNews steamNews;

    @Override
    public List<GameDto> findAll() {
        return gameService.findAll()
                          .stream()
                          .map(gameModelToDataConverter::convert)
                          .collect(Collectors.toList());
    }

    @Override
    public Optional<GameDto> findById(Long id) {
        return gameService.findById(id)
                          .map(gameModelToDataConverter::convert);
    }

    @Override
    public List<GameDto> findByTitle(String title) {
        return gameService.findByTitle(title)
                          .stream()
                          .map(gameModelToDataConverter::convert)
                          .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        gameService.delete(id);
    }

    @Override
    public GameDto save(GameDto gameDto) {
        GameModel gameModel = gameService.save(gameDataToModelConverter.convert(gameDto));
        return gameModelToDataConverter.convert(gameModel);
    }

    @Override
    public Boolean existsById(Long id) {
        return gameService.existsById(id);
    }

    @Override
    public String getSteamGameById(Integer id, String countryCode, String language) {
        SteamGameDto steamGameDto = gameSteamDtoConverter.convert(steamStorefront.getAppDetails(id, countryCode, language).join());

        assert steamGameDto != null;
        return steamGameDto.getScreenshotUrl();
    }

    @Override
    public List<SteamNewsDto> getSteamNewsById(Integer id) {
        return steamNews.getNewsForApp(id, -1, -1, 5, "")
                        .join()
                        .stream()
                        .map(gameSteamNewsDtoConverter::convert)
                        .collect(Collectors.toList());
    }

}