 <!DOCTYPE HTML>
<html>
<head>
<script>
window.onload = function() {

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "dark2", // "light1", "light2", "dark1", "dark2"
	title: {
		text: "INCOME vs INVESTMENT"
	},
	data: [{
		type: "pie",
		startAngle: 240,
		
		indexLabel: "{label} {y}",
		dataPoints: [
			{y: ${income}, label: "INCOME"},
	
			{y: ${investment}, label: "INVESTMENT"}
		]
	}]
});
chart.render();

}
</script>
</head>
<body bgcolor="teal">
<div id="chartContainer" style="height: 600px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>