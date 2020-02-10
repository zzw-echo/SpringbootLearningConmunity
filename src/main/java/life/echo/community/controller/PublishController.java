package life.echo.community.controller;

import life.echo.community.cache.TagCache;
import life.echo.community.dto.QuestionDTO;
import life.echo.community.model.Question;
import life.echo.community.model.User;
import life.echo.community.service.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangzewen on 2019/12/27
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish")
    public String publish(Model model) {
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Long id,
                       Model model) {
        QuestionDTO quesstion = questionService.getById(id);
        model.addAttribute("title", quesstion.getTitle());
        model.addAttribute("description", quesstion.getDescription());
        model.addAttribute("tag", quesstion.getTag());
        model.addAttribute("id", quesstion.getId());
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "id", required = false) Long id,
            HttpServletRequest request,
            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", TagCache.get());

        if (title == null || title == "") {
            model.addAttribute("error", "title can not null ..");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "description can not null ..");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "tag can not null");
            return "publish";
        }

        String invalid = TagCache.filterInvalid(tag);
        if (StringUtils.isNotBlank(invalid)) {
            model.addAttribute("error", "输入非法标签：" + invalid);
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
        }

        Question quesstion = new Question();
        quesstion.setTitle(title);
        quesstion.setDescription(description);
        quesstion.setTag(tag);
        quesstion.setCreator(user.getId());

        quesstion.setId(id);
        questionService.createOrUpdate(quesstion);
        return "redirect:/";
    }
}
