//package com.example.springdatajpademo.common.entity.business;
//
//import com.example.springdatajpademo.common.entity.BaseEntity;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// * @author 周林
// * @Description 操作人
// * @email prometheus@noask-ai.com
// * @date 2020/9/10 17:54
// */
//@MappedSuperclass
//@Setter
//@Getter
//public class OperatorExtendsEntity extends BaseEntity {
//    @ManyToOne
//    @JoinColumn(name = "create_by", insertable = false, updatable = false)
//    @GraphQLField
//    private ErpUser createByUser;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "update_by", insertable = false, updatable = false)
//    @GraphQLField
//    private ErpUser updateByUser;
//
//    /**
//     * 持久化之前自动填充实体属性
//     **/
//    @PrePersist
//    protected void onCreate() {
//        createAt = updateAt = new Date();
//    }
//
//    /**
//     * 更新实体时更新修改时间
//     **/
//    @PreUpdate
//    protected void onUpdate() {
//        updateAt = new Date();
//    }
//
//}
