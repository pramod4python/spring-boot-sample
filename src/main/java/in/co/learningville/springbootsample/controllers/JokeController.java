package in.co.learningville.springbootsample.controllers;

import in.co.learningville.springbootsample.service.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pra_pri on 13-Aug-17.
 */
@Controller
public class JokeController {
    private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/",""})
    public String showJoke(Model model){

        model.addAttribute("joke",jokeService.getJoke());
       return "chuknorris";
    }
}
