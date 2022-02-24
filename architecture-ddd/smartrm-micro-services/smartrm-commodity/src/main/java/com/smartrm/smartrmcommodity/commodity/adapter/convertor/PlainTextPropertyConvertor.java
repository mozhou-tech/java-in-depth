package com.smartrm.smartrmcommodity.commodity.adapter.convertor;

import static com.smartrm.smartrmcommodity.commodity.domain.model.ValueTypeCode.CURRENCY;
import static com.smartrm.smartrmcommodity.commodity.domain.model.ValueTypeCode.DATE;
import static com.smartrm.smartrmcommodity.commodity.domain.model.ValueTypeCode.DATETIME;
import static com.smartrm.smartrmcommodity.commodity.domain.model.ValueTypeCode.FLOAT;
import static com.smartrm.smartrmcommodity.commodity.domain.model.ValueTypeCode.IMAGE_URL;
import static com.smartrm.smartrmcommodity.commodity.domain.model.ValueTypeCode.INTEGER;
import static com.smartrm.smartrmcommodity.commodity.domain.model.ValueTypeCode.MAP;
import static com.smartrm.smartrmcommodity.commodity.domain.model.ValueTypeCode.STRING;

import com.google.common.collect.ImmutableMap;
import com.smartrm.smartrmcommodity.commodity.adapter.convertor.plaintext.CurrencyPropertyTextParser;
import com.smartrm.smartrmcommodity.commodity.adapter.convertor.plaintext.DatePropertyTextParser;
import com.smartrm.smartrmcommodity.commodity.adapter.convertor.plaintext.DateTimePropertyTextParser;
import com.smartrm.smartrmcommodity.commodity.adapter.convertor.plaintext.FloatPropertyTextParser;
import com.smartrm.smartrmcommodity.commodity.adapter.convertor.plaintext.ImageUrlPropertyTextParser;
import com.smartrm.smartrmcommodity.commodity.adapter.convertor.plaintext.IntegerPropertyTextParser;
import com.smartrm.smartrmcommodity.commodity.adapter.convertor.plaintext.MapPropertyTextParser;
import com.smartrm.smartrmcommodity.commodity.adapter.convertor.plaintext.StringPropertyTextParser;
import com.smartrm.smartrmcommodity.commodity.domain.model.ValueType;
import com.smartrm.smartrmcommodity.commodity.domain.model.ValueTypeCode;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

/**
 * @author: liuyuancheng
 * @description:
 */
@Component
public class PlainTextPropertyConvertor implements PropertyConvertor {

  private static Map<ValueTypeCode, Pair<CommodityPropertyParser, CommodityPropertyDumper>> adapterMap = ImmutableMap
      .<ValueTypeCode, Pair<CommodityPropertyParser, CommodityPropertyDumper>>builder()
      .put(STRING, Pair.of(new StringPropertyTextParser(), null))
      .put(INTEGER, Pair.of(new IntegerPropertyTextParser(), null))
      .put(FLOAT, Pair.of(new FloatPropertyTextParser(), null))
      .put(CURRENCY, Pair.of(new CurrencyPropertyTextParser(), null))
      .put(DATE, Pair.of(new DatePropertyTextParser(), null))
      .put(DATETIME, Pair.of(new DateTimePropertyTextParser(), null))
      .put(IMAGE_URL, Pair.of(new ImageUrlPropertyTextParser(null), null))
      .put(MAP, Pair.of(new MapPropertyTextParser(), null))
      .build();

  @Override
  public CommodityPropertyParser parser(ValueType type) {
    return adapterMap.get(type.getType()).getLeft();
  }

  @Override
  public CommodityPropertyDumper dumper(ValueType type) {
    return null;
  }
}
