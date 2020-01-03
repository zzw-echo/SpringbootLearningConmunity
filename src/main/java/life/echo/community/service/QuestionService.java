package life.echo.community.service;

import life.echo.community.dto.QuestionDTO;
import life.echo.community.mapper.QuesstionMapper;
import life.echo.community.mapper.UserMapper;
import life.echo.community.model.Quesstion;
import life.echo.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzewen on 2019/12/30
 */
@Service
public class QuestionService {

    @Autowired
    private QuesstionMapper quesstionMapper;

    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Quesstion> quesstions = quesstionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Quesstion quesstion : quesstions) {
            User user = userMapper.findById(quesstion.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(quesstion, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        return questionDTOList;
    }
}
