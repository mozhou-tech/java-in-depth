package com.tenstone.leet.patterns.behavioral.command;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 * 命令模式
 *
 *
 * @author liuyuancheng
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        Stock stock = new Stock();
        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.placeOrders();
    }

}
