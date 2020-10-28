package com.wu.common.utils;

import java.util.UUID;

/**
 * @ClassName Uuid
 * @Description
 * @Author wuhjie
 * @Data 2020/10/28 2:25 pm
 * @Version 1.0
 **/
public class Uuid  {

    public static String getUUID32(){

        return UUID.randomUUID().toString().replace("-", "").toLowerCase();

    }
}
