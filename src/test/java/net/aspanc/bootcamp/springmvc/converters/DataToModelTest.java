package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.models.GameModel;
import org.junit.Assert;
import org.junit.Test;

public class DataToModelTest {

    private final static Long ID = 1L;
    private final static String TITLE = "A";
    private final static String DESCRIPTION = "B1";
    private final static Integer STEAM_ID = 1;
    private final static Boolean FINISHED = true;

    @Test
    public void checkConvertedObject(){
        GameDto gameDto = GameDto.builder()
                .id(ID)
                .title(TITLE)
                .description(DESCRIPTION)
                .steamId(STEAM_ID)
                .played(FINISHED)
                .build();

        GameDataToModelConverter gameDataToModelConverter = new GameDataToModelConverter();

        GameModel gameModel = gameDataToModelConverter.convert(gameDto);

        Assert.assertNotNull(gameModel);
        Assert.assertEquals(ID, gameModel.getId());
        Assert.assertEquals(TITLE, gameModel.getTitle());
        Assert.assertEquals(DESCRIPTION, gameModel.getDescription());
        Assert.assertEquals(STEAM_ID, gameModel.getSteamId());
        Assert.assertEquals(FINISHED, gameModel.getPlayed());
    }
}
