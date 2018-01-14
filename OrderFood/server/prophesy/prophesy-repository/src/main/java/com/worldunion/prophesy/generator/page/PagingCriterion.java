package com.worldunion.prophesy.generator.page;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

    public PagingCriterion() {

    }

    public PagingCriterion(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
