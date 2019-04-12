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
<body>
<script type="text/javascript">

//jQuery

$(document).ready(function (){
  
  //Variable declarations that use or refer to jquery should be INSIDE the ready function to make sure jquery is instanciated. 
  $name = $('input[name="item-name"'); //notice the different declaration…
  $amount = $('input[name="amount"'); 
  $type = $('select[name="type"');
  $date = $('input[name="date"');
  
  var formatDate = function(d) {
    //2014-07-09
    var d = d.split('-');//Since we know the value comes yyyy-mm-dd…
    
    var dt = new Date(d[0],d[1],d[2]);//Note: The month is off by +1 - for JS Date object, 
    
    var formattedDate = '';
    
    var months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];//Now we can get the month like this:
    
    formattedDate += months[ dt.getMonth()-1 ]; //Months are 0-11 for getDate

    var formattedDay;//We are gonna store the formatted day here.
    
    switch( d[2].substring(1) ) {//We can use the string of the day (dd format) to access the last number, which determines what we append...
      case '1':
        formattedDay = parseInt(d[2]) + "st"; //1st, 21st, etc
        break;        
      case '2':
        formattedDay = parseInt(d[2]) + "nd"; //2nd
        break;        
      case '3':
        formattedDay = parseInt(d[2]) + "rd"; //etc…
        break;  
      default:
        formattedDay = parseInt(d[2]) + "th";
    }
    //Add a space and the day, now correctly appended
    formattedDate += ' ' + formattedDay;
    //Return nice formatted date!
    return formattedDate;
  }
  
  //Notice the $varname - Now each of these is is a jquery object corresponding to the DOM element and can be used to call the .val() method directly at any time. The way you had it before would only grab the value at the time of the declarations - ie before the values are set.
  
  $('#button').click(function () {
    // Making it always add a icon in the type row
    var type_icon; //Store the html fragment to a variable when needed.
    if ($type.val() == 'card') {
      type_icon = "<i class='fa fa-credit-card'></i>";
    } else if ($type.val() == 'cash') {
      type_icon = "<i class='fa fa-money'></i>";
    } else if ($type.val() == 'cryptocoin') {
      type_icon = "<i class='fa fa-bitcoin'></i>";
    } else if ($type.val() == 'other') {
      type_icon = "<i class='fa fa-question-circle'></i>";
    }
    
    var form_validated = true;
    //Add your validation tests, have them set form_validated to false if they fail
    //TODO
    
    if(form_validated) {
      //Now we can use our references we made before
      $("table tr:first").after('<tr><td>'+type_icon+'</td><td>'+$name.val()+'</td><td>'+formatDate($date.val())+'</td><td class="amount">$'+$amount.val()+'</td></tr>');
      $date.val(null);
      $amount.val(null);
      $name.val(null);
      $("#if-empty").remove();
    };
  });
  
});

</script>
<div id="form-box">
<form>
<!--   <center>
    <span>Category : </span> 
      <select name="type">
          <option value="Investment">Investment</option>
          <option value="Income">Income</option>
          <option value="Expense">Expense</option>
      </select>
  </center>
  <br> -->
  <div>
    <span>Type:</span> 
      <select name="type">
          <option value="card">Petrol</option>
          <option value="cash">Gold</option>
          <option value="cryptocoin">Share market</option>
          <option value="other">Other</option>
      </select>
  </div>
  
  <div>
    <span>Name:</span> <input type="text" name="item-name" placeholder="What did you spend on?">
  </div>
  
  <div>
    <span>Date:</span> <input type="date" name="date">
  </div>
  
  <div>
    <span>Amount:</span> <input type="number" name="amount" placeholder="How much?">
  </div>
  
</form>
</div>

<div id="button"><span>Done</span></div>

<table>
  <tr>
    <th id="type" class="center">type</th>
    <th>name</th>
    <th id="date">date</th>
    <th style="text-align: right" id="amount">amount</th>
  </tr>
  <tr id="if-empty">
    <td colspan="4"><span>Your added items will show up here!</span></td>
  </tr>

</table>
</body>
</html>