package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.models.GameModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class GameModelToDataConverter implements Converter<GameModel, GameDto> {

    @Override
    public GameDto convert(GameModel gameModel) {

        Assert.notNull(gameModel, "The model object is null!");

        return GameDto.builder()
                .id(gameModel.getId())
                .title(gameModel.getTitle())
                .description(gameModel.getDescription())
                .steamId(gameModel.getSteamId())
                .build();
    }
}