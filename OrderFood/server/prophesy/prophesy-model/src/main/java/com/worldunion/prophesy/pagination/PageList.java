package com.worldunion.prophesy.pagination;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 0141434 on 2016-02-17.
 */
public class PageList <E> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Paginator paginator;
    private List<E> list;

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
