package com.edu.ldu.core.duty.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yanmengjie
 * 2018/3/11
 */
@Data()
public class Duty {
    private Integer id;
    /**
     * 职务名称
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
}