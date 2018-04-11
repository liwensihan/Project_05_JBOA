<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp" %>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script>
    $(function () {
        //日期选择控件
        $("#startDate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd', maxDate: '#F{$dp.$D(\'endDate\')}', isShowClear: true, readOnly: true});
        });
        $("#endDate").click(function () {
            WdatePicker({
                dateFmt: 'yyyy-MM-dd',
                minDate: '#F{$dp.$D(\'startDate\')}',
                isShowClear: true,
                readOnly: true
            });
        });
    });
    function delVoucher(id) {
        if (!confirm('确定删除报单吗')) return;

        document.claimvoucherForm.action = "claimVoucher_deleteclaimvoucherById.action?claimvoucher.id=" + id;
        document.claimvoucherForm.submit();

    }

</script>
<div class="action  divaction">
    <div class="t">报销单列表</div>
    <div class="pages">
        <div class="forms">
            <s:form action="claimVoucher_searchClaimVoucher.action" method="POST" name="queryForm">
                <label>报销单状态</label>
                <!-- 普通员工 -->
                <s:if test="#session.employee.position_id== 1">
                    <s:select name="status"
                              list="#{'新创建':'新创建','已提交':'已提交','已审批':'已审批','已打回':'已打回','已付款':'已付款','已终止':'已终止'}"
                              listKey="key" listValue="value" headerKey="0" headerValue="全部" theme="simple">
                    </s:select>
                </s:if>
                <s:if test="#session.employee.position_id== 2 ||#session.employee.position_id== 3">
                    <s:select name="status"
                              list="#{'已提交':'已提交','已审批':'已审批','已打回':'已打回','已付款':'已付款','已终止':'已终止'}"
                              listKey="key" listValue="value" headerKey="0" headerValue="全部" theme="simple">
                    </s:select>
                </s:if>
                <s:if test="#session.employee.position_id== 4">
                    <s:select name="status"
                              list="#{'已审批':'已审批'}"
                              listKey="key" listValue="value" headerKey="0" headerValue="全部" theme="simple">
                    </s:select>
                </s:if>
                <br>
                <label for="time">开始时间</label>
                <s:textfield name="startDate" id="startDate" cssClass="nwinput"></s:textfield>
                <label for="end-time">结束时间</label>
                <s:textfield name="endDate" id="endDate" cssClass="nwinput"></s:textfield>
                <input type="hidden" id="pageNo" name="page.pageNo" value="1"/>

                <input type="hidden" name="page.pageSize" value="5"/>
                <s:submit cssClass="submit_01" value="查询"/>
            </s:form>
            <input type="hidden" id="check" name="check" value="1"/>
        </div>
        <script>
            $(function(){
                $("#fy a").click(function(){
                    var pageNo = $(this).attr("pageNo");
                    $("#pageNo").val(pageNo);
                    if( $("#check").val()=="0"){
                        $("#pageNo").val("1");
                    }
                    $("[name=queryForm]").submit();
                })

                $("[name=status]").change(function(){
                    $("#check").val("0");
                });
            })
        </script>
        <!--增加报销单 区域 开始-->
        <s:form action="claimVoucher_searchClaimVoucher.action" name="claimvoucherForm">
            <table width="90%" border="0" cellspacing="0" cellpadding="0" class="list items">
                <tr class="even">
                    <td>编号</td>
                    <td>填报日期</td>
                    <td>填报人</td>
                    <td>总金额</td>
                    <td>状态</td>
                    <td>待处理人</td>
                    <td>操作</td>
                </tr>
                <s:iterator value="#session.voucherList" id="claimvoucher">
                    <tr>
                        <td>
                            <a href="claimVoucher_getClaimVoucherById.action?claimvoucher.id=<s:property value="#claimvoucher.id"/>"><s:property
                                    value="#claimvoucher.id"/></a></td>
                        <td><s:date name="#claimvoucher.create_time"/></td>
                        <td><s:property value="#claimvoucher.create.name"/></td>
                        <td><s:property value="#claimvoucher.total_account"/></td>
                        <td><s:property value="#claimvoucher.status"/></td>
                        <td><s:property value="#claimvoucher.next_deal.name"/></td>
                        <td>
                            <s:if test="#claimvoucher.status == '新创建' || #claimvoucher.status == '已打回'">
                                <!-- 修改报销单 -->
                                <a href="claimVoucher_toUpdate.action?claimvoucher.id=<s:property value="#claimvoucher.id"/>">
                                    <img src="${images}/edit.gif" width="16" height="16"/>
                                </a>
                                <!-- 删除报销单 -->
                                <a onClick="delVoucher(<s:property value="#claimvoucher.id"/>)" href="#">
                                    <img src="${images}/delete.gif" width="16" height="16"/>
                                </a>
                            </s:if>
                            <img src="${images}/save.gif" width="16" height="16"/>
                            <!-- 通过报销单id查询报销单明细信息 -->
                            <a href="claimVoucher_getClaimVoucherById.action?claimvoucher.id=<s:property value="#claimvoucher.id"/>">
                                <img src="${images}/search.gif" width="16" height="15"/>
                            </a>

                            <!-- 提交审批 -->
                            <s:if test="#claimvoucher.next_deal.name == #session.employee.name">
                                <s:if test="#claimvoucher.status == '已提交' || #claimvoucher.status == '侍审批' || #claimvoucher.status == '已审批'">
                                    <a href="claimVoucher_toCheck.action?claimvoucher.id=<s:property value="#claimvoucher.id"/>">
                                        <img src="${images}/sub.gif" width="16" height="16"/>
                                    </a>
                                </s:if>
                            </s:if>
                        </td>
                    </tr>
                </s:iterator>
                <tr>
                    <td colspan="6" align="center" id="fy">
                            <%--       <c:import url="rollPage.jsp" charEncoding="UTF-8">
                                       &lt;%&ndash;&lt;%&ndash; <c:param name="formName" value="document.forms[0]"/>
                                       <c:param name="totalRecordCount" value="${pageSupport.totalCount}"/>
                                       <c:param name="totalPageCount" value="${pageSupport.totalPageCount}"/>
                                       <c:param name="currentPageNo" value="${pageSupport.currPageNo}"/> &ndash;%&gt;&ndash;%&gt;
                                   </c:import>--%>
                                <a href=#" pageNo="1">首页</a>
                                <a href="#" pageNo="<s:property value="page.pageNo-1"/>">上一页</a>
                                <a href="#" pageNo="<s:property value="page.pageNo+1"/>">下一页</a>
                                <a href="#" pageNo="<s:property value="page.totalPage"/>">末页</a>

                    </td>
                </tr>
            </table>
        </s:form>
        <!--增加报销单 区域 结束-->

    </div>
</div>