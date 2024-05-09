package net.aspanc.bootcamp.springmvc;

import net.aspanc.bootcamp.springmvc.models.GameModel;
import net.aspanc.bootcamp.springmvc.services.GameService;
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

    @Resource
    private GameService gameService;

    private final GameModel gameModelAux = new GameModel();

    @Before
    public void setUp(){
        List<GameModel> games = gameService.findAll();
        if(games.isEmpty()) {
            gameModelAux.setTitle("A");
            gameModelAux.setDescription("B");
            gameModelAux.setSteamId(1);
            gameService.save(gameModelAux);
        }
    }

    @After
    public void cleaner(){
        List<GameModel> games = gameService.findAll();
        if(!games.isEmpty()){
            GameModel gameModel = gameService.findByTitle("A").get(0);
            gameService.delete(gameModel.getId());
        }
    }

    @Test
    public void createGameModelTest(){
        Assert.assertNotNull(gameService.save(gameModelAux));
    }

    @Test
    public void retrieveGameModel(){
        GameModel gameModel = gameService.findByTitle("A").get(0);

        Assert.assertNotNull(gameModel);
        Assert.assertNotNull(gameModel.getId());
        Assert.assertEquals(gameModelAux.getId(), gameModel.getId());
        Assert.assertEquals(gameModelAux.getTitle(), gameModel.getTitle());
        Assert.assertEquals(gameModelAux.getDescription(), gameModel.getDescription());
        Assert.assertEquals(gameModelAux.getSteamId(), gameModel.getSteamId());
    }

    @Test
    public void updateGameModelTest(){
        GameModel gameModel = gameService.findByTitle("A").get(0);
        Assert.assertNotNull(gameModel);
        gameModel.setDescription("C");
        Assert.assertNotNull(gameService.save(gameModel));
    }

    @Test
    public void deleteGameModelTest(){
        gameService.delete(gameModelAux.getId());
        Assert.assertFalse(gameService.findById(gameModelAux.getId()).isPresent());
    }
}
