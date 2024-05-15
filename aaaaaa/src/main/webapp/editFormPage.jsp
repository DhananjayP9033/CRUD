<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.container {
	max-width: 400px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

.form-group input[type="text"] {
	width: 100%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

.btn-submit {
	display: block;
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btn-submit:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<%
	String addedSuccessfully = "";
	String pagerr = "";

	if (request.getAttribute("msg") != null) {

		addedSuccessfully = (String) request.getAttribute("msg");
		request.removeAttribute("msg");
	}

	if (request.getAttribute("error") != null) {
		pagerr = (String) request.getAttribute("error");
		request.removeAttribute("error");
	}

	//int var1 = Integer.parseInt((String) request.getAttribute("var1"));
	
	 String string1= request.getAttribute("var1").toString();
	 int var1 = Integer.parseInt(string1);
	
	
	
	String var2 = (String) request.getAttribute("var2");
	String var3 = (String) request.getAttribute("var3");
	String var4 = (String) request.getAttribute("var4");
	
	%>


	<div class="container">
		<h2>Edit Form</h2>
		<form action="updateUser" method="POST">
			<div class="form-group">
				<input type="text" id="username" name="id" value=<%=var1%> readonly>
			</div>

			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					id="username" name="username" value="<%=var2%>" required>
			</div>
			<div class="form-group">
				<label for="email">Email Id</label> <input type="text" id="email"
					name="email" value="<%=var3%>" required>
			</div>
			<div class="form-group">
				<label for="mobile">Mobile Number</label> <input type="text"
					id="mobile" name="mobile" value="<%=var4%>" required>
			</div>
			<button type="submit" class="btn-submit">Submit</button>
		</form>



		<%
		if (!addedSuccessfully.isEmpty()) {
		%>
		<div class="msgdiv"
			style="background-color: #00800033; color: darkgreen;">
			<%=addedSuccessfully%>
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
	</div>

	<script>
	let msgdiv = document.getElementsByClassName("msgdiv")
	if(msgdiv != null && msgdiv.length > 0){
		console.log(msgdiv)
		setTimeout(() => {
			msgdiv[0].style.display = "none";
			window.location.href = "./formPage.jsp";
		}, 8000)
	}
</script>
</body>
</html>



