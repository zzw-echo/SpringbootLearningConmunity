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


        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = quesstionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) {
            page = 1;
        }

        if (page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        //size * (page - 1)
        Integer offset = size * (page - 1);

        List<Quesstion> quesstions = quesstionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Quesstion quesstion : quesstions) {
            User user = userMapper.findById(quesstion.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(quesstion, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);



        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {


        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = quesstionMapper.countByUserId(userId);
        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) {
            page = 1;
        }

        if (page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        //size * (page - 1)
        Integer offset = size * (page - 1);

        List<Quesstion> quesstions = quesstionMapper.listByUserId(userId, offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Quesstion quesstion : quesstions) {
            User user = userMapper.findById(quesstion.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(quesstion, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);



        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Quesstion quesstion = quesstionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(quesstion, questionDTO);
        return questionDTO;
    }
}
