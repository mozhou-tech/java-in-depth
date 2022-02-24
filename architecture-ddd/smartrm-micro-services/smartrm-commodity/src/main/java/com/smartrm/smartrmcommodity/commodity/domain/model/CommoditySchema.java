package com.smartrm.smartrmcommodity.commodity.domain.model;

import java.util.List;

/**
 * @author: liuyuancheng
 * @description:
 */
public interface CommoditySchema {

  PropertySchema getPropertySchema(String fieldName);

  List<PropertySchema> getAllPropertySchemas();

}
