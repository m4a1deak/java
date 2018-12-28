<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userType = session.getAttribute("userType").toString();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN">
<HTML><HEAD><TITLE>华中师范大学校医院绩效考勤管理</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.5848" name=GENERATOR></HEAD><FRAMESET id=index 
border=0 frameSpacing=0 rows=120,* frameBorder=no><FRAME id=topFrame 
name=topFrame src="<%=path %>/admin/top.jsp" noResize scrolling=no><FRAMESET 
border=0 frameSpacing=0 frameBorder=no cols=20%,*>

<%if(userType.equals("1")){ %>

<FRAME id=leftFrame name=leftFrame src="<%=path %>/admin/left.jsp" noResize scrolling=no>
<%}else{ %>
<FRAME id=leftFrame name=leftFrame src="<%=path %>/admin/left2.jsp" noResize scrolling=no>
<%} %>
<FRAME id=mainFrame name=mainFrame src="" noResize 
scrolling=no></FRAMESET></FRAMESET><noframes></noframes></HTML>
