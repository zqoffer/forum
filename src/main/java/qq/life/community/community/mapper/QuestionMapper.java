package qq.life.community.community.mapper;

import org.apache.ibatis.annotations.*;
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

    @Select("select * from Question where creator = #{userId} limit #{offset},#{size}")
    public List<Question> listByUser(@Param("userId")Integer userId,@Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question where creator = #{userId}")
    public Integer countById(@Param("userId")Integer userId);

    @Select("select * from question where id=#{id}")
    public Question getById(@Param("id") Integer id);

    @Update("update question set " +
            "title = #{title},description=#{description},gmt_create=#{gmtCreate},gmt_modified=#{gmtModified}," +
            "creator=#{creator},tag=#{tag} where id = #{id}")
    void update(Question question);
}
