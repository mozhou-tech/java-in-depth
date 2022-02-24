package com.smartrm.smartrmmonolith.infracore.idgenerator;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: liuyuancheng
 * @description: 唯一id生成器util
 */
@Component
public class UniqueIdGeneratorUtil {

  private static UniqueIdGeneratorUtil instance;

  @Autowired(required = false)
  private UniqueIdGenerator generator;

  @PostConstruct
  private void init() {
    instance = this;
  }

  public static UniqueIdGeneratorUtil instance() {
    return instance;
  }

  public long nextId() {
    return generator.next();
  }
}
