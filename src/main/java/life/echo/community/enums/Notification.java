package life.echo.community.enums;

/**
 * Created by zhangzewen on 2020/2/10
 */
public enum Notification {
    REPLY_QUESTION(1,"回复了问题"),
    REPLY_COMMENT(2,"回复了评论"),
    ;


    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    private int status;
    private String name;

    Notification(int status, String name) {
        this.status = status;
        this.name = name;
    }
}
