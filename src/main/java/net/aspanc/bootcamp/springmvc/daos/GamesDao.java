package net.aspanc.bootcamp.springmvc.daos;

import net.aspanc.bootcamp.springmvc.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesDao extends JpaRepository<GameModel, Long> {
}
