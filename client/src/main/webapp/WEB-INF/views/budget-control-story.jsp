
<!DOCTYPE html>
<!--[if IE 7]>
<html class="ie ie7 no-js" lang="en-US">
<![endif]-->
<!--[if IE 8]>
<html class="ie ie8 no-js" lang="en-US">
<![endif]-->
<!--[if !(IE 7) | !(IE 8)  ]><!-->
<html lang="en" class="no-js">
<head>
    <!-- Basic need -->
    <title>Story</title>
    <meta charset="UTF-8">
<script type="text/javascript">window.NREUM||(NREUM={});NREUM.info={"beacon":"bam.nr-data.net","errorBeacon":"bam.nr-data.net","licenseKey":"3ff0c07a52","applicationID":"14687042","transactionName":"JQxfEURXVFgDFBZLFgkRSEpUTVxTAxJaVwwSEV4J","queueTime":0,"applicationTime":9,"agent":""}</script>
<script type="text/javascript">window.NREUM||(NREUM={}),__nr_require=function(e,n,t){function r(t){if(!n[t]){var o=n[t]={exports:{}};e[t][0].call(o.exports,function(n){var o=e[t][1][n];return r(o||n)},o,o.exports)}return n[t].exports}if("function"==typeof __nr_require)return __nr_require;for(var o=0;o<t.length;o++)r(t[o]);return r}({1:[function(e,n,t){function r(){}function o(e,n,t){return function(){return i(e,[c.now()].concat(u(arguments)),n?null:this,t),n?void 0:this}}var i=e("handle"),a=e(3),u=e(4),f=e("ee").get("tracer"),c=e("loader"),s=NREUM;"undefined"==typeof window.newrelic&&(newrelic=s);var p=["setPageViewName","setCustomAttribute","setErrorHandler","finished","addToTrace","inlineHit","addRelease"],d="api-",l=d+"ixn-";a(p,function(e,n){s[n]=o(d+n,!0,"api")}),s.addPageAction=o(d+"addPageAction",!0),s.setCurrentRouteName=o(d+"routeName",!0),n.exports=newrelic,s.interaction=function(){return(new r).get()};var m=r.prototype={createTracer:function(e,n){var t={},r=this,o="function"==typeof n;return i(l+"tracer",[c.now(),e,t],r),function(){if(f.emit((o?"":"no-")+"fn-start",[c.now(),r,o],t),o)try{return n.apply(this,arguments)}catch(e){throw f.emit("fn-err",[arguments,this,e],t),e}finally{f.emit("fn-end",[c.now()],t)}}}};a("actionText,setName,setAttribute,save,ignore,onEnd,getContext,end,get".split(","),function(e,n){m[n]=o(l+n)}),newrelic.noticeError=function(e,n){"string"==typeof e&&(e=new Error(e)),i("err",[e,c.now(),!1,n])}},{}],2:[function(e,n,t){function r(e,n){if(!o)return!1;if(e!==o)return!1;if(!n)return!0;if(!i)return!1;for(var t=i.split("."),r=n.split("."),a=0;a<r.length;a++)if(r[a]!==t[a])return!1;return!0}var o=null,i=null,a=/Version\/(\S+)\s+Safari/;if(navigator.userAgent){var u=navigator.userAgent,f=u.match(a);f&&u.indexOf("Chrome")===-1&&u.indexOf("Chromium")===-1&&(o="Safari",i=f[1])}n.exports={agent:o,version:i,match:r}},{}],3:[function(e,n,t){function r(e,n){var t=[],r="",i=0;for(r in e)o.call(e,r)&&(t[i]=n(r,e[r]),i+=1);return t}var o=Object.prototype.hasOwnProperty;n.exports=r},{}],4:[function(e,n,t){function r(e,n,t){n||(n=0),"undefined"==typeof t&&(t=e?e.length:0);for(var r=-1,o=t-n||0,i=Array(o<0?0:o);++r<o;)i[r]=e[n+r];return i}n.exports=r},{}],5:[function(e,n,t){n.exports={exists:"undefined"!=typeof window.performance&&window.performance.timing&&"undefined"!=typeof window.performance.timing.navigationStart}},{}],ee:[function(e,n,t){function r(){}function o(e){function n(e){return e&&e instanceof r?e:e?f(e,u,i):i()}function t(t,r,o,i){if(!d.aborted||i){e&&e(t,r,o);for(var a=n(o),u=v(t),f=u.length,c=0;c<f;c++)u[c].apply(a,r);var p=s[y[t]];return p&&p.push([b,t,r,a]),a}}function l(e,n){h[e]=v(e).concat(n)}function m(e,n){var t=h[e];if(t)for(var r=0;r<t.length;r++)t[r]===n&&t.splice(r,1)}function v(e){return h[e]||[]}function g(e){return p[e]=p[e]||o(t)}function w(e,n){c(e,function(e,t){n=n||"feature",y[t]=n,n in s||(s[n]=[])})}var h={},y={},b={on:l,addEventListener:l,removeEventListener:m,emit:t,get:g,listeners:v,context:n,buffer:w,abort:a,aborted:!1};return b}function i(){return new r}function a(){(s.api||s.feature)&&(d.aborted=!0,s=d.backlog={})}var u="nr@context",f=e("gos"),c=e(3),s={},p={},d=n.exports=o();d.backlog=s},{}],gos:[function(e,n,t){function r(e,n,t){if(o.call(e,n))return e[n];var r=t();if(Object.defineProperty&&Object.keys)try{return Object.defineProperty(e,n,{value:r,writable:!0,enumerable:!1}),r}catch(i){}return e[n]=r,r}var o=Object.prototype.hasOwnProperty;n.exports=r},{}],handle:[function(e,n,t){function r(e,n,t,r){o.buffer([e],r),o.emit(e,n,t)}var o=e("ee").get("handle");n.exports=r,r.ee=o},{}],id:[function(e,n,t){function r(e){var n=typeof e;return!e||"object"!==n&&"function"!==n?-1:e===window?0:a(e,i,function(){return o++})}var o=1,i="nr@id",a=e("gos");n.exports=r},{}],loader:[function(e,n,t){function r(){if(!E++){var e=x.info=NREUM.info,n=l.getElementsByTagName("script")[0];if(setTimeout(s.abort,3e4),!(e&&e.licenseKey&&e.applicationID&&n))return s.abort();c(y,function(n,t){e[n]||(e[n]=t)}),f("mark",["onload",a()+x.offset],null,"api");var t=l.createElement("script");t.src="https://"+e.agent,n.parentNode.insertBefore(t,n)}}function o(){"complete"===l.readyState&&i()}function i(){f("mark",["domContent",a()+x.offset],null,"api")}function a(){return O.exists&&performance.now?Math.round(performance.now()):(u=Math.max((new Date).getTime(),u))-x.offset}var u=(new Date).getTime(),f=e("handle"),c=e(3),s=e("ee"),p=e(2),d=window,l=d.document,m="addEventListener",v="attachEvent",g=d.XMLHttpRequest,w=g&&g.prototype;NREUM.o={ST:setTimeout,SI:d.setImmediate,CT:clearTimeout,XHR:g,REQ:d.Request,EV:d.Event,PR:d.Promise,MO:d.MutationObserver};var h=""+location,y={beacon:"bam.nr-data.net",errorBeacon:"bam.nr-data.net",agent:"js-agent.newrelic.com/nr-1123.min.js"},b=g&&w&&w[m]&&!/CriOS/.test(navigator.userAgent),x=n.exports={offset:u,now:a,origin:h,features:{},xhrWrappable:b,userAgent:p};e(1),l[m]?(l[m]("DOMContentLoaded",i,!1),d[m]("load",r,!1)):(l[v]("onreadystatechange",o),d[v]("onload",r)),f("mark",["firstbyte",u],null,"api");var E=0,O=e(5)},{}]},{},["loader"]);</script>
    <meta name="description" content="Expensebit">
    <meta name="keywords" content="Expense tracker">
    <meta name="author" content="rohith">
    <link rel="profile" href="#profile">
    <link rel="icon"  type="image/png" href="../assets/MDPI.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Mobile specific meta -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

