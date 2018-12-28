package wang.sichao.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import wang.sichao.pojo.User;
import wang.sichao.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public ModelAndView registerPage(User user){
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public ModelAndView registerSubmit(@Valid User user, BindingResult bindingResult){
        if(bindingResult.getFieldError("email") != null || bindingResult.getFieldError("password") != null){
            return registerPage(user);
        }
        userService.insert(user);
        ModelAndView modelAndView = new ModelAndView("registerSuccess");
        return modelAndView;
    }


    @RequestMapping(value = "/register2.do", method = RequestMethod.GET)
    public ModelAndView registerPage2(){
        ModelAndView modelAndView = new ModelAndView("register2");
        return modelAndView;
    }

    @RequestMapping(value = "/register2.do", method = RequestMethod.POST)
    public ModelAndView registerSubmit2(String email, String password, HttpServletRequest request){
        if (email == null || !email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) {
            request.setAttribute("message", "请输入正确的电子邮箱");
            return new ModelAndView("register");
        }
        if (password == null || password.length() < 6) {
            request.setAttribute("message", "密码长度至少6位");
            return new ModelAndView("register");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        userService.insert(user);

        ModelAndView modelAndView = new ModelAndView("registerSuccess");
        return modelAndView;
    }
}
