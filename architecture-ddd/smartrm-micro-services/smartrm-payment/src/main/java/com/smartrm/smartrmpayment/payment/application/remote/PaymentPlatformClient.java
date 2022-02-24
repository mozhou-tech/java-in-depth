package com.smartrm.smartrmpayment.payment.application.remote;

import com.smartrm.smartrmpayment.payment.application.dto.PaymentQrCodeDto;
import com.smartrm.smartrmpayment.payment.domain.Payment;

/**
 * @author: liuyuancheng
 * @description:
 */
public interface PaymentPlatformClient {

  PaymentQrCodeDto queryQrCode(Payment payment);

  void requestForDeduction(Payment payment);

  void requestForRefund(Payment payment);

}
