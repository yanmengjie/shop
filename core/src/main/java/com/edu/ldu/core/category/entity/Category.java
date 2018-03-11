package com.edu.ldu.core.category.entity;

import com.edu.ldu.core.category.enums.CategoryStatusEnum;
import lombok.Data;

import java.util.Date;


/**
 * 分类表
 *
 * @author yanmengjie
 * 2018/3/11
 */
@Data()
public class Category {

    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
    /**
     * 状态
     */
    private CategoryStatusEnum status;

}