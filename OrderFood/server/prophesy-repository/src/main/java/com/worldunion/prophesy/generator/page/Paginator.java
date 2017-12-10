package com.worldunion.prophesy.generator.page;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by 0141434 on 2016-02-17.
 */
public class Paginator implements Serializable {
    private static final long serialVersionUID = 1L;

    private int totalRows;//总记录数
    private int pageSize;//每页条数
    private int currentPage;//当前页
    private int pages;//当前页

    public int getPages() {
        return totalRows <= 0 ? 0 : (int) Math.ceil((double) totalRows / pageSize);
    }
    public void setPages() {
    	pages = totalRows <= 0 ? 0 : (int) Math.ceil((double) totalRows / pageSize);
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalSize) {
        this.totalRows = totalSize;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
