package qq.life.community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import qq.life.community.community.model.Comment;

@Mapper
@Component
public interface CommentMapper {

    @Insert("insert into comment(id,parent_id,type,commentor,gmt_create,gmt_modified,content) " +
            "values(#{id},#{parentId},#{type},#{commentor},#{gmtCreate},#{gmtModified},#{content})")
    public void insert(Comment comment);

    @Select("Select * from comment where id = #{id}")
    Comment getById(@Param("id") Integer id);
}
