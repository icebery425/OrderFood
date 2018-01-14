package com.worldunion.prophesy.pagination;

import java.io.Serializable;

/**
 * Created by 0141434 on 2016-02-17.
 */
public class PagingCriterion implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int DEFAULT_SIZE_PERPAGE = 20;
    public static final int DEFAULT_PAGE_INDEX = 1;
    protected int pageSize = DEFAULT_SIZE_PERPAGE;
    protected int currentPage = DEFAULT_PAGE_INDEX;

    public int getStartRow() {
        return pageSize * (currentPage - 1);
    }

    public int getEndRow() {
        return pageSize * currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
