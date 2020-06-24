package com.zl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/3/24 15:12
 */
public class myBatis {
    //log4j的是使用，不会的请看之前写的文章
    static final Log logger = LogFactory.getLog(myBatis.class);

    public static void main(String[] args) throws Exception {
        //初始化一个httpclient
        HttpClient client = new DefaultHttpClient();
        //我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
//        String url = "http://search.jd.com/Search?keyword=Python&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb";
        String url = "https://www.cnblogs.com/comeluder/p/8215317.html";
        //获取网站响应的html，这里调用了HTTPUtils类
        HttpResponse response = getRawHtml(client, url);
        //获取响应状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        //如果状态响应码为200，则获取html实体内容或者json文件
        if (StatusCode == 200) {
            String entity = EntityUtils.toString(response.getEntity(), "utf-8");
            logger.info(entity);
//            JingdongData = JdParse.getData(entity);
            EntityUtils.consume(response.getEntity());
        }

        // 抓取的数据
//        List<JdModel> bookdatas = URLFecter.URLParser(client, url);
//        //循环输出抓取的数据
//        for (JdModel jd : bookdatas) {
//            logger.info("bookID:" + jd.getBookID() + "\t" + "bookPrice:" + jd.getBookPrice() + "\t" + "bookName:" + jd.getBookName());
//        }
//        //将抓取的数据插入数据库
//        MYSQLControl.executeInsert(bookdatas);
    }

    public static HttpResponse getRawHtml(HttpClient client, String personalUrl) {
        //获取响应文件，即html，采用get方法获取响应数据
        HttpGet getMethod = new HttpGet(personalUrl);
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        try {
            //执行get方法
            response = client.execute(getMethod);
        } catch (IOException e) {

        } finally {
            // getMethod.abort();
        }
        return response;
    }

//    public static List<JdModel> getData (String html) throws Exception{
//        //获取的数据，存放在集合中
//        List<JdModel> data = new ArrayList<JdModel>();
//        //采用Jsoup解析
//        Document doc = Jsoup.parse(html);
//        //获取html标签中的内容
//        Elements elements=doc.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
//        for (Element ele:elements) {
//            String bookID=ele.attr("data-sku");
//            String bookPrice=ele.select("div[class=p-price]").select("strong").select("i").text();
//            String bookName=ele.select("div[class=p-name]").select("em").text();
//            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
//            JdModel jdModel=new JdModel();
//            //对象的值
//            jdModel.setBookID(bookID);
//            jdModel.setBookName(bookName);
//            jdModel.setBookPrice(bookPrice);
//            //将每一个对象的值，保存到List集合中
//            data.add(jdModel);
//        }
//        //返回数据
//        return data;
//    }

}
