package cn.liuawen.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-07-07
 */
public class CrawlerFirst {
    public static void main(String[] args) throws IOException {
        //1、打开浏览器 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2、输入网址  发起get请求 创建HttpGet对象
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");
        //3、按回车 发起请求 返回响应
//        CloseableHttpResponse response= httpClient.execute(httpGet);
        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求
            response = httpClient.execute(httpGet);

            //4、解析响应 获取数据
            //判断状态码是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // //如果为200表示请求成功，获取返回数据
                HttpEntity httpEntity = response.getEntity();
                String context = EntityUtils.toString(httpEntity, "utf8");
                //打印数据长度
                System.out.println(context);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }
}
