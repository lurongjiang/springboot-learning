package com.springboot.blog.interceptor;

import com.springboot.blog.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        logger.info("requestURI:{}", requestURI);
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(Constant.CURRENT_USER);
        if (attribute == null) {
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        return true;
    }
}
