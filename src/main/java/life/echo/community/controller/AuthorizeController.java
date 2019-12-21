package life.echo.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhangzewen on 2019/12/21
 */
@Controller
public class AuthorizeController {
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state
                           ){
        return "index";
    }
}
