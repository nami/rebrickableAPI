package rebrickable.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import rebrickable.model.db.User;

@Mapper
public interface UserMapper {

    // SQL Queries
    String INSERT_USER = "INSERT INTO `User`.`users` (`last_name`, `first_name`, `api_key`) " +
            "VALUES (#{last_name}, #{first_name}, #{api_key})";

    String SELECT_USER_BY_API_KEY = "SELECT * FROM `User`.`users` where api_key = #{api_key}";

    // my-batis fills this for us
    @Insert(INSERT_USER)
    void addUser(User users);

    @Select(SELECT_USER_BY_API_KEY)
    User getUserByApiKey(String apiKey);
}