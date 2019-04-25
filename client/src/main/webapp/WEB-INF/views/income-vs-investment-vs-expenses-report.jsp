

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="https://static.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" />
<link rel="mask-icon" type="" href="https://static.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" />
<title>INCOME VS INVESTMENT VS EXPENSESREPORT</title>
<script>
  window.console = window.console || function(t) {};
</script>
<script>
  if (document.location.search.match(/type=embed/gi)) {
    window.parent.postMessage("resize", "*");
  }
</script>
</head>
<body translate="no" bgcolor="#273746">
<canvas id="myChart" style="height: 500px; width: 100%;"></canvas>
<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js'></script>
<script id="rendered-js">
      var ctx = document.getElementById("myChart").getContext('2d');

var myChart = new Chart(ctx, {
	type: 'line',
	theme: "dark2",
  data: {
    labels: ["January", "February", "March", "April", "May", "June", "July", "August", "", "September","October","November","December"],
    datasets: [{
      label: 'INCOME', // Name the series
      data: ${report.getIncomeForYear()}, // Specify the data values array
      fill: false,
      borderColor: '#2196f3', // Add custom color border (Line)
      backgroundColor: '#2196f3', // Add custom color background (Points and Fill)
      borderWidth: 1 // Specify bar border width
    },
    {
      label: 'INVESTMENT', // Name the series
      data: ${report.getInvestmentForYear()}, // Specify the data values array
      fill: false,
      borderColor: '#4CAF50', // Add custom color border (Line)
      backgroundColor: '#4CAF50', // Add custom color background (Points and Fill)
      borderWidth: 1 // Specify bar border width
    },
    {
        label: 'EXPENSES', // Name the series
        data: ${report.getExpenseForYear()}, // Specify the data values array
        fill: false,
        borderColor: 'red', // Add custom color border (Line)
        backgroundColor: 'red', // Add custom color background (Points and Fill)
        borderWidth: 1 // Specify bar border width
      }
    ] },

  options: {
    responsive: true, // Instruct chart js to respond nicely.
    maintainAspectRatio: false // Add to prevent default behaviour of full-width/height 
  } });
      //# sourceURL=pen.js
    </script>
<script src="https://static.codepen.io/assets/editor/live/css_reload-5619dc0905a68b2e6298901de54f73cefe4e079f65a75406858d92924b4938bf.js"></script>
</body>
</html>