<!-- CSS files -->
<link href="https://unpkg.com/ionicons@4.5.5/dist/css/ionicons.min.css" rel="stylesheet">
    <!-- Mobile specific meta -->
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="format-detection" content="telephone-no">
    <!-- CSS files -->
    
        <link rel="stylesheet" media="all" href="https://www.expensebit.com/assets/application-9df1c57b3e9a20072390e5dd1f8573f8295231300bb9b1fd50c02eae7ee15067.css" data-turbolinks-track="true" />

    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js"></script>
    <script>
      WebFont.load({
        google: {
          families: ['Poppins:300,400,500,600,700']
        }
      });
    </script>
   <!--  <link href='https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700' rel='stylesheet' type='text/css'> -->
   <script>
      WebFont.load({
        google: {
          families: ['Lato:300,400,900']
        }
      });
    </script>
    <!-- <link href='https://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'> -->
    
</head>
<body>

<div class="page">
<!-- <div id="template-options"></div> -->
<!-- HEADER -->
		<!-- HEADER -->
		<header class="flw">
			<!-- topbar -->
			<div class="topbar flw">
				<div class="container">
					<div class="topbar-left">
					
					
					</div>
				
				</div>
			</div>
			<div class="ht-header flw">
				<!-- menu -->
				<div class="seo-wrap-menu">
					<div class="menu-box header-fixed flw">
						<div class="container">
							<div class="menu-box-nav flw">
								<!-- box left -->
								<div class="menu-box-left">
									<div class="logo lg-top">
										<a href="/"> <img alt="Expensebit logo"
											class="lg-1"
											src="data:image/png;base64,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" style="width:250px;height:80px;"/>
											

										</a>
									</div>
								</div>
								<!-- box right -->
								<div class="menu-box-right">
									<ul class="primary-menu">
										<li class="current-style-menu-1"><a href="/"><i class="fas fa-home"></i> home</a>
									</li>
									
										<li><a
											href="/user-login"><i class="fa fa-sign-in" aria-hidden="true"></i> SignIn</a>
											</li>
												<li><a 
											href="/user-registration"><i class="fas fa-user-plus"></i> SignUp</a>
											</li>
											<li><a href="#contact"><i class="fas fa-address-book"></i> contact</a></li>
							</ul>
								</div>
								<!-- search form -->
								<div class="box-form-top">
									<form action="index.html" class="search-form-menu">
										<input class="search-form-input" name="search" type="text"
											placeholder="To Search start typing..." required>
									</form>
									<span class="ion-close close-form-btn"></span>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Main view  -->


			</div>
		</header>
		<!-- //HEADER -->
