package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.models.GameModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class GameDataToModelConverter implements Converter<GameDto, GameModel> {

    @Override
    public GameModel convert(GameDto gameDto) {

        Assert.notNull(gameDto, "The dto object is null!");

        return GameModel.builder()
                .id(gameDto.getId())
                .title(gameDto.getTitle())
                .description(gameDto.getDescription())
                .steamId(gameDto.getSteamId())
                .build();
    }
}
