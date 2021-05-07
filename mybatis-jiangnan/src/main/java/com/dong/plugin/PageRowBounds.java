package com.dong.plugin;

import org.apache.ibatis.session.RowBounds;

/**
 * @version 1.0 2021/5/3
 * @author dongliyang
 */
public class PageRowBounds extends RowBounds {
    private Long total;

    public PageRowBounds() {}

    public PageRowBounds(int offset, int limit) {
        super(offset, limit);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}