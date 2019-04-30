<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
	line-height: 25px;
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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Transactions</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-image:
		url("http://3.bp.blogspot.com/-7_SL72jHg-Y/ThFs5MwZUBI/AAAAAAAAAJ8/GLV1x9j__8I/s400/blue-serenity-animated-wavy+2.gif");
	height: 100%;
	/* Center and scale the image nicely */
	background-repeat: no-repeat;
	background-size: cover;
	font-family: 'Roboto', sans-serif;
}

.table-wrapper {
	background: #fff;
	padding: 20px;
	margin: 30px 0;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	padding-bottom: 10px;
	margin: 0 0 10px;
}

.table-title h2 {
	margin: 8px 0 0;
	font-size: 22px;
}

.search-box {
	position: relative;
	float: right;
}

.search-box input {
	height: 34px;
	border-radius: 20px;
	padding-left: 35px;
	border-color: #ddd;
	box-shadow: none;
}

.search-box input:focus {
	border-color: #3FBAE4;
}

.search-box i {
	color: #a0a5b1;
	position: absolute;
	font-size: 19px;
	top: 8px;
	left: 10px;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table td:last-child {
	width: 130px;
}

table.table td a {
	color: #a0a5b1;
	display: inline-block;
	margin: 0 5px;
}

table.table td a.view {
	color: #03A9F4;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #E34724;
}

table.table td i {
	font-size: 19px;
}

.pagination {
	float: right;
	margin: 0 0 5px;
}

.pagination li a {
	border: none;
	font-size: 95%;
	width: 30px;
	height: 30px;
	color: #999;
	margin: 0 2px;
	line-height: 30px;
	border-radius: 30px !important;
	text-align: center;
	padding: 0;
}

.pagination li a:hover {
	color: #666;
}

.pagination li.active a {
	background: #03A9F4;
}

.pagination li.active a:hover {
	background: #0397d6;
}

.pagination li.disabled i {
	color: #ccc;
}

.pagination li i {
	font-size: 16px;
	padding-top: 6px
}

.hint-text {
	float: left;
	margin-top: 6px;
	font-size: 95%;
}
</style>

<style type="text/css">
    body {
		font-family: 'Varela Round', sans-serif;
	}
	.modal-confirm {		
		color: #636363;
		width: 400px;
	}
	.modal-confirm .modal-content {
		padding: 20px;
		border-radius: 5px;
		border: none;
        text-align: center;
		font-size: 14px;
	}
	.modal-confirm .modal-header {
		border-bottom: none;   
        position: relative;
	}
	.modal-confirm h4 {
		text-align: center;
		font-size: 26px;
		margin: 30px 0 -10px;
	}
	.modal-confirm .close {
        position: absolute;
		top: -5px;
		right: -2px;
	}
	.modal-confirm .modal-body {
		color: #999;
	}
	.modal-confirm .modal-footer {
		border: none;
		text-align: center;		
		border-radius: 5px;
		font-size: 13px;
		padding: 10px 15px 25px;
	}
	.modal-confirm .modal-footer a {
		color: #999;
	}		
	.modal-confirm .icon-box {
		width: 80px;
		height: 80px;
		margin: 0 auto;
		border-radius: 50%;
		z-index: 9;
		text-align: center;
		border: 3px solid #f15e5e;
	}
	.modal-confirm .icon-box i {
		color: #f15e5e;
		font-size: 46px;
		display: inline-block;
		margin-top: 13px;
	}
    .modal-confirm .btn {
        color: #fff;
        border-radius: 4px;
		background: #60c7c1;
		text-decoration: none;
		transition: all 0.4s;
        line-height: normal;
		min-width: 120px;
        border: none;
		min-height: 40px;
		border-radius: 3px;
		margin: 0 5px;
		outline: none !important;
    }
	.modal-confirm .btn-info {
        background: #c1c1c1;
    }
    .modal-confirm .btn-info:hover, .modal-confirm .btn-info:focus {
        background: #a8a8a8;
    }
    .modal-confirm .btn-danger {
        background: #f15e5e;
    }
    .modal-confirm .btn-danger:hover, .modal-confirm .btn-danger:focus {
        background: #ee3535;
    }
	.trigger-btn {
		display: inline-block;
		margin: 100px auto;
	}
</style>



<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
 <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="http://johannburkard.de/resources/Johann/jquery.highlight-5.js"></script>
</head>
<body>
	<div class="header">
  <a href="/" class="logo"><img src="data:image/png;base64,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" style="width:250px;height:60px;"/>
  </a>
  <div class="header-right">
    <a href="/user-home">HOME</a>
    <a href="/user-reports">REPORTS</a>
  </div>
</div>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-8">
						<h2>
							User <b>Transactions</b>
						</h2>
					</div>

					<div class="col-sm-4">
						<div class="search-box">
							<i class="material-icons">&#xE8B6;</i> <input class="form-control" id="myInput" type="text" placeholder="Search..">
						</div>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<%!int data = 1;%>
					<tr>
						<th>#</th>
						<th align="center">TYPE</th>
						<th align="center">AMOUNT</th>
						<th align="center">DATE</th>
						<th align="center">NOTE</th>
						<th align="center">CATEGORY</th>
						<th align="center">Actions</th>
					</tr>
				</thead>
				<tbody id="myTable">
			
					<c:forEach items="${transactionsList}" var="transactionsList">
						<tr>
							
							<td><%=data%></td>
							<td>${transactionsList.getCategoryList().getName()}</td>
							<td>${transactionsList.getAmount()}</td>
							<td>${transactionsList.getDate()}</td>
							<td>${transactionsList.getNote()}</td>
							<td>${transactionsList.getCategoryList().getCategory().getCategory()}</td>
								
							<td>
							<a  href="/user-transaction/update-transaction?id=${transactionsList.getId()}" class="edit" title="Edit"
							
								data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>	
														
								<a href="#myModal" class="trigger-btn" data-toggle="modal"  title="Delete" ><i
									class="material-icons">&#xE872;</i></a>
									</td>
									
						</tr>
							<%data++;%>
							<div id="myModal" class="modal fade">
	<div class="modal-dialog modal-confirm">
		<div class="modal-content">
			<div class="modal-header">
				<div class="icon-box">
					<i class="material-icons">&#xE5CD;</i>
				</div>				
				<h4 class="modal-title">Are you sure?</h4>	
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<p>Do you really want to delete this record? This process cannot be undone.</p>
			</div>
			<div class="modal-footer" align="left">
				<button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
				<button onclick="window.location.href = '/user-transaction/delete-transaction?id=${transactionsList.getId()}';" type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
	</div>
</div>   	
					</c:forEach>
				<%data = 1;%>
				</tbody>
			</table>

		</div>
	</div>

<!-- Modal HTML -->

	
	<script type="text/javascript">
	$('#myInput').click(function(){
		$('#myTable').removeHighlight().highlight($('#myInput').val());
	})
</script>
	<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
</body>
</html>
