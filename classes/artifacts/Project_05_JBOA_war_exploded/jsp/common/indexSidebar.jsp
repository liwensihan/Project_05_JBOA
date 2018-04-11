<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="taglib.jsp"%>
<div class="nav" id="nav">
		<div class="t"></div>
		<c:forEach items="${treeList}" var="parent">
	   		<dl class="open">
		       	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">${parent.text}</dt>
		        <c:forEach items="${parent.treeNode}" var="child">
		        	<dd><a href="${child.url}">${child.text}</a></dd>
		    	</c:forEach>  
		    </dl>
	    </c:forEach>
</div>