package com.zl.springdataelasticsearchdemo.TEST;

import com.zl.springdataelasticsearchdemo.demo.dao.ItemRepository;
import com.zl.springdataelasticsearchdemo.demo.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/5/26 17:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IndexTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ItemRepository itemRepository;

    //创建索引和映射
    @Test
    public void createTest() {
        elasticsearchTemplate.createIndex(Item.class);
        elasticsearchTemplate.putMapping(Item.class);
    }

    //保存一条数据
    @Test
    public void saveTest() {
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        itemRepository.save(item);
    }
}
