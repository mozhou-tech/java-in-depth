package com.smartrm.smartrmcommodity.commodity.adapter.convertor;

import com.smartrm.smartrmcommodity.commodity.domain.model.ValueType;

/**
 * @author: liuyuancheng
 * @description:
 */
public interface PropertyConvertor {

  CommodityPropertyParser parser(ValueType type);

  CommodityPropertyDumper dumper(ValueType type);

}
