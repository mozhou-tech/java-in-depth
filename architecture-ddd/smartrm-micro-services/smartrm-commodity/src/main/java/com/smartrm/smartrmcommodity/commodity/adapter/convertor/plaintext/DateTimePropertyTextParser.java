package com.smartrm.smartrmcommodity.commodity.adapter.convertor.plaintext;

import com.smartrm.smartrmcommodity.commodity.adapter.convertor.CommodityPropertyParser;
import com.smartrm.smartrmcommodity.commodity.domain.model.DateParser;
import com.smartrm.smartrmcommodity.commodity.infrastructure.CommodityError;
import com.smartrm.infracore.exception.DomainException;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: liuyuancheng
 * @description:
 */
public class DateTimePropertyTextParser implements
    CommodityPropertyParser<LocalDateTime, String> {

  @Override
  public LocalDateTime parse(String content) {
    if (StringUtils.isEmpty(content)) {
      return null;
    }

    LocalDateTime dateTime = DateParser.asLocalDateTime(content);
    if (dateTime == null) {
      throw new DomainException(CommodityError.CommodityParseError);
    }
    return dateTime;
  }
}
