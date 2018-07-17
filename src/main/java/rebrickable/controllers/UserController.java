package rebrickable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rebrickable.model.db.Parts;
import rebrickable.model.db.Users;
import rebrickable.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // Create parts
    @PostMapping
   public Users addNewUser(@RequestBody Users users){
       return userService.newUser(users);
    }

}
