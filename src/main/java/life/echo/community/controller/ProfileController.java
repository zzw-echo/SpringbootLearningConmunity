package life.echo.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zhangzewen on 2020/1/8
 */
@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }
}
