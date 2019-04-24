<!DOCTYPE html><%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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
	color: white;
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
		url("data:image/jpeg;base64,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");
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
	color: white;
	padding: 20px;
	text-align: center;
	line-height: 24px;
	width: 200px;
	background-color:#1F6FF9;
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
	color: white;
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
<h1>Your Money Manager</h1>
<h2>Add an Investment :</h2>

<body>
	<script type="text/javascript" src="resources/javascript.js">
		
	</script>
	<div id="form-box">
		<form>
			<div>
				<span>Type:</span> <select name="type">
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
		<span>INEVST</span>
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
</body>
</html>