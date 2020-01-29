package life.echo.community.dto;

import life.echo.community.model.User;
import lombok.Data;

/**
 * Created by zhangzewen on 2019/12/30
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
