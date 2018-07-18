package rebrickable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rebrickable.model.db.InvalidAPIKeyException;
import rebrickable.model.db.User;
import rebrickable.services.SecurityService;
import rebrickable.services.UserService;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    // Create user
    @PostMapping
    public User addUser(@RequestBody User user) throws NoSuchAlgorithmException {

        return userService.newUser(user);
    }
}

//    throws InvalidAPIKeyException {
//     @RequestParam(api-key)String apikey
//
//        if (securityService.authenticate(apiKey)) {
//            return userService.newUser(apiKey);
//        } else {
//            throw new InvalidAPIKeyException("No API Key found.");

