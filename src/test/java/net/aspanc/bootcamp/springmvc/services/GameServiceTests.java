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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceTests {

    private final String TITLE = "A";

    private final String DESCRIPTION = "B1";

    private final Integer STEAM_ID = 1;

    @Resource
    private GameService gameService;

    private GameModel gameModelAux;

    @Before
    public void setUp(){
        gameModelAux = new GameModel();

        gameModelAux.setTitle(TITLE);
        gameModelAux.setDescription(DESCRIPTION);
        gameModelAux.setSteamId(STEAM_ID);
        gameService.save(gameModelAux);
    }

    @After
    public void cleaner(){
        List<GameModel> games = gameService.findAll();
        if(!games.isEmpty()){
            GameModel gameModel = gameService.findByTitle(TITLE).get(0);
            gameService.delete(gameModel.getId());
        }
    }

    @Test
    public void saveGameModel(){
        Assert.assertNotNull(gameService.save(gameModelAux));
    }

    @Test
    public void retrieveGameModel(){
        gameService.findById(gameModelAux.getId()).ifPresent(game -> {
            Assert.assertNotNull(game);
            Assert.assertNotNull(game.getId());
            Assert.assertEquals(gameModelAux.getId(), game.getId());
            Assert.assertEquals(TITLE, game.getTitle());
            Assert.assertEquals(DESCRIPTION, game.getDescription());
            Assert.assertEquals(STEAM_ID, game.getSteamId());
        });
    }

    @Test
    public void updateGameModel(){
        gameModelAux.setDescription("C");
        Assert.assertNotNull(gameService.save(gameModelAux));
        gameModelAux.setDescription(TITLE);

        GameModel gameModel = gameService.findByTitle(TITLE).get(0);

        Assert.assertNotNull(gameModel);
        Assert.assertNotNull(gameModel.getId());
        Assert.assertNotEquals(gameModelAux.getDescription(), gameModel.getDescription());
    }

    @Test
    public void deleteGameModel(){
        gameService.delete(gameModelAux.getId());
        Assert.assertTrue(gameService.findById(gameModelAux.getId()).isEmpty());
    }
}
