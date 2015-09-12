package com.bakigoal.controller;

import com.bakigoal.entity.User;
import com.bakigoal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by bakigoal on 12.09.15.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @return - list of all persons
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String allUsers(Model model) {
        List all = userService.getUsers();
        model.addAttribute("users",all);
        return "users";
    }

    /**
     * @param id
     * @return - user by its id
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String  personById(@PathVariable("id") Long id, Model model) {
        User byId = userService.getUserById(id);
        model.addAttribute("user",byId);
        return "user";
    }
}
