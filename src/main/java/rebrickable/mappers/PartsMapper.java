package rebrickable.mappers;

import org.apache.ibatis.annotations.*;
import rebrickable.model.db.Parts;

import java.util.ArrayList;

@Mapper
public interface PartsMapper {

    // write in mySQL commands to be used
    String GET_ALL_PARTS = "SELECT * FROM `rebrickable`.PartsResults where part_num IS NOT NULL";

    String GET_PART_NUM = "SELECT * FROM `rebrickable`.PartsResults where part_num = #{part_num}";

    String INSERT_PART = "INSERT INTO `rebrickable`.`PartsResults` (`part_num`, `name`, `part_url`)" +
            " VALUES (#{part_num}, #{name}, #{part_url})";

    String UPDATE_BY_PART_NUM = "UPDATE `rebrickable`.PartsResults SET part_num = #{part_num}, name = #{name}, part_url = #{part_url}" +
            "WHERE part_num = #{part_num}";

    String DELETE_PART = "DELETE FROM `rebrickable`.PartsResults where part_num = #{part_num}";

    @Select(GET_ALL_PARTS)
    public ArrayList<Parts> getAllParts();

    @Select(GET_PART_NUM)
    public Parts getPartNum(String part_num);

    @Insert(INSERT_PART)
    public void insertPart(Parts parts);

    @Update(UPDATE_BY_PART_NUM)
    public void updatePartNum(Parts parts);

    @Delete(DELETE_PART)
    public void deletePart(String part_num);
}
