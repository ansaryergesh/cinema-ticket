package com.rental.User.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String hello() {
        return "Hello, It's info page";
    }

    //------------------------------------------------------------------------------------------------------\\
    @PostMapping("/add")
    public User add(@Valid @RequestBody User user) {
        user.setRole("USER");
        return userRepository.save(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{userName}")
    public Boolean getUserByUserName(@PathVariable(value = "userName") String userName){
//            throws ResourceNotFoundException {
//        User user = userRepository.getByUsername(userName);
//        if (user.getFullName() == null){
//            return false;
//        }
//        System.out.println(user.getFullName());
//        return true;
        return userRepository.existsByUsername(userName);
    }

    @GetMapping("/user")
    public Boolean getUserByUserNameAndPassword(@RequestParam("userName") String userName,
                                             @RequestParam("password") String password)
            throws ResourceNotFoundException {
//        User user = userRepository.getByUsernameAndPassword(userName, password);
//        if (user.getFullName() == null){
//            return false;
//        }
//        System.out.println(user.getFullName());
        return userRepository.existsByUsernameAndPassword(userName, password);
    }
}
