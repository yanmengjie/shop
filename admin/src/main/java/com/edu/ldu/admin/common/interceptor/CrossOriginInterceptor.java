package com.edu.ldu.admin.common.interceptor;


import com.edu.ldu.core.common.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description:
 *
 * @author 唐全成
 * @date 2018/2/9
 */
public class CrossOriginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(CrossOriginInterceptor.class);

    /**
     * 跨域拦截.
     */
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

            logger.info("intercept-url:{}", request.getRequestURI());

            response.setHeader("Access-Control-Allow-Headers", Constants.HEADERS);
            response.setHeader("Access-Control-Allow-Method", Constants.METHOD_GET);
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
            response.setHeader("Access-Control-Allow-Credentials", Constants.STRING_TRUE);
    }

}
