package com.lwsh.jboa.claim.biz;

import java.util.List;
import java.util.Map;

import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER;
import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER_DETAIL;

public interface ClaimService {
	/**
	 * 新增报销单
	 * @param claim_voucher
	 * @return
	 */
	int addClaim(BIZ_CLAIM_VOUCHER claim_voucher);
	
	int addClaimDetail(List<BIZ_CLAIM_VOUCHER_DETAIL> detailList);
	
	List<BIZ_CLAIM_VOUCHER> getVoucher(Map<String, Object> map);
	
	BIZ_CLAIM_VOUCHER getClaimById(Integer id);

	int deleteClaim(BIZ_CLAIM_VOUCHER claim_voucher);

	int updateClaim(BIZ_CLAIM_VOUCHER claim_voucher);

	int delDetail(Integer voucherId);

	Integer getCount(Map<String, Object> map);
}
