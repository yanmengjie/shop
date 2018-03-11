package com.edu.ldu.admin.category.controller;

import com.edu.ldu.core.category.entity.Category;
import com.edu.ldu.core.category.service.CategoryService;
import com.edu.ldu.core.category.vo.CategoryVO;
import com.edu.ldu.core.common.entity.Message;
import com.edu.ldu.core.common.entity.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author yanmengjie
 * 2018/3/11
 */
@Slf4j
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 跳转页面
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView categoryPage()  {

        ModelAndView md = new ModelAndView("category/categoryList");
        return md;

    }

    /**
     * 新增分类
     *
     * @param category 分类实体
     * @return
     */
    @RequestMapping("addCategory")
    public Message addCategory(Category category) {

        if (!StringUtils.isNotBlank(category.getName())) {
            return Message.fail("分类名不能为空");
        }
        return categoryService.addCategory(category);

    }

    /**
     * 查询分类列表
     *
     * @param page       分页实体
     * @param categoryVO 分类实体
     * @return
     */
    @RequestMapping("listCategory")
    public Page listCategory(Page page, CategoryVO categoryVO) {

        return categoryService.listCategory(page, categoryVO);
    }

    /**
     * 修改分类名称
     *
     * @param category 分类实体
     * @return
     */
    @RequestMapping("updateCategory")
    public Message updateCategory(Category category) {

        if (category.getId() == null) {
            return Message.fail("分类id不能为空");
        }
        if (!StringUtils.isNotBlank(category.getName())) {
            return Message.fail("分类名不能为空");
        }
        return categoryService.updateCategory(category);
    }

    /**
     * 删除分类
     *
     * @param category 分类实体
     * @return
     */
    @RequestMapping("deleteCategory")
    public Message deleteCategory(Category category) {

        if (category.getId() == null) {
            return Message.fail("分类id不能为空");
        }
        return categoryService.deleteCategory(category);
    }

}