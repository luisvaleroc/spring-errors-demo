package com.errors.demoerrors.controllers;


import com.errors.demoerrors.exeptions.UserNotFoundExeption;
import com.errors.demoerrors.models.domain.User;
import com.errors.demoerrors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppController

{

    @Autowired
    private UserService userService;
    @GetMapping
    public  String index(){

        //int value = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name= "id") Long id) {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundExeption(("Error el usuario no existe Optional")));
        return user;
    }

    @GetMapping("/show2/{id}")
    public User show2(@PathVariable(name= "id") Long id) {
       User user = null;
        // User user = userService.findById(id);
        if(user == null){
            throw  new UserNotFoundExeption("Error el usuario no existe");
        }


        return user;
    }
}
