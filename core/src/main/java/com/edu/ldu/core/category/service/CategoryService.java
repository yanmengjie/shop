package com.edu.ldu.core.category.service;

import com.edu.ldu.core.category.entity.Category;
import com.edu.ldu.core.category.vo.CategoryVO;
import com.edu.ldu.core.common.entity.Message;
import com.edu.ldu.core.common.entity.Page;

/**
 * @author yanmengjie
 * 2018/3/11
 */
public interface CategoryService {


    /**
     * 查询分类列表
     *
     * @param page       分页实体
     * @param categoryVO 分类实体
     * @return
     */
    Page listCategory(Page page, CategoryVO categoryVO);


    /**
     * 新增分类
     *
     * @param category 分类实体
     * @return
     */
    Message addCategory(Category category);

    /**
     * 修改分类
     * @param category 分类实体
     * @return
     */
    Message updateCategory(Category category);

    /**
     * 删除分类
     * @param category 分类实体
     * @return
     */
    Message deleteCategory(Category category);

}