package com.yuer.auth.toekn.authtoekn.controller;

import com.yuer.auth.toekn.authtoekn.auth.Login;
import com.yuer.auth.toekn.authtoekn.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtils redisUtils;

    @ResponseBody
    @GetMapping("/questUserInfo")
    @Login
    public String questUserInfo(HttpSession session) {
        session.setAttribute("user", null);
        new RedisUtils().set("user", "user");
        String value = "hello,123";
        boolean result = redisUtils.set("key1",value);
//        RedisTemplate<String,Object> redis = new RedisTemplate<String,Object>();

        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        hashOps.put("k1","k2", "value");
        String value2 = hashOps.get("k1", "k2");


        System.out.println(value2);


        if(result){
            String rl = (String) redisUtils.get("key1");
            return "redis缓存 success : " +rl;
        }
        return "redis缓存 faild  ~~";
    }

}
