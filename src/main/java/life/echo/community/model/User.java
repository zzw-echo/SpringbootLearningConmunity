package life.echo.community.model;

import lombok.Data;

/**
 * Created by zhangzewen on 2019/12/24
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private long gmtCreate;
    private long gmtModified;
    private String avatarUrl;
}
