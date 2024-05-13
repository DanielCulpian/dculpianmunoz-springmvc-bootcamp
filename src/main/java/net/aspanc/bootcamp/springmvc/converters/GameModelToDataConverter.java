package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.models.GameModel;
import org.springframework.core.convert.converter.Converter;

public class GameModelToDataConverter implements Converter<GameModel, GameDto> {
    @Override
    public GameDto convert(GameModel gameModel) {
        return null;
    }
}
