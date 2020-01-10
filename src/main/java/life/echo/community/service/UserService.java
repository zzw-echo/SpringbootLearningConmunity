package life.echo.community.service;

import life.echo.community.mapper.UserMapper;
import life.echo.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangzewen on 2020/1/9
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public void createOrUpdate(User user) {

    }
}
