package com.lwsh.jboa.base.util;

import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * 白夜行 on 2018/3/10.
 */
public class Pager {
    private Integer pageNo;
    private Integer totalCount;
    private Integer totalPage;
    private Integer pageSize;

    public List<BIZ_CLAIM_VOUCHER> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<BIZ_CLAIM_VOUCHER> vouchers) {
        this.vouchers = vouchers;
    }

    private List<BIZ_CLAIM_VOUCHER> vouchers = new ArrayList<BIZ_CLAIM_VOUCHER>();

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
