package life.echo.community.enums;

/**
 * Created by zhangzewen on 2020/2/1
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2)
    ;
    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
