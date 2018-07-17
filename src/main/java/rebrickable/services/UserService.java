package rebrickable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rebrickable.mappers.UserMapper;
import rebrickable.model.db.Users;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

//    public Users newUser(Users users) {
//        userMapper.addUser(users);
//        return userMapper.
//    }
}