<!-- Main view  -->
<main class="flw page_content service-detail" id=main>
    <nav class="flw breadcrumb">
        <div class=container>
            <div class="flw bread">
                <h3 class=page-title>Budget Control</h3>
                <div class=crumbs><span><a href=index.html>Home</a></span></div>
            </div>
        </div>
        <img alt="navbar1" class="nav-bg-1" src="https://www.expensebit.com/assets/upload/nav-1-db8cd94831aa8bac7487cfe1842517fa2571354bdc7155c78162b8e593b38834.png" />
            <img alt="navbar2" class="nav-bg-2" src="https://www.expensebit.com/assets/upload/nav-2-df4106a21468fcd6f69e3a5b8ee0d75bef11acc181d93d66d8b2b9bf7b098c7a.png" />
                <img alt="navbar3" class="nav-bg-3" src="https://www.expensebit.com/assets/upload/nav-3-9e9111f85f1cbf2b799d9a5aa386e470fe2a8619c8cc99d57aedaa5b91eb38a5.png" />
    </nav>
    <div class=container>
        <div class=row>
            <div class="col-lg-6 col-md-6">
                <div class="flw case-detail-thumbnail">
                    <img alt="img" class="customthumb case-detail-lg-img custom_thumb" src="https://www.expensebit.com/assets/upload/case-detail-lg-f09aed2e2db21c953f4c9e561d22550c3591d16380b447501640697021197c53.png" />
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="flw case-detail-right">
                    <div class=case-detail-info>
                        <h3 class=case-detail-info-name>Budget Control</h3>
                    </div>
                    <p class=case-detail-content>Do you know where your money is going every month? If not, then that’s a huge mistake that you are doing. Start to track your expenses Today.<br><br>No Matter how much money you make, budgeting is the only way to keep control on your
                        financial pattern. Often, people who are making a decent salary cannot get out of the vicious cycle of living paycheck to paycheck — and the reason why is because they are not tracking where all their money is going.<br><br></div>
            </div>
            <div class=case-detail-tabs-box>
                <ul class="case-detail-tabs-menu project-tabs-menu">
                    <li><a href=#tabs1>PROBLEM</a>
                        <li><a href=#tabs2>SOLUTION</a>
                            <li class=project-tabs-current-menu><a href=#tabs3>RESULTS</a></ul>
            </div>
            <div class="flw project-tabs">
                <div class="project-tabs-content display-none" id=tabs1>
                    <div class="col-lg-5 col-md-5">
                        <div class=case-detail-content-left>
                            <p>How often do you realize by the end of the month that you couldn't save the money that you planned to save?.<br><br>Every great financial plan starts with a word budget. If you’re trying to pay off your bills and start saving
                                mponey for a dream vacation, a budget is your first step toward making your dreams into a reality..</div>
                    </div>
                    <div class="col-lg-7 col-md-7">
                        <img alt="img" src="https://www.expensebit.com/assets/upload/chart-61b56e21a02323dd9f296e51f325dd8220e8323b0e7f6e96df89744e4c1b7ceb.png" />
                    </div>
                </div>
                <div class="project-tabs-content display-none" id=tabs2>
                    <div class="col-lg-5 col-md-5">
                        <div class=case-detail-content-left>
                            <h4>1. Calulate you total Expenses</h4><br><br>
                            <p>Your first step towards saving money is finding out exactly how much you’re spending each month. You can do this by glancing your bank statements and bills. Add up everything you spent for the last six to 12 months and then
                                divide by the amount of months, which will give you your average monthly expenses..</p><br><br>
                            <h4>2. Set Goals</h4><br>
                            <p>Figure out what your priorities are for both the Short and long-term plans. For example, buying a house, buying a car, a big vacation, emergency savings, retirement etc fall under long-term plans. Pay the bills and loans are
                                the short term plans.<br><br>
                                <h4>3. Find the amount you Earn and the Amount you spend.</h4><br>
                                <p>Now you have calculated how you are spending on everything, it’s time to figure out how much is coming in and where it’s all going each month. This will help you identify expenses that need to be tracked often.</p><br><br>
                                <h4>4. Plan a Budget</h4><br>
                                <p>Now you will have a clear picture of the total money coming in and the money going out, you can start tracking your expenses and then create your budget based on what you should be spending on most.<br><br>The less you
                                    spend on the expenses you can control, the quicker you’ll get out of debt and/or be able to save more towards your goals.</div>
                    </div>
                    <div class="col-lg-7 col-md-7">
                        <img alt="img" src="https://www.expensebit.com/assets/upload/chart-61b56e21a02323dd9f296e51f325dd8220e8323b0e7f6e96df89744e4c1b7ceb.png" />
                    </div>
                </div>
                <div class="project-tabs-content display-block" id=tabs3>
                    <div class="col-lg-5 col-md-5">
                        <div class=case-detail-content-left>
                            <h4>* Proper budgeting gives you control over your money<br><br>* You can be focus on your goals<br><br>* You can be aware of your money in/out flow.<br><br>* You can organise your spending and saving.<br><br>* You can decide in
                                advance what to do with your money.<br><br>* You can even save the expected and unexpected costs.<br><br>* Pre-Warned about the potential problems that arises.<br><br>* It can enable you to generate extra money.<br><br></h4>
                        </div>
                    </div>
                    <div class="col-lg-7 col-md-7">
                        <img alt="img" src="https://www.expensebit.com/assets/upload/chart-61b56e21a02323dd9f296e51f325dd8220e8323b0e7f6e96df89744e4c1b7ceb.png" />
                    </div>
                </div>
            </div>
            <div class="flw case-detail-more-section">
                <div class=container>
                    <h3 class=case-detail-more-item>MORE CASE STUDIES</h3>
                    <div class=row>
                        <div class="flw case-detail-more-crs">
                            <div class="case-study">
					<div class="case-img">
						<img alt="img" src="https://www.expensebit.com/assets/upload/case5-33dc4d16499b3221b54a535abd35c3eff8134099f3ed7bdd01af22326a04abad.png" />
						
					</div>
				
					<div class="case-overlay-banner"></div>
					<h3 class="case-readmore"><a href="/overspending" class="case-readmore-btn">Read more</a></h3>
					<div class="case-overlay-info">
						<h3 class="case-name"><a href="/overspending" class="case-name-btn">Avoid going broke by monthend</a></h3>
					
					</div>
				</div>
	
				<div class="case-study">
					<div class="case-img">
						<img alt="img" src="https://www.expensebit.com/assets/upload/case4-ea71e468f7c944fcb4ab403b44f28228869363b15484ef5349b8acef3e45bfc6.png" />
						
					</div>
				
					<div class="case-overlay-banner"></div>
					<h3 class="case-readmore"><a href="/purchase" class="case-readmore-btn">Read more</a></h3>
					<div class="case-overlay-info">
						<h3 class="case-name"><a href="/purchase" class="case-name-btn">Keep track of the Purchase</a></h3>
					
					</div>
				</div>
				<div class="case-study">
					<div class="case-img">
						<img alt="img" src="https://www.expensebit.com/assets/upload/case2-2821316a8d9f743755c2a9433fc8de5da471ea379a4981858f895030e28d6e75.png" />
						
					</div>
					
					<div class="case-overlay-banner"></div>
					<h3 class="case-readmore"><a href="/splitexpense" class="case-readmore-btn">Read more</a></h3>
					<div class="case-overlay-info">
						<h3 class="case-name"><a href="/splitexpense" class="case-name-btn">Split Expenses</a></h3>
						
					</div>
				</div>
				<div class="case-study">
					<div class="case-img">
						<img alt="img" src="https://www.expensebit.com/assets/upload/case6-22a3acc356dd9bb8a41617d6770675d747f38d5afb87da3aa0c30cc3efc7dfd7.png" />
						
					</div>
					
					<div class="case-overlay-banner"></div>
					<h3 class="case-readmore"><a href="/tripplanner" class="case-readmore-btn">Read more</a></h3>
					<div class="case-overlay-info">
						<h3 class="case-name"><a href="/tripplanner" class="case-name-btn">How to plan for a trip?</a></h3>
					
					</div>
				</div>
						<div class="case-study">
					<div class="case-img">
						<img alt="img" src="https://www.expensebit.com/assets/upload/case1-4046ff3bb1584505cff7b6201bf66d3fd868a434a6663f24bc63a5ea2cac105a.png" />
						
					</div>
					
					<div class="case-overlay-banner"></div>
					<h3 class="case-readmore"><a href="/budgetControl" class="case-readmore-btn">Read more</a></h3>
					<div class="case-overlay-info">
						<h3 class="case-name"><a href="/budgetControl" class="case-name-btn">Budget Control</a></h3>
					
					</div>
				</div>		<div class="case-study">
					<div class="case-img">
						<img alt="img" src="https://www.expensebit.com/assets/upload/case3-72044194ad587f16b7784ae038adc3f18d038fe4612bf92a1270d5076e3c2017.png" />
						
					</div>
					
					<div class="case-overlay-banner"></div>
					<h3 class="case-readmore"><a href="/overspending" class="case-readmore-btn">Read more</a></h3>
					<div class="case-overlay-info">
						<h3 class="case-name"><a href="/overspending" class="case-name-btn">How to Avoid Overspending?</a></h3>
					
					</div>
				</div>
                        </div>
                    </div>
                </div>
            </div>
