package qq.life.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qq.life.community.community.dto.QuestionDto;
import qq.life.community.community.mapper.QuestionMapper;
import qq.life.community.community.mapper.UserMapper;
import qq.life.community.community.model.Question;
import qq.life.community.community.model.User;
import qq.life.community.community.service.QuestionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {


    @Autowired
    private QuestionService questionService;
    @GetMapping("/publish/{id}")
    public  String edit(@PathVariable ("id") Integer id,Model model){
        QuestionDto question = questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id",question.getId());
        return "publish";
    }
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    //@RequestParam接受输入的参数
    public String doPublish(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("tag") String tag,
                            @RequestParam("id") Integer id,
                            HttpServletRequest request,Model model){
        //再输入信息后保存到request域（可以从页面获取值），防止因为都登陆报错后填写的值消失
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        //填写信息不能为空
        if(title == null || title.equals("")){
            model.addAttribute("error","标题不能为空");
        }
        if(description == null || description.equals("")){
            model.addAttribute("error","内容描述不能为空");
        }
        if(tag == null || tag.equals("")){
            model.addAttribute("error","标签不能为空");
        }

        //获取user对象信息
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        //从html文件中获取这些参数值封装到question中
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());

        question.setId(id);
        //数据注入数据库
        questionService.createOrUpdate(question);


        return "redirect:/";
    }
}
