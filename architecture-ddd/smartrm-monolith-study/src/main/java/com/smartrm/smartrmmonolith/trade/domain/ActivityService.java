package com.smartrm.smartrmmonolith.trade.domain;

import com.smartrm.smartrmmonolith.trade.domain.remote.UserInfo;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 * @author: liuyuancheng
 * @description:
 */
@Service
public class ActivityService {

  public BigDecimal caculateOrderAmount(Order order, UserInfo userInfo) {
    // caculate order amount with activity
    return BigDecimal.ZERO;
  }
}
