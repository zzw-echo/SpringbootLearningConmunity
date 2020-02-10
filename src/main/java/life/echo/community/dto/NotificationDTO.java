package life.echo.community.dto;

import life.echo.community.model.User;
import lombok.Data;

/**
 * Created by zhangzewen on 2020/2/10
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private User notifier;
    private String outerTitle;
    private String type;
}
