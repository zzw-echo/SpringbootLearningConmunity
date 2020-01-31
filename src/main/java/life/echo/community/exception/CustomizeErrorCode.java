package life.echo.community.exception;

/**
 * Created by zhangzewen on 2020/1/31
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND("你找到的问题不在了，请换个问题试试 ..");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
