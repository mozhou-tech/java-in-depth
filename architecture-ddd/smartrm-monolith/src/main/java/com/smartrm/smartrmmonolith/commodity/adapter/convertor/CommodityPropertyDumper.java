package com.smartrm.smartrmmonolith.commodity.adapter.convertor;

import com.smartrm.smartrmmonolith.commodity.domain.model.Property;

/**
 * @author: liuyuancheng
 * @description:
 */
public interface CommodityPropertyDumper<T> {

  void dump(Property<T> from);

}
