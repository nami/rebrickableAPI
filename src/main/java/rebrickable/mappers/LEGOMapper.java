package rebrickable.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rebrickable.model.LEGO.SetsResults;
import rebrickable.model.LEGO.ThemesResults;
import rebrickable.model.db.Parts;

@Mapper
public interface LEGOMapper {

    String INSERT_THEME = "INSERT INTO `rebrickable`.`ThemesResults` (`id`, `parent_id`, `name`) " +
            "VALUES (#{id}, #{parent_id}, #{name})";

    String INSERT_SET = "INSERT INTO `rebrickable`.`SetsResults` (`set_num`, `name`, `year`, `theme_id`, `num_parts`, `set_img_url`, `set_url`, `last_modified_dt`) " +
            "VALUES (#{set_num}, #{name}, #{year}, #{theme_id}, #{num_parts}, #{set_img_url}, #{set_url}, #{last_modified_dt})";

    String INSERT_PART = "INSERT INTO `rebrickable`.`PartsResults` (`part_num`, `name`, `part_url`) " +
            "VALUES (#{part_num}, #{name}, #{part_url})";

    @Insert(INSERT_THEME)
    public int insertThemeResult(ThemesResults tr);

    @Insert(INSERT_SET)
    public int insertSetResult(SetsResults setResult);

    @Insert(INSERT_PART)
    public int insertRecord(Parts p);
}
