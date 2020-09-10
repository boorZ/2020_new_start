package com.zl.springdataelasticsearchdemo.demo.entity;

import com.zl.springdataelasticsearchdemo.demo.type.dto.ClassificationIndexDTO;
import com.zl.springdataelasticsearchdemo.demo.type.dto.LabelDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/7/9 15:02
 */
@Data
@NoArgsConstructor
@Document(indexName = "se", type = "_doc", shards = 2, replicas = 1)
public class SeIndexBo {
    /**
     * 文档id
     */
    private Long docId;
    /**
     * 文档分类
     */
    private String docType;
    private String docTypeName;
    /**
     * 文档名称
     */
    private String docName;
    /**
     * 有效状态
     * 0: 全部
     * 1：全文有效
     * 2：部分失效
     * 3：全文失效
     */
    private Integer effectiveStatus;

    /**
     * 编号
     **/
    private String serialNumber;
    /**
     * 文档简介
     */
    private String docInfo;
    /**
     * 文号
     */
    private String writNo;
    /**
     * 发布时间
     */
    private String dispatchTime;
    /**
     * 发布时间戳
     */
    private Long dispatchTimeMill;
    /**
     * 发文单位
     */
    private String dispatchUnit;
    /**
     * 版本Id
     */
    private Long normTypeId;
    /**
     * 来源
     */
    private String source;
    /**
     * 分类索引
     */
    private List<ClassificationIndexDTO> classificationIndex;

    /**
     * 标签
     **/
    private List<LabelDTO> labelList;
}
