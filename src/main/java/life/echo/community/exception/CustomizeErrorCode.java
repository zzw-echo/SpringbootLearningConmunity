package life.echo.community.exception;

/**
 * Created by zhangzewen on 2020/1/31
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你找到的问题不在了，请换个问题试试 .."),
    TARGET_NOT_FOUND(2002,"未选择任何评论进行回复 ..")
    ;

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
