package com.zl.springdataelasticsearchdemo.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/5/26 16:36
 *
 */
@Data
@Document(indexName = "item", type = "docs", shards = 1, replicas = 0)
public class Item {
    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    /** 标题 **/
    private String title;

    @Field(type = FieldType.Keyword)
    /**  分类 **/
    private String category;

    @Field(type = FieldType.Keyword)
    /**  品牌 **/
    private String brand;

    @Field(type = FieldType.Double)
    /**  价格 **/
    private Double price;

    @Field(index = false, type = FieldType.Keyword)
    /**  图片地址 **/
    private String images;

    public Item() {
    }

    public Item(Long id, String title, String category, String brand, Double price, String images) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.images = images;
    }
}
