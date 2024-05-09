package net.aspanc.bootcamp.springmvc;

import net.aspanc.bootcamp.springmvc.models.GameModel;
import net.aspanc.bootcamp.springmvc.services.GameService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmvcApplicationTests {

    @Resource
    private GameService gameService;

    private final GameModel gameModelAux = new GameModel();

    @Before
    public void setUp(){
        gameModelAux.setTitle("A");
        gameModelAux.setDescription("B");
        gameModelAux.setSteamId(1);
        gameService.save(gameModelAux);
    }

    @Test
    public void createGameModelTest(){
        Assert.assertNotNull(gameService.save(gameModelAux));
    }

    @Test
    public void retrieveGameModel(){
        GameModel gameModel = gameService.findByTitle("A").get(0);
        Assert.assertNotNull(gameModel);

        gameModel = gameService.findAll().get(0);
        Assert.assertNotNull(gameModel);
        Assert.assertNotNull(gameModel.getId());
        Assert.assertNotNull(gameModel.getTitle());
        Assert.assertNotNull(gameModel.getDescription());
        Assert.assertNotNull(gameModel.getSteamId());
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
        GameModel gameModel = gameService.findByTitle("A").get(0);
        Assert.assertNotNull(gameModel);

        gameService.delete(gameModel.getId());
        Optional<GameModel> optionalGameModel = gameService.findById(gameModel.getId());
        Assert.assertTrue(optionalGameModel.isEmpty());
    }
}

