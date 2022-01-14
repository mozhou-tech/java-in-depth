package com.tenstone.leet.patterns.base_behavioral.command;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 * 命令模式（Command Pattern）是一种数据驱动的设计模式，它属于行为型模式。 请求以命令的形式包裹在对象中，并传给调用对象。
 * 调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。
 *
 * 优点： 1、降低了系统耦合度。 2、新的命令可以很容易添加到系统中去。
 * 缺点：使用命令模式可能会导致某些系统有过多的具体命令类。
 * 使用场景：认为是命令的地方都可以使用命令模式，比如： 1、GUI 中每一个按钮都是一条命令。 2、模拟 CMD。
 * 注意事项：系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作，也可以考虑使用命令模式，见命令模式的扩展。
 * @author liuyuancheng
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        Stock stock = new Stock();
        // 将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。
        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);
        Broker broker = new Broker();
        // 对象作为参数传入（先放在内存，再统一执行）
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.placeOrders();
    }

}
