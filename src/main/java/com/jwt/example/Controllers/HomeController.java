package com.jwt.example.Controllers;

import com.jwt.example.entities.User;
import com.jwt.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")


public class HomeController {

    @Autowired
    private UserService userService;

    //htttp:localhost:8080/home/user
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user")
    public List<User> user(){

        return userService.getUsers();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getuser")
    public String getUsers(){

        return "{\"name\":\"Akash\"}";
    }

    @GetMapping("/currentUser")
    public String currentUser(Principal principal){
        return principal.getName();
    }


}
