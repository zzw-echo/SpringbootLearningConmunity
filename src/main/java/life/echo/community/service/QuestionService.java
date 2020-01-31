package life.echo.community.service;

import life.echo.community.dto.PaginationDTO;
import life.echo.community.dto.QuestionDTO;
import life.echo.community.exception.CustomizeErrorCode;
import life.echo.community.exception.CustomizeException;
import life.echo.community.mapper.QuesstionMapper;
import life.echo.community.mapper.QuestionMapper;
import life.echo.community.mapper.UserMapper;
import life.echo.community.model.Question;
import life.echo.community.model.QuestionExample;
import life.echo.community.model.User;
import org.apache.ibatis.session.RowBounds;
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

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {


        PaginationDTO paginationDTO = new PaginationDTO();

        Integer totalCount = (int)questionMapper.countByExample(new QuestionExample());
        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) {
            page = 1;
        }

        if (page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        //size * (page - 1)
        Integer offset = size * (page - 1);

        List<Question> questions = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, size));

        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question quesstion : questions) {
            User user = userMapper.selectByPrimaryKey(quesstion.getCreator());
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

//        Integer totalCount = quesstionMapper.countByUserId(userId);

        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCreatorEqualTo(userId);
        Integer totalCount = (int)questionMapper.countByExample(questionExample);


        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) {
            page = 1;
        }

        if (page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        //size * (page - 1)
        Integer offset = size * (page - 1);

//        List<Quesstion> quesstions = quesstionMapper.listByUserId(userId, offset, size);


        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andCreatorEqualTo(userId);

        List<Question> questions = questionMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));

        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question quesstion : questions) {
            User user = userMapper.selectByPrimaryKey(quesstion.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(quesstion, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question quesstion = questionMapper.selectByPrimaryKey(id);
        if (quesstion == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(quesstion, questionDTO);
        User user = userMapper.selectByPrimaryKey(quesstion.getCreator());
        questionDTO.setUser(user);

        return questionDTO;
    }

    public void createOrUpdate(Question quesstion) {
        if (quesstion.getId() == null){
            //创建
            quesstion.setGmtCreate(System.currentTimeMillis());
            quesstion.setGmtModified(quesstion.getGmtCreate());
            questionMapper.insert(quesstion);
        }else{
            //更新
//            quesstion.setGmtModified(quesstion.getGmtCreate());

            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTitle(quesstion.getTitle());
            updateQuestion.setDescription(quesstion.getDescription());
            updateQuestion.setTag(quesstion.getTag());

            QuestionExample example = new QuestionExample();
            example.createCriteria()
                    .andIdEqualTo(quesstion.getId());

            int update = questionMapper.updateByExampleSelective(updateQuestion, example);
            if (update != 1){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
//            quesstionMapper.update(quesstion);

        }
    }

    public void incView(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        Question updateQuestion = new Question();
        updateQuestion.setViewCount(question.getViewCount() + 1);
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andIdEqualTo(id);
        questionMapper.updateByExampleSelective(updateQuestion, questionExample);
    }

}
