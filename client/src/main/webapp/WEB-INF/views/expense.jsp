<!DOCTYPE html><%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<style>
@import
	url(https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400);

.d {
	height: 100%;
	font-size: 20px;
	font-family: Source Sans Pro;
}

#go {
	position: absolute;
	top: 30px;
	left: 50%;
	transform: translate(-50%, 0%);
	color: white;
	border: 0;
	background: #71c341;
	width: 100px;
	height: 30px;
	border-radius: 6px;
	font-size: 1rem;
	transition: background 0.2s ease;
	outline: none;
}

#go:hover {
	background: #8ecf68;
}

#go:active {
	background: #5a9f32;
}

.message {
	position: absolute;
	top: -200px;
	left: 50%;
	transform: translate(-50%, 0%);
	width: 300px;
	background: white;
	border-radius: 8px;
	padding: 30px;
	text-align: center;
	font-weight: 300;
	color: #2c2928;
	opacity: 0;
	padding: 30px;
	text-align: center;
	font-weight: 300;
	color: #2c2928;
	opacity: 0;
	transition: top 0.5s cubic-bezier(0.31, 0.25, 0.5, 1.5), opacity 0.2s
		ease-in-out;
}

.message .check {
	position: absolute;
	top: 0;
	left: 50%;
	transform: translate(-50%, 50%) scale(10);
	width: 120px;
	height: 110px;
	background: #71c341;
	color: white;
	font-size: 3.8rem;
	padding-top: 25px;
	border-radius: 50%;
	opacity: 0;
	transition: transform 0.2s 0.25s cubic-bezier(0.31, 0.25, 0.5, 1.5),
		opacity 0.1s 0.25s ease-in-out;
}

.message .scaledown {
	transform: translate(-50%, -50%) scale(1);
	opacity: 1;
}

.message p {
	font-size: 2.1rem;
	margin: 25px 0px;
	padding: 0;
}

.message button {
	background: #71c341;
	color: white;
	border: none;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
}

.message p:nth-child(2) {
	font-size: 2.3rem;
	margin: 40px 0px 0px 0px;
}

.comein {
	top: 150px;
	opacity: 1;
}
</style>
<script>
	window.console = window.console || function(t) {
	};
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<script>
	if (document.location.search.match(/type=embed/gi)) {
		window.parent.postMessage("resize", "*");
	}
</script>
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

input[type=number]::-webkit-inner-spin-button, input[type=number]::-webkit-outer-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}

h1, h2 {
	color: blue;
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
		url("https://d2e70e9yced57e.cloudfront.net/wallethub/posts/58860/2019-best-worst-cities-at-money-management-og-image-.png");
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
	color: #F5F7FA;
	padding: 20px;
	text-align: center;
	line-height: 24px;
	width: 200px;
	background-color: teal;
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

.button {
	position: relative;
	top: 0;
	color: #F5F7FA;
	padding: 20px;
	text-align: center;
	line-height: 24px;
	width: 200px;
	background-color: teal;
	border-radius: 3px;
	cursor: pointer;
	margin: auto;
	box-shadow: 0 3px #4A89DC;
	transition: 0.1s ease;
}

.button:active {
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

.alertInput {
	width: 70%; ,
	text-align: center;
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
	color: blue;
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

.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}
</style>
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.header {
	overflow: hidden;
	background-color: #2A201E;
	padding: 5px 10px;
}

.header a {
	float: left;
	color: white;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 18px;
	line-height: 55px;
	border-radius: 4px;
}

.header a.logo {
	font-size: 25px;
	font-weight: bold;
}

.header a:hover {
	background-color: white;
	color: green;
}

.header a.active {
	background-color: #2A201E;
	color: blue;
}

.header-right {
	float: right;
}

@media screen and (max-width: 500px) {
	.header a {
		float: none;
		display: block;
		text-align: left;
	}
	.header-right {
		float: none;
	}
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<body>
	<div class="header">
		<a href="/" class="logo"> <img
			src="data:image/png;base64,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"
			style="width: 250px; height: 60px;" />
		</a>
		<div class="header-right">
			<a href="/user-home"><i class="fas fa-home"></i> HOME</a> <a
				href="/user-reports"><span class="glyphicon glyphicon-stats"></span>
				REPORTS</a> <a href="/user-transaction/all-transactions"><i
				class="fas fa-history"></i> TRANSACTIONS</a>
		</div>
	</div>
</head>
<h1 style="color: blue">Your Money Manager</h1>
<h2 style="color: blue">Add an Expense :</h2>
<div style="text-align: center">
	<button id="myBtn" class="button">Add Type</button>
</div>
<c:if test="${sucess} != null">
	<input type="text" value="${sucess}">
</c:if>
<div id="form-box">
	<form:form modelAttribute="transaction"
		action="/user-transaction/expense" method="post">
		<div>
			<span>Type:</span>
			<form:select id="mysel" name="type" path="categoryListId">
				<c:forEach items="${categoriesList}" var="categoriesList">

					<form:option value="${categoriesList.getId()}">${categoriesList.getName()}</form:option>
				</c:forEach>
			</form:select>
		</div>

		<div>
			<span>Note:</span>
			<form:input path="note" type="text" name="item-name"
				placeholder="A quick note for expense?"  required="required" maxlength="50"/>
		</div>

		<div>
			<span>Date:</span>
			<form:input type="date" path="date" name="date" id=""  required="required"/>

		</div>

		<div>
			<span>Amount:</span>
			<c:forEach var="msg" items="${errorMsg}">
				<c:if test="${msg.getCode()=='MM0025'}">
					<spring:message code="error.${msg.getCode()}"></spring:message>
				</c:if>
			</c:forEach>
			<form:input type="number" path="amount" name="amount"
				placeholder="How much?" min="1" max="1000000" required="required"/>

		</div>
		<br>
		<br>
		<center>
			<input type="submit" id="button" value="Add Expense">
		</center>
	</form:form>
	<c:if test="${s==true}">
		<div class="d" translate="yes">

			<div class='message'>
				<div class='check'>&#10004;</div>
				<p>Success</p>
				<p>Your Expense Transaction added !</p>
				<button id="ok">OKAY</button>
			</div>
		</div>
		<script
		src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js"></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script id="rendered-js">
		$('#go').click(function() {
			go(50);
		});
		$('#ok').click(function() {
			go(500);
			location.reload(true);
		});

		setTimeout(function() {
			go(100);
		}, 700);
		/* setTimeout(function() {
			go(500);
		}, 3000);
 */
		function go(nr) {
			$('.bb').fadeToggle(200);
			$('.message').toggleClass('comein');
			$('.check').toggleClass('scaledown');
			$('#go').fadeToggle(nr);

		}

		//# sourceURL=pen.js
	</script>
	</c:if>
	
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<div style="text-align: center">
				<form action="/expense/category-list" method="get">
					<input class="alertInput" type="text" name="typeName"
						placeholder="Add new Type...." /><br> <input id="button"
						type="submit" value="add Type" />
				</form>
			</div>
		</div>

	</div>
	
	<script>
		// Get the modal
		var modal = document.getElementById('myModal');

		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks the button, open the modal 
		btn.onclick = function() {
			modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
		popup();
		function popup() {
			var i = $('#popup').val();
			console.log(i)
			if (i == 'ajith') {
				alert('sucess')
			}
		}
	</script>

</div>
</body>
</html>