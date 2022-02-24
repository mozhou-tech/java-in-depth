package com.smartrm.smartrmmonolith.device.domain;

/**
 * @author: liuyuancheng
 * @description:
 */
public enum VendingMachineType {
  SLOT(0),
  CABINET(1);

  private final int code;

  private VendingMachineType(int code) {
    this.code = code;
  }

  public int code() {
    return this.code;
  }

  public static VendingMachineType of(int code) {
    for (VendingMachineType type : values()) {
      if (type.code == code) {
        return type;
      }
    }
    return null;
  }
}
