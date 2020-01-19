package qq.life.community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import qq.life.community.community.model.User;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    @Select("select * from user where token = #{token}" )
    User findByToken(@Param("token") String token);
}