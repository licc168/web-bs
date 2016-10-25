package com.licc.common.util;

import java.util.Collection;

/**
 * 分页查询结果
 * Created by Jake on 2/21 0021.
 */
public class PageResult<T> {

    private PageInfo pageInfo;

    private Collection<T> data;

    private PageResult(PageInfo pageInfo, Collection<T> data) {
        this.pageInfo = pageInfo;
        this.data = data;
    }

    /**
     * 创建PageResult
     * @param pageInfo PageInfo
     * @param data List
     * @return
     */
    public static <T> PageResult<T> valueOf(PageInfo pageInfo, Collection<T> data) {
        return new PageResult(pageInfo, data);
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public Collection<T> getData() {
        return data;
    }

}
