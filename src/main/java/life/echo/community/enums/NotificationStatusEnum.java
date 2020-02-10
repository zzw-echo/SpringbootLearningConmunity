package life.echo.community.enums;

/**
 * Created by zhangzewen on 2020/2/10
 */
public enum NotificationStatusEnum {

    UNREAD(0),
    READ(1),
    ;

    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
