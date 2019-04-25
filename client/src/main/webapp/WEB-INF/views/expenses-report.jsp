<!DOCTYPE HTML><%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head> 

</head>
<body bgcolor="teal"> 
<div id="chartContainer" style="height: 600px; width: 100%;"></div><script>
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
			<c:forEach items="${fullExpense}" var="expense" >
	     
			{ y: ${expense.value} , label: "${expense.key}" },
     </c:forEach>    
			
		]
	}]
});
chart.render();

}
</script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>