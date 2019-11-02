package com.yuer.auth.toekn.authtoekn;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.yuer.*"})
//@Aspect//开启切面Aop
public class AuthtoeknApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthtoeknApplication.class, args);
    }

}
//@ComponentScan(basePackages="com.zcw")
//@Component//这个必不可缺,否则aop不生效
//@Aspect//开启切面Aop
//
////不能只使用@Component,因为只使用此注解启动会报aop切面类注入容器失败(我这里是这样)，
////需加上@ComponentScan(basePackages="XXX.XXX.XXX")扫描具体包才能注入成功