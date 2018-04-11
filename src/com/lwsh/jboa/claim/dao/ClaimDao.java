package com.lwsh.jboa.claim.dao;

import java.util.List;
import java.util.Map;

import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER;
import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER_DETAIL;
import com.lwsh.jboa.base.entity.SYS_EMPLOYEE;

public interface ClaimDao {

	/**
	 * 新增报销单
	 * @param claim_voucher
	 * @return
	 */
	public int addClaim(BIZ_CLAIM_VOUCHER claim_voucher);
	
	public int addClaimDetail(List<BIZ_CLAIM_VOUCHER_DETAIL> detailList);

	/**
	 * 查询报销单
	 * @param map
	 * @return
	 */
	public List<BIZ_CLAIM_VOUCHER> getVoucher(Map<String, Object> map);

	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public BIZ_CLAIM_VOUCHER getClaimById(Integer id);

	/**
	 * 删除报销单
	 * @param claim_voucher
	 */
	public void delClaim(BIZ_CLAIM_VOUCHER claim_voucher);

	/**
	 * 更新报销单
	 * @param claim_voucher
	 */
	public void updateClaim(BIZ_CLAIM_VOUCHER claim_voucher);

	public void delDetail(Integer integer);

	/**
	 * 查询总数量
	 * @param map
	 * @return
	 */
	public Integer getPageCount(Map<String,Object> map);
}
