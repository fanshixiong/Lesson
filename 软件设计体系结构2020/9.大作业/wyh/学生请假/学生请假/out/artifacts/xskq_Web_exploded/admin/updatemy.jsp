<%@include file="/common/sub_header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.util.*,java.sql.*,com.www.db.*" pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");

	String userPw = request.getParameter("userPw");

 

	DBManager dbm = new DBManager();
	String sql = "update admin set userPw='" + userPw + "' where id=" + id;
	System.out.println(sql);

	Statement stat = null;
	Connection conn = null;
	try {
		conn = dbm.getConnection();
		stat = conn.createStatement();
		stat.execute(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			if (stat != null)
				stat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	response.sendRedirect("modMyAdmin.jsp");
%>
