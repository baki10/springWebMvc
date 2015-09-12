package com.bakigoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Map;

/**
 * Created by bakigoal on 08.09.15.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "The one and only amazing web store");
        return "welcome";
    }

    @RequestMapping("/home")
    public ModelAndView home(Map<String, Object> model) {
        model.put("greeting", "Welcome to my web store!");
        model.put("tagline", "The test version of view resolver");

        View view = new InternalResourceView("/WEB-INF/jsp/welcome.jsp");

        return new ModelAndView(view, model);
    }
}
