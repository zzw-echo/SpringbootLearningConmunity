package life.echo.community.model;

import lombok.Data;

/**
 * Created by zhangzewen on 2019/12/27
 */
@Data
public class Quesstion {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commnetCount;
    private Integer likeCount;
}
