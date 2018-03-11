package com.edu.ldu.core.category.dao.provider;

import com.edu.ldu.core.common.entity.Page;
import com.edu.ldu.core.category.vo.CategoryVO;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


/**
 * @author yanmengjie
 * 2018/3/11
 */
public class CategoryDaoProvider {

    public String countListCategory(Map map) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(1) from tbl_category where status <> 'DELETE'");
        createCondition(map, sql);
        return sql.toString();

    }

    public String listCategory(Map map) {
        Page page = (Page) map.get("page");
        StringBuilder sql = new StringBuilder();
        sql.append("select id, name,create_time as createTime,modified_time as modifiedTime, status " +
                "from tbl_category where status <> 'DELETE' ");
        createCondition(map, sql);
        sql.append(" limit ");
        sql.append(page.getBeginIndex()).append(",").append(page.getPageSize());
        return sql.toString();
    }

    private void createCondition(Map map, StringBuilder sql) {
        CategoryVO categoryVO = (CategoryVO) map.get("categoryVO");

        if (categoryVO.getStartTime() != null) {
            sql.append(" and create_time >=#{categoryVO.createTime}");
        }
        if (categoryVO.getEndTime() != null) {
            sql.append(" and create_time <=#{categoryVO.endTime}");
        }
        if (StringUtils.isNotBlank(categoryVO.getName())) {
            sql.append("instr(name,#{categoryVO.name})>0");
        }

    }
}