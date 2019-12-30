package life.echo.community.controller;

import life.echo.community.mapper.UserMapper;
import life.echo.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangzewen on 2019/12/20
 */
@Controller
public class IndexController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String Index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        return "index";
    }
}