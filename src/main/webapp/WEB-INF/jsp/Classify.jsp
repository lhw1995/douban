<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>分类</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="../../css/Classify.css" />
<script src="../../js/Classify.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form id="form1" runat="server">
		<div></div>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
