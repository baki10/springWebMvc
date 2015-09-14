package com.bakigoal.controller;

import com.bakigoal.component.ImageFileManipulator;
import com.bakigoal.entity.User;
import com.bakigoal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by bakigoal on 12.09.15.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private static final String USERS = "users";
    private static final String USER = "user";

    @Autowired
    private UserService userService;

    @Autowired
    private ImageFileManipulator imageFileManipulator;

    /**
     * @return - list of all users
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allUsers(Model model) {
        List all = userService.getUsers();
        model.addAttribute(USERS, all);
        return USERS;
    }

    @RequestMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(USERS, userService.getUsers());
        modelAndView.setViewName(USERS);
        return modelAndView;
    }


    /**
     * @param username
     * @return - user by its id
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String personById(@PathVariable("username") String username, Model model) {
        User byId = userService.getUserByUsername(username);
        model.addAttribute(USER, byId);
        return USER;
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
    public String processAddNewUserForm(@ModelAttribute("newUser") @Valid User newUser,
                                        BindingResult errors,
                                        @RequestParam(value = "image", required = false) MultipartFile image) {

        if (errors.hasErrors()) {
            return "addUser";
        }

        if (!image.isEmpty()) {
            try {
                imageFileManipulator.validateImage(image);
            } catch (RuntimeException re) {
                errors.reject("registerForm.image");
                return "addUser";
            }

            try {
                String imageUrl = imageFileManipulator.saveImage("users/" + newUser.getUsername() + ".jpg", image);
                newUser.setImageUrl(imageUrl);
            } catch (IOException e) {
                errors.reject("global.error.code");
                return "addUser";
            }
        }

        userService.registerNewUser(newUser);
        return "redirect:/users";
    }

    /**
     * @param model
     * @return - remove user form
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String getRemoveUserForm(@RequestParam("username") String username, Model model) {
        User deleteUser = userService.getUserByUsername(username);
        imageFileManipulator.deleteImage(deleteUser.getImageUrl());
        userService.removeUser(deleteUser);
        return "redirect:/users";
    }

    /**
     * @param username
     * @return - edit user by its id
     */
    @RequestMapping(value = "/edit/{username}", method = RequestMethod.GET)
    public String editUser(@PathVariable("username") String username, Model model) {
        User byId = userService.getUserByUsername(username);
        model.addAttribute("user", byId);
        return "editUser";
    }

    /**
     * @param newUser
     * @return - process adding new user
     */
    @RequestMapping(value = "/edit/{username}", method = RequestMethod.POST)
    public String processUpdateUserForm(@PathVariable("username") String username,
                                        @ModelAttribute("user") @Valid User newUser,
                                        BindingResult errors,
                                        @RequestParam(value = "image", required = false) MultipartFile image) {

        if (errors.hasErrors()) {
            return "editUser";
        }

        if (!image.isEmpty()) {
            try {
                imageFileManipulator.validateImage(image);
            } catch (RuntimeException re) {
                errors.reject("registerForm.image");
                return "editUser";
            }

            try {
                String imageUrl = imageFileManipulator.saveImage("users/" + newUser.getUsername() + ".jpg", image);
                newUser.setImageUrl(imageUrl);
            } catch (IOException e) {
                errors.reject("global.error.code");
                return "editUser";
            }
        }

        userService.updateUser(newUser);
        return "redirect:/users/"+username;
    }
}
