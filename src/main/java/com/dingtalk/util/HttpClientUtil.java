package com.dingtalk.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * <p> 发送请求工具类 </p>
 *
 * @author vchar fred
 * @version 1.0
 * @create_date 2019/7/25 9:51
 */
public class HttpClientUtil {

    public static String sendPost(String url, String param){
        return _post(url, param, 20000, 20000, 3000);
    }

    public static String sendPost(String url, String param
            , int connectTimeout, int socketTimeout, int connectionRequestTimeout){
        return _post(url, param, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    private static String _post(String url, String params
            , int connectTimeout, int socketTimeout, int connectionRequestTimeout){
        CloseableHttpClient httpClient = null;
        try{
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout)
                    .setConnectionRequestTimeout(connectionRequestTimeout).build();

            httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-type", "application/json; charset=utf-8");
            httpPost.setHeader("Connection", "Close");
            StringEntity entity = new StringEntity(params, Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            return EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(httpClient!=null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
