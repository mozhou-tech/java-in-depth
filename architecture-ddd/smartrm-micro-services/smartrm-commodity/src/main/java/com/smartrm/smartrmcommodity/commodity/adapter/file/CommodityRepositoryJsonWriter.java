package com.smartrm.smartrmcommodity.commodity.adapter.file;

import com.smartrm.smartrmcommodity.commodity.adapter.convertor.CommodityDumper;
import com.smartrm.smartrmcommodity.commodity.adapter.convertor.json.CommodityJsonDumper;
import com.smartrm.smartrmcommodity.commodity.domain.repository.CommodityRepository;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: liuyuancheng
 * @description: 把资源库写入到json文件
 */
@Component
public class CommodityRepositoryJsonWriter {

  @Autowired
  private CommodityRepository commodityRepository;

  public void dumpRepository() throws IOException {
    CommodityDumper dumper = new CommodityJsonDumper(
        new FileOutputStream("commodity_repository_dump.json"));
    commodityRepository.traverse(dumper);
  }

}
