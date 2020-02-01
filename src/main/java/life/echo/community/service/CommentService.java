package life.echo.community.service;

import life.echo.community.exception.CustomizeErrorCode;
import life.echo.community.exception.CustomizeException;
import life.echo.community.model.Comment;
import org.springframework.stereotype.Service;

/**
 * Created by zhangzewen on 2020/2/1
 */
@Service
public class CommentService {
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_NOT_FOUND);
        }
    }
}
