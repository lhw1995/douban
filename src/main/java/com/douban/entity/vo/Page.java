package com.douban.entity.vo;

/**
 * Created by lhw2 on 2017/5/1.
 */
public class Page {
    //总页数
    private Long totalPageCount;
    //页面大小，即每页显示记录数
    private Long pageSize;
    //记录总数
    private Long totalCount;
    //当前页号
    private Long currPageNo;

    public Long getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Long totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Long currPageNo) {
        this.currPageNo = currPageNo;
    }
}
