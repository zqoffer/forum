package qq.life.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qq.life.community.community.dto.CommentDto;
import qq.life.community.community.dto.ResultDto;
import qq.life.community.community.enums.CommentTypeEnum;
import qq.life.community.community.mapper.CommentMapper;
import qq.life.community.community.model.Comment;
import qq.life.community.community.model.User;
import qq.life.community.community.myEception.CustomizeErrorCode;
import qq.life.community.community.myEception.CustomizeException;
import qq.life.community.community.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * JASON:前端后端交互的语言类型，通过post从前端接受JASON数据传入，反序列化为对象，
 * 后端将对象以Object类型返回给前端，spring解析成JASON对象
 */
@Controller
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentService commentService;
    @ResponseBody
    //@RequestMapping(name = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDto commentDto, HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        if(user == null){
            return ResultDto.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        Comment comment = new Comment();
        comment.setParentId(commentDto.getParentId());
        comment.setContent(commentDto.getContent());
        comment.setType(commentDto.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentor(user.getId());
        commentService.insert(comment);
        if(comment.getType() == CommentTypeEnum.QUESTION.getType()){
            commentService.incComment(comment.getParentId());
        }
//        //通过ResponseBody可以将其序列化为json，返回到前端
//        Map<Object,Object> map = new HashMap<Object,Object>();
//        map.put("message","成功");
        return ResultDto.okOf();
    }
}
