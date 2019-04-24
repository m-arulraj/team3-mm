<!DOCTYPE html><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">

@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,600,300&subset=latin,latin-ext);
* {
  font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

h1, h2 {
  color: #F5F7FA;
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

  background-color : teal;

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
  background-color: #4FC1E9;
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
  font-size: 1.3em;
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

<link href="font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
</head>
<h1>Your Money Manager</h1>
<h2>Add an ${type} :</h2>

<body>
<script type="text/javascript" src="resources/javascript.js">
</script>
<div id="form-box">
<form:form modelAttribute="transaction" action="/user-transaction" method="get">
  <div>
    <span>Type:</span> 
      <form:select name="type" path="categoryListId">
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
  <br><input type="submit" id="button" value="save">
</form:form>
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