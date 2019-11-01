package com.yuer.auth.toekn.authtoekn.auth;

import com.yuer.auth.toekn.authtoekn.model.User;
import com.yuer.auth.toekn.authtoekn.utils.ServerResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：31/10/2019</br> 修改备注：</br>
 * @author lihang
 * @date 2017/12/16.
 * @description 使用aop实现登陆/鉴权
 *
 *
 */
@Aspect
@Component
public class AuthHandle {

    private static final String NEED_LOGIN = "请先登录";
    private static final String TEACHER_AND_ADMIN = "只有教师或管理员有权操作！";
    private static final String NEED_ADMIN = "只有管理员有权操作！";

    @Pointcut(value = "execution(public * team.njupt.iFit.controller..*.*(..))")
    public void start(){
    }

    @Around("start()")
    public ServerResponse access(ProceedingJoinPoint joinPoint){
        System.out.println("============================================");
        User user = getUser();
        MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        //获得请求的方法
        Method method = joinPointObject.getMethod();
        //判断是否需要登陆（含有Login注解）
        if (hasAnnotationOnMethod(method,Login.class)){
            if (user == null){
                //用户未登录
//                return ServerResponse.createByErrorMessage(NEED_LOGIN);
                return ServerResponse.createByErrorMessage(NEED_LOGIN);
            }
        }
        //判断是否需要教师权限（含有Teacher注解）
//        if (hasAnnotationOnMethod(method,TTeacher.class)){
//            //只有教师和管理员可以操作
//            if (!(user.getRole() == UserRoleConstant.TTEACHER||user.getRole() == UserRoleConstant.ADMIN)){
//                return ServerResponse.createByErrorMessage(TEACHER_AND_ADMIN);
//            }
//        }
//        //判断是否需要管理员权限（含有Admin注解）
//        if (hasAnnotationOnMethod(method, KafkaProperties.Admin.class)){
//            //只有管理员能操作
//            if (user.getRole() != UserRoleConstant.ADMIN){
//                return ServerResponse.createByErrorMessage(NEED_ADMIN);
//            }
//        }
        ServerResponse obj = null;
        try {
            obj = (ServerResponse) joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

    /**
     * 从session中获取当前用户
     * @return
     */
    private User getUser(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }

    /**
     * 判断某方法上是否含有某注解
     * @param method
     * @param annotationClazz
     * @return
     */
    private boolean hasAnnotationOnMethod(Method method, Class annotationClazz){
        //使用反射获取注解信息
        Annotation a = method.getAnnotation(annotationClazz);
        if (a == null){
            return false;
        }
        return true;
    }
}