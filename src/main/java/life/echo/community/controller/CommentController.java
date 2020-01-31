package life.echo.community.controller;

import life.echo.community.dto.CommentDTO;
import life.echo.community.mapper.CommentMapper;
import life.echo.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangzewen on 2020/1/31
 */
@Controller
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;


    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        commentMapper.insert(comment);
        return null;
    }
}
