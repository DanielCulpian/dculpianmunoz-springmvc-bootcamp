package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.models.GameModel;
import org.junit.Assert;
import org.junit.Test;

public class ModelToDataTest {

    private final static Long ID = 1L;
    private final static String TITLE = "A";
    private final static String DESCRIPTION = "B1";
    private final static Integer STEAM_ID = 1;

    @Test
    public void checkConvertedObject(){
        GameModel gameModel = GameModel.builder()
                .id(ID)
                .title(TITLE)
                .description(DESCRIPTION)
                .steamId(STEAM_ID)
                .build();

        GameModelToDataConverter gameModelToDataConverter = new GameModelToDataConverter();

        GameDto gameDto = gameModelToDataConverter.convert(gameModel);

        Assert.assertNotNull(gameDto);
        Assert.assertEquals(ID, gameDto.getId());
        Assert.assertEquals(TITLE, gameDto.getTitle());
        Assert.assertEquals(DESCRIPTION, gameDto.getDescription());
        Assert.assertEquals(STEAM_ID, gameDto.getSteamId());
    }
}
