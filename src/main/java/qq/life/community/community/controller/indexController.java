package qq.life.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qq.life.community.community.dto.PaginationDto;
import qq.life.community.community.dto.QuestionDto;
import qq.life.community.community.mapper.QuestionMapper;
import qq.life.community.community.mapper.UserMapper;
import qq.life.community.community.model.Question;
import qq.life.community.community.model.User;
import qq.life.community.community.service.QuestionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class indexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
@GetMapping("/")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size){
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user =  userMapper.findByToken(token);
                request.getSession().setAttribute("user",user);
                break;
            }
        }
    }

    PaginationDto pagination = questionService.list(page,size);
    model.addAttribute("pagination",pagination);


    return "index";
}
}
