<!DOCTYPE html><%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<style type="text/css">
@import
	url(https://fonts.googleapis.com/css?family=Open+Sans:400,600,300&subset=latin,latin-ext)
	;

* {
	font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

h1, h2 {
	color: #BB29F8;
	text-align: center;
	
}

h1 {
	font-size: 2.5em;
	margin-top: 20px;
}

h2 {
	margin: 20px 0;
	font-weight: 100;
}

body {
	
	background-image:
		url("http://www.hdfs.ie/wp-content/uploads/2016/01/Protect.jpg");
	height: 100%;
	/* Center and scale the image nicely */
	background-repeat: no-repeat;
	background-size: cover;
}

table {
	text-align: left;
	width: 640px;
	margin: 30px auto;
	border-radius: 3px;
	background-color: #fff;
}

table th {
	padding: 10px;
}

table tr:nth-child(odd) {
	background-color: #F5F7FA;
}

table td {
	padding: 10px 15px;
	color: #434A54;
}

.amount {
	color: #DA4453;
	text-align: right;
}

#button {
	position: relative;
	top: 0;
	color: BLUE;
	padding: 20px;
	text-align: center;
	line-height: 24px;
	width: 200px;
	background-color: #EECEFB;
	border-radius: 3px;
	cursor: pointer;
	margin: auto;
	box-shadow: 0 3px #4A89DC;
	transition: 0.1s ease;
}

#button:active {
	position: relative;
	box-shadow: 0 0px #4A89DC;
	top: 3px;
	box-shadow: 0 0;
}

#form-box {
	width: 650px;
	margin: 30px auto;
	padding-left: 15px;
}

form {
	color: #fff;
	margin: auto;
}

form select, form input {
	margin-bottom: 25px;
	color: #434A54;
	padding: 10px;
	width: 200px;
	border-radius: 3px;
	border: 0;
}

form selectactive, form inputactive {
	border: 1px solid #4FC1E9;
	transition: 0.2s ease;
}

form div {
	display: inline-block;
	margin-right: 10px;
}

form span {
	color : blue;
	font-size: 1.5em;
	font-weight: 100;
	display: inline-block;
	width: 100px;
}

#type {
	width: 50px;
}

#date {
	width: 141px;
}

#amount {
	width: 100px;
}

#if-empty {
	text-align: center;
}

.center {
	margin: auto;
	text-align: center;
}
</style>

<link href="font-awesome.min.css" rel="stylesheet" type="text/css"
	media="all">
</head>
<h1 >Your Money Manager</h1>
<h2>Add an Income :</h2>

<body>
	<script type="text/javascript" src="resources/javascript.js">
		
	</script>
	<div id="form-box">
		<form>
			<div>
				<span >Type:</span> <select name="type">
					<option value="SELECT CATEGORY">SELECT CATEGORY</option>
					<c:forEach items="${categoriesList}" var="categoriesList">

						<option value="${categoriesList.getId()}">${categoriesList.getName()}</option>

					</c:forEach>
				</select>
			</div>

			<div>
				<span>Note:</span> <input type="text" name="item-name"
					placeholder="What did you spend on?">
			</div>

			<div>
				<span>Date:</span> <input type="date" name="date">
			</div>

			<div>
				<span>Amount:</span> <input type="number" name="amount"
					placeholder="How much?">
			</div>

		</form>
	</div>

	<div id="button">
		<span>Done</span>
	</div>

	<!-- <table>
  <tr>
    <th id="type" class="center">type</th>
    <th>name</th>
    <th id="date">date</th>
    <th style="text-align: right" id="amount">amount</th>
  </tr>
  <tr id="if-empty">
    <td colspan="4"><span>Your added items will show up here!</span></td>
  </tr>

</table> -->
<br><br><br><br>
<div class="container">
  <div class="progress" style="height:50px">
    <div class="progress-bar bg-success" style="width:40%">
      Income(40)
    </div>
    <div class="progress-bar bg-warning" style="width:30%">
      Expense(30)
    </div>
    <div class="progress-bar bg-danger" style="width:30%">
      Investment(30)
    </div>
  </div>
</div>
</body>
</html>