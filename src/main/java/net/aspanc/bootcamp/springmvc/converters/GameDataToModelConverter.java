package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.models.GameModel;
import org.springframework.core.convert.converter.Converter;

public class GameDataToModelConverter implements Converter<GameDto, GameModel> {
    @Override
    public GameModel convert(GameDto gameDto) {
        return  new GameModel(
                gameDto.getId(),
                gameDto.getTitle(),
                gameDto.getDescription(),
                gameDto.getSteamId()
        );
    }
}
