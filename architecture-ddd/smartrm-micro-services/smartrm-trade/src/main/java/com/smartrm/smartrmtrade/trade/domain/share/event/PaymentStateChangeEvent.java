package com.smartrm.smartrmtrade.trade.domain.share.event;

import com.smartrm.infracore.event.DomainEvent;
import com.smartrm.smartrmtrade.trade.domain.share.OrderInfo;
import com.smartrm.smartrmtrade.trade.domain.share.PaymentState;
import com.smartrm.smartrmtrade.trade.domain.share.PaymentType;

/**
 * @author: liuyuancheng
 * @description:
 */
public class PaymentStateChangeEvent extends DomainEvent {

  private Long paymentId;
  private PaymentType type;
  private OrderInfo orderInfo;
  private PaymentState preState;
  private PaymentState curState;

  public PaymentStateChangeEvent() {
    super("PaymentStateChangeEvent");
  }

  public Long getPaymentId() {
    return paymentId;
  }

  public OrderInfo getOrderInfo() {
    return orderInfo;
  }

  public PaymentState getPreState() {
    return preState;
  }

  public PaymentState getCurState() {
    return curState;
  }

  public PaymentType getType() {
    return type;
  }

  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  public void setType(PaymentType type) {
    this.type = type;
  }

  public void setOrderInfo(OrderInfo orderInfo) {
    this.orderInfo = orderInfo;
  }

  public void setPreState(PaymentState preState) {
    this.preState = preState;
  }

  public void setCurState(PaymentState curState) {
    this.curState = curState;
  }

  @Override
  public String key() {
    return paymentId.toString();
  }
}
