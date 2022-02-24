package com.smartrm.smartrmpayment.payment.domain.share;


import com.smartrm.infracore.event.DomainEvent;
import java.math.BigDecimal;

/**
 * @author: liuyuancheng
 * @description:订单取消事件
 */
public class OrderCanceledEvent extends DomainEvent {

  private long machineId;
  private long orderId;
  private OrderType type;
  private BigDecimal totalAmount;

  public OrderCanceledEvent() {
    super("OrderCanceledEvent");
  }


  public long getOrderId() {
    return orderId;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public OrderType getType() {
    return type;
  }

  public long getMachineId() {
    return machineId;
  }

  @Override
  public String key() {
    return Long.toString(machineId);
  }

  public void setMachineId(long machineId) {
    this.machineId = machineId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public void setType(OrderType type) {
    this.type = type;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }
}
