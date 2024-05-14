package net.aspanc.bootcamp.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @GetMapping
    public String helloWorld(Model model) {
        model.addAttribute("msg","Hello world");
        return "index";
    }

}
