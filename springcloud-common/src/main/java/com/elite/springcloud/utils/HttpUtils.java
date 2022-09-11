package com.elite.springcloud.utils;


import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.web.util.UriComponentsBuilder;


import java.io.IOException;
import java.util.Map;

/**
 * @Description TODO
 * @Author gengweiqiang
 * @date 2021/12/13 11:52
 **/
public  class HttpUtils {

    /**
     * 如果你需要发送https请求并跳过ssl证书验证，请使用此方法
     * 条件：请求体格式为json
     *
     * @param url
     * @param body
     * @return
     */
    public static String sendPostByHttps(String url, Map<String, String> body, String token) {

        CloseableHttpResponse response = null;
        // 处理请求路径
        url = UriComponentsBuilder.fromHttpUrl(url)
                .toUriString();
        //创建httpclient对象
        CloseableHttpClient client = null;
        String respBody;
        try {
            client = HttpClients.custom()
                    .setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContexts.custom()
                            //忽略掉对服务器端证书的校验
                            .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                            .build(), NoopHostnameVerifier.INSTANCE))
                    .build();
            //创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);
            // 请求头设置
            httpPost.setHeader("Accept", "*/*");
            httpPost.setHeader("connection", "Keep-Alive");
            httpPost.setHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpPost.setHeader("Content-type", "application/json;charset=utf-8");
            httpPost.setHeader("Authorization", token);//如果需要token请修改传入自己的token以及Authorization
            // 情求体设置
            if (body != null) {
                httpPost.setEntity(new StringEntity(JSON.toJSONString(body), "utf-8"));
            }
            //执行请求操作，并拿到结果
            response = client.execute(httpPost);
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                respBody = EntityUtils.toString(entity);
                return respBody;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
            }
        }

        return null;
    }
}