package qq.life.community.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qq.life.community.community.enums.CommentTypeEnum;
import qq.life.community.community.mapper.CommentMapper;
import qq.life.community.community.mapper.QuestionMapper;
import qq.life.community.community.model.Comment;
import qq.life.community.community.model.Question;
import qq.life.community.community.myEception.CustomizeErrorCode;
import qq.life.community.community.myEception.CustomizeException;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    QuestionMapper questionMapper;

    public void insert(Comment comment) {
        if(comment.getParentId()==null ||comment.getParentId()==0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if(comment.getType()==null || CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }

        if(comment.getType() == CommentTypeEnum.COMMENT.getType()){
            commentMapper.getById(comment.getParentId());
            if(comment == null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        }else{
            questionMapper.getById(comment.getParentId());
            if(comment == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);

        }
    }


    public void incComment(Integer id) {
        Question question = questionMapper.getById(id);
        Integer commentCount = question.getCommentCount() + 1;
        questionMapper.updateViewCount(id,commentCount);
    }
}
