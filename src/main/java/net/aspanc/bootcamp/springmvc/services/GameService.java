package net.aspanc.bootcamp.springmvc.services;

import net.aspanc.bootcamp.springmvc.model.GameModel;

import java.util.List;
import java.util.Optional;

public interface GameService {

    List<GameModel> findAll();

    Optional<GameModel> findById(Long id);

    List<GameModel> findByTitle(String title);

    void delete(Long id);

    void save(GameModel gameModel);
}
