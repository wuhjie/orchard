package com.wu.web.controller;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.web.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MainOrderController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/28 3:18 pm
 * @Version 1.0
 * todo reassure the status
 **/

@RestController
@Slf4j
public class MainOrderController {

    OrderDao orderDao;

    @Autowired
    public void setMainOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @RequestMapping("/mainOrder/add")
    public String addOrder(MainOrder.SubOrder mainOrder) {
        orderDao.addOrder(mainOrder);
        return "redirect:/mainOrder";
    }

    @GetMapping("mainOrder/queryById/{orderId}")
    public String queryByOrderId(@PathVariable("orderId")Model model,String orderId) {
        MainOrder.SubOrder mainOrder = orderDao.queryByOrderId(orderId);
        if (mainOrder == null) {
            return "404";
        }
        model.addAttribute("orderWithCustomerId", mainOrder);
        //todo
        return "mainOrder/list";
    }

    @GetMapping("mainOrder/queryByCustomerId/{customerId}")
    public String queryAll(@PathVariable("customerId") Model model, String customerId) {
        List<MainOrder.SubOrder> mainOrderCollection = orderDao.queryAllWithCustomerId(customerId);
        //todo
        model.addAttribute("orderWithCustomerId", mainOrderCollection);
        return "mainOrder/list";
    }

    @GetMapping("/shoppingCart")
    public String inShoppingCart(Model model, Good good) {
        MainOrder.SubOrder mainOrder = orderDao.inShoppingCart(good);
        model.addAttribute("addToShoppingCart", mainOrder);
        return "shoppingCart";
    }

    @GetMapping("/removeFromShoppingCart")
    public String removeFromShoppingCart(String subOrderId, String customerId) {
        orderDao.removeFromShoppingCart(subOrderId, customerId);
        return "redirect:/shoppingCart";
    }

//    @GetMapping("/shoppingCart")
    public void itemSelected(Model model, List<MainOrder.SubOrder> subOrders) {
        List<MainOrder.SubOrder> mainOrder = orderDao.itemSelected(subOrders);
        model.addAttribute("itemSelected", mainOrder);
    }

    @GetMapping("mainOrder/purchasing")
    public String purchaseAndOrderIntoMainOrder(Model model, List<MainOrder.SubOrder> subOrders) {
        List<MainOrder.SubOrder> newSubOrders = new ArrayList<>();
        for (MainOrder.SubOrder subOrder : subOrders) {
            newSubOrders.add(orderDao.purchase(subOrder));
        }
        MainOrder mainOrders = orderDao.subOrderIntoMainOrder(newSubOrders);
        model.addAttribute("purchasing", mainOrders);
        return "purchasing";
    }

    //todo
    public String orderPending(Model model, MainOrder.SubOrder subOrder) {
        MainOrder.SubOrder newOrder = orderDao.orderPending(subOrder.getSubOrderId());
        model.addAttribute("orderPending", newOrder);
        return "redirect:/orders";
    }

    public String orderReceived(Model model, MainOrder subOrder) {
        MainOrder.SubOrder newOrder = orderDao.orderReceived(subOrder.getMainOrderId());
        model.addAttribute("orderReceived", newOrder);
        return "redirect:/mainOrder/list";
    }

    public String expressReceived(Model model, MainOrder subOrder) {
        MainOrder.SubOrder newOrder = orderDao.expressReceived(subOrder.getMainOrderId());
        model.addAttribute("expressedReceived", newOrder);
        return "redirect:/list";
    }

    /**
    *todo ?
    *done every 1am on Sundays
     **/
    @Scheduled(cron = "0 0 1 ? * L")
    public void orderReceived() {
        try {
            List<MainOrder.SubOrder> subOrders = orderDao.queryAll();
            List<MainOrder.SubOrder> receivedOrders = subOrders.stream()
                    .filter(subOrder -> subOrder.getOrderStatus() == MainOrder.SubOrder.OrderStatus.orderReceived)
                    .collect(Collectors.toList());
            for (MainOrder.SubOrder receivedOrder : receivedOrders) {
                receivedOrder.setOrderStatus(MainOrder.SubOrder.OrderStatus.orderFinished);
            }

        } catch (Exception e) {

        }
    }

    //todo
    public String orderCancelled(Model model, MainOrder.SubOrder subOrder) {
        MainOrder.SubOrder newOrder = orderDao.orderCancelled(subOrder.getSubOrderId());
        model.addAttribute("orderCancelled", newOrder);
        return "redirect:/cancelled";
    }

    /**
     * auto check for unpaid items
     */
    @Scheduled(cron = "0 0 1 ? * L")
    public void autoCheckForUnpaidOrder() {
        try {
            List<MainOrder.SubOrder> subOrders = orderDao.queryAll();
            List<MainOrder.SubOrder> pendingOrders = subOrders.stream()
                    .filter(subOrder -> subOrder.getOrderStatus() == MainOrder.SubOrder.OrderStatus.orderPending)
                    .collect(Collectors.toList());
            for (MainOrder.SubOrder pendingOrder : pendingOrders) {
                pendingOrder.setOrderStatus(MainOrder.SubOrder.OrderStatus.orderCancelled);
            }
        } catch (Exception e) {

        }

    }

    //set the status in suborder into frozen and add it into the giftitem table
    public String giftPending(Model model, MainOrder.SubOrder subOrder) {
        MainOrder.GiftingItem giftingOrder = orderDao.giftPending(subOrder);
        //the order is frozen in this process
        subOrder.setOrderStatus(MainOrder.SubOrder.OrderStatus.orderFrozen);
        //todo add order into the present gifting list
        model.addAttribute("giftPending", giftingOrder);
        return "customer/giftingCenter";
    }

    public String giftReceiving(Model model, MainOrder.GiftingItem giftingItem) {
        // add the order into the presentGiving table
        orderDao.itemIntoPresentGiving(giftingItem);
        String senderId = giftingItem.getSenderId();
        //making giftItem as a order and add it back to the sender orders
        orderDao.removeFromShoppingCart(giftingItem.getItemId(), senderId);
        MainOrder.SubOrder addedOrder =  orderDao.addOrder(orderDao.queryByOrderId(giftingItem.getItemId()));
        model.addAttribute("giftReceiving", addedOrder);
        return "customer/giftingCenter";
    }



}
