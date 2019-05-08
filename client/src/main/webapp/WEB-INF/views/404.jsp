

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>MoneyManager - 404 Page - Lost In Space</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
      /*
VIEW IN FULL SCREEN MODE
FULL SCREEN MODE: http://salehriaz.com/404Page/404.html

DRIBBBLE: https://dribbble.com/shots/4330167-404-Page-Lost-In-Space
*/

@import url('https://fonts.googleapis.com/css?family=Dosis:300,400,500');

@-moz-keyframes rocket-movement { 100% {-moz-transform: translate(1200px,-600px);} }
@-webkit-keyframes rocket-movement {100% {-webkit-transform: translate(1200px,-600px); } }
@keyframes rocket-movement { 100% {transform: translate(1200px,-600px);} }
@-moz-keyframes spin-earth { 100% { -moz-transform: rotate(-360deg); transition: transform 20s;  } }
@-webkit-keyframes spin-earth { 100% { -webkit-transform: rotate(-360deg); transition: transform 20s;  } }
@keyframes spin-earth{ 100% { -webkit-transform: rotate(-360deg); transform:rotate(-360deg); transition: transform 20s; } }

@-moz-keyframes move-astronaut {
    100% { -moz-transform: translate(-160px, -160px);}
}
@-webkit-keyframes move-astronaut {
    100% { -webkit-transform: translate(-160px, -160px);}
}
@keyframes move-astronaut{
    100% { -webkit-transform: translate(-160px, -160px); transform:translate(-160px, -160px); }
}
@-moz-keyframes rotate-astronaut {
    100% { -moz-transform: rotate(-720deg);}
}
@-webkit-keyframes rotate-astronaut {
    100% { -webkit-transform: rotate(-720deg);}
}
@keyframes rotate-astronaut{
    100% { -webkit-transform: rotate(-720deg); transform:rotate(-720deg); }
}

@-moz-keyframes glow-star {
    40% { -moz-opacity: 0.3;}
    90%,100% { -moz-opacity: 1; -moz-transform: scale(1.2);}
}
@-webkit-keyframes glow-star {
    40% { -webkit-opacity: 0.3;}
    90%,100% { -webkit-opacity: 1; -webkit-transform: scale(1.2);}
}
@keyframes glow-star{
    40% { -webkit-opacity: 0.3; opacity: 0.3;  }
    90%,100% { -webkit-opacity: 1; opacity: 1; -webkit-transform: scale(1.2); transform: scale(1.2); border-radius: 999999px;}
}

.spin-earth-on-hover{
    
    transition: ease 200s !important;
    transform: rotate(-3600deg) !important;
}

html, body{
    margin: 0;
    width: 100%;
    height: 100%;
    font-family: 'Dosis', sans-serif;
    font-weight: 300;
    -webkit-user-select: none; /* Safari 3.1+ */
    -moz-user-select: none; /* Firefox 2+ */
    -ms-user-select: none; /* IE 10+ */
    user-select: none; /* Standard syntax */
}

