package com.example.mybatisplus.entities;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class TUser {
    @TableId
    private Long uId;
    private String uName;
}
