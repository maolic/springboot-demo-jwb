package com.example.springbootdemo.dto;

import java.util.List;

/**
 * 分页DTO
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/23 13:34
 */
public class PageDTO<T> {
    /**
     * 页码
     */
    private Integer page;
    /**
     * 数量
     */
    private Integer limit;
    /**
     * 总数
     */
    private Long total;
    /**
     * 当前分页列表
     */
    private List<T> list;

    public PageDTO() {
    }

    public PageDTO(Integer page, Integer limit, Long total, List<T> list) {
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.list = list;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "page=" + page +
                ", limit=" + limit +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
