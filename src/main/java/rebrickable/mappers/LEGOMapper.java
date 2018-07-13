package rebrickable.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rebrickable.model.LEGO.ThemesResults;

@Mapper
public interface LEGOMapper {

    String INSERT_THEME = "INSERT INTO `rebrickable`.`ThemesResults` (`id`, `parent_id`, `name`) " +
            "VALUES (#{id}, #{parent_id}, #{name})";

    @Insert(INSERT_THEME)
    public int insertThemeResult(ThemesResults tr);

}
