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
	background-image: url("https://d2e70e9yced57e.cloudfront.net/wallethub/posts/58860/2019-best-worst-cities-at-money-management-og-image-.png");
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
	width: 70%;,
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
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
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

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
</style>

<link href="font-awesome.min.css" rel="stylesheet" type="text/css"
	media="all">
</head>
<h1>Your Money Manager</h1>
<h2>Add an Expense :</h2>

<body>
	<script type="text/javascript" src="resources/javascript.js">
		
	</script>
	<div style="text-align:center">  <button id="myBtn" class="button">Add Type</button></div>
	
<!-- 	<div id="form-box"> -->
		<form:form modelAttribute="transaction" action="/user-transaction/expense" method="get">
  <div>
    <span>Type:</span> 
      <form:select id="mysel" name="type" path="categoryListId" >
     <c:forEach items="${categoriesList}" var="categoriesList" >
     
         <form:option value="${categoriesList.getId()}">${categoriesList.getName()}</form:option>
      </c:forEach>
      </form:select>
  </div>
  
  <div>
    <span>Name:</span> <form:input path="note" type="text" name="item-name" placeholder="What did you spend on?"/>
  </div>
  
  <div>
    <span>Date:</span> <form:input type="date" path="date" name="date"/>
  </div>
  
  <div>
    <span>Amount:</span> <form:input type="number" path="amount" name="amount" placeholder="How much?"/>
  </div>
  <br>
  <br><center><input  type="submit" id="button" value="Add Expense">
  </center>
</form:form>
 
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

		</div> <script>
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
</script> 


</body>
</html>