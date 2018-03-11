package com.edu.ldu.core.category.dao;

import com.edu.ldu.core.category.dao.provider.CategoryDaoProvider;
import com.edu.ldu.core.category.entity.Category;
import com.edu.ldu.core.common.entity.Page;
import com.edu.ldu.core.category.vo.CategoryVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yanmengjie
 * 2018/3/11
 */
@Repository
public interface CategoryDao {

    /**
     * 查询分类列表
     *
     * @param page       分页实体
     * @param categoryVO 分类实体
     * @return
     */
    @SelectProvider(type = CategoryDaoProvider.class, method = "listCategory")
    List<Category> listCategory(@Param("page") Page page, @Param("categoryVO") CategoryVO categoryVO);

    /**
     * 统计分类总计
     *
     * @param categoryVO 分类实体
     * @return
     */
    @SelectProvider(type = CategoryDaoProvider.class, method = "countListCategory")
    int countListCategory(@Param("categoryVO") CategoryVO categoryVO);


    /**
     * 新增分类
     *
     * @param category 分类实体
     * @return
     */
    @Insert(" insert " +
            " into " +
            " tbl_category(" +
            " name," +
            " create_time," +
            " modified_time," +
            " status) " +
            " values(" +
            " #{category.name}," +
            " #{category.createTime}," +
            " #{category.modifiedTime}," +
            " #{category.status})")
    int addCategory(@Param("category") Category category);

    /**
     * 修改分类
     *
     * @param category 分类实体
     * @return
     */
    @Update("update tbl_category set name=#{category.name},modified_time=#{category.modifiedTime} where id=#{category.id}")
    int updateCategory(@Param("category") Category category);

    /**
     * 删除分类
     *
     * @param category 分类实体
     * @return
     */
    @Update("update tbl_category set status='DELETE' where id=#{category.id}")
    int deleteCategory(@Param("category") Category category);
}