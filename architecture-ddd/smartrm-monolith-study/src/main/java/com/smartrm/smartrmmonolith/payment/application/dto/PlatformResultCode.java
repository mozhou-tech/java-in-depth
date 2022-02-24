package com.smartrm.smartrmmonolith.payment.application.dto;

/**
 * @author: liuyuancheng
 * @description:
 */
public enum PlatformResultCode {
  Success(0),
  Fail(1);

  private final int code;

  private PlatformResultCode(int code) {
    this.code = code;
  }

  public int code() {
    return this.code;
  }

  public static PlatformResultCode of(int code) {
    for (PlatformResultCode resultCode : values()) {
      if (resultCode.code == code) {
        return resultCode;
      }
    }
    return null;
  }
}
