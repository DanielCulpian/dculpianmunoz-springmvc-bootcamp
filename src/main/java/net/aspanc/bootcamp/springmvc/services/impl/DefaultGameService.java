package net.aspanc.bootcamp.springmvc.services.impl;

import net.aspanc.bootcamp.springmvc.daos.GamesDao;
import net.aspanc.bootcamp.springmvc.model.GameModel;
import net.aspanc.bootcamp.springmvc.services.GameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultGameService implements GameService {

    @Resource
    private GamesDao gameDao;

    @Override
    public List<GameModel> findAll() {
        return gameDao.findAll();
    }

    @Override
    public Optional<GameModel> findById(Long id) {
        return gameDao.findById(id);
    }

    @Override
    public List<GameModel> findByTitle(String title) {
        return gameDao.findByTitleIgnoreCase(title);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void save(GameModel gameModel) {

    }
}
