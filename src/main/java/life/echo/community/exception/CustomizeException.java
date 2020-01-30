package life.echo.community.exception;

/**
 * Created by zhangzewen on 2020/1/30
 */
public class CustomizeException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CustomizeException(String message) {
        this.message = message;
    }
}
