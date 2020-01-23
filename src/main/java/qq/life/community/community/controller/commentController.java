package qq.life.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import qq.life.community.community.dto.CommentDto;
import qq.life.community.community.mapper.CommentMapper;
import qq.life.community.community.model.Comment;


/**
 * JASON:前端后端交互的语言类型，通过post从前端接受JASON数据传入，反序列化为对象，
 * 后端将对象以Object类型返回给前端，spring解析成JASON对象
 */
@Controller
public class commentController {
    @Autowired
    private CommentMapper commentMapper;
    @RequestMapping(name = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDto commentDto){
        Comment comment = new Comment();
        comment.setParentId(commentDto.getParentId());
        comment.setContent(commentDto.getContent());
        comment.setType(commentDto.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentor(1);
        commentMapper.insert(comment);
        return null;
    }
}
