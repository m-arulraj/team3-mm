

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="https://static.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico" />
<link rel="mask-icon" type="" href="https://static.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg" color="#111" />
<title>CodePen - 403 Forbidden Airport Security - Codepen Challenge</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<style>
      @import url("https://fonts.googleapis.com/css?family=Share+Tech+Mono");
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html, body {
  width: 100%;
  height: 100%;
}

body {
  display: flex;
  justify-content: center;
  align-items: flex-end;
  background: #f6525d;
  overflow: hidden;
}

.scanner {
  position: absolute;
  margin: auto;
  width: 300px;
  height: 250px;
  bottom: 0;
  left: 0;
  right: 0;
  background: #dedded;
  border-top-right-radius: 16px;
  border-top-left-radius: 16px;
  box-shadow: inset 0 -20px 0 0 #dedded, inset 0 -40px 0 0 #7e6e92;
}
.scanner:before, .scanner:after {
  content: '';
  position: absolute;
  margin: auto;
}
.scanner:before {
  width: 20px;
  height: 30px;
  top: -30px;
  left: 20px;
  background: rgba(253, 205, 35, 0.6);
  border-top-right-radius: 10px;
  border-top-left-radius: 10px;
}
.scanner:after {
  width: 150px;
  height: 20px;
  background: #cecce4;
  top: -20px;
  right: 20px;
  border-top-right-radius: 10px;
  border-top-left-radius: 10px;
}

.belt {
  position: absolute;
  margin: auto;
  width: 800px;
  height: 30px;
  background: #7e6e92;
  border-radius: 15px;
  bottom: 50px;
  left: 0;
  right: 0;
  border: 4px solid #dedded;
}
.belt:before, .belt:after {
  position: absolute;
  content: '';
  margin: auto;
}
.belt:before {
  width: 10px;
  height: 50px;
  background: #bebcdb;
  bottom: -54px;
  left: 20px;
  box-shadow: 745px 0 0 0 #cecce4;
}
.belt:after {
  width: 30px;
  height: 10px;
  background: #8d8ac1;
  bottom: -54px;
  left: 10px;
  border-top-right-radius: 5px;
  border-top-left-radius: 5px;
  box-shadow: 745px 0 0 0 #8d8ac1;
}

.monitor {
  position: absolute;
  width: 160px;
  height: 90px;
  background: #3b2c4a;
  margin: auto;
  bottom: 130px;
  left: 500px;
  right: 0;
  border: 4px solid #dedded;
  text-align: center;
  line-height: 85px;
  font-size: 50px;
  color: #70a8ff;
  font-family: 'Share Tech Mono', monospace;
}
.monitor.text {
  font-size: 30px;
}
.monitor:before, .monitor:after {
  content: '';
  position: absolute;
  margin: auto;
}
.monitor:before {
  width: 10px;
  height: 20px;
  background: #adabd3;
  left: 0;
  right: 0;
  bottom: -24px;
}
.monitor:after {
  width: 105px;
  height: 10px;
  background: #adabd3;
  left: -24px;
  bottom: -34px;
}

.scan-window {
  position: absolute;
  margin: auto;
  width: 150px;
  height: 120px;
  background: #3b2c4a;
  bottom: 80px;
  border-top-right-radius: 10px;
  border-top-left-radius: 10px;
  overflow: hidden;
}
.scan-window.scanning {
  -webkit-animation: scanning .5s ease infinite alternate;
          animation: scanning .5s ease infinite alternate;
}
.scan-window:before {
  content: '';
  position: absolute;
  width: 10px;
  height: 100%;
  background: rgba(0, 0, 0, 0.1);
  box-shadow: 12px 0 0 0 rgba(0, 0, 0, 0.1), 24px 0 0 0 rgba(0, 0, 0, 0.1), 36px 0 0 0 rgba(0, 0, 0, 0.1), 48px 0 0 0 rgba(0, 0, 0, 0.1), 60px 0 0 0 rgba(0, 0, 0, 0.1), 72px 0 0 0 rgba(0, 0, 0, 0.1), 84px 0 0 0 rgba(0, 0, 0, 0.1), 96px 0 0 0 rgba(0, 0, 0, 0.1), 108px 0 0 0 rgba(0, 0, 0, 0.1), 120px 0 0 0 rgba(0, 0, 0, 0.1), 132px 0 0 0 rgba(0, 0, 0, 0.1), 144px 0 0 0 rgba(0, 0, 0, 0.1);
}