.bg-purple{
    background: url(http://salehriaz.com/404Page/img/bg_purple.png);
    background-repeat: repeat-x;
    background-size: cover;
    background-position: left top;
    height: 100%;
    overflow: hidden;
    
}

.custom-navbar{
    padding-top: 15px;
}

.brand-logo{
    margin-left: 25px;
    margin-top: 5px;
    display: inline-block;
}

.navbar-links{
    display: inline-block;
    float: right;
    margin-right: 15px;
    text-transform: uppercase;
    
    
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
/*    overflow: hidden;*/
    display: flex; 
    align-items: center; 
}

li {
    float: left;
    padding: 0px 15px;
}

li a {
    display: block;
    color: white;
    text-align: center;
    text-decoration: none;
    letter-spacing : 2px;
    font-size: 12px;
    
    -webkit-transition: all 0.3s ease-in;
    -moz-transition: all 0.3s ease-in;
    -ms-transition: all 0.3s ease-in;
    -o-transition: all 0.3s ease-in;
    transition: all 0.3s ease-in;
}

li a:hover {
    color: #ffcb39;
}

.btn-request{
    padding: 10px 25px;
    border: 1px solid #FFCB39;
    border-radius: 100px;
    font-weight: 400;
}

.btn-request:hover{
    background-color: #FFCB39;
    color: #fff;
    transform: scale(1.05);
    box-shadow: 0px 20px 20px rgba(0,0,0,0.1);
}

.btn-go-home{
    position: relative;
    z-index: 200;
    margin: 15px auto;
    width: 100px;
    padding: 10px 15px;
    border: 1px solid #FFCB39;
    border-radius: 100px;
    font-weight: 400;
    display: block;
    color: white;
    text-align: center;
    text-decoration: none;
    letter-spacing : 2px;
    font-size: 11px;
    
    -webkit-transition: all 0.3s ease-in;
    -moz-transition: all 0.3s ease-in;
    -ms-transition: all 0.3s ease-in;
    -o-transition: all 0.3s ease-in;
    transition: all 0.3s ease-in;
}

.btn-go-home:hover{
    background-color: #FFCB39;
    color: #fff;
    transform: scale(1.05);
    box-shadow: 0px 20px 20px rgba(0,0,0,0.1);
}

.central-body{
/*    width: 100%;*/
    padding: 17% 5% 10% 5%;
    text-align: center;
}

.objects img{
    z-index: 90;
    pointer-events: none;
}

.object_rocket{
    z-index: 95;
    position: absolute;
    transform: translateX(-50px);
    top: 75%;
    pointer-events: none;
    animation: rocket-movement 200s linear infinite both running;
}

.object_earth{
    position: absolute;
    top: 20%;
    left: 15%;
    z-index: 90;
/*    animation: spin-earth 100s infinite linear both;*/
}

.object_moon{
    position: absolute;
    top: 12%;
    left: 25%;
/*
    transform: rotate(0deg);
    transition: transform ease-in 99999999999s;
*/
}

.earth-moon{
    
}

.object_astronaut{
    animation: rotate-astronaut 200s infinite linear both alternate;
}

.box_astronaut{
    z-index: 110 !important;
    position: absolute;
    top: 60%;
    right: 20%;
    will-change: transform;
    animation: move-astronaut 50s infinite linear both alternate;
}

.image-404{
    position: relative;
    z-index: 100;
    pointer-events: none;
}

.stars{
    background: url(http://salehriaz.com/404Page/img/overlay_stars.svg);
    background-repeat: repeat;
    background-size: contain;
    background-position: left top;
}

.glowing_stars .star{
    position: absolute;
    border-radius: 100%;
    background-color: #fff;
    width: 3px;
    height: 3px;
    opacity: 0.3;
    will-change: opacity;
}

.glowing_stars .star:nth-child(1){
    top: 80%;
    left: 25%;
    animation: glow-star 2s infinite ease-in-out alternate 1s;
}
.glowing_stars .star:nth-child(2){
    top: 20%;
    left: 40%;
    animation: glow-star 2s infinite ease-in-out alternate 3s;
}
.glowing_stars .star:nth-child(3){
    top: 25%;
    left: 25%;
    animation: glow-star 2s infinite ease-in-out alternate 5s;
}
.glowing_stars .star:nth-child(4){
    top: 75%;
    left: 80%;
    animation: glow-star 2s infinite ease-in-out alternate 7s;
}
.glowing_stars .star:nth-child(5){
    top: 90%;
    left: 50%;
    animation: glow-star 2s infinite ease-in-out alternate 9s;
}

@media only screen and (max-width: 600px){
    .navbar-links{
        display: none;
    }
    
    .custom-navbar{
        text-align: center;
    }
    
    .brand-logo img{
        width: 120px;
    }
    
    .box_astronaut{
        top: 70%;
    }
    
    .central-body{
        padding-top: 25%;
    }
}
    </style>
<script>
  window.console = window.console || function(t) {};
</script>
<script>
  if (document.location.search.match(/type=embed/gi)) {
    window.parent.postMessage("resize", "*");
  }
</script>
</head>
<body translate="no">

<body class="bg-purple">
<div class="stars">
<div class="custom-navbar">
<div class="brand-logo">
<img
		src="data:image/png;base64,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"
		style="width: 250px; height: 60px;" />
</div>
<div class="navbar-links">
<ul>
<li><a href="/">Home</a></li>
<li><a href="/user-login">SignIn</a></li>

</ul>
</div>
</div>
<div class="central-body">
<img class="image-404" src="http://salehriaz.com/404Page/img/404.svg" width="300px">
<a href="/" class="btn-go-home" target="_blank">GO BACK HOME</a>
</div>
<div class="objects">
<img class="object_rocket" src="http://salehriaz.com/404Page/img/rocket.svg" width="40px">
<div class="earth-moon">
<img class="object_earth" src="http://salehriaz.com/404Page/img/earth.svg" width="100px">
<img class="object_moon" src="http://salehriaz.com/404Page/img/moon.svg" width="80px">
</div>
<div class="box_astronaut">
<img class="object_astronaut" src="http://salehriaz.com/404Page/img/astronaut.svg" width="140px">
</div>
</div>
<div class="glowing_stars">
<div class="star"></div>
<div class="star"></div>
<div class="star"></div>
<div class="star"></div>
<div class="star"></div>
</div>
</div>
</body>
<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js"></script>
<script id="rendered-js">
      /*
VIEW IN FULL SCREEN MODE
FULL SCREEN MODE: http://salehriaz.com/404Page/404.html

DRIBBBLE: https://dribbble.com/shots/4330167-404-Page-Lost-In-Space
*/
      //# sourceURL=pen.js
    </script>
<script src="https://static.codepen.io/assets/editor/live/css_reload-5619dc0905a68b2e6298901de54f73cefe4e079f65a75406858d92924b4938bf.js"></script>
</body>
</html>
