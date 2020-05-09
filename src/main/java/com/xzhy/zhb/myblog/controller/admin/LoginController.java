package com.xzhy.zhb.myblog.controller.admin;

import com.xzhy.zhb.myblog.pojo.User;
import com.xzhy.zhb.myblog.service.UserService;
import com.xzhy.zhb.myblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @ClassNameLoginController
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/1 11:27
 * @Version V1.0
 **/
@Controller
@RequestMapping("/admin")
public class LoginController
{
    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage(){return "admin/login";}

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes){
        User user = userService.checkUser(username, MD5Utils.code(password));
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",username);
            return "admin/index";
        }
        else {
            attributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/admin";
        }
    }
}
