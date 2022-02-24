package com.smartrm.smartrmmonolith.user.application.service;

import com.smartrm.smartrmmonolith.user.application.dto.PaymentContractInfoDto;
import com.smartrm.smartrmmonolith.user.application.dto.SignInCommandDto;
import com.smartrm.smartrmmonolith.user.application.dto.SignInResultDto;
import com.smartrm.smartrmmonolith.user.application.dto.UserInfoDto;
import com.smartrm.smartrmmonolith.user.application.dto.UserInfoQueryDto;

/**
 * @author: liuyuancheng
 * @description: 用户上下文应用层服务
 */
public interface AppUserService {

  /**
   * 登录+注册
   *
   * @param code 微信平台 js_code
   * @return 登录结果
   */
  SignInResultDto signInOrSignUp(SignInCommandDto code);

  /**
   * 获取用户信息
   *
   * @param query
   * @return
   */
  UserInfoDto getUserInfo(UserInfoQueryDto query);

  /**
   * 支付协议签署结果处理
   *
   * @param contractInfoDto
   */
  void onPaymentContractSigned(PaymentContractInfoDto contractInfoDto);

}
