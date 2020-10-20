package com.wu.web.interceptor;

import com.wu.common.domain.ApiResponse;
import com.wu.common.entity.CustomerAccount;
import com.wu.common.exception.ExceptionEnum;
import com.wu.common.exception.ServiceException;
import com.wu.common.utils.ApplicationContextUtil;
import com.wu.common.utils.Audience;
import com.wu.common.utils.JwtTokenUtil;
import com.wu.common.utils.jwt.JwtIgnore;
import com.wu.core.RequestContextHolder;
import com.wu.core.repository.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.logging.Handler;

import static org.graalvm.compiler.graph.Graph.SourcePositionTracking.Ignore;

/**
 * @ClassName JwtInterceptor
 * @Description
 * @Author wuhjie
 * @Data 2020/10/16 9:49 am
 * @Version 1.0
 **/
@Component
@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    public Audience audience;

    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return super.preHandle(request, response, handler);

        response.setContentType("application/json;charset=UTF-8");

        String activeProfile = ApplicationContextUtil.getActiveProfile();

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        final String authenticationToken = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        log.info("## authHeader = {}", authenticationToken);

        if (StringUtils.isBlank(authenticationToken)) {
            log.info ("plz login first");
            ApiResponse error = ApiResponse.error(-12, "plz login first");
            String s = JSONObject.toJSONString(error);
            log.info("authentication expire return: " + s);
            response.getWriter().write(s);
            return false;
        }

        Long userId = null;

        try {
            userId = JwtTokenUtil.getUserId(authenticationToken, audience.getBase64Secret());
        }catch (Exception e) {
            ApiResponse error = ApiResponse.error(-12, "plz first");
            String s = JSONObject.toJSONString(error);
            log.info("user token expires: " + s);
            response.getWriter().write(s);
            return false;
        }

        Optional<CustomerAccount> optional = userAccountRepository.findById(userId);
        CustomerAccount customerAccount = optional.get();

        if(customerAccount == null) {
            throw ServiceException.build(ExceptionEnum.USER_DOES_NOT_EXIST, "user doesn't exist");
        }

        RequestContextHolder.setCurrentCustomer(customerAccount);

        return true;
    }




    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        RequestContextHolder.removeCurrentUser();
    }

}
