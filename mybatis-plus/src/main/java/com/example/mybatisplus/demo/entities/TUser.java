package com.example.mybatisplus.demo.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author 周林
 * @Description
 * @email prometheus@noask-ai.com
 * @date 2020/3/24 15:25
 */
@Data
@Component
@TableName(value = "t_user")
public class TUser {
    @TableId
    private Long uId;

//    @TableField(value = "u_name", jdbcType = JdbcType.VARCHAR)
    private String uName;
}
