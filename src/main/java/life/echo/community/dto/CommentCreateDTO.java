package life.echo.community.dto;

import lombok.Data;

/**
 * Created by zhangzewen on 2020/1/31
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
