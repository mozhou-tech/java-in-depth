package com.tenstone.leet.patterns.cloud_distributed.api_gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 * Here we can see how API Gateway maps the requests to the microservices.
 *
 * @author liuyuancheng
 */
public class ApiGateway {

    @Resource
    private ImageClient imageClient;

    @Resource
    private PriceClient priceClient;

    @RequestMapping(path = "/desktop",method = RequestMethod.GET)
    public DesktopProduct getDesktopProduct(){
        var desktopProduct = new DesktopProduct();
        desktopProduct.setImagePath(imageClient.getImagePath());
        desktopProduct.setPrice(priceClient.getPrice());
        return desktopProduct;
    }


    @RequestMapping(path = "/mobile",method = RequestMethod.GET)
    public MobileProduct getMobileProduct(){
        var mobileProduct = new MobileProduct();
        mobileProduct.setImagePath(imageClient.getImagePath());
        mobileProduct.setPrice(priceClient.getPrice());
        return mobileProduct;
    }

}
