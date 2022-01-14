package com.tenstone.leet.patterns.behavioral.command;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 * 命令调用类
 *
 * @author liuyuancheng
 */
public class Broker {
    private List<Order> orderList = Lists.newArrayList();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
