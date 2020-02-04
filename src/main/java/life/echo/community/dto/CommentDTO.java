package life.echo.community.dto;

import life.echo.community.model.User;

/**
 * Created by zhangzewen on 2020/2/4
 */
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
