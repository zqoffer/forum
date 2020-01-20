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

    @Select("select * from Question limit #{offset},#{size}")
    public List<Question> list(@Param("offset") Integer offset, @Param("size") Integer size);

    @Insert("insert into Question(title,description,gmt_create,gmt_modified,creator,tag) " +
            "values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void create(Question question);

    @Select("select count(1) from question")
    public Integer count();

}
