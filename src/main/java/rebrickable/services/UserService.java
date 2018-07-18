package rebrickable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rebrickable.mappers.UserMapper;
import rebrickable.model.db.User;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SecurityService securityService;

    // add user to the db
    public User newUser(User user) throws NoSuchAlgorithmException {

        //　create API Key
        String apiKey = securityService.createApiKey();
        // set API key
        user.setApi_key(apiKey);
        // call SQL query to to insert into
        userMapper.addUser(user);
        // return user by API key
        return userMapper.getUserByApiKey(apiKey);
    }
}
