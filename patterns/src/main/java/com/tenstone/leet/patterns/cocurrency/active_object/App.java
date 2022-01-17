package com.tenstone.leet.patterns.cocurrency.active_object;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/17  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        var app = new App();
        app.run();
    }

    private void run() {
        ActiveCreature creature;
        int creatures = 1000;
        try {
            for (int i = 0; i < creatures; i++) {
                creature = new Orc(Orc.class.getSimpleName() + i);
                creature.eat();
                creature.roam();
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        Runtime.getRuntime().exit(1);
    }

}
