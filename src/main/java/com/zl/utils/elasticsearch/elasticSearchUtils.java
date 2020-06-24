package com.zl.utils.elasticsearch;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.lucene.index.*;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周林
 * @Description ES检索工具类
 * @email prometheus@noask-ai.com
 * @date 2020/3/12 19:06
 */
public class elasticSearchUtils {

    private static RestHighLevelClient client;
    private static final Logger logger = LoggerFactory.getLogger(elasticSearchUtils.class);

    private void getTermAll(String field) {
        File file = new File("E:\\LearningSoftware\\ES\\lucene\\index");
        // 获取索引域中所有Term
        try {
            IndexReader indexReader = DirectoryReader.open(FSDirectory.open(file.toPath()));
            Terms terms = MultiTerms.getTerms(indexReader, field);
            TermsEnum iterator = terms.iterator();
            BytesRef byteRef;
            int i = 0;
            while ((byteRef = iterator.next()) != null) {
                i++;
                System.out.println(byteRef.toString());
                System.out.println("bytes：" + byteRef.bytes);
                System.out.println("offset：" + byteRef.offset);
                System.out.println("length：" + byteRef.length);
                String term = new String(byteRef.bytes, byteRef.offset, byteRef.length);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("id", i);
                dataMap.put("term", term);
                dataMap.put("field", field);
                System.out.println(dataMap);
                System.out.println();
                if (i == 10) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 获取连接
     * @create：zhoulin 2020-01-17
     */
    public static RestHighLevelClient getClient() {
        String urls = "http://" + Config.ES_IP + ":" + Config.ES_PORT;
        String[] urlArrays = urls.split(",");
        List<HttpHost> httpHosts = new ArrayList<>();
        for (String host : urlArrays) {
            logger.info("主机：" + host);
            httpHosts.add(HttpHost.create(host));
        }
        UsernamePasswordCredentials usernamePasswordCredentials = new
                UsernamePasswordCredentials(Config.EsUserName, Config.EsPassword);
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, usernamePasswordCredentials);
        RestClientBuilder restClientBuilder = RestClient.builder(httpHosts.toArray(new HttpHost[0]));
//        restClientBuilder.setRequestConfigCallback(builder -> builder.setSocketTimeout(1200000));
//        restClientBuilder.setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
        client = new RestHighLevelClient(restClientBuilder);
        logger.info("认证成功");
        return client;
    }

    /**
     * 建立连接
     */
    public static void close() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMain() {
//        getTermAll("docName");

    }
}
