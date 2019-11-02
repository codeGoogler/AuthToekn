package com.yuer.auth.toekn.authtoekn;

import com.yuer.auth.toekn.authtoekn.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class AuthtoeknApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    TokenService tokenService;

//    @Test
//    public void ss(){
//        RedisTemplate<String,Object> redis = new RedisTemplate<String,Object>();
//
//        HashOperations<String, String, String> hashOps = redis.opsForHash();
//        hashOps.put("k1","k2", "value");
//        String value2 = hashOps.get("k1", "k2");
//        System.out.println(value2);
//    }
        @Test
        public void ss(){

//            tokenService.generatorToken("1231242","13011007869");
            String value2  = tokenService.generatorToken2("1231242","13011007869");
            System.out.println(value2);

    }
}
