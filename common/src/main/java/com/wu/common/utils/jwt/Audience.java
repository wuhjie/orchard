package com.wu.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Audience
 * @Description
 * @Author wuhjie
 * @Data 2020/10/15 1:45 pm
 * @Version 1.0
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {

    private String clientId;

    private String base64Secret;

    private String name;

    private Integer expireSecond;
}
