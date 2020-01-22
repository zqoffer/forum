package qq.life.community.community.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import qq.life.community.community.myEception.CustomizeException;

import javax.servlet.http.HttpServletRequest;



@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Throwable  e, HttpServletRequest request, Model model){
        if(e instanceof CustomizeException ) {
            model.addAttribute("msg", e.getMessage());
        }else {
        model.addAttribute("msg","访问失败");
    }


            return new ModelAndView("error");
    }


}
