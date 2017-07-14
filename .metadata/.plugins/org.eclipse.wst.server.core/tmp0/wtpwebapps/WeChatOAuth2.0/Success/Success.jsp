<%@page import="com.wechat.https.UserInformationBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		UserInformationBean userInformationBean = (UserInformationBean) request.getAttribute("userInformation");
	%>

	<table border=1px>
		<tr>
			<td>昵称</td>
			<td>
				<%
					userInformationBean.getNickname();
				%>
			</td>
		</tr>

		<tr>
			<td>性别</td>
			<td>
				<%
					userInformationBean.getSex();
				%>
			</td>
		</tr>
		<tr>
		<tr>
			<td>头像</td>
			<td>
				<%
					userInformationBean.getHeadimgurl();
				%>
			</td>
		</tr>

		<tr>
			<td>ID号</td>
			<td>
				<%
					userInformationBean.getOpenid();
				%>
			</td>
		</tr>

		<tr>
			<td>国家</td>
			<td>
				<%
					userInformationBean.getCountry();
				%>
			</td>
		</tr>


		<tr>
			<td>省份</td>
			<td>
				<%
					userInformationBean.getProvince();
				%>
			</td>
		</tr>


		<tr>
			<td>绑定号</td>
			<td>
				<%
					userInformationBean.getUnionid();
				%>
			</td>
		</tr>

		<tr>
			<td>特权</td>
			<td>
				<%userInformationBean.getPrivilege(); %>
			</td>
		</tr>

	</table>


</body>
</html>