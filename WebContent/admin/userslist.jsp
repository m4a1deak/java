<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.util.*"%>
<%@ page import="com.model.*"%>
<%@ page import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	Pagination p = (Pagination)request.getAttribute("page");
	int totleNum = p.getTotle();
	int totlePage = p.getTotlePage();
	int currentPage = p.getIndex();
	List list = p.getData();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(<%=path %>/images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid
}
.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
}
.cmdField {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(<%=path %>/images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(<%=path %>/images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(<%=path %>/images/bg.gif); BACKGROUND-REPEAT: repeat-x">
<SCRIPT type=text/javascript>
//<![CDATA[
var theForm = document.forms['aspnetForm'];
if (!theForm) {
    theForm = document.aspnetForm;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</SCRIPT>
<script type="text/javascript">
        
        function frist()
		{
		 	with (document.getElementById("memberForm")) {
	            method = "post";
	            action = "<%=path %>/usersmana.action?index=1";
	            submit();
	        }
		}
        
        
		function back()
		{
		    var pageNo= '<%=currentPage%>';
		    if(pageNo<2){
		 	   alert("当前已经是第一页");
		 	   return;
		    }else{
		 	   pageNo=Number(pageNo)-1;
		    }
				 with (document.getElementById("memberForm")) {
			            method = "post";
			             action = "<%=path %>/usersmana.action?index="+pageNo;
			            submit();
			        }
		}
        
		function next()
		{
			   var pageNo= '<%=currentPage%>';
			   var totlePage='<%=totlePage%>';
		    if(pageNo==totlePage){
		 	   alert("当前已经是最后一页");
		 	   return;
		    }else{
		 	   pageNo=Number(pageNo)+1;
		    }  
		    with (document.getElementById("memberForm")) {
		        method = "post";
		        action = "<%=path %>/usersmana.action?index="+pageNo;
		        submit();
		    }
		}
        
        function last()
		{ 
		   var totlePage='<%=totlePage%>';
			with (document.getElementById("memberForm")) {
	            method = "post";
	            action = "<%=path %>/usersmana.action?index="+totlePage;
	            submit();
	        }
		}
		
		function search2()
		{
			with (document.getElementById("memberForm")) {
	            method = "post";
	            action = "<%=path %>/usersmana.action?index=1";
	            submit();
	        }
		}
	
		function modify(id){
			window.location.href="<%=path %>/usersmodifybefore.action?id="+id;
		}
		function bmyg(id){
			window.location.href="<%=path %>/bmygmana.action?bmid="+id;
		}
		function del(id){
			window.location.href="<%=path %>/usersdel.action?id="+id;
		}
		</script>
<SCRIPT src="<%=path %>/images/WebResource.axd" type=text/javascript></SCRIPT>
<SCRIPT src="<%=path %>/images/ScriptResource.axd" 
type=text/javascript></SCRIPT>
<SCRIPT 
src="C:\Documents and Settings\Administrator\桌面\MyOffice 首页.files\EmployeeMgr.files\ScriptResource(1).axd" 
type=text/javascript></SCRIPT>
<DIV>
<form id="memberForm">
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR 
  style="BACKGROUND-IMAGE: url(<%=path %>/images/bg_header.gif); BACKGROUND-REPEAT: repeat-x" 
  height=47>
        <TD width=10><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(<%=path %>/images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(<%=path %>/images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN 
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(<%=path %>/images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">人员列表 </SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(<%=path %>/images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD 
    style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(<%=path %>/images/main_rc.gif)" 
    width=10></TD>
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(<%=path %>/images/main_ls.gif)">&nbsp;</TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align=middle>
   姓名<input type="text" id="realname" name="realname">
   <A class=cmdField 
            href="#" onclick="search2()">查询</A>
          <DIV>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
               <TBODY>
                <TR>
                  <TH class=gridViewHeader scope=col >工号</TH>
                  <TH class=gridViewHeader scope=col >密码</TH>
                   <TH class=gridViewHeader scope=col >姓名</TH>
                    <TH class=gridViewHeader scope=col >电话</TH>
                     <TH class=gridViewHeader scope=col >科室</TH>
                  <TH class=gridViewHeader scope=col width="10%">修改</TH>
                  <TH class=gridViewHeader scope=col width="10%">删除</TH>
                </TR>
                
                <%
			for(int i = 0;i<list.size();i++){
				Users bean = (Users)list.get(i);
			%>
                
                <TR>
                  <TD class=gridViewItem><%=bean.getNo()%></TD>
                   <TD class=gridViewItem><%=bean.getPassword()%></TD>
                   <TD class=gridViewItem><%=bean.getRealname()%></TD>
                    <TD class=gridViewItem><%=bean.getTel()%></TD>
                     <TD class=gridViewItem><%=bean.getKsnames()%></TD>
                  <TD class=gridViewItem><A class=cmdField 
            href="#" onclick="modify(<%=bean.getId()%>)">修改</A></TD>
                  <TD class=gridViewItem><A class=cmdField 
            id=ctl00_ContentPlaceHolder2_GridView1_ctl02_LinkButton1 
            onclick="del(<%=bean.getId()%>)" 
            href="#" >删除</A> </TD>
                </TR>
                <%} %>
              </TBODY>
            </TABLE>
            当前第<%=currentPage %>页/共<%=totlePage %>页&nbsp;&nbsp;共<%=totleNum %>条记录&nbsp;&nbsp;
           <A class=cmdField 
            href="#" onclick="frist()">首页</A>
             <A class=cmdField 
             href="#" onclick="back()">上一页</A>
             <A class=cmdField 
             href="#" onclick="next()">下一页</A>
             <A class=cmdField 
             href="#" onclick="last()">尾页</A>
          </DIV>
        </TD>
        <TD style="BACKGROUND-IMAGE: url(<%=path %>/images/main_rs.gif)"></TD>
      </TR>
      <TR 
  style="BACKGROUND-IMAGE: url(<%=path %>/images/main_fs.gif); BACKGROUND-REPEAT: repeat-x" 
  height=10>
        <TD style="BACKGROUND-IMAGE: url(<%=path %>/images/main_lf.gif)"></TD>
        <TD style="BACKGROUND-IMAGE: url(<%=path %>/images/main_fs.gif)"></TD>
        <TD 
style="BACKGROUND-IMAGE: url(<%=path %>/images/main_rf.gif)"></TD>
      </TR>
    </TBODY>
  </TABLE>
  </form>
</DIV>
</BODY>
</HTML>



