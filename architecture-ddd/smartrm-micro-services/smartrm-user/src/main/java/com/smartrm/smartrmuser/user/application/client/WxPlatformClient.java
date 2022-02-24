package com.smartrm.smartrmuser.user.application.client;

import com.smartrm.smartrmuser.user.application.dto.WxCode2SessionResultDto;

/**
 * @author: liuyuancheng
 * @description:
 */
public interface WxPlatformClient {

  WxCode2SessionResultDto code2Session(String code);

}
