package net.aspanc.bootcamp.springmvc.controllers;

import com.ibasco.agql.protocols.valve.steam.webapi.pojos.StoreAppDetails;
import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.dtos.GameSteamDto;
import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
public class GameController {

    static final String INDEX = "index";
    static final String GAME_FORM = "gameForm";
    static final String GAME_EDIT_FORM = "gameEditForm";
    static final String GAME_DETAILS = "gameDetails";
    static final String NOT_FOUND = "notFound";

    @Resource
    private GameFacade gameFacade;
    @Resource
    MessageSource messageSource;

    @GetMapping(value = "/")
    public String showGames(Model model) {
        model.addAttribute("games", gameFacade.findAll());

        return INDEX;
    }

    @GetMapping(value = "/game/{id}")
    public String showGame(Model model, @PathVariable Long id) {
        model.addAttribute("games", gameFacade.findById(id)
                                              .stream()
                                              .collect(Collectors.toList()));

        return GAME_DETAILS;
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
        return NOT_FOUND;
    }

    @GetMapping(value = "/game")
    public String showGamesByTitle(Model model, @RequestParam String title) {
        model.addAttribute("games", gameFacade.findByTitle(title));
        return INDEX;
    }

    @GetMapping(value = "game/new")
    public String openForm(@ModelAttribute GameDto gameDto) {
        return GAME_FORM;
    }

    @PostMapping(value = "/game/new")
    public String addNewGame(@ModelAttribute @Valid GameDto gameDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            return GAME_FORM;
        }

        gameDto = gameFacade.save(gameDto);
        redirectAttrs.addAttribute("id", gameDto.getId())
                     .addFlashAttribute("message", String.format("%s %s %s", messageSource.getMessage("game_txt", null, LocaleContextHolder.getLocale()), gameDto.getId(), messageSource.getMessage("edited_txt", null, LocaleContextHolder.getLocale())));

        return "redirect:/game/" + gameFacade.save(gameDto)
                                             .getId();
    }

    @GetMapping(value = "/game/edit/{id}")
    public String openEditForm(Model model,
                               @PathVariable Long id,
                               @ModelAttribute GameDto gameDto) {
        model.addAttribute("gameDto", gameFacade.findById(id)
                                                .orElseThrow(() -> new NoSuchElementException(messageSource.getMessage("game_not_found_exc", null, LocaleContextHolder.getLocale()) + " " + id)));

        return GAME_EDIT_FORM;
    }

    @PostMapping(value = "/game/edit/{id}")
    public String editGame(@ModelAttribute @Valid GameDto gameDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            return GAME_EDIT_FORM;
        }

        gameDto = gameFacade.save(gameDto);
        redirectAttrs.addAttribute("id", gameDto.getId())
                     .addFlashAttribute("message", String.format("%s %s %s", messageSource.getMessage("game_txt", null, LocaleContextHolder.getLocale()), gameDto.getId(), messageSource.getMessage("created_txt", null, LocaleContextHolder.getLocale())));

        return "redirect:/";
    }

    @ResponseBody
    @GetMapping(value = "/game/steam/details/{steamId}")
    public String getGameDatailsById(@PathVariable Integer steamId) {
        return gameFacade.getSteamGameById(steamId);
    }

}