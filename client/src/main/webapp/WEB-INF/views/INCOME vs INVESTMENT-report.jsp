<!-- <!DOCTYPE html>
<html lang="en">
<head>
<title>EXPENSES</title>
<style>
#chartdiv {

  width: 100%;
  height: 600px;
  background-color : teal;
}

</style>

Resources
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>

Chart code
<script>
am4core.ready(function() {

// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

// Create chart instance
var chart = am4core.create("chartdiv", am4charts.PieChart);

// Add data
chart.data = [ 
{
  "country": "INCOME",
  "litres": 55
}, {
  "country": "INVESTMENT",
  "litres": 45
}];

// Add and configure Series
var pieSeries = chart.series.push(new am4charts.PieSeries());
pieSeries.dataFields.value = "litres";
pieSeries.dataFields.category = "country";
pieSeries.slices.template.stroke = am4core.color("#8E44AD");
pieSeries.slices.template.strokeWidth = 2;
pieSeries.slices.template.strokeOpacity = 1;

// This creates initial animation
pieSeries.hiddenState.properties.opacity = 1;
pieSeries.hiddenState.properties.endAngle = -90;
pieSeries.hiddenState.properties.startAngle = -90;

}); // end am4core.ready()
</script>
</head>
<body>
<div id="chartdiv" title="Expenses"></div>
</body>
</html>
 -->
 <!DOCTYPE HTML>
<html>
<head>
<script>
window.onload = function() {

var chart = new CanvasJS.Chart("chartContainer", {
	theme: "dark2", // "light1", "light2", "dark1", "dark2"
	exportEnabled: true,
	animationEnabled: true,
	title: {
		text: "INCOME vs INVESTMENT"
	},
	data: [{
		type: "pie",
		startAngle: 25,
		toolTipContent: "<b>{label}</b>: {y}%",
		showInLegend: "true",
		legendText: "{label}",
		indexLabelFontSize: 16,
		indexLabel: "{label} = {y}%",
		dataPoints: [
			{ y: 51.08, label: "Income" },
	
			{ y: 45.44, label: "Investment" }
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