package com.worldunion.prophesy.pagination;

import java.io.Serializable;

/**
 * Created by 0141434 on 2016-02-17.
 */
public class Paginator implements Serializable {
    private static final long serialVersionUID = 1L;

    private int totalRows;//总记录数
    private int pageSize;//每页条数
    private int currentPage;//当前页



    public Paginator(){

    }

    public Paginator(int pageSize, int currentPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public int getPages() {
        return totalRows <= 0 ? 0 : (int) Math.ceil((double) totalRows / pageSize);
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
}
