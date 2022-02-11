package com.tenstone.leet.patterns.cloud_distributed.api_gateway;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 *
 * @author liuyuancheng
 */
public class PriceClientImpl implements PriceClient{
    @Override
    public String getPrice() {
        var httpClient = HttpClient.newHttpClient();
        var httpGet = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:50006/price"))
                .build();
        try {
            var httpResponse = httpClient.send(httpGet, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
