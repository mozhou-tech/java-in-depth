package com.tenstone.leet.patterns.action.memento;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class Gamer {

    private int money;

    private List<String> fruits = Lists.newArrayList();

    private final Random random = new Random();

    private final static String[] fruitsname = {
            "苹果", "葡萄", "香蕉", "橘子"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    /**
     * 掷骰子
     */
    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            log.info("所持金钱增加100");
        } else if (dice == 2) {
            money /= 2;
            log.info("所持金钱减半");
        } else if (dice == 6) {
            String f = getFruit();
            log.info("获得了水果 {}", f);
            fruits.add(f);
        }
    }

    /**
     * 拍摄快照
     *
     * @return
     */
    public Memento createMemento() {
        Memento m = new Memento(money);
        Iterator<String> it = fruits.listIterator();
        while (it.hasNext()) {
            String f = it.next();
            if (f.startsWith("好吃的")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[Money = " + money + ", fruits = " + fruits + "]";
    }

    /**
     * 获得一个水果
     *
     * @return
     */
    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}
