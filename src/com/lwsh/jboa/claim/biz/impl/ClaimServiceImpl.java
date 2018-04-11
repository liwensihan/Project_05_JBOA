package com.lwsh.jboa.claim.biz.impl;

import java.util.List;
import java.util.Map;

import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER;
import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER_DETAIL;
import com.lwsh.jboa.claim.biz.ClaimService;
import com.lwsh.jboa.claim.dao.ClaimDao;

public class ClaimServiceImpl implements ClaimService{

	private ClaimDao claimDao;
	
	public ClaimDao getClaimDao() {
		return claimDao;
	}

	public void setClaimDao(ClaimDao claimDao) {
		this.claimDao = claimDao;
	}

	@Override
	public int addClaim(BIZ_CLAIM_VOUCHER claim_voucher) {
		return claimDao.addClaim(claim_voucher);
	}

	@Override
	public int addClaimDetail(List<BIZ_CLAIM_VOUCHER_DETAIL> detailList) {
		return claimDao.addClaimDetail(detailList);
	}

	@Override
	public List<BIZ_CLAIM_VOUCHER> getVoucher(Map<String, Object> map) {	
		return claimDao.getVoucher(map);
	}

	@Override
	public BIZ_CLAIM_VOUCHER getClaimById(Integer id) {
		
		return claimDao.getClaimById(id);
	}

	@Override
	public int deleteClaim(BIZ_CLAIM_VOUCHER claim_voucher) {
		int count = 0;
		try{
			claimDao.delClaim(claim_voucher);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int updateClaim(BIZ_CLAIM_VOUCHER claim_voucher) {
		int count = 0;
		try{
			claimDao.updateClaim(claim_voucher);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int delDetail(Integer voucherId) {
		int count = 0;
		try{
			claimDao.delDetail(voucherId);
			count =1;
		}catch (Exception e){
			new RuntimeException();

		}
			return count;
	}

	@Override
	public Integer getCount(Map<String, Object> map) {
		return claimDao.getPageCount(map);
	}

}
