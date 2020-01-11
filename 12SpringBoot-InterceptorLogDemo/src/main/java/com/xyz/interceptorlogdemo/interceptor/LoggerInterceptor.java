package com.xyz.interceptorlogdemo.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xyz.interceptorlogdemo.entity.LoggerEntity;
import com.xyz.interceptorlogdemo.jpa.LoggerJPA;
import com.xyz.interceptorlogdemo.util.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor implements HandlerInterceptor {

    private static final String LOGGER_SEND_TIME = "_send_time";
    private static final String LOGGER_ENTITY = "_logger_entity";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        LoggerEntity logger= new LoggerEntity();
        String sessionId = request.getRequestedSessionId();
        String url = request.getRequestURI();
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue
                );
        logger.setClientIp(LoggerUtils.getCliectIp(request));
        logger.setMethod(request.getMethod());
        logger.setType(LoggerUtils.getRequestType(request));
        logger.setParamData(paramData);
        logger.setUri(url);
        logger.setSessionId(sessionId);
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY,logger);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                    @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        //获取请求错误码
        int status = response.getStatus();
        //当前时间
        long currentTime = System.currentTimeMillis();
        //请求开始时间
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        //获取本次请求日志实体
        LoggerEntity loggerEntity = (LoggerEntity) request.getAttribute(LOGGER_ENTITY);
        //设置请求时间差
        loggerEntity.setTimeConsuming(Integer.valueOf((currentTime - time)+""));
        //设置返回时间
        loggerEntity.setReturnTime(currentTime + "");
        //设置返回错误码
        loggerEntity.setHttpStatusCode(status+"");
        //设置返回值
        loggerEntity.setReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //执行将日志写入数据库
        LoggerJPA loggerDAO = getDAO(LoggerJPA.class,request);
        loggerDAO.save(loggerEntity);
    }

    private <T> T getDAO(Class<T> clazz,HttpServletRequest request)
    {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }

}
