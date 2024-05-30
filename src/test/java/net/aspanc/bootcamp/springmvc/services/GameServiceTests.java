package net.aspanc.bootcamp.springmvc.services;

import net.aspanc.bootcamp.springmvc.models.GameModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceTests {

    private final static String TITLE = "A";
    private final static String DESCRIPTION = "B1";
    private final static String NEW_DESCRIPTION = "C";
    private final static Integer STEAM_ID = 1;
    private final static Boolean FINISHED = true;

    @Resource
    private GameService gameService;

    private GameModel gameModelAux;

    @Before
    public void setUp(){
        gameModelAux = new GameModel();

        gameModelAux.setTitle(TITLE);
        gameModelAux.setDescription(DESCRIPTION);
        gameModelAux.setSteamId(STEAM_ID);
        gameModelAux.setPlayed(FINISHED);
        gameModelAux = gameService.save(gameModelAux);
    }

    @After
    public void cleaner(){
        gameService.findById(gameModelAux.getId()).ifPresent( game -> {
            gameService.delete(game.getId());
        });
    }

    @Test
    public void saveGameModel(){
        Assert.assertNotNull(gameModelAux);
    }

    @Test
    public void retrieveGameModel(){
        gameService.findById(gameModelAux.getId())
                   .ifPresentOrElse(
                        (game) -> {
                            Assert.assertEquals(gameModelAux.getId(), game.getId());
                            Assert.assertEquals(TITLE, game.getTitle());
                            Assert.assertEquals(DESCRIPTION, game.getDescription());
                            Assert.assertEquals(STEAM_ID, game.getSteamId());
                            Assert.assertEquals(FINISHED, game.getPlayed());
                        },
                        Assert::fail
        );
    }

    @Test
    public void updateGameModel(){
        gameModelAux.setDescription(NEW_DESCRIPTION);
        GameModel gameModel = gameService.save(gameModelAux);

        Assert.assertNotNull(gameModel);
        gameModelAux.setDescription(DESCRIPTION);

        Assert.assertEquals(NEW_DESCRIPTION, gameModel.getDescription());
    }

    @Test
    public void deleteGameModel(){
        gameService.delete(gameModelAux.getId());

        Assert.assertTrue(gameService.findById(gameModelAux.getId()).isEmpty());
    }
}
