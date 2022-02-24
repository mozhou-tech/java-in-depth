package com.smartrm.smartrmmonolith.device.domain.iot;

/**
 * @author: liuyuancheng
 * @description:
 */
public interface IoTDeviceService {

  public void popCommodity(IoTDeviceId deviceId, int slotId, long orderId) throws Exception;

}
