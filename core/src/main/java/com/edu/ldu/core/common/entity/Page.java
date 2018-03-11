package com.edu.ldu.core.common.entity;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

/**
 * 分页实体
 *
 * @author yanmengjie
 * 2018/3/6
 */
@SuppressWarnings("serial")
public class Page<T> implements Serializable {
    /**
     * 当前页
     */
    private Integer page = 1;
    /**
     * 当前页(bootStrap)
     */
    private Integer pageNumber = 1;
    /**
     * 最大页/总页数
     */
    private Integer maxPage;
    /**
     * 每页长度
     */
    private Integer rows = 10;
    /**
     * 每页长度
     */
    private Integer pageSize = 10;
    /**
     * 总记录
     */
    private Integer total = 0;
    /**
     * 查询条件
     */
    private T queryBean;
    /**
     * 结果集
     */
    private List<T> resultList;
    /**
     * 默认检索条件
     */
    private String searchText;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        this.pageNumber = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
        this.pageSize = rows;
    }

    @JsonGetter("rows")
    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;

    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        this.page = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        this.rows = pageSize;
    }

    public T getQueryBean() {
        return queryBean;
    }

    public void setQueryBean(T queryBean) {
        this.queryBean = queryBean;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
        this.maxPage = Integer.parseInt(new DecimalFormat("#0").format(Math
                .ceil(total / 1.0 / rows)));
        this.total = total;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    /**
     * 获取当前分页开始坐标
     *
     * @return
     */
    public Integer getBeginIndex() {
        return ((this.page - 1) * this.rows);
    }

    /**
     * 获取当前分页结束坐标
     *
     * @return
     */
    public Integer getEndIndex() {
        return this.page * this.rows;
    }

    public static void getEmptyResult(Page page, Message message) {
        if (page == null || message == null) {
            return;
        }
        page.setTotal(0);
        page.setResultList(Collections.EMPTY_LIST);
        page.setQueryBean(message);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Page{");
        sb.append("page=").append(page);
        sb.append(", pageNumber=").append(pageNumber);
        sb.append(", maxPage=").append(maxPage);
        sb.append(", rows=").append(rows);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(total);
        sb.append(", queryBean=").append(queryBean);
        sb.append(", resultList=").append(resultList);
        sb.append('}');
        return sb.toString();
    }
}

