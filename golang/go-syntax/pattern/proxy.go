package main

import (
	"fmt"
)

/*
意图:
代理模式为另一个对象提供一个替身或者占位符以控制对这个对象的访问

关键代码:
代理类和被代理类实现同一接口，代理类中持有被代理类对象

应用实例:

火车票的代理售票点。代售点就是代理，它拥有被代理对象的部分功能 — 售票功能
明星的经纪人，经纪人就是代理，负责为明星处理一些事务。
*/

type Station struct {
	stock int
}

// 接收器为struct增加方法
func (s *Station) sell(name string) {
	if s.stock > 0 {
		s.stock--
		fmt.Printf("卖了一张票给%s，目前剩余%d张！！\n", name, s.stock)
	} else {
		fmt.Print("库存不足\n")
	}
}

type StationProxy struct {
	station *Station
}

func (proxy *StationProxy) sell(name string) {
	fmt.Print("[proxy]")
	proxy.station.sell(name)
}
