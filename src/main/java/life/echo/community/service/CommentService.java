package life.echo.community.service;

import life.echo.community.enums.CommentTypeEnum;
import life.echo.community.exception.CustomizeErrorCode;
import life.echo.community.exception.CustomizeException;
import life.echo.community.mapper.CommentMapper;
import life.echo.community.mapper.QuestionMapper;
import life.echo.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangzewen on 2020/2/1
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_NOT_FOUND);
        }

        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }

        if (comment.getType() == CommentTypeEnum.COMMENT.getType()){
            //回复评论
        } else {
            //回复问题
        }
    }
}
