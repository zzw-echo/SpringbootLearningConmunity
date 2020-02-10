package life.echo.community.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by zhangzewen on 2020/2/10
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
