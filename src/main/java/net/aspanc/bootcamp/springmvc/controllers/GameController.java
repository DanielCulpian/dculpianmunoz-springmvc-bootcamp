package net.aspanc.bootcamp.springmvc.controllers;

import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Controller
public class GameController {

    @Resource
    private GameFacade gameFacade;

    @GetMapping(value = "/")
    public String showGames(Model model) {
        model.addAttribute("games", gameFacade.findAll());

        return "index";
    }

    @GetMapping(value = "/game/{id}")
    public String showGame(@PathVariable Long id, Model model) {
        model.addAttribute("games", gameFacade.findById(id)
                                              .stream()
                                              .collect(Collectors.toList()));

        return "gameDetails";
    }

    @DeleteMapping(value = "/game/delete/{id}")
    public ResponseEntity<Long> deleteGame(@PathVariable Long id) {
        gameFacade.delete(id);
        return ResponseEntity.ok()
                             .build();
    }
}