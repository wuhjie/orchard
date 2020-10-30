package com.wu.web.controller;

import com.wu.common.domain.MainOrder;
import com.wu.common.domain.company.Good;
import com.wu.web.dao.MainOrderDao;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName MainOrderController
 * @Description
 * @Author wuhjie
 * @Data 2020/10/28 3:18 pm
 * @Version 1.0
 **/

@RestController
public class MainOrderController {

    MainOrderDao mainOrderDao;

    @Autowired
    public void setMainOrderDao(MainOrderDao mainOrderDao) {
        this.mainOrderDao = mainOrderDao;
    }

    @RequestMapping("/mainOrder/add")
    public String addOrder(MainOrder mainOrder) {
        mainOrderDao.addOrder(mainOrder);
        return "redirect:/mainOrder";
    }

    @GetMapping("mainOrder/queryById/{orderId}")
    public String queryByOrderId(@PathVariable("orderId")Model model, String orderId) {
        MainOrder mainOrder = mainOrderDao.queryByOrderId(orderId);
        if (mainOrder == null) {
            return "404";
        }
        model.addAttribute("orderWithCustomerId", mainOrder);
        //todo
        return "mainOrder/list";
    }

    @GetMapping("mainOrder/queryByCustomerId/{customerId}")
    public String queryAll(@PathVariable("customerId") Model model, String customerId) {
        Collection<MainOrder> mainOrderCollection = mainOrderDao.quertAll(customerId);
        //todo
        model.addAttribute("orderWithCustomerId", mainOrderCollection);
        return "mainOrder/list";
    }

//    //todo
//    public String statusChanged(@PathVariable("orderId") Model model, String orderId, MainOrder.subOrder.OrderStatus changedStatus) {
//        MainOrder newOrder = mainOrderDao.statusChanged(orderId, changedStatus);
//        model.addAttribute("orderStatusChanged", newOrder);
//        return "redirect:/mainOrder/list";
//    }

    /**
     * todo stay in current page or go to the shopping cart page
     */
//    @GetMapping("/shoppingCart")
    public String inShoppingCart(Model model, Good good) {
        MainOrder mainOrder = mainOrderDao.inShoppingCart(good);
        model.addAttribute("addToShoppingCart", mainOrder);
        return "shoppingCart";
    }

    @GetMapping("mainOrder/purchasing")
    public String purchaseAndOrderIntoMainOrder(Model model, List<MainOrder> mainOrders) {
        //todo
        Collection<MainOrder> mainOrderCollection = mainOrderDao.purchase(mainOrders);
        mainOrderDao.subOrderIntoMainOrder(mainOrders);
        model.addAttribute("purchase", mainOrderCollection);
        return "purchasing";
    }

    //todo
    public String orderPending(Model model, MainOrder subOrder) {
        MainOrder newOrder = mainOrderDao.orderPending(subOrder.getMainOrderId());
        return "redirect:/orders";
    }

    public String orderReceived(Model model, MainOrder subOrder) {
        MainOrder newOrder = mainOrderDao.orderReceived(subOrder.getMainOrderId());
        model.addAttribute("orderReceived", newOrder);
        return "redirect:/mainOrder/list";
    }

    public String expressReceived(Model model, MainOrder subOrder) {
        MainOrder newOrder = mainOrderDao.expressReceived(subOrder.getMainOrderId());
        model.addAttribute("expressedReceived", newOrder);
        return "redirect:/list";
    }

    public String orderFinished(Model model, MainOrder subOrder) {
        MainOrder newOrder = mainOrderDao.orderFinished(subOrder.getMainOrderId());
        model.addAttribute("orderFinished", newOrder);
        return "redirect:/mainOrder";
    }

    public String orderCancelled(Model model, MainOrder subOrder) {
        MainOrder newOrder = mainOrderDao.orderCancelled(subOrder.getMainOrderId());
        model.addAttribute("orderCancelled", newOrder);
        return "redirect:/cancelled";
    }







}
