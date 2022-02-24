package com.smartrm.infracore.event;

/**
 * @author: liuyuancheng
 * @description: 事件处理器接口
 */
public abstract class DomainEventHandler<T extends DomainEvent> {

  public abstract void onApplicationEvent(T event);

}
