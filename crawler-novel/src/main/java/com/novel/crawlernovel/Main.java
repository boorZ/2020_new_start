package com.novel.crawlernovel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author 周林
 * @Description 入口
 * @email prometheus@noask-ai.com
 * @date 2020/6/18 21:40
 */
public class Main {
    static final Log logger = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        String url = "https://www.qimao.com/reader/index/150153/";
        String data = getUrlData(url);
        logger.info("开始打印数据： \n" + data);
//        data.
        logger.info("\n结束打印数据");
    }
//    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        //        Collections.copy(newList, list);
//        List<Integer> newList = new ArrayList<>(list);
//
//        List<Integer> integers = Arrays.asList(1, 2);
//        newList.removeAll(integers);
//        System.out.println(list);
//        System.out.println(newList);
//    }

    public static String getUrlData(String url) {
        //初始化一个httpclient
        HttpClient client = new DefaultHttpClient();
        //我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
//        String url = "http://www.147xs.org/";
        //获取网站响应的html，这里调用了HTTPUtils类
        HttpResponse response = getRawHtml(client, url);
        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        //如果状态响应码为200，则获取html实体内容或者json文件
        String data = "";
        if (statusCode != 200) {
            return data;
        }
        HttpEntity entity = response.getEntity();
        try {
            data = EntityUtils.toString(entity, "gbk");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 确保实体内容被完全使用，如果存在，则关闭内容流。
        try {
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static HttpResponse getRawHtml(HttpClient client, String personalUrl) {
        //获取响应文件，即html，采用get方法获取响应数据
        HttpGet getMethod = new HttpGet(personalUrl);
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        try {
            //执行get方法
            response = client.execute(getMethod);
        } catch (IOException e) {
            logger.info("执行请求错误： " + e.toString());
            e.printStackTrace();
        } finally {
            // 终止
            System.out.println("finally");
//            getMethod.abort();
        }
        return response;
    }
}
