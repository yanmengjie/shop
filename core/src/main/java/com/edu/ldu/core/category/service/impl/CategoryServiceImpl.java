package com.edu.ldu.core.category.service.impl;

import com.edu.ldu.core.category.dao.CategoryDao;
import com.edu.ldu.core.category.entity.Category;
import com.edu.ldu.core.category.enums.CategoryStatusEnum;
import com.edu.ldu.core.category.service.CategoryService;
import com.edu.ldu.core.category.vo.CategoryVO;
import com.edu.ldu.core.common.entity.Message;
import com.edu.ldu.core.common.entity.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yanmengjie
 * 2018/3/11
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    /**
     * 查询分类列表
     *
     * @param page       分页实体
     * @param categoryVO 分类实体
     * @return
     */
    @Override
    public Page listCategory(Page page, CategoryVO categoryVO) {

        try {
            int size = categoryDao.countListCategory(categoryVO);
            page.setPageSize(size);
            if (size == 0) {
                page.setResultList(new ArrayList());
                return page;
            }
            List<Category> categories = categoryDao.listCategory(page, categoryVO);
            page.setResultList(categories);
            return page;

        } catch (Exception e) {
            page.setTotal(0);
            page.setResultList(new ArrayList());
            return page;
        }
    }

    /**
     * 新增分类
     *
     * @param category 分类实体
     * @return
     */
    @Override
    public Message addCategory(Category category) {

        category.setCreateTime(new Date());
        category.setStatus(CategoryStatusEnum.NORMAL);
        if (categoryDao.addCategory(category) != 1) {
            log.error("新增分类[{}]失败", category);
            return Message.fail("新增分类失败");
        }
        return Message.success("新增分类成功");
    }

    /**
     * 修改分类
     *
     * @param category 分类实体
     * @return
     */
    @Override
    public Message updateCategory(Category category) {
        if (categoryDao.updateCategory(category) != 1) {
            return Message.fail("修改分类失败");
        }
        return Message.success("修改分类成功");
    }

    /**
     * 删除分类
     *
     * @param category 分类实体
     * @return
     */
    @Override
    public Message deleteCategory(Category category) {
        if (categoryDao.deleteCategory(category) != 1) {
            return Message.fail("删除分类失败");
        }
        return Message.success("删除分类成功");
    }
}