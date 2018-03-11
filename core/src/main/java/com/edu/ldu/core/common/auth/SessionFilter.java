package com.edu.ldu.core.common.auth;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author 唐全成
 */

public class SessionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, httpServletResponse);
    }
}
