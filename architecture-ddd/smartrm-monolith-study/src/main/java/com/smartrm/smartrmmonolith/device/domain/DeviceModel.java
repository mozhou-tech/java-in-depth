package com.smartrm.smartrmmonolith.device.domain;

/**
 * @author: liuyuancheng
 * @description:
 */
public enum DeviceModel {
  NormalSlot(1),
  NormalCabinet(2);


  private final int code;

  private DeviceModel(int code) {
    this.code = code;
  }

  public int code() {
    return code;
  }

  public static DeviceModel of(int code) {
    for (DeviceModel state : values()) {
      if (state.code == code) {
        return state;
      }
    }
    return null;
  }
}
