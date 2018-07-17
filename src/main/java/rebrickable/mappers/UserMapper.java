package rebrickable.mappers;

import org.apache.ibatis.annotations.Mapper;
import rebrickable.model.db.Users;

@Mapper
public interface UserMapper {

    String INSERT_USER = " ";

    void addUser(Users users);
}