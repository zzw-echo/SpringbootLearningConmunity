package life.echo.community.controller;

import life.echo.community.mapper.QuesstionMapper;
import life.echo.community.mapper.UserMapper;
import life.echo.community.model.Quesstion;
import life.echo.community.model.User;
import life.echo.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id")Integer id,
                       Model model){
        Quesstion quesstion = quesstionMapper.getById(id);
        model.addAttribute("title", quesstion.getTitle());
        model.addAttribute("description", quesstion.getDescription());
        model.addAttribute("tag", quesstion.getTag());
        model.addAttribute("id", quesstion.getId());
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            HttpServletRequest request,
            Model model){
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if (title == null || title == ""){
            model.addAttribute("error", "title can not null ..");
            return "publish";
        }
        if (description == null || description == ""){
            model.addAttribute("error", "description can not null ..");
            return "publish";
        }
        if (tag == null || tag == ""){
            model.addAttribute("error", "tag can not null");
            return "publish";
        }
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
