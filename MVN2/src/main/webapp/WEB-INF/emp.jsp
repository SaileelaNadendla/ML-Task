<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.util.*"%>
	<%@ page import="javax.sql.*;"%>
	<%
	java.sql.Connection con;
	java.sql.Statement s;
	java.sql.ResultSet rs;
	java.sql.PreparedStatement pst;

	con = null;
	s = null;
	pst = null;
	rs = null;

	// Remember to change the next line with your own environment
	String url = "jdbc:sqlserver://localhost\\\\BHAVNAWKS774;databaseName=saiDB;portNumber=1433";
	String username = "sa";
	String pass = "Bhavna@123";
	try {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = java.sql.DriverManager.getConnection(url, username, pass);

	} catch (ClassNotFoundException cnfex) {
		cnfex.printStackTrace();

	}
	String sql = "select * from EMP";
	try {
		s = con.createStatement();
		rs = s.executeQuery(sql);
	%>

	<%
	while (rs.next()) {
	%><tr>
		<td><%=rs.getString("empid")%></td>
		<td><%=rs.getString("eName")%></td>
		<td><%=rs.getString("esal")%></td>
		<td><%=rs.getString("doj")%></td>
		<td><%=rs.getString("deptid")%></td>
		<td><%=rs.getString("status")%></td>
		
	</tr>
	<%
	}
	%>

	<%
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	if (rs != null)
		rs.close();
	if (s != null)
		s.close();
	if (con != null)
		con.close();
	}
	%>
</body>
</html>