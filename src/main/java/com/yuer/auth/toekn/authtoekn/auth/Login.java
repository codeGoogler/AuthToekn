package com.yuer.auth.toekn.authtoekn.auth;

import java.lang.annotation.*;

/**
 * 类功能描述：</br>
 *
 * @author lihang
 * @date 2017/12/16.
 * @description 用于判断是否需要登陆（有该注解则需要登陆，因此登陆请求不能加该注解，否则就“死循环”了）
 */
// 本注解只能用在方法上
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}

