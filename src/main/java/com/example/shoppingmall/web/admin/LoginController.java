package com.example.shoppingmall.web.admin;

import com.example.shoppingmall.po.User;
import com.example.shoppingmall.service.admin.UserService;
import com.example.shoppingmall.utils.AjaxResult;
import com.example.shoppingmall.utils.Const;
import com.example.shoppingmall.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    //访问登陆页面
    @GetMapping
    public String loginPage(){
        return "/admin/login";
    }

    //登陆功能
    @ResponseBody
    @PostMapping(value = "/login")
    public AjaxResult login(@RequestParam String loginacct,@RequestParam String userpswd, HttpSession session){
        AjaxResult result = new AjaxResult();
        try {
            String psw = MD5Util.digest(userpswd);
            User user = userService.checkUser(loginacct, psw);
            if (user !=  null){
                session.setAttribute(Const.LOGIN_USER, user);
                result.setMessage("登陆成功");
                result.setSuccess(true);
            }else {
                result.setSuccess(false);
                result.setMessage("用户名或密码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("登陆失败");
        }
        return result;
    }

    //登出
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/admin";
    }


    //登陆后跳转
    @GetMapping("/index")
    public String index(){
        return "/index";
    }

}
