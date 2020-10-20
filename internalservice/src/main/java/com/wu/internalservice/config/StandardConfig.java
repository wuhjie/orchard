package com.wu.internalservice.config;

import com.wu.common.exception.ExceptionEnum;
import com.wu.internalservice.common.StandardResponse;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName StandardConfig
 * @Description
 * @Author wuhjie
 * @Data 2020/10/15 3:48 pm
 * @Version 1.0
 **/

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Slf4j
@EnableCircuitBreaker
@Configuration
public class StandardConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> msgConverters;

    @Bean
    public Decoder decoder() {
        return new SpringDecoder(msgConverters) {

            @Override
            public Object decode(Response response, Type type) throws IOException, FeignException {

                Type processedTyped = type;

                Object object = null;

                if (type instanceof Class ||
                        ((type instanceof ParameterizedType) &&
                        !((Class) ((ParameterizedType) type).getRawType()).isAssignableFrom(StandardResponse.class))) {
                    processedTyped = ParameterizedTypeImpl.make(StandardResponse.class, new Type[]{type}, null);
                }

                object = super.decode(response, processedTyped);

                if (!(object instanceof StandardResponse)) {
                    return object;
                }

                try {
                    StandardResponse result = (StandardResponse) object;

                    if (!result.isOK()) {
                        log.error("failed to implement 3rd party interface, httpStatus:{}, url:{}, code:{}, msg:{}",
                                response.status(), response.request().url(), result.getCode(), result.getMsg());
                        throw com.wu.common.exception.ServiceException.build(ExceptionEnum.DEFAULT_EXCEPTION);
                    }
                    return result.getData();
                } catch (ServiceException e){
                    throw e;
                } catch (Exception e) {
                    log.error("failed to implement 3rd party interface, msg:{}", e.getMessage());
                    e.printStackTrace();
                    throw com.wu.common.exception.ServiceException.build(ExceptionEnum.DEFAULT_EXCEPTION, e);
                }
            }
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {

        return new ErrorDecoder.Default() {

            @Override
            public Exception decode(String methodKey, Response response) {

                if(response.status() == 500) {
                    return com.wu.common.exception.ServiceException.build(ExceptionEnum.RPC_EXCEPTION);
                }

                return super.decode(methodKey, response);
            }
        };
    }
}
