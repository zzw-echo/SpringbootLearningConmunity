package life.echo.community.mapper;

import life.echo.community.model.Comment;

public interface CommentExtMapper {
   int incCommentCount(Comment comment);
}