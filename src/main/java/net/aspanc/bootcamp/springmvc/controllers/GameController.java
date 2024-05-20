package net.aspanc.bootcamp.springmvc.controllers;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showGame(Model model, @PathVariable Long id) {
        model.addAttribute("games", gameFacade.findById(id)
                                              .stream()
                                              .collect(Collectors.toList()));

        return "gameDetails";
    }

    @DeleteMapping(value = "/game/delete/{id}")
    public ResponseEntity<Long> deleteGame(@PathVariable Long id) {
        if (gameFacade.existsById(id)) {
            gameFacade.delete(id);
            return ResponseEntity.ok()
                                 .build();
        } else {
            return ResponseEntity.notFound()
                                 .build();
        }
    }

    @GetMapping(value = "/error/404")
    public String show404() {
        return "notFound";
    }

    @GetMapping(value = "/game")
    public String showGamesByTitle(Model model, @RequestParam String title) {
        model.addAttribute("games", gameFacade.findByTitle(title));
        return "index";
    }

    @PostMapping(value = "/game/new")
    public String addNewGame(@ModelAttribute GameDto gameDto){
        gameDto = gameFacade.save(gameDto);

        return "redirect:/game/" + gameDto.getId();
    }

}