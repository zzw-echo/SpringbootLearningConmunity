package life.echo.community.dto;

import lombok.Data;

/**
 * Created by zhangzewen on 2020/2/10
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
