package com.tenstone.leet.patterns.action.memento;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * 收集水果和获取金钱数的投掷骰子游戏
 * 1. 游戏会自动进行
 * 2. 游戏的主人公通过掷骰子来决定下一个状态
 * 3. 当骰子点数为1的时候，主人公的金钱会增加
 * 4. 当骰子点数为2的时候，主人公的金钱会减少
 * 5. 当骰子点数为6的时候，主人公会得到水果
 * 6. 主人公没钱时游戏结束
 *
 * @author liuyuancheng
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        // 初始化游戏者金钱
        Gamer gamer = new Gamer(100);
        // 保存初始状态
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            log.info("=========== {}", i);
            log.info("当前状态：{}", gamer);
            gamer.bet();
            log.info("所持金钱为{}元", gamer.getMoney());
            if (gamer.getMoney() > memento.getMoney()) {
                log.info("所持金钱增加了许多，保存当前游戏状态");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                log.info("所持金钱减少了许多，将游戏恢复至以前状态");
                gamer.restoreMemento(memento);
            }
            // 等待一段时间
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
            System.out.println();
        }
    }

}
