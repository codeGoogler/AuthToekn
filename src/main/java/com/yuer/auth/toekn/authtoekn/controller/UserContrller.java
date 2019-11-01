package com.yuer.auth.toekn.authtoekn.controller;

import com.yuer.auth.toekn.authtoekn.auth.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 类功能描述：</br>
 *
 * https://blog.csdn.net/starlh35/article/details/78846980
 * https://www.cnblogs.com/Tiancheng-Duan/p/11363437.html
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：31/10/2019</br> 修改备注：</br>
 */
@Controller
@RequestMapping("/UserContrller")
public class UserContrller {



    @ResponseBody
    @GetMapping("/questUserInfo")
    @Login
    public String questUserInfo(HttpSession session){
        session.setAttribute("user",null);
        return "str";
    }

}
