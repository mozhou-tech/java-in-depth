package com.tenstone.leet.patterns.creation.object_pool;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 *
 * @author liuyuancheng
 */
public class OliphauntPool extends ObjectPool<Oliphaunt>{
    @Override
    protected Oliphaunt create() {
        return new Oliphaunt();
    }
}
