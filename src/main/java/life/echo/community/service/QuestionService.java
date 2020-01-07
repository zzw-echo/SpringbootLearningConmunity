package life.echo.community.service;

import life.echo.community.dto.PaginationDTO;
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

    public PaginationDTO list(Integer page, Integer size) {
        //size * (page - 1)
        Integer offset = size * (page - 1);

        List<Quesstion> quesstions = quesstionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();
        for (Quesstion quesstion : quesstions) {
            User user = userMapper.findById(quesstion.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(quesstion, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        Integer totalCount = quesstionMapper.count();

        paginationDTO.setPagination(totalCount, page, size);

        return paginationDTO;
    }
}
