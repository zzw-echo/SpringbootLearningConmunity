package life.echo.community.controller;

import life.echo.community.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangzewen on 2020/2/21
 */
@Controller
public class FileController {
    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(){
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/wechat2.png");
        return fileDTO;
    }
}
