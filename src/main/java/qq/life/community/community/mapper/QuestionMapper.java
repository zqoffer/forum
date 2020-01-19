package qq.life.community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import qq.life.community.community.model.Question;

/**
 * 将数据注入到数据库
 */
@Mapper
@Component
public interface QuestionMapper {
    @Insert("insert into (title,description,gm_create,gm_modified,creator,tag) " +
            "values(#{title},#{description},#{gmCreate},#{gmModified},#{creator},#{tag})")
    public void create(Question question);

}
