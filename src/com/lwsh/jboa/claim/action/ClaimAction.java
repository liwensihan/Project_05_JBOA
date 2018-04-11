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

    private BIZ_CLAIM_VOUCHER claimvoucher;//报销单对象
    private SYS_EMPLOYEE employee;//员工对象
    private Pager page;//分页对象
    private Set<BIZ_CLAIM_VOUCHER_DETAIL> details;//报销单详细信息Set集合
    private List<BIZ_CLAIM_VOUCHER_DETAIL> detailList = new ArrayList<BIZ_CLAIM_VOUCHER_DETAIL>();//从前台接收的报销单详情List集合
    private ClaimService claimService;//报销单事务
    private EmployeeService employeeService;//员工事务
    private String status;//报销单状态
    private Date startDate;//开始时间
    private Date endDate;//结束时间

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
     * 从index.jsp跳到(claim_voucher_list.jsp)查看报销单
     * 查询改员工的所有报销单信息集合
     * 这里需要通过角色id做一个判断，若是role_id是员工就查询所有当前对象新建和审批打回的，审批通过的报销单信息。
     * 若是role_id是部门经理可以查看除了新创建以为的所有报销单
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
     * 从index.jsp跳到(claim_voucher_edit.jsp)添加报销单
     *
     * @return
     */
    public String toAdd() {

        return "toAdd";
    }

    /**
     * 添加报销单信息
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
                //报销单和报销单详情由于双向关联,所以先要将详情中放入报销单对象
                detailList.get(i).setBizClaimVoucher(claimvoucher);
                details.add(detailList.get(i));
            }
        }
        if (claimvoucher.getStatus().equals("新创建")) {
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
     * 通过id删除订单
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
     * 通过id获得员工对象信息，然后跳到(claim_voucher_view.jsp)查询报销单信息明细
     * 从(claim_voucher_list.jsp)
     *
     * @return
     */
    public String getClaimVoucherById() {
        claimvoucher = claimService.getClaimById(claimvoucher.getId());
        return "toView";
    }

    /**
     * 新创建或者审批被打回通过id获得员工对象信息，跳到(claim_voucher_update.jsp)去修改报销单信息
     * @return
     */
    public String toUpdate() {
        claimvoucher = claimService.getClaimById(claimvoucher.getId());
        return "toUpdate";
    }

    /**
     * 更新报销单对象
     * @return
     */
    public String updateClaimVoucher() {
        details = new HashSet<BIZ_CLAIM_VOUCHER_DETAIL>();//new一个Set集合
        Integer total_account = claimvoucher.getTotal_account();//获得页面修改后的总金额
        claimvoucher = claimService.getClaimById(claimvoucher.getId());//通过id从数据库找到当前订单对象
        claimvoucher.setTotal_account(total_account);//用当前页面修改后的总金额代替数据库中报销单总金额
        claimvoucher.setModify_time(new Date());//修改报销单时间
        claimService.delDetail(claimvoucher.getId());
        if (detailList.size() > 0) {
            for (int i = 0; i < detailList.size(); i++) {
                //报销单和报销单详情由于双向关联,所以先要将详情中放入报销单对象
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
     * 从查看页面的审批按钮跳到审批页面(claim_voucher_check.jsp)
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
