package life.echo.community.mapper;

import life.echo.community.model.Quesstion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

    @Select("select * from question")
    List<Quesstion> list();
}