</main>

 
<!-- FOOTER -->
		<footer class="flw" id="contact">
			<div class="ht-footer flw">
				<div class="container">
					<div class="row">
						<div class="col-md-3 col-lg-3">
							<div class="footer-desc footer-col">
								<div class="logo lg-bottom">
									<a href="index.html"> <img alt="expensebit logo"
										 											src="data:image/png;base64,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" style="width:250px;height:80px;"/>
										 
										<!-- <img src="assets/ExpenseBitLogo-white.png" alt="Expensebit"> -->
									</a>
								</div>
								<div class="footer-content">
									<p>
										Meet Moneymanager, your personal money manager <br> <br>Expensebit
										lets you split and share expenses with your friends,lunchmates
										and flatmates seamlessly.
									</p>
									<a href="#" class="footer-content-rm">Read more &#187;</a>
								</div>
							</div>
							<div class="footer-contact footer-col col-md-3 col-lg-3"
								style="margin-left: 335%; margin-top: -105%;">
								<h3 class="footer-title ft_tb">contact info</h3>
								<ul class="footer-contact-info flw">
									<li><span class="fa fa-map-marker"></span> Chennai,
										India</li>
									<li><span class="fa fa-phone"></span> (+91) 9999999999</li>
									<li><span class="fa fa-envelope"></span>
										moneymanager@virtusa.com</li>
								</ul>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="copyright flw">
				<div class="container">
					<div class="center-copyright">
						<h1>
							Copyright &#169; 2019 <a href="/" class="site-name">Moneymanager</a>
						</h1>
						
					</div>
				
				
				</div>
			</div>
		</footer>
		<!-- //FOOTER -->
</div>
<!-- JS files -->
    <script src="https://www.expensebit.com/assets/application-0b790829841069763a8247c76c1c9b417682f301e1f2df901f4f94ea24ead7d4.js" data-turbolinks-track="true"></script>

</body>
</html>
