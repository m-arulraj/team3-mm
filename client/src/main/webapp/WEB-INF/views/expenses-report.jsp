<!DOCTYPE HTML><%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head> 
<script>
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "dark2", // "light1", "light2", "dark1", "dark2"
	title:{
		text: "EXPENSES-REPORT"
	},
	axisY: {
		title: "AMOUNT"
	},
	data: [{        
		type: "column",  
		showInLegend: true, 
		legendMarkerColor: "grey",
		legendText: "TYPE OF EXPENSE",
		dataPoints: [  
			/* <c:forEach items="${fullExpense}" var="expense" >
	     
			{ y: ${expense.key}, label: "${expense.value}" },
     </c:forEach>   */  
			
			{ y: 266455,  label: "jabdja" },
			{ y: 169709,  label: "RENT OF A PROPERTY" },
			{ y: 158400,  label: "RENT OF A VEHICLE" },
			{ y: 142503,  label: "FUEL" },
			{ y: 101500, label: "MEDICAl" },
			{ y: 97800,  label: "TRAVELING" },
			{ y: 80000,  label: "CHILDERNS" }
		]
	}]
});
chart.render();

}
</script>
</head>
<body bgcolor="teal"> ${name}
<div id="chartContainer" style="height: 600px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>