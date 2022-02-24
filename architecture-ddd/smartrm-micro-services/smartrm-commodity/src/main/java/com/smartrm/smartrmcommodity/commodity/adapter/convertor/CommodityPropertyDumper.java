package com.smartrm.smartrmcommodity.commodity.adapter.convertor;

import com.smartrm.smartrmcommodity.commodity.domain.model.Property;

/**
 * @author: liuyuancheng
 * @description:
 */
public interface CommodityPropertyDumper<T> {

  void dump(Property<T> from);

}
