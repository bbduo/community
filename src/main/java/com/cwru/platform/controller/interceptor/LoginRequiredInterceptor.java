package com.cwru.platform.controller.interceptor;

import com.cwru.platform.annotation.LoginRequired;
import com.cwru.platform.util.HostHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断拦截目标handler是不是method类型
        if (handler instanceof HandlerMethod) {
            //如果是，把他转型一下
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //直接获取到method对象
            Method method = handlerMethod.getMethod();
            // 取这个方法的注解
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
            // 错误情况：当前访问到这个路径，激活了这个注解，但用户没登陆
            if (loginRequired != null && hostHolder.getUser() == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return false;
            }
        }
        return true;
    }


}
