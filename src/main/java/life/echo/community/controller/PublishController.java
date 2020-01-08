package life.echo.community.controller;

import life.echo.community.mapper.QuesstionMapper;
import life.echo.community.mapper.UserMapper;
import life.echo.community.model.Quesstion;
import life.echo.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangzewen on 2019/12/27
 */
@Controller
public class PublishController {

    @Autowired
    private QuesstionMapper quesstionMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model
    ){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
        }
        Quesstion quesstion = new Quesstion();
        quesstion.setTitle(title);
        quesstion.setDescription(description);
        quesstion.setTag(tag);
        quesstion.setCreator(user.getId());
        quesstion.setGmtCreate(System.currentTimeMillis());
        quesstion.setGmtModified(quesstion.getGmtCreate());

        quesstionMapper.create(quesstion);
        return "redirect:/";
    }
}
