package life.echo.community.exception;

/**
 * Created by zhangzewen on 2020/1/31
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你找到的问题不在了，请换个问题试试 .."),
    TARGET_NOT_FOUND(2002,"未选择任何评论进行回复 .."),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试 .."),
    SYS_ERROR(2004,"请稍后再试 .. "),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在 .."),
    COMMENT_NOT_FOUND(2006, "该评论不存在 .."),
    COMMENT_IS_EMPTY(2007, "输入内容不能为空 .."),
    READ_NOTIFICATION_FAIL(2008, "兄弟你这是都别人的信息 .."),
    NOTIFICATION_NOT_FOUND(2009, "未找到该通知 .."),
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
