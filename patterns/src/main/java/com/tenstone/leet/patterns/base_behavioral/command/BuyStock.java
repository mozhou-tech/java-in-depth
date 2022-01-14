package com.tenstone.leet.patterns.base_behavioral.command;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class BuyStock implements Order {

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    private Stock stock;

    @Override
    public void execute() {
        stock.buy();
    }
}
