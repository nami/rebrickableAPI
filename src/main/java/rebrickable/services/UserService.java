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

        String apiKey = securityService.createApiKey();
        user.setAPI_Key(apiKey);
        userMapper.addUser(user);
        return userMapper.getUserByApiKey(apiKey);
    }
}
