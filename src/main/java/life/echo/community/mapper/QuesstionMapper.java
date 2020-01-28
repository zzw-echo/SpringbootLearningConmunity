package life.echo.community.mapper;

import life.echo.community.model.Quesstion;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangzewen on 2019/12/27
 */
@Mapper
@Repository
public interface QuesstionMapper {
    @Insert("insert into question (title, description, gmt_create, gmt_modified, creator, tag) values (#{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{tag})")
    void create(Quesstion quesstion);

    @Select("select * from question limit #{offset}, #{size}")
    List<Quesstion> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question;")
    Integer count();

    @Select("select * from question where creator = #{userId} limit #{offset}, #{size}")
    List<Quesstion> listByUserId(@Param("userId") Integer userId,@Param("offset") Integer offset,@Param("size") Integer size);

    @Select("select count(1) from question where creator = #{userId}")
    Integer countByUserId(@Param("userId") Integer userId);

    @Select("select * from question where id = #{id}")
    Quesstion getById(@Param("id") Integer id);

    @Update("update question set title = #{title}, description = #{description}, gmt_modified = #{gmtModified}, tag = #{tag} where id = #{id}")
    void update(Quesstion quesstion);
}
