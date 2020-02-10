package life.echo.community.service;

import life.echo.community.dto.PaginationDTO;
import life.echo.community.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangzewen on 2020/2/10
 */
@Service
public class NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    public PaginationDTO list(Long id, Integer page, Integer size) {
        return null;
    }
}
