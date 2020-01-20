package qq.life.community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import qq.life.community.community.model.Question;

import java.util.List;

/**
 * 将数据注入到数据库
 */
@Mapper
@Component
public interface QuestionMapper {

    @Select("select * from Question")
    public List<Question> list();

    @Insert("insert into Question(title,description,gmt_create,gmt_modified,creator,tag) " +
            "values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void create(Question question);

}
