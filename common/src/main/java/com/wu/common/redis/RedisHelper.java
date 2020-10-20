package com.wu.common.redis;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName RedisHelper
 * @Description
 * @Author wuhjie
 * @Data 2020/10/19 2:00 pm
 * @Version 1.0
 **/
@Slf4j
public class RedisHelper {

    private static final Map<String, String> pool = new HashMap<>();

    private static final Map<String, Long> poolTime = new HashMap<>();

    private static final ReentrantLock reentrantLock = new ReentrantLock(false);

    public static List<String> seeAll() {

        List<String> resultList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<String, String>> entrySet = pool.entrySet();

        for (Map.Entry<String, String> entry : entrySet) {
            stringBuilder.append(entry.getKey()).append(":").append(entry.getValue());
            stringBuilder.append("\r\n");
            stringBuilder.append(poolTime.get(entry.getKey()));
            resultList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return resultList;
    }

    public static String get(String key, boolean flag) {

        String data = pool.get(key);
        try {
            if(flag) {
                pool.remove(key);
                poolTime.remove(key);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void set(String key, String value) throws Exception {
        try {
            pool.put(key, value);
            Long timeLong = System.currentTimeMillis();
            poolTime.put(key, timeLong);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearRedis(long time) {
        long condition = time * 1000 * 60;
        log.info("clearCache---->clearTime:" + time + "minuetes");
        long current = System.currentTimeMillis();
        Set<Map.Entry<String, String>> entrySet = pool.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            try {
                String poolKey = entry.getKey();
                long data = poolTime.get(poolKey);
                if ((current - data) > condition) {
                    String valye = pool.remove(poolKey);
                    Long currentTimeMillis = poolTime.remove(poolKey);
                    log.info("clearCache---->" + poolKey + "exceeds" + time + "removed");
                }
            }catch (Exception e) {
                e.printStackTrace();
                log.info("clearCache---->" + e.getMessage());
            }
        }

    }

    public static void set(String key, String value, Integer clearTime) throws Exception {
        set(key, value);
        if (clearTime != null) {
            clearRedis(clearTime);
        }
    }

    public static void remove (String key) throws Exception {
        log.info("remove----->remove key");
        try {
            String value = pool.remove(key);
            Long currentTimeMillis = poolTime.remove(key);
            log.info("remove----->successes" + value);
            log.info("remove----->successes" + currentTimeMillis);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("remove----->failed" + e.getMessage());
        }
    }

}
