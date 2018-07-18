package rebrickable.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import rebrickable.model.db.User;

@Mapper
public interface UserMapper {

    // SQL Queries
    String INSERT_USER = "INSERT INTO `User`.`users` (`last_name`, `first_name`, `API_key`) " +
            "VALUES (#{last_name}, #{first_name}, #{API_key})";

    String SELECT_USER_BY_API_KEY = "SELECT FROM `Users`.`users` where API_key = #{api_key}";

    // 
    @Insert(INSERT_USER)
    void addUser(User users);

    @Insert(SELECT_USER_BY_API_KEY)
    User getUserByApiKey(String apiKey);
}