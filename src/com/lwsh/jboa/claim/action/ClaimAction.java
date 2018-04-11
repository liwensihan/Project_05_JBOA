package com.lwsh.jboa.claim.action;

import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER;
import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER_DETAIL;
import com.lwsh.jboa.base.entity.SYS_EMPLOYEE;
import com.lwsh.jboa.base.util.Pager;
import com.lwsh.jboa.claim.biz.ClaimService;
import com.lwsh.jboa.employee.biz.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class ClaimAction extends ActionSupport {

    private BIZ_CLAIM_VOUCHER claimvoucher;//����������
    private SYS_EMPLOYEE employee;//Ա������
    private Pager page;//��ҳ����
    private Set<BIZ_CLAIM_VOUCHER_DETAIL> details;//��������ϸ��ϢSet����
    private List<BIZ_CLAIM_VOUCHER_DETAIL> detailList = new ArrayList<BIZ_CLAIM_VOUCHER_DETAIL>();//��ǰ̨���յı���������List����
    private ClaimService claimService;//����������
    private EmployeeService employeeService;//Ա������
    private String status;//������״̬
    private Date startDate;//��ʼʱ��
    private Date endDate;//����ʱ��

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * ��index.jsp����(claim_voucher_list.jsp)�鿴������
     * ��ѯ��Ա�������б�������Ϣ����
     * ������Ҫͨ����ɫid��һ���жϣ�����role_id��Ա���Ͳ�ѯ���е�ǰ�����½���������صģ�����ͨ���ı�������Ϣ��
     * ����role_id�ǲ��ž�����Բ鿴�����´�����Ϊ�����б�����
     *
     * @return
     */
    public String searchClaimVoucher() {
        SYS_EMPLOYEE emp = (SYS_EMPLOYEE) ActionContext.getContext().getSession().get("employee");
        Map<String, Object> map = new HashMap<String, Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        map.put("employee", emp);
        map.put("startDate",startDate!=null?sdf.format(startDate):null);
        map.put("endDate",endDate!=null?sdf.format(endDate):null);
        map.put("status",status);
        if (page==null){
            page = new Pager();
        }
        if (page.getPageNo()==null){
            page.setPageNo(1);
        }

        page.setPageSize(5);
        Integer totalCount = claimService.getCount(map);
        page.setTotalCount(totalCount);
        Integer totalPage = page.getTotalCount()%page.getPageSize()==0?page.getTotalCount()/page.getPageSize():page.getTotalCount()/page.getPageSize()+1;
       page.setTotalPage(totalPage);
        map.put("pageNo",(page.getPageNo()-1)*page.getPageSize());
        map.put("pageSize",page.getPageSize());
        List<BIZ_CLAIM_VOUCHER> voucherList = claimService.getVoucher(map);
        ActionContext.getContext().getSession().put("voucherList", voucherList);
        return "toList";
    }

    /**
     * ��index.jsp����(claim_voucher_edit.jsp)��ӱ�����
     *
     * @return
     */
    public String toAdd() {

        return "toAdd";
    }

    /**
     * ��ӱ�������Ϣ
     *
     * @return
     */
    public String saveClaimVoucher() {
        employee = (SYS_EMPLOYEE) ActionContext.getContext().getSession().get("employee");
        claimvoucher.setCreate(employee);
        details = new HashSet<BIZ_CLAIM_VOUCHER_DETAIL>();
        Date createTime = new Date();
        claimvoucher.setCreate_time(createTime);

        if (detailList.size() > 0) {
            for (int i = 0; i < detailList.size(); i++) {
                //�������ͱ�������������˫�����,������Ҫ�������з��뱨��������
                detailList.get(i).setBizClaimVoucher(claimvoucher);
                details.add(detailList.get(i));
            }
        }
        if (claimvoucher.getStatus().equals("�´���")) {
            claimvoucher.setNext_deal(employee);

        }

        claimvoucher.setBizClaimVoucherDetails(details);
        int count = claimService.addClaim(claimvoucher);
        if (count > 0) {
            return searchClaimVoucher();
        } else {
            return "index";
        }
    }

    /**
     * ͨ��idɾ������
     * @return
     */
    public String deleteclaimvoucherById() {
        claimvoucher = claimService.getClaimById(claimvoucher.getId());
        if (claimvoucher != null) {
            claimService.deleteClaim(claimvoucher);
            return searchClaimVoucher();
        }
        return ERROR;
    }


    /**
     * ͨ��id���Ա��������Ϣ��Ȼ������(claim_voucher_view.jsp)��ѯ��������Ϣ��ϸ
     * ��(claim_voucher_list.jsp)
     *
     * @return
     */
    public String getClaimVoucherById() {
        claimvoucher = claimService.getClaimById(claimvoucher.getId());
        return "toView";
    }

    /**
     * �´����������������ͨ��id���Ա��������Ϣ������(claim_voucher_update.jsp)ȥ�޸ı�������Ϣ
     * @return
     */
    public String toUpdate() {
        claimvoucher = claimService.getClaimById(claimvoucher.getId());
        return "toUpdate";
    }

    /**
     * ���±���������
     * @return
     */
    public String updateClaimVoucher() {
        details = new HashSet<BIZ_CLAIM_VOUCHER_DETAIL>();//newһ��Set����
        Integer total_account = claimvoucher.getTotal_account();//���ҳ���޸ĺ���ܽ��
        claimvoucher = claimService.getClaimById(claimvoucher.getId());//ͨ��id�����ݿ��ҵ���ǰ��������
        claimvoucher.setTotal_account(total_account);//�õ�ǰҳ���޸ĺ���ܽ��������ݿ��б������ܽ��
        claimvoucher.setModify_time(new Date());//�޸ı�����ʱ��
        claimService.delDetail(claimvoucher.getId());
        if (detailList.size() > 0) {
            for (int i = 0; i < detailList.size(); i++) {
                //�������ͱ�������������˫�����,������Ҫ�������з��뱨��������
                detailList.get(i).setId(null);
                detailList.get(i).setBizClaimVoucher(claimvoucher);
                details.add(detailList.get(i));
            }
        }

        claimvoucher.setBizClaimVoucherDetails(details);
        int count = claimService.updateClaim(claimvoucher);
        if (count > 0) {
            return searchClaimVoucher();
        } else {
            return ERROR;
        }

    }

    /**
     * �Ӳ鿴ҳ���������ť��������ҳ��(claim_voucher_check.jsp)
     * @return
     */
    public String toCheck() {

        return "toCheck";
    }




    public BIZ_CLAIM_VOUCHER getClaimvoucher() {
        return claimvoucher;
    }
    public void setClaimvoucher(BIZ_CLAIM_VOUCHER claimvoucher) {
        this.claimvoucher = claimvoucher;
    }
    public ClaimService getClaimService() {
        return claimService;
    }
    public void setClaimService(ClaimService claimService) {
        this.claimService = claimService;
    }
    public EmployeeService getEmployeeService() {
        return employeeService;
    }
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Pager getPage() {
        return page;
    }
    public void setPage(Pager page) {
        this.page = page;
    }
    public SYS_EMPLOYEE getEmployee() {
        return employee;
    }
    public void setEmployee(SYS_EMPLOYEE employee) {
        this.employee = employee;
    }
    public Set<BIZ_CLAIM_VOUCHER_DETAIL> getDetails() {
        return details;
    }
    public void setDetails(Set<BIZ_CLAIM_VOUCHER_DETAIL> details) {
        this.details = details;
    }
    public List<BIZ_CLAIM_VOUCHER_DETAIL> getDetailList() {
        return detailList;
    }
    public void setDetailList(List<BIZ_CLAIM_VOUCHER_DETAIL> detailList) {
        this.detailList = detailList;
    }
}
