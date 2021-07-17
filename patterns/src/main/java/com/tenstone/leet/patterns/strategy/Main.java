package com.tenstone.leet.patterns.strategy;

/**
 * Created by liuyuancheng on 2021/7/17  <br/>
 */
public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Taro", new WinningStrategy(1));
        Player player2 = new Player("Hana", new ProbStrategy(2));

        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongThan(nextHand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            }else if(nextHand2.isStrongThan(nextHand1)){
                System.out.println("Winner: "+player2);
                player1.lose();
                player2.win();
            }else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result:");
        System.out.println(player1);
        System.out.println(player2);
    }

}
