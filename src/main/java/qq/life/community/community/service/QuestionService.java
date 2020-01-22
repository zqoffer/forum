package qq.life.community.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qq.life.community.community.dto.PaginationDto;
import qq.life.community.community.dto.QuestionDto;
import qq.life.community.community.mapper.QuestionMapper;
import qq.life.community.community.mapper.UserMapper;
import qq.life.community.community.model.Question;
import qq.life.community.community.model.User;
import qq.life.community.community.myEception.CustomizeException;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;
    public PaginationDto list(Integer currentPage, Integer size) {
        Integer offset = size * (currentPage -1);

        List<Question> questionList = questionMapper.list(offset,size);
        List<QuestionDto> questionDtos=new ArrayList<>();

        PaginationDto paginationDto = new PaginationDto();
        for(Question question:questionList){
            User user = userMapper.findById(question.getId());
            QuestionDto questionDto = new QuestionDto();
            //吧两个对象中属性名相同的属性进行复制
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        paginationDto.setQuestions(questionDtos);

        Integer totalCount = questionMapper.count();


        paginationDto.setPagination(totalCount,currentPage,size);
        return paginationDto;
    }

    public PaginationDto list(Integer userId, Integer currentPage, Integer size) {
        Integer offset = size * (currentPage -1);

        List<Question> questionList = questionMapper.listByUser(userId,offset,size);
        List<QuestionDto> questionDtos=new ArrayList<>();

        PaginationDto paginationDto = new PaginationDto();
        for(Question question:questionList){
            User user = userMapper.findById(question.getId());
            QuestionDto questionDto = new QuestionDto();
            //吧两个对象中属性名相同的属性进行复制
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        paginationDto.setQuestions(questionDtos);

        Integer totalCount = questionMapper.countById(userId);


        paginationDto.setPagination(totalCount,currentPage,size);
        return paginationDto;
    }

    public QuestionDto getById(Integer id) {

        Question question = questionMapper.getById(id);
        if(question == null){
            throw new CustomizeException("该问题不存在");
        }
        QuestionDto questionDto = new QuestionDto();
        //吧两个对象中属性名相同的属性进行复制
        BeanUtils.copyProperties(question,questionDto);
        User user = userMapper.findById(question.getId());
        questionDto.setUser(user);
        return questionDto;
    }

    public void createOrUpdate(Question question) {
        if(question.getId() == null){
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.create(question);
        }else{
            question.setGmtModified(question.getGmtCreate());
            questionMapper.update(question);
        }
    }

    public void incView(Integer id) {
        Question question = questionMapper.getById(id);
        Integer viewCount = question.getViewCount() + 1;
        questionMapper.updateViewCount(id,viewCount);
    }
}
