package net.aspanc.bootcamp.springmvc.facades.impl;

import net.aspanc.bootcamp.springmvc.converters.GameDataToModelConverter;
import net.aspanc.bootcamp.springmvc.converters.GameModelToDataConverter;
import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.facades.GameFacadeLayer;
import net.aspanc.bootcamp.springmvc.models.GameModel;
import net.aspanc.bootcamp.springmvc.services.GameService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameFacade implements GameFacadeLayer {

    private GameModelToDataConverter gameModelToDataConverter;
    private GameDataToModelConverter gameDataToModelConverter;

    @Resource
    private GameService gameService;

    @Override
    public List<GameDto> findAll() {
        List<GameDto> gameDtoList = new ArrayList<>();

        gameService.findAll()
                   .forEach(gameModel -> gameDtoList.add(gameModelToDataConverter.convert(gameModel)));

        return gameDtoList;
    }

    @Override
    public Optional<GameDto> findById(Long id) {
        return Optional.ofNullable(gameModelToDataConverter.convert(gameService.findById(id).get()));
    }

    @Override
    public List<GameDto> findByTitle(String title) {
        List<GameDto> gameDtoList = new ArrayList<>();
        List<GameModel> gameModelList = gameService.findByTitle(title);

        gameModelList.forEach(gameModel -> gameDtoList.add(gameModelToDataConverter.convert(gameModel)));

        return gameDtoList;
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
}
