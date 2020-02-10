package life.echo.community.cache;

import life.echo.community.dto.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangzewen on 2020/2/10
 */
public class TagCache {
    public List<TagDTO> get(){
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("Java","C","Python","PHP","C++","C#","JavaScript","R","Go","OC","Swift"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台架构");
        framework.setTags(Arrays.asList("SpringMVC","Spring","Mybatis","Dubbo","Maven","RabbitMQ","Log4j","Ehcache","Redis","Shiro"));
        tagDTOS.add(framework);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("Linux","Tomcat","Resin","JBoss","WebSphere","WebLogic","Apache","Lighttpd","IIS","NGINX"));
        tagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql","SQL","Server","Oracle","Sybase","DB2"));
        tagDTOS.add(db);

        TagDTO tool = new TagDTO();
        tool.setCategoryName("开发工具");
        tool.setTags(Arrays.asList("github","IDEA","eclipse","maven"));
        tagDTOS.add(tool);




        return tagDTOS;
    }
}
