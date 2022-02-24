package com.smartrm.smartrmmonolith.commodity.adapter.convertor;

/**
 * @author: liuyuancheng
 * @description:
 */
public interface CommodityPropertyParser<T, V> {

  T parse(V content);

}
