package com.wu.core;

import com.wu.common.entity.CustomerAccount;

import java.awt.dnd.MouseDragGestureRecognizer;

/**
 * @ClassName RequestContextHolder
 * @Description
 * @Author wuhjie
 * @Data 2020/10/16 2:13 pm
 * @Version 1.0
 **/
public class RequestContextHolder {

    public static final ThreadLocal<CustomerAccount> currentUser = new ThreadLocal<>();

    public static CustomerAccount getCurrentCustomer() {

        return currentUser.get();
    }

    public static void setCurrentCustomer(CustomerAccount currentCustomer) {
        currentUser.set(currentCustomer);
    }

    public static void removeCurrentUser() {
        currentUser.remove();
    }
}
