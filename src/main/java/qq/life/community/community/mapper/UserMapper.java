package qq.life.community.community.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import qq.life.community.community.model.User;

@Mapper
@Component
public interface UserMapper {
    @Insert("insert into USER (name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    @Select("select * from user where token = #{token}" )
    User findByToken(@Param("token") String token);
    @Select("select * from user where id = #{id}")
    User findById(@Param("id")Integer id);
    @Select("select * from user where account_id=#{accountId}")
    User getByAccountId(@Param("accountId") String accountId);
    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified} where id=#{id}")
    void update(User dbUser);
}
