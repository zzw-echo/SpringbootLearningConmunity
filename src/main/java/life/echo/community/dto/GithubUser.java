package life.echo.community.dto;

import lombok.Data;

/**
 * Created by zhangzewen on 2019/12/24
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
