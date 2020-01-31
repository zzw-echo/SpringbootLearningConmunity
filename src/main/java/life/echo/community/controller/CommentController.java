package life.echo.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangzewen on 2020/1/31
 */
@Controller
public class CommentController {

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post() {

    }
}
