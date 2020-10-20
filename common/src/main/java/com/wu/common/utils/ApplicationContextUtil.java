package com.wu.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @ClassName ApplicationContextUtil
 * @Description
 * @Author wuhjie
 * @Data 2020/10/16 10:26 am
 * @Version 1.0
 **/
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * send to thread
     * @param beanName
     * @param <T>
     * @return
     */
    public static<T> T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }

    /**
     * international use
     * @param key
     * @return
     */
    public static String getMessage(String key) {
        return context.getMessage(key, null, Locale.getDefault());
    }

    /**
     * get current environment
     * @return
     */
    public static String getActiveProfile() {
        return context.getEnvironment().getActiveProfiles()[0];
    }

    public static boolean isProd() {

        String activeProfile = ApplicationContextUtil.getActiveProfile();

        return "prod".equals(activeProfile);

    }
}
