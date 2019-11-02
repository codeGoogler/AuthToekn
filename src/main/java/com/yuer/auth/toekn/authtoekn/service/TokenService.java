package com.yuer.auth.toekn.authtoekn.service;



import com.yuer.auth.toekn.authtoekn.model.TokenVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

//import com.zretc.auth.arauthzretc.api.vo.TokenVo;
//import com.zretc.auth.arauthzretc.api.vo.UserInfo;
//import com.zretc.auth.arauthzretc.auth.constant.RedisKey;
//import com.zretc.auth.arauthzretc.controller.AuthProperties;
//import com.zretc.auth.arauthzretc.net.ResponseObject;
//import com.zretc.auth.arauthzretc.sdk.internal.utils.JsonUtils;

//import static com.zretc.auth.arauthzretc.auth.constant.RedisKey.NONCE_PREFIX;


@Service
public class TokenService {
    private static Logger logger = LoggerFactory.getLogger(TokenService.class);


    @Resource
    RedisTemplate<String, Object> redisTemplate;





    public TokenVo generatorToken(String userId, String phone) {
//        RedisTemplate<String, Object> redisTemplate = new  RedisTemplate<String, Object>();
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        RedisTemplate<String,Object> redis = new RedisTemplate<String,Object>();
        HashOperations<String, String, String> hashOps = redis.opsForHash();
        hashOps.put("k1","k2", "value");
        String value2 = hashOps.get("k1", "k2");
        System.out.println(value2);
        TokenVo t = new TokenVo();
        return t;
    }

    public String generatorToken2(String userId, String phone) {
        redisTemplate.opsForValue().set("1111", "2222");
        String rel = (String) redisTemplate.opsForValue().get("1111");
        if(!StringUtils.isEmpty(rel)){
            return "你好，我成功啦 ： " +rel;
        }
        return "你好，faild ~~" ;
    }
}
