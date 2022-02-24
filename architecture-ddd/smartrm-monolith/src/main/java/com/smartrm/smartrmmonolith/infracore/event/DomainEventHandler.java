package com.smartrm.smartrmmonolith.infracore.event;

import org.springframework.context.ApplicationListener;

/**
 * @author: liuyuancheng
 * @description: 事件处理器接口
 */
public interface DomainEventHandler<T extends DomainEvent> extends ApplicationListener<T> {

}
