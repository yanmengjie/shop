package com.edu.ldu.core.category.vo;

import com.edu.ldu.core.category.entity.Category;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yanmengjie
 * 2018/3/11
 */
@Data()
public class CategoryVO extends Category {
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}