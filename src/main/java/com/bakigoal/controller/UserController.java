package com.bakigoal.controller;

import com.bakigoal.entity.User;
import com.bakigoal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
     * @return - list of all users
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allUsers(Model model) {
        List all = userService.getUsers();
        model.addAttribute("users",all);
        return "users";
    }

    @RequestMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", userService.getUsers());
        modelAndView.setViewName("users");
        return modelAndView;
    }


    /**
     * @param username
     * @return - user by its id
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String  personById(@PathVariable("username") String username, Model model) {
        User byId = userService.getUserByUsername(username);
        model.addAttribute("user",byId);
        return "user";
    }


    /**
     * @param model
     * @return - add new user form
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewUserForm(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "addUser";
    }

    /**
     * @param newUser
     * @return - process adding new user
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewUserForm(@ModelAttribute("newUser") User newUser) {
        userService.registerNewUser(newUser);
        return "redirect:/users";
    }

    /**
     * @param model
     * @return - remove user form
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String getRemoveUserForm(@RequestParam("username") String username,Model model) {
        User deleteUser = userService.getUserByUsername(username);
        userService.removeUser(deleteUser);
        return "redirect:/users";
    }
}
