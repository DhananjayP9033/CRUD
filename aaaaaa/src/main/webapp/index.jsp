<%@page import="com.model.Employee"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

.container {
	position: relative;
	height: 10vh;
}

.create-user-btn {
	position: absolute;
	top: 10px;
	right: 10px;
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.show-user-btn {
	position: absolute;
	top: 10px;
	left: 10px;
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.delete-user-btn {
	padding: 5px 10px;
	background-color: #ff003e;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.edit-user-btn {
	padding: 5px 10px;
	background-color: #00c3ff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

table, td, th {
	border: 1px solid #ddd;
	text-align: left;
}

table {
	top-margin: 10px;
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 15px;
}
</style>

</head>
<body>
	<%
	String msg = "";
	ArrayList<Employee> arr = null;
	//System.out.println(session.getAttribute("policydetails"));
	//System.out.println(session.getAttribute("errmsg"));
	if (session.getAttribute("user-details") != null) {
		arr = (ArrayList<Employee>) session.getAttribute("user-details");
		System.out.println("you got details of Users");
		//session.removeAttribute("policydetails");
	}
	
	String deletedSuccessfully = "";
	String pagerr = "";

	if (request.getAttribute("msg") != null) {

		deletedSuccessfully = (String) request.getAttribute("msg");
		request.removeAttribute("msg");
	}

	if (request.getAttribute("error") != null) {
		pagerr = (String) request.getAttribute("error");
		request.removeAttribute("error");
	}
	
	%>

	<div class="container">
		<form action="ABCDE" method="post">
			<button class="create-user-btn">Create User</button>

		</form>
		

		<form action="findAllUser" method="post">
			<button class="show-user-btn">Show User</button>
		</form>
	</div>
	<%
		if (!deletedSuccessfully.isEmpty()) {
		%>
		<div class="msgdiv" style="color:blue; margin: 0 auto; width:10% vw"
			style="background-color: #00800033; color: darkgreen;">
			<%=deletedSuccessfully%>
		</div>
		<%
		} else if (!pagerr.isEmpty()) {
		%>
		<div class="msgdiv"
			style="background-color: #ff00004a; color: darkred;">
			<%=pagerr%>
		</div>
		<%
		}
		%>
	<div class=user-details>
		<%
		if (arr != null) {
		%>
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email Id</th>
				<th>Mobile Number</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<%
			for (int i = 0; i < arr.size(); i++) {
				int id = arr.get(i).getId();
				String name = arr.get(i).getName();
				String emailId = arr.get(i).getEmailId();
				String mobileNo = arr.get(i).getMoNumber();
			%>
			<tr>
				<td><%=id%></td>
				<td><%=name%></td>
				<td><%=emailId%></td>
				<td><%=mobileNo%></td>
				
				<td><form action="editUser" method="post">
						<input type="hidden" name="variable1" value=<%=id%>>
						<input type="hidden" name="variable2" value=<%=name%>>
						<input type="hidden" name="variable3" value=<%=emailId%>>
						<input type="hidden" name="variable4" value=<%=mobileNo%>>
						<button class="edit-user-btn">Edit</button>
					</form>
				</td>
					
				<td><form action="deleteUser" method="post">
						<input type="hidden" name="variable1" value=<%=id%>>
						<button class="delete-user-btn">Delete</button>
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>
	
	
<script>
	let msgdiv = document.getElementsByClassName("msgdiv")
	if(msgdiv != null && msgdiv.length > 0){
		console.log(msgdiv)
		setTimeout(() => {
			msgdiv[0].style.display = "none";
			window.location.href = "./index.jsp";
		}, 8000)
	}
</script>
</body>
</html>