package net.aspanc.bootcamp.springmvc.controllers;

import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class GameController {

    @Resource
    private GameFacade gameFacade;

    @GetMapping(value = "/")
    public String showGames(Model model) {
        model.addAttribute("games", gameFacade.findAll());

        return "index";
    }
}