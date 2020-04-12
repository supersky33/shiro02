package com.pc.resolver;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println(e.getClass());
        //e.printStackTrace();
        ModelAndView mv = new ModelAndView();
        if (e instanceof IncorrectCredentialsException || e instanceof UnknownAccountException) {
            mv.setViewName("redirect:/user/login");
        }
        return mv;
    }
}