.hide {
  position: absolute;
  margin: auto;
  width: 75px;
  background: #dedded;
  height: 120px;
  bottom: 80px;
  left: 0;
  right: 226px;
  z-index: 3;
  box-shadow: 225px 0 0 0 #dedded;
}
.hide:before {
  content: '';
  position: absolute;
  width: 150px;
  height: 120px;
  top: 0;
  left: 75px;
  background: rgba(0, 0, 0, 0.5);
  border-top-right-radius: 10px;
  border-top-left-radius: 10px;
}

.box {
  position: absolute;
  margin: auto;
  width: 80px;
  height: 80px;
  background: #E3D0B9;
  bottom: 80px;
  left: 0;
  right: 600px;
  z-index: 1;
  font-family: 'Share Tech Mono', monospace;
  text-align: center;
  color: #c69f70;
  padding-top: 5px;
  font-size: 14px;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.box p {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.box .user {
  position: absolute;
  margin: auto;
  width: 40px;
  height: 30px;
  bottom: 0;
  left: 0;
  right: 0;
  background: #70a8ff;
  border-top-right-radius: 20px;
  border-top-left-radius: 20px;
  opacity: 0;
}
.box .user:before {
  content: '';
  position: absolute;
  left: 2px;
  top: -34px;
  width: 34px;
  height: 35px;
  border-radius: 50%;
  background: inherit;
}
.box.scanned {
  background: rgba(227, 208, 185, 0.2);
  box-shadow: inset 0 0 0 2px #E3D0B9;
  text-indent: -99999px;
}
.box.scanned .user {
  opacity: 1;
}

@-webkit-keyframes scanning {
  from {
    background: #2e223a;
  }
  to {
    background: #47355a;
  }
}

@keyframes scanning {
  from {
    background: #2e223a;
  }
  to {
    background: #47355a;
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
<div class="belt"></div>
<div class="scanner"></div>
<div class="scan-window"></div>
<div class="hide"></div>
<div class="monitor text"></div>
<div class="box">
<p>User X</p>
<p class="version"></p>
<div class="user"></div>
</div>
<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.1/TweenMax.min.js'></script>
<script id="rendered-js">
      // reveal your real identity!
navigator.sayswho = function () {
  var ua = navigator.userAgent,tem,
  M = ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*(\d+)/i) || [];
  if (/trident/i.test(M[1])) {
    tem = /\brv[ :]+(\d+)/g.exec(ua) || [];
    return 'IE ' + (tem[1] || '');
  }
  if (M[1] === 'Chrome') {
    tem = ua.match(/\b(OPR|Edge)\/(\d+)/);
    if (tem != null) return tem.slice(1).join(' ').replace('OPR', 'Opera');
  }
  M = M[2] ? [M[1], M[2]] : [navigator.appName, navigator.appVersion, '-?'];
  if ((tem = ua.match(/version\/(\d+)/i)) != null) M.splice(1, 1, tem[1]);
  return M.join(' ');
}();

// print your dirty secrets on the box
$('.box .version').html(navigator.sayswho);


// high end monitor software
var text = ['403', 'Forbidden'];
var counter = 0;
var elem = $('.monitor');

function scanning() {
  elem.html('Forbidden');
  var inst = setInterval(change, 1000);
}

function change() {
  elem.html(text[counter]);
  elem.toggleClass('text');
  counter++;
  if (counter >= text.length) {
    counter = 0;
  }
}

// high end conveyor belt functionality
var box = '.box';
var tl = new TimelineMax();

tl.to(box, 4, {
  right: '0',
  ease: Power0.easeNone });


tl.call(function () {
  $(box).addClass('scanned');
  $('.scan-window').addClass('scanning');
  scanning();
}, null, null, 2.5);
      //# sourceURL=pen.js
    </script>
<script src="https://static.codepen.io/assets/editor/live/css_reload-5619dc0905a68b2e6298901de54f73cefe4e079f65a75406858d92924b4938bf.js"></script>
</body>
</html>
