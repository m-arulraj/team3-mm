<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- saved from url=(0106)https://demo.w3layouts.com/demos_new/template_demo/23-02-2019/business_login_form-demo_Free/123711373/web/ -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style class="vjs-styles-defaults">
<
link rel ="stylesheet " href ="https: //www.w3schools.com /w3css/4/w3.css
	 ">.vdo-js {
	width: 300px;
	height: 150px;
}

.vjs-fluid {
	padding-top: 56.25%
}
</style>
<style class="vjs-styles-dimensions">
.vdo_ai_9305047-dimensions {
	width: 419px;
	height: 236px;
}

.vdo_ai_9305047-dimensions.vjs-fluid {
	padding-top: 56.25%;
}
</style>
<title>Money Manager</title>
<!-- css files -->
<style type="text/css">
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, dl, dt, dd, ol, nav ul, nav li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}

article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section {
	display: block;
}

ol, ul {
	list-style: none;
	margin: 0px;
	padding: 0px;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

a {
	text-decoration: none;
}

.txt-rt {
	text-align: right;
} /* text align right */
.txt-lt {
	text-align: left;
} /* text align left */
.txt-center {
	text-align: center;
} /* text align center */
.float-rt {
	float: right;
} /* float right */
.float-lt {
	float: left;
} /* float left */
.clear {
	clear: both;
} /* clear float */
.pos-relative {
	position: relative;
} /* Position Relative */
.pos-absolute {
	position: absolute;
} /* Position Absolute */
.vertical-base {
	vertical-align: baseline;
} /* vertical align baseline */
.vertical-top {
	vertical-align: top;
} /* vertical align top */
nav.vertical ul li {
	display: block;
} /* vertical menu */
nav.horizontal ul li {
	display: inline-block;
} /* horizontal menu */
img {
	max-width: 100%;
}

body {
	padding: 0;
	margin: 0;
	background: #fff;
	min-height: 100vh;
	background: linear-gradient(to left, #f5f5f5 50%, #fff 50%);
	font-family: 'Raleway', sans-serif;
}

body a {
	transition: 0.5s all;
	-webkit-transition: 0.5s all;
	-moz-transition: 0.5s all;
	-o-transition: 0.5s all;
	-ms-transition: 0.5s all;
	text-decoration: none;
	letter-spacing: 1px;
	font-size: 15px;
	font-weight: 600;
}

body a:hover {
	text-decoration: none;
}

body a:focus, a:hover {
	text-decoration: none;
}

input[type="button"], input[type="submit"] {
	transition: 0.5s all;
	-webkit-transition: 0.5s all;
	-moz-transition: 0.5s all;
	-o-transition: 0.5s all;
	-ms-transition: 0.5s all;
}

h1, h2, h3, h4, h5, h6 {
	margin: 0;
	padding: 0;
	font-family: 'Raleway', sans-serif;
	font-weight: 600;
	letter-spacing: 1px;
}

.clear {
	clear: both;
}

p {
	margin: 0;
	color: #666;
	letter-spacing: 1px;
	line-height: 1.8em;
	font-size: 16px;
	font-weight: 400;
}

.row {
	margin: 0px;
	padding: 0px;
}

ul {
	margin: 0;
	padding: 0;
}

label {
	margin: 0;
}

a:focus, a:hover {
	text-decoration: none;
	outline: none;
}

img {
	width: 100%;
}
/*-- //Reset-Code --*/
.signupform {
	padding: 3em 0;
}

.left_grid_info h1 {
	font-size: 45px;
	margin: 1em 0em .5em 0em;
	color: #333;
	font-weight: 700;
}

input[type="email"] ,input[type="number"],input[type="text"]{
	font-size: 15px;
	color: #333;
	text-align: left;
	letter-spacing: 1px;
	padding: 14px 10px;
	width: 93%;
	display: inline-block;
	box-sizing: border-box;
	border: none;
	outline: none;
	background: transparent;
	font-family: 'Raleway', sans-serif;
}
input[type="date"] {
	font-size: 15px;
	color: #333;
	text-align: left;
	letter-spacing: 1px;
	padding: 14px 10px;
	width: 93%;
	display: inline-block;
	box-sizing: border-box;
	border: none;
	outline: none;
	background: transparent;
	font-family: 'Raleway', sans-serif;
}

input[type="Password"] {
	font-size: 15px;
	color: #333;
	text-align: left;
	text-transform: capitalize;
	letter-spacing: 1px;
	padding: 14px 10px;
	width: 93%;
	display: inline-block;
	box-sizing: border-box;
	border: none;
	outline: none;
	background: transparent;
	font-family: 'Raleway', sans-serif;
}

.input-group {
	margin-top: 10px;
	margin-bottom: 20px;
	padding: 3px 10px;
	border: 1px solid #ddd;
	background: #fff;
}

.btn-block {
	background: #ff4040;
	border: none;
	color: #fff;
	font-size: 13px;
	padding: 12px 40px;
	letter-spacing: 2px;
	text-transform: uppercase;
	cursor: pointer;
}

.w3_info h2 {
	display: inline-block;
	font-size: 26px;
	margin-bottom: 10px;
	color: #333;
	letter-spacing: 2px;
	text-transform: capitalize;
}

.w3_info h4 {
	display: inline-block;
	font-size: 15px;
	padding: 8px 0px;
	color: #444;
	text-transform: capitalize;
}

a.btn.btn-block.btn-social.btn-facebook {
	display: block;
	width: 100%;
	padding: 10px 0px;
	text-align: center;
	font-size: 16px;
	font-weight: 600;
	letter-spacing: 1px;
	font-family: 'Raleway', sans-serif;
}

.w3_info {
	flex-basis: 50%;
	-webkit-flex-basis: 50%;
	box-sizing: border-box;
	padding: 3em 4em;
	/* -webkit-box-shadow: 1px 0px 15px 0px rgba(0,0,0,0.2);
    -moz-box-shadow: 1px 0px 15px 0px rgba(0,0,0,0.2);
    box-shadow: 1px 0px 15px 0px rgba(0,0,0,0.2); */
}

.login-check {
	position: relative;
}

.w3_info .login-check label {
	text-transform: capitalize;
	font-size: 13px;
	letter-spacing: 1px;
	color: #000;
}

.checkbox i {
	position: absolute;
	top: 0px;
	left: 0%;
	text-align: center;
	display: block;
	width: 14px;
	height: 14px;
	border: 1px solid #777;
	outline: none;
	border-radius: 0px;
	-webkit-border-radius: 0px;
	-moz-border-radius: 0px;
	-o-border-radius: 0px;
	cursor: pointer;
}

.checkbox input:checked+i:after {
	opacity: 1;
}

.checkbox input+i:after {
	position: absolute;
	opacity: 0;
	transition: opacity 0.1s;
	-o-transition: opacity 0.1s;
	-ms-transition: opacity 0.1s;
	-moz-transition: opacity 0.1s;
	-webkit-transition: opacity 0.1s;
}

.checkbox input+i:after {
	content: url(../images/tick.png);
	top: 0px;
	left: 2px;
}

.checkbox {
	position: relative;
	display: inline-block;
	padding-left: 25px !important;
	text-transform: capitalize;
	letter-spacing: 1px;
	font-size: 14px;
	color: #fff;
}

input[type="checkbox" i] {
	display: none;
}

.agile_info {
	display: -webkit-box; /* OLD - iOS 6-, Safari 3.1-6 */
	display: -moz-box; /* OLD - Firefox 19- (buggy but mostly works) */
	display: -ms-flexbox; /* TWEENER - IE 10 */
	display: -webkit-flex; /* NEW - Chrome */
	display: flex; /* NEW, Spec - Opera 12.1, Firefox 20+ */
}

.left_grid_info {
	padding-right: 3em;
}

.w3l_form {
	padding: 0px;
	flex-basis: 50%;
	-webkit-flex-basis: 50%;
}

.w3_info p {
	padding-bottom: 30px;
}

p.account, p.account1 {
	padding-top: 20px;
	padding-bottom: 0px;
	line-height: 1.5em;
	font-size: 13px;
}

p.account a, p.account1 a {
	color: #ff4040;
	font-size: 11px;
	text-decoration: underline;
}

p.account a:hover, p.account1 a:hover {
	text-decoration: none;
}

.w3_info label {
	margin: 0;
	text-transform: uppercase;
	letter-spacing: 1px;
	font-weight: 500;
	color: #000;
	margin-bottom: 20px;
	font-size: 13px;
	padding-left: 0px;
}

h3.w3ls {
	margin: 10px 0px;
	padding-left: 60px;
}

h3.agileits {
	padding-left: 10px;
}

.container {
	width: 65%;
	margin: 0 auto;
}

.input-group span.fa {
	font-size: 16px;
	vertical-align: middle;
	box-sizing: border-box;
	float: left;
	text-align: center;
	width: 6%;
	padding: 15px 0px;
	color: #01cd74;
}

h5 {
	text-align: center;
	margin: 10px 0px;
	font-size: 15px;
	font-weight: 600;
	color: #000;
}

.footer p {
	color: #666;
	text-align: center;
	letter-spacing: 1px;
	font-size: 15px;
	margin-top: 2em;
}

.footer p a {
	color: #333;
}
/** Responsive **/
@media screen and (max-width: 1440px) {
	.container {
		width: 70%;
		margin: 0 auto;
	}
}

@media screen and (max-width: 1366px) {
	.container {
		width: 75%;
	}
	.left_grid_info h1 {
		font-size: 40px;
	}
}

@media screen and (max-width: 1080px) {
	.container {
		width: 80%;
	}
	.w3_info h2 {
		font-size: 24px;
		letter-spacing: 1px;
	}
	.left_grid_info h1 {
		font-size: 35px;
	}
	.w3_info {
		padding: 3em 3em;
	}
}

@media screen and (max-width: 1024px) {
	.signupform {
		padding: 1em 0;
	}
	.container {
		width: 85%;
	}
	.left_grid_info {
		padding-right: 3em;
		padding-top: 2em;
	}
}

@media screen and (max-width: 991px) {
	.w3_info h2 {
		font-size: 24px;
	}
	h1 {
		font-size: 40px;
		letter-spacing: 2px;
	}
}

@media screen and (max-width: 900px) {
	.container {
		width: 90%;
	}
	.left_grid_info h4 {
		font-size: 1em;
	}
	.w3_info {
		padding: 3em 2.5em;
	}
}

@media screen and (max-width: 800px) {
	.container {
		width: 95%;
	}
	input[type="text"], input[type="email"], input[type="password"] {
		font-size: 14px;
	}
	.input-group span.fa {
		font-size: 16px;
		padding: 13px 0px;
	}
	.w3_info h2 {
		font-size: 23px;
	}
}

@media screen and (max-width: 768px) {
	.container {
		width: 95%;
	}
	.w3_info h2 {
		letter-spacing: 1px;
	}
	.left_grid_info h1 {
		font-size: 30px;
		letter-spacing: 1px;
	}
	.left_grid_info {
		padding-right: 2em;
	}
}

@media screen and (max-width: 736px) {
	.left_grid_info h3 {
		font-size: 1.7em;
	}
	.w3_info h2 {
		font-size: 22px;
	}
	.w3_info {
		padding: 3em 2em;
	}
	.footer p {
		font-size: 14px;
	}
	.w3_info h4 {
		font-size: 14px;
	}
	.footer p {
		margin-top: 0em;
		margin-bottom: 2em;
	}
}

@media screen and (max-width: 684px) {
	.w3_info h2 {
		font-size: 20px;
		letter-spacing: 0px;
	}
	.left_grid_info h1 {
		font-size: 26px;
		letter-spacing: 1px;
	}
}

@media screen and (max-width: 667px) {
	.container {
		width: 80%;
	}
}

@media screen and (max-width: 640px) {
	h1 {
		font-size: 37px;
	}
	.agile_info {
		flex-direction: column;
	}
	body {
		background: #FFF;
	}
	.left_grid_info {
		padding-right: 0em;
	}
}

@media screen and (max-width: 480px) {
	.w3l_form {
		padding: 0em;
	}
	h1 {
		font-size: 34px;
	}
	.w3_info {
		padding: 3em 1em;
	}
	.footer {
		margin: 0 1em;
	}
	.left_grid_info h1 {
		margin: 0em 0em .5em 0em;
	}
}

@media screen and (max-width: 414px) {
	.w3_info {
		padding: 2em;
	}
	h1 {
		font-size: 32px;
		letter-spacing: 1px;
	}
	.left_grid_info p {
		font-size: 14px;
	}
	.container {
		width: 90%;
	}
	.left_grid_info {
		padding-top: 1em;
	}
	.w3_info p {
		font-size: 14px;
	}
}

@media screen and (max-width: 384px) {
	.left_grid_info h4 {
		font-size: .9em;
	}
	.w3_info {
		padding: 2em 1em;
	}
	.left_grid_info h1 {
		font-size: 21px;
		letter-spacing: 0px;
	}
	.w3_info h2 {
		font-size: 18px;
	}
}

@media screen and (max-width: 375px) {
	.left_grid_info h3 {
		font-size: 1.5em;
	}
}

@media screen and (max-width: 320px) {
	h1 {
		font-size: 25px;
		letter-spacing: 1px;
	}
	.w3_info h2 {
		font-size: 18px;
		letter-spacing: 0px;
	}
	.btn-danger {
		padding: 13px 12px;
		font-size: 13px;
	}
	input[type="text"], input[type="email"], input[type="number"], input[type="password"] {
		font-size: 13px;
	}
	.footer p {
		font-size: 13px;
	}
	.footer p a {
		font-size: 13px;
	}
}
/** /Responsive **/
</style>
<style type="text/css">
/*!
 *  Font Awesome 4.7.0 by @davegandy - http://fontawesome.io - @fontawesome
 *  License - http://fontawesome.io/license (Font: SIL OFL 1.1, CSS: MIT License)
 */
@font-face {
	font-family: 'FontAwesome';
	src: url('../fonts/fontawesome-webfont.eot?v=4.7.0');
	src: url('../fonts/fontawesome-webfont.eot?#iefix&v=4.7.0')
		format('embedded-opentype'),
		url('../fonts/fontawesome-webfont.woff2?v=4.7.0') format('woff2'),
		url('../fonts/fontawesome-webfont.woff?v=4.7.0') format('woff'),
		url('../fonts/fontawesome-webfont.ttf?v=4.7.0') format('truetype'),
		url('../fonts/fontawesome-webfont.svg?v=4.7.0#fontawesomeregular')
		format('svg');
	font-weight: normal;
	font-style: normal
}

.fa {
	display: inline-block;
	font: normal normal normal 14px/1 FontAwesome;
	font-size: inherit;
	text-rendering: auto;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale
}

.fa-lg {
	font-size: 1.33333333em;
	line-height: .75em;
	vertical-align: -15%
}

.fa-2x {
	font-size: 2em
}

.fa-3x {
	font-size: 3em
}

.fa-4x {
	font-size: 4em
}

.fa-5x {
	font-size: 5em
}

.fa-fw {
	width: 1.28571429em;
	text-align: center
}

.fa-ul {
	padding-left: 0;
	margin-left: 2.14285714em;
	list-style-type: none
}

.fa-ul>li {
	position: relative
}

.fa-li {
	position: absolute;
	left: -2.14285714em;
	width: 2.14285714em;
	top: .14285714em;
	text-align: center
}

.fa-li.fa-lg {
	left: -1.85714286em
}

.fa-border {
	padding: .2em .25em .15em;
	border: solid .08em #eee;
	border-radius: .1em
}

.fa-pull-left {
	float: left
}

.fa-pull-right {
	float: right
}

.fa.fa-pull-left {
	margin-right: .3em
}

.fa.fa-pull-right {
	margin-left: .3em
}

.pull-right {
	float: right
}

.pull-left {
	float: left
}

.fa.pull-left {
	margin-right: .3em
}

.fa.pull-right {
	margin-left: .3em
}

.fa-spin {
	-webkit-animation: fa-spin 2s infinite linear;
	animation: fa-spin 2s infinite linear
}

.fa-pulse {
	-webkit-animation: fa-spin 1s infinite steps(8);
	animation: fa-spin 1s infinite steps(8)
}

@
-webkit-keyframes fa-spin { 0%{
	-webkit-transform: rotate(0deg);
	transform: rotate(0deg)
}

100%{
-webkit-transform








:rotate(359deg)








;
transform








:rotate(359deg)








}
}
@
keyframes fa-spin { 0%{
	-webkit-transform: rotate(0deg);
	transform: rotate(0deg)
}

100%{
-webkit-transform








:rotate(359deg)








;
transform








:rotate(359deg)








}
}
.fa-rotate-90 {
	-ms-filter: "progid:DXImageTransform.Microsoft.BasicImage(rotation=1)";
	-webkit-transform: rotate(90deg);
	-ms-transform: rotate(90deg);
	transform: rotate(90deg)
}

.fa-rotate-180 {
	-ms-filter: "progid:DXImageTransform.Microsoft.BasicImage(rotation=2)";
	-webkit-transform: rotate(180deg);
	-ms-transform: rotate(180deg);
	transform: rotate(180deg)
}

.fa-rotate-270 {
	-ms-filter: "progid:DXImageTransform.Microsoft.BasicImage(rotation=3)";
	-webkit-transform: rotate(270deg);
	-ms-transform: rotate(270deg);
	transform: rotate(270deg)
}

.fa-flip-horizontal {
	-ms-filter:
		"progid:DXImageTransform.Microsoft.BasicImage(rotation=0, mirror=1)";
	-webkit-transform: scale(-1, 1);
	-ms-transform: scale(-1, 1);
	transform: scale(-1, 1)
}

.fa-flip-vertical {
	-ms-filter:
		"progid:DXImageTransform.Microsoft.BasicImage(rotation=2, mirror=1)";
	-webkit-transform: scale(1, -1);
	-ms-transform: scale(1, -1);
	transform: scale(1, -1)
}

:root .fa-rotate-90, :root .fa-rotate-180, :root .fa-rotate-270, :root .fa-flip-horizontal,
	:root .fa-flip-vertical {
	filter: none
}

.fa-stack {
	position: relative;
	display: inline-block;
	width: 2em;
	height: 2em;
	line-height: 2em;
	vertical-align: middle
}

.fa-stack-1x, .fa-stack-2x {
	position: absolute;
	left: 0;
	width: 100%;
	text-align: center
}

.fa-stack-1x {
	line-height: inherit
}

.fa-stack-2x {
	font-size: 2em
}

.fa-inverse {
	color: #fff
}

.fa-glass:before {
	content: "\f000"
}

.fa-music:before {
	content: "\f001"
}

.fa-search:before {
	content: "\f002"
}

.fa-envelope-o:before {
	content: "\f003"
}

.fa-heart:before {
	content: "\f004"
}

.fa-star:before {
	content: "\f005"
}

.fa-star-o:before {
	content: "\f006"
}

.fa-user:before {
	content: "\f007"
}

.fa-film:before {
	content: "\f008"
}

.fa-th-large:before {
	content: "\f009"
}

.fa-th:before {
	content: "\f00a"
}

.fa-th-list:before {
	content: "\f00b"
}

.fa-check:before {
	content: "\f00c"
}

.fa-remove:before, .fa-close:before, .fa-times:before {
	content: "\f00d"
}

.fa-search-plus:before {
	content: "\f00e"
}

.fa-search-minus:before {
	content: "\f010"
}

.fa-power-off:before {
	content: "\f011"
}

.fa-signal:before {
	content: "\f012"
}

.fa-gear:before, .fa-cog:before {
	content: "\f013"
}

.fa-trash-o:before {
	content: "\f014"
}

.fa-home:before {
	content: "\f015"
}

.fa-file-o:before {
	content: "\f016"
}

.fa-clock-o:before {
	content: "\f017"
}

.fa-road:before {
	content: "\f018"
}

.fa-download:before {
	content: "\f019"
}

.fa-arrow-circle-o-down:before {
	content: "\f01a"
}

.fa-arrow-circle-o-up:before {
	content: "\f01b"
}

.fa-inbox:before {
	content: "\f01c"
}

.fa-play-circle-o:before {
	content: "\f01d"
}

.fa-rotate-right:before, .fa-repeat:before {
	content: "\f01e"
}

.fa-refresh:before {
	content: "\f021"
}

.fa-list-alt:before {
	content: "\f022"
}

.fa-lock:before {
	content: "\f023"
}

.fa-flag:before {
	content: "\f024"
}

.fa-headphones:before {
	content: "\f025"
}

.fa-volume-off:before {
	content: "\f026"
}

.fa-volume-down:before {
	content: "\f027"
}

.fa-volume-up:before {
	content: "\f028"
}

.fa-qrcode:before {
	content: "\f029"
}

.fa-barcode:before {
	content: "\f02a"
}

.fa-tag:before {
	content: "\f02b"
}

.fa-tags:before {
	content: "\f02c"
}

.fa-book:before {
	content: "\f02d"
}

.fa-bookmark:before {
	content: "\f02e"
}

.fa-print:before {
	content: "\f02f"
}

.fa-camera:before {
	content: "\f030"
}

.fa-font:before {
	content: "\f031"
}

.fa-bold:before {
	content: "\f032"
}

.fa-italic:before {
	content: "\f033"
}

.fa-text-height:before {
	content: "\f034"
}

.fa-text-width:before {
	content: "\f035"
}

.fa-align-left:before {
	content: "\f036"
}

.fa-align-center:before {
	content: "\f037"
}

.fa-align-right:before {
	content: "\f038"
}

.fa-align-justify:before {
	content: "\f039"
}

.fa-list:before {
	content: "\f03a"
}

.fa-dedent:before, .fa-outdent:before {
	content: "\f03b"
}

.fa-indent:before {
	content: "\f03c"
}

.fa-video-camera:before {
	content: "\f03d"
}

.fa-photo:before, .fa-image:before, .fa-picture-o:before {
	content: "\f03e"
}

.fa-pencil:before {
	content: "\f040"
}

.fa-map-marker:before {
	content: "\f041"
}

.fa-adjust:before {
	content: "\f042"
}

.fa-tint:before {
	content: "\f043"
}

.fa-edit:before, .fa-pencil-square-o:before {
	content: "\f044"
}

.fa-share-square-o:before {
	content: "\f045"
}

.fa-check-square-o:before {
	content: "\f046"
}

.fa-arrows:before {
	content: "\f047"
}

.fa-step-backward:before {
	content: "\f048"
}

.fa-fast-backward:before {
	content: "\f049"
}

.fa-backward:before {
	content: "\f04a"
}

.fa-play:before {
	content: "\f04b"
}

.fa-pause:before {
	content: "\f04c"
}

.fa-stop:before {
	content: "\f04d"
}

.fa-forward:before {
	content: "\f04e"
}

.fa-fast-forward:before {
	content: "\f050"
}

.fa-step-forward:before {
	content: "\f051"
}

.fa-eject:before {
	content: "\f052"
}

.fa-chevron-left:before {
	content: "\f053"
}

.fa-chevron-right:before {
	content: "\f054"
}

.fa-plus-circle:before {
	content: "\f055"
}

.fa-minus-circle:before {
	content: "\f056"
}

.fa-times-circle:before {
	content: "\f057"
}

.fa-check-circle:before {
	content: "\f058"
}

.fa-question-circle:before {
	content: "\f059"
}

.fa-info-circle:before {
	content: "\f05a"
}

.fa-crosshairs:before {
	content: "\f05b"
}

.fa-times-circle-o:before {
	content: "\f05c"
}

.fa-check-circle-o:before {
	content: "\f05d"
}

.fa-ban:before {
	content: "\f05e"
}

.fa-arrow-left:before {
	content: "\f060"
}

.fa-arrow-right:before {
	content: "\f061"
}

.fa-arrow-up:before {
	content: "\f062"
}

.fa-arrow-down:before {
	content: "\f063"
}

.fa-mail-forward:before, .fa-share:before {
	content: "\f064"
}

.fa-expand:before {
	content: "\f065"
}

.fa-compress:before {
	content: "\f066"
}

.fa-plus:before {
	content: "\f067"
}

.fa-minus:before {
	content: "\f068"
}

.fa-asterisk:before {
	content: "\f069"
}

.fa-exclamation-circle:before {
	content: "\f06a"
}

.fa-gift:before {
	content: "\f06b"
}

.fa-leaf:before {
	content: "\f06c"
}

.fa-fire:before {
	content: "\f06d"
}

.fa-eye:before {
	content: "\f06e"
}

.fa-eye-slash:before {
	content: "\f070"
}

.fa-warning:before, .fa-exclamation-triangle:before {
	content: "\f071"
}

.fa-plane:before {
	content: "\f072"
}

.fa-calendar:before {
	content: "\f073"
}

.fa-random:before {
	content: "\f074"
}

.fa-comment:before {
	content: "\f075"
}

.fa-magnet:before {
	content: "\f076"
}

.fa-chevron-up:before {
	content: "\f077"
}

.fa-chevron-down:before {
	content: "\f078"
}

.fa-retweet:before {
	content: "\f079"
}

.fa-shopping-cart:before {
	content: "\f07a"
}

.fa-folder:before {
	content: "\f07b"
}

.fa-folder-open:before {
	content: "\f07c"
}

.fa-arrows-v:before {
	content: "\f07d"
}

.fa-arrows-h:before {
	content: "\f07e"
}

.fa-bar-chart-o:before, .fa-bar-chart:before {
	content: "\f080"
}

.fa-twitter-square:before {
	content: "\f081"
}

.fa-facebook-square:before {
	content: "\f082"
}

.fa-camera-retro:before {
	content: "\f083"
}

.fa-key:before {
	content: "\f084"
}

.fa-gears:before, .fa-cogs:before {
	content: "\f085"
}

.fa-comments:before {
	content: "\f086"
}

.fa-thumbs-o-up:before {
	content: "\f087"
}

.fa-thumbs-o-down:before {
	content: "\f088"
}

.fa-star-half:before {
	content: "\f089"
}

.fa-heart-o:before {
	content: "\f08a"
}

.fa-sign-out:before {
	content: "\f08b"
}

.fa-linkedin-square:before {
	content: "\f08c"
}

.fa-thumb-tack:before {
	content: "\f08d"
}

.fa-external-link:before {
	content: "\f08e"
}

.fa-sign-in:before {
	content: "\f090"
}

.fa-trophy:before {
	content: "\f091"
}

.fa-github-square:before {
	content: "\f092"
}

.fa-upload:before {
	content: "\f093"
}

.fa-lemon-o:before {
	content: "\f094"
}

.fa-phone:before {
	content: "\f095"
}

.fa-square-o:before {
	content: "\f096"
}

.fa-bookmark-o:before {
	content: "\f097"
}

.fa-phone-square:before {
	content: "\f098"
}

.fa-twitter:before {
	content: "\f099"
}

.fa-facebook-f:before, .fa-facebook:before {
	content: "\f09a"
}

.fa-github:before {
	content: "\f09b"
}

.fa-unlock:before {
	content: "\f09c"
}

.fa-credit-card:before {
	content: "\f09d"
}

.fa-feed:before, .fa-rss:before {
	content: "\f09e"
}

.fa-hdd-o:before {
	content: "\f0a0"
}

.fa-bullhorn:before {
	content: "\f0a1"
}

.fa-bell:before {
	content: "\f0f3"
}

.fa-certificate:before {
	content: "\f0a3"
}

.fa-hand-o-right:before {
	content: "\f0a4"
}

.fa-hand-o-left:before {
	content: "\f0a5"
}

.fa-hand-o-up:before {
	content: "\f0a6"
}

.fa-hand-o-down:before {
	content: "\f0a7"
}

.fa-arrow-circle-left:before {
	content: "\f0a8"
}

.fa-arrow-circle-right:before {
	content: "\f0a9"
}

.fa-arrow-circle-up:before {
	content: "\f0aa"
}

.fa-arrow-circle-down:before {
	content: "\f0ab"
}

.fa-globe:before {
	content: "\f0ac"
}

.fa-wrench:before {
	content: "\f0ad"
}

.fa-tasks:before {
	content: "\f0ae"
}

.fa-filter:before {
	content: "\f0b0"
}

.fa-briefcase:before {
	content: "\f0b1"
}

.fa-arrows-alt:before {
	content: "\f0b2"
}

.fa-group:before, .fa-users:before {
	content: "\f0c0"
}

.fa-chain:before, .fa-link:before {
	content: "\f0c1"
}

.fa-cloud:before {
	content: "\f0c2"
}

.fa-flask:before {
	content: "\f0c3"
}

.fa-cut:before, .fa-scissors:before {
	content: "\f0c4"
}

.fa-copy:before, .fa-files-o:before {
	content: "\f0c5"
}

.fa-paperclip:before {
	content: "\f0c6"
}

.fa-save:before, .fa-floppy-o:before {
	content: "\f0c7"
}

.fa-square:before {
	content: "\f0c8"
}

.fa-navicon:before, .fa-reorder:before, .fa-bars:before {
	content: "\f0c9"
}

.fa-list-ul:before {
	content: "\f0ca"
}

.fa-list-ol:before {
	content: "\f0cb"
}

.fa-strikethrough:before {
	content: "\f0cc"
}

.fa-underline:before {
	content: "\f0cd"
}

.fa-table:before {
	content: "\f0ce"
}

.fa-magic:before {
	content: "\f0d0"
}

.fa-truck:before {
	content: "\f0d1"
}

.fa-pinterest:before {
	content: "\f0d2"
}

.fa-pinterest-square:before {
	content: "\f0d3"
}

.fa-google-plus-square:before {
	content: "\f0d4"
}

.fa-google-plus:before {
	content: "\f0d5"
}

.fa-money:before {
	content: "\f0d6"
}

.fa-caret-down:before {
	content: "\f0d7"
}

.fa-caret-up:before {
	content: "\f0d8"
}

.fa-caret-left:before {
	content: "\f0d9"
}

.fa-caret-right:before {
	content: "\f0da"
}

.fa-columns:before {
	content: "\f0db"
}

.fa-unsorted:before, .fa-sort:before {
	content: "\f0dc"
}

.fa-sort-down:before, .fa-sort-desc:before {
	content: "\f0dd"
}

.fa-sort-up:before, .fa-sort-asc:before {
	content: "\f0de"
}

.fa-envelope:before {
	content: "\f0e0"
}

.fa-linkedin:before {
	content: "\f0e1"
}

.fa-rotate-left:before, .fa-undo:before {
	content: "\f0e2"
}

.fa-legal:before, .fa-gavel:before {
	content: "\f0e3"
}

.fa-dashboard:before, .fa-tachometer:before {
	content: "\f0e4"
}

.fa-comment-o:before {
	content: "\f0e5"
}

.fa-comments-o:before {
	content: "\f0e6"
}

.fa-flash:before, .fa-bolt:before {
	content: "\f0e7"
}

.fa-sitemap:before {
	content: "\f0e8"
}

.fa-umbrella:before {
	content: "\f0e9"
}

.fa-paste:before, .fa-clipboard:before {
	content: "\f0ea"
}

.fa-lightbulb-o:before {
	content: "\f0eb"
}

.fa-exchange:before {
	content: "\f0ec"
}

.fa-cloud-download:before {
	content: "\f0ed"
}

.fa-cloud-upload:before {
	content: "\f0ee"
}

.fa-user-md:before {
	content: "\f0f0"
}

.fa-stethoscope:before {
	content: "\f0f1"
}

.fa-suitcase:before {
	content: "\f0f2"
}

.fa-bell-o:before {
	content: "\f0a2"
}

.fa-coffee:before {
	content: "\f0f4"
}

.fa-cutlery:before {
	content: "\f0f5"
}

.fa-file-text-o:before {
	content: "\f0f6"
}

.fa-building-o:before {
	content: "\f0f7"
}

.fa-hospital-o:before {
	content: "\f0f8"
}

.fa-ambulance:before {
	content: "\f0f9"
}

.fa-medkit:before {
	content: "\f0fa"
}

.fa-fighter-jet:before {
	content: "\f0fb"
}

.fa-beer:before {
	content: "\f0fc"
}

.fa-h-square:before {
	content: "\f0fd"
}

.fa-plus-square:before {
	content: "\f0fe"
}

.fa-angle-double-left:before {
	content: "\f100"
}

.fa-angle-double-right:before {
	content: "\f101"
}

.fa-angle-double-up:before {
	content: "\f102"
}

.fa-angle-double-down:before {
	content: "\f103"
}

.fa-angle-left:before {
	content: "\f104"
}

.fa-angle-right:before {
	content: "\f105"
}

.fa-angle-up:before {
	content: "\f106"
}

.fa-angle-down:before {
	content: "\f107"
}

.fa-desktop:before {
	content: "\f108"
}

.fa-laptop:before {
	content: "\f109"
}

.fa-tablet:before {
	content: "\f10a"
}

.fa-mobile-phone:before, .fa-mobile:before {
	content: "\f10b"
}

.fa-circle-o:before {
	content: "\f10c"
}

.fa-quote-left:before {
	content: "\f10d"
}

.fa-quote-right:before {
	content: "\f10e"
}

.fa-spinner:before {
	content: "\f110"
}

.fa-circle:before {
	content: "\f111"
}

.fa-mail-reply:before, .fa-reply:before {
	content: "\f112"
}

.fa-github-alt:before {
	content: "\f113"
}

.fa-folder-o:before {
	content: "\f114"
}

.fa-folder-open-o:before {
	content: "\f115"
}

.fa-smile-o:before {
	content: "\f118"
}

.fa-frown-o:before {
	content: "\f119"
}

.fa-meh-o:before {
	content: "\f11a"
}

.fa-gamepad:before {
	content: "\f11b"
}

.fa-keyboard-o:before {
	content: "\f11c"
}

.fa-flag-o:before {
	content: "\f11d"
}

.fa-flag-checkered:before {
	content: "\f11e"
}

.fa-terminal:before {
	content: "\f120"
}

.fa-code:before {
	content: "\f121"
}

.fa-mail-reply-all:before, .fa-reply-all:before {
	content: "\f122"
}

.fa-star-half-empty:before, .fa-star-half-full:before, .fa-star-half-o:before
	{
	content: "\f123"
}

.fa-location-arrow:before {
	content: "\f124"
}

.fa-crop:before {
	content: "\f125"
}

.fa-code-fork:before {
	content: "\f126"
}

.fa-unlink:before, .fa-chain-broken:before {
	content: "\f127"
}

.fa-question:before {
	content: "\f128"
}

.fa-info:before {
	content: "\f129"
}

.fa-exclamation:before {
	content: "\f12a"
}

.fa-superscript:before {
	content: "\f12b"
}

.fa-subscript:before {
	content: "\f12c"
}

.fa-eraser:before {
	content: "\f12d"
}

.fa-puzzle-piece:before {
	content: "\f12e"
}

.fa-microphone:before {
	content: "\f130"
}

.fa-microphone-slash:before {
	content: "\f131"
}

.fa-shield:before {
	content: "\f132"
}

.fa-calendar-o:before {
	content: "\f133"
}

.fa-fire-extinguisher:before {
	content: "\f134"
}

.fa-rocket:before {
	content: "\f135"
}

.fa-maxcdn:before {
	content: "\f136"
}

.fa-chevron-circle-left:before {
	content: "\f137"
}

.fa-chevron-circle-right:before {
	content: "\f138"
}

.fa-chevron-circle-up:before {
	content: "\f139"
}

.fa-chevron-circle-down:before {
	content: "\f13a"
}

.fa-html5:before {
	content: "\f13b"
}

.fa-css3:before {
	content: "\f13c"
}

.fa-anchor:before {
	content: "\f13d"
}

.fa-unlock-alt:before {
	content: "\f13e"
}

.fa-bullseye:before {
	content: "\f140"
}

.fa-ellipsis-h:before {
	content: "\f141"
}

.fa-ellipsis-v:before {
	content: "\f142"
}

.fa-rss-square:before {
	content: "\f143"
}

.fa-play-circle:before {
	content: "\f144"
}

.fa-ticket:before {
	content: "\f145"
}

.fa-minus-square:before {
	content: "\f146"
}

.fa-minus-square-o:before {
	content: "\f147"
}

.fa-level-up:before {
	content: "\f148"
}

.fa-level-down:before {
	content: "\f149"
}

.fa-check-square:before {
	content: "\f14a"
}

.fa-pencil-square:before {
	content: "\f14b"
}

.fa-external-link-square:before {
	content: "\f14c"
}

.fa-share-square:before {
	content: "\f14d"
}

.fa-compass:before {
	content: "\f14e"
}

.fa-toggle-down:before, .fa-caret-square-o-down:before {
	content: "\f150"
}

.fa-toggle-up:before, .fa-caret-square-o-up:before {
	content: "\f151"
}

.fa-toggle-right:before, .fa-caret-square-o-right:before {
	content: "\f152"
}

.fa-euro:before, .fa-eur:before {
	content: "\f153"
}

.fa-gbp:before {
	content: "\f154"
}

.fa-dollar:before, .fa-usd:before {
	content: "\f155"
}

.fa-rupee:before, .fa-inr:before {
	content: "\f156"
}

.fa-cny:before, .fa-rmb:before, .fa-yen:before, .fa-jpy:before {
	content: "\f157"
}

.fa-ruble:before, .fa-rouble:before, .fa-rub:before {
	content: "\f158"
}

.fa-won:before, .fa-krw:before {
	content: "\f159"
}

.fa-bitcoin:before, .fa-btc:before {
	content: "\f15a"
}

.fa-file:before {
	content: "\f15b"
}

.fa-file-text:before {
	content: "\f15c"
}

.fa-sort-alpha-asc:before {
	content: "\f15d"
}

.fa-sort-alpha-desc:before {
	content: "\f15e"
}

.fa-sort-amount-asc:before {
	content: "\f160"
}

.fa-sort-amount-desc:before {
	content: "\f161"
}

.fa-sort-numeric-asc:before {
	content: "\f162"
}

.fa-sort-numeric-desc:before {
	content: "\f163"
}

.fa-thumbs-up:before {
	content: "\f164"
}

.fa-thumbs-down:before {
	content: "\f165"
}

.fa-youtube-square:before {
	content: "\f166"
}

.fa-youtube:before {
	content: "\f167"
}

.fa-xing:before {
	content: "\f168"
}

.fa-xing-square:before {
	content: "\f169"
}

.fa-youtube-play:before {
	content: "\f16a"
}

.fa-dropbox:before {
	content: "\f16b"
}

.fa-stack-overflow:before {
	content: "\f16c"
}

.fa-instagram:before {
	content: "\f16d"
}

.fa-flickr:before {
	content: "\f16e"
}

.fa-adn:before {
	content: "\f170"
}

.fa-bitbucket:before {
	content: "\f171"
}

.fa-bitbucket-square:before {
	content: "\f172"
}

.fa-tumblr:before {
	content: "\f173"
}

.fa-tumblr-square:before {
	content: "\f174"
}

.fa-long-arrow-down:before {
	content: "\f175"
}

.fa-long-arrow-up:before {
	content: "\f176"
}

.fa-long-arrow-left:before {
	content: "\f177"
}

.fa-long-arrow-right:before {
	content: "\f178"
}

.fa-apple:before {
	content: "\f179"
}

.fa-windows:before {
	content: "\f17a"
}

.fa-android:before {
	content: "\f17b"
}

.fa-linux:before {
	content: "\f17c"
}

.fa-dribbble:before {
	content: "\f17d"
}

.fa-skype:before {
	content: "\f17e"
}

.fa-foursquare:before {
	content: "\f180"
}

.fa-trello:before {
	content: "\f181"
}

.fa-female:before {
	content: "\f182"
}

.fa-male:before {
	content: "\f183"
}

.fa-gittip:before, .fa-gratipay:before {
	content: "\f184"
}

.fa-sun-o:before {
	content: "\f185"
}

.fa-moon-o:before {
	content: "\f186"
}

.fa-archive:before {
	content: "\f187"
}

.fa-bug:before {
	content: "\f188"
}

.fa-vk:before {
	content: "\f189"
}

.fa-weibo:before {
	content: "\f18a"
}

.fa-renren:before {
	content: "\f18b"
}

.fa-pagelines:before {
	content: "\f18c"
}

.fa-stack-exchange:before {
	content: "\f18d"
}

.fa-arrow-circle-o-right:before {
	content: "\f18e"
}

.fa-arrow-circle-o-left:before {
	content: "\f190"
}

.fa-toggle-left:before, .fa-caret-square-o-left:before {
	content: "\f191"
}

.fa-dot-circle-o:before {
	content: "\f192"
}

.fa-wheelchair:before {
	content: "\f193"
}

.fa-vimeo-square:before {
	content: "\f194"
}

.fa-turkish-lira:before, .fa-try:before {
	content: "\f195"
}

.fa-plus-square-o:before {
	content: "\f196"
}

.fa-space-shuttle:before {
	content: "\f197"
}

.fa-slack:before {
	content: "\f198"
}

.fa-envelope-square:before {
	content: "\f199"
}

.fa-wordpress:before {
	content: "\f19a"
}

.fa-openid:before {
	content: "\f19b"
}

.fa-institution:before, .fa-bank:before, .fa-university:before {
	content: "\f19c"
}

.fa-mortar-board:before, .fa-graduation-cap:before {
	content: "\f19d"
}

.fa-yahoo:before {
	content: "\f19e"
}

.fa-google:before {
	content: "\f1a0"
}

.fa-reddit:before {
	content: "\f1a1"
}

.fa-reddit-square:before {
	content: "\f1a2"
}

.fa-stumbleupon-circle:before {
	content: "\f1a3"
}

.fa-stumbleupon:before {
	content: "\f1a4"
}

.fa-delicious:before {
	content: "\f1a5"
}

.fa-digg:before {
	content: "\f1a6"
}

.fa-pied-piper-pp:before {
	content: "\f1a7"
}

.fa-pied-piper-alt:before {
	content: "\f1a8"
}

.fa-drupal:before {
	content: "\f1a9"
}

.fa-joomla:before {
	content: "\f1aa"
}

.fa-language:before {
	content: "\f1ab"
}

.fa-fax:before {
	content: "\f1ac"
}

.fa-building:before {
	content: "\f1ad"
}

.fa-child:before {
	content: "\f1ae"
}

.fa-paw:before {
	content: "\f1b0"
}

.fa-spoon:before {
	content: "\f1b1"
}

.fa-cube:before {
	content: "\f1b2"
}

.fa-cubes:before {
	content: "\f1b3"
}

.fa-behance:before {
	content: "\f1b4"
}

.fa-behance-square:before {
	content: "\f1b5"
}

.fa-steam:before {
	content: "\f1b6"
}

.fa-steam-square:before {
	content: "\f1b7"
}

.fa-recycle:before {
	content: "\f1b8"
}

.fa-automobile:before, .fa-car:before {
	content: "\f1b9"
}

.fa-cab:before, .fa-taxi:before {
	content: "\f1ba"
}

.fa-tree:before {
	content: "\f1bb"
}

.fa-spotify:before {
	content: "\f1bc"
}

.fa-deviantart:before {
	content: "\f1bd"
}

.fa-soundcloud:before {
	content: "\f1be"
}

.fa-database:before {
	content: "\f1c0"
}

.fa-file-pdf-o:before {
	content: "\f1c1"
}

.fa-file-word-o:before {
	content: "\f1c2"
}

.fa-file-excel-o:before {
	content: "\f1c3"
}

.fa-file-powerpoint-o:before {
	content: "\f1c4"
}

.fa-file-photo-o:before, .fa-file-picture-o:before, .fa-file-image-o:before
	{
	content: "\f1c5"
}

.fa-file-zip-o:before, .fa-file-archive-o:before {
	content: "\f1c6"
}

.fa-file-sound-o:before, .fa-file-audio-o:before {
	content: "\f1c7"
}

.fa-file-movie-o:before, .fa-file-video-o:before {
	content: "\f1c8"
}

.fa-file-code-o:before {
	content: "\f1c9"
}

.fa-vine:before {
	content: "\f1ca"
}

.fa-codepen:before {
	content: "\f1cb"
}

.fa-jsfiddle:before {
	content: "\f1cc"
}

.fa-life-bouy:before, .fa-life-buoy:before, .fa-life-saver:before,
	.fa-support:before, .fa-life-ring:before {
	content: "\f1cd"
}

.fa-circle-o-notch:before {
	content: "\f1ce"
}

.fa-ra:before, .fa-resistance:before, .fa-rebel:before {
	content: "\f1d0"
}

.fa-ge:before, .fa-empire:before {
	content: "\f1d1"
}

.fa-git-square:before {
	content: "\f1d2"
}

.fa-git:before {
	content: "\f1d3"
}

.fa-y-combinator-square:before, .fa-yc-square:before, .fa-hacker-news:before
	{
	content: "\f1d4"
}

.fa-tencent-weibo:before {
	content: "\f1d5"
}

.fa-qq:before {
	content: "\f1d6"
}

.fa-wechat:before, .fa-weixin:before {
	content: "\f1d7"
}

.fa-send:before, .fa-paper-plane:before {
	content: "\f1d8"
}

.fa-send-o:before, .fa-paper-plane-o:before {
	content: "\f1d9"
}

.fa-history:before {
	content: "\f1da"
}

.fa-circle-thin:before {
	content: "\f1db"
}

.fa-header:before {
	content: "\f1dc"
}

.fa-paragraph:before {
	content: "\f1dd"
}

.fa-sliders:before {
	content: "\f1de"
}

.fa-share-alt:before {
	content: "\f1e0"
}

.fa-share-alt-square:before {
	content: "\f1e1"
}

.fa-bomb:before {
	content: "\f1e2"
}

.fa-soccer-ball-o:before, .fa-futbol-o:before {
	content: "\f1e3"
}

.fa-tty:before {
	content: "\f1e4"
}

.fa-binoculars:before {
	content: "\f1e5"
}

.fa-plug:before {
	content: "\f1e6"
}

.fa-slideshare:before {
	content: "\f1e7"
}

.fa-twitch:before {
	content: "\f1e8"
}

.fa-yelp:before {
	content: "\f1e9"
}

.fa-newspaper-o:before {
	content: "\f1ea"
}

.fa-wifi:before {
	content: "\f1eb"
}

.fa-calculator:before {
	content: "\f1ec"
}

.fa-paypal:before {
	content: "\f1ed"
}

.fa-google-wallet:before {
	content: "\f1ee"
}

.fa-cc-visa:before {
	content: "\f1f0"
}

.fa-cc-mastercard:before {
	content: "\f1f1"
}

.fa-cc-discover:before {
	content: "\f1f2"
}

.fa-cc-amex:before {
	content: "\f1f3"
}

.fa-cc-paypal:before {
	content: "\f1f4"
}

.fa-cc-stripe:before {
	content: "\f1f5"
}

.fa-bell-slash:before {
	content: "\f1f6"
}

.fa-bell-slash-o:before {
	content: "\f1f7"
}

.fa-trash:before {
	content: "\f1f8"
}

.fa-copyright:before {
	content: "\f1f9"
}

.fa-at:before {
	content: "\f1fa"
}

.fa-eyedropper:before {
	content: "\f1fb"
}

.fa-paint-brush:before {
	content: "\f1fc"
}

.fa-birthday-cake:before {
	content: "\f1fd"
}

.fa-area-chart:before {
	content: "\f1fe"
}

.fa-pie-chart:before {
	content: "\f200"
}

.fa-line-chart:before {
	content: "\f201"
}

.fa-lastfm:before {
	content: "\f202"
}

.fa-lastfm-square:before {
	content: "\f203"
}

.fa-toggle-off:before {
	content: "\f204"
}

.fa-toggle-on:before {
	content: "\f205"
}

.fa-bicycle:before {
	content: "\f206"
}

.fa-bus:before {
	content: "\f207"
}

.fa-ioxhost:before {
	content: "\f208"
}

.fa-angellist:before {
	content: "\f209"
}

.fa-cc:before {
	content: "\f20a"
}

.fa-shekel:before, .fa-sheqel:before, .fa-ils:before {
	content: "\f20b"
}

.fa-meanpath:before {
	content: "\f20c"
}

.fa-buysellads:before {
	content: "\f20d"
}

.fa-connectdevelop:before {
	content: "\f20e"
}

.fa-dashcube:before {
	content: "\f210"
}

.fa-forumbee:before {
	content: "\f211"
}

.fa-leanpub:before {
	content: "\f212"
}

.fa-sellsy:before {
	content: "\f213"
}

.fa-shirtsinbulk:before {
	content: "\f214"
}

.fa-simplybuilt:before {
	content: "\f215"
}

.fa-skyatlas:before {
	content: "\f216"
}

.fa-cart-plus:before {
	content: "\f217"
}

.fa-cart-arrow-down:before {
	content: "\f218"
}

.fa-diamond:before {
	content: "\f219"
}

.fa-ship:before {
	content: "\f21a"
}

.fa-user-secret:before {
	content: "\f21b"
}

.fa-motorcycle:before {
	content: "\f21c"
}

.fa-street-view:before {
	content: "\f21d"
}

.fa-heartbeat:before {
	content: "\f21e"
}

.fa-venus:before {
	content: "\f221"
}

.fa-mars:before {
	content: "\f222"
}

.fa-mercury:before {
	content: "\f223"
}

.fa-intersex:before, .fa-transgender:before {
	content: "\f224"
}

.fa-transgender-alt:before {
	content: "\f225"
}

.fa-venus-double:before {
	content: "\f226"
}

.fa-mars-double:before {
	content: "\f227"
}

.fa-venus-mars:before {
	content: "\f228"
}

.fa-mars-stroke:before {
	content: "\f229"
}

.fa-mars-stroke-v:before {
	content: "\f22a"
}

.fa-mars-stroke-h:before {
	content: "\f22b"
}

.fa-neuter:before {
	content: "\f22c"
}

.fa-genderless:before {
	content: "\f22d"
}

.fa-facebook-official:before {
	content: "\f230"
}

.fa-pinterest-p:before {
	content: "\f231"
}

.fa-whatsapp:before {
	content: "\f232"
}

.fa-server:before {
	content: "\f233"
}

.fa-user-plus:before {
	content: "\f234"
}

.fa-user-times:before {
	content: "\f235"
}

.fa-hotel:before, .fa-bed:before {
	content: "\f236"
}

.fa-viacoin:before {
	content: "\f237"
}

.fa-train:before {
	content: "\f238"
}

.fa-subway:before {
	content: "\f239"
}

.fa-medium:before {
	content: "\f23a"
}

.fa-yc:before, .fa-y-combinator:before {
	content: "\f23b"
}

.fa-optin-monster:before {
	content: "\f23c"
}

.fa-opencart:before {
	content: "\f23d"
}

.fa-expeditedssl:before {
	content: "\f23e"
}

.fa-battery-4:before, .fa-battery:before, .fa-battery-full:before {
	content: "\f240"
}

.fa-battery-3:before, .fa-battery-three-quarters:before {
	content: "\f241"
}

.fa-battery-2:before, .fa-battery-half:before {
	content: "\f242"
}

.fa-battery-1:before, .fa-battery-quarter:before {
	content: "\f243"
}

.fa-battery-0:before, .fa-battery-empty:before {
	content: "\f244"
}

.fa-mouse-pointer:before {
	content: "\f245"
}

.fa-i-cursor:before {
	content: "\f246"
}

.fa-object-group:before {
	content: "\f247"
}

.fa-object-ungroup:before {
	content: "\f248"
}

.fa-sticky-note:before {
	content: "\f249"
}

.fa-sticky-note-o:before {
	content: "\f24a"
}

.fa-cc-jcb:before {
	content: "\f24b"
}

.fa-cc-diners-club:before {
	content: "\f24c"
}

.fa-clone:before {
	content: "\f24d"
}

.fa-balance-scale:before {
	content: "\f24e"
}

.fa-hourglass-o:before {
	content: "\f250"
}

.fa-hourglass-1:before, .fa-hourglass-start:before {
	content: "\f251"
}

.fa-hourglass-2:before, .fa-hourglass-half:before {
	content: "\f252"
}

.fa-hourglass-3:before, .fa-hourglass-end:before {
	content: "\f253"
}

.fa-hourglass:before {
	content: "\f254"
}

.fa-hand-grab-o:before, .fa-hand-rock-o:before {
	content: "\f255"
}

.fa-hand-stop-o:before, .fa-hand-paper-o:before {
	content: "\f256"
}

.fa-hand-scissors-o:before {
	content: "\f257"
}

.fa-hand-lizard-o:before {
	content: "\f258"
}

.fa-hand-spock-o:before {
	content: "\f259"
}

.fa-hand-pointer-o:before {
	content: "\f25a"
}

.fa-hand-peace-o:before {
	content: "\f25b"
}

.fa-trademark:before {
	content: "\f25c"
}

.fa-registered:before {
	content: "\f25d"
}

.fa-creative-commons:before {
	content: "\f25e"
}

.fa-gg:before {
	content: "\f260"
}

.fa-gg-circle:before {
	content: "\f261"
}

.fa-tripadvisor:before {
	content: "\f262"
}

.fa-odnoklassniki:before {
	content: "\f263"
}

.fa-odnoklassniki-square:before {
	content: "\f264"
}

.fa-get-pocket:before {
	content: "\f265"
}

.fa-wikipedia-w:before {
	content: "\f266"
}

.fa-safari:before {
	content: "\f267"
}

.fa-chrome:before {
	content: "\f268"
}

.fa-firefox:before {
	content: "\f269"
}

.fa-opera:before {
	content: "\f26a"
}

.fa-internet-explorer:before {
	content: "\f26b"
}

.fa-tv:before, .fa-television:before {
	content: "\f26c"
}

.fa-contao:before {
	content: "\f26d"
}

.fa-500px:before {
	content: "\f26e"
}

.fa-amazon:before {
	content: "\f270"
}

.fa-calendar-plus-o:before {
	content: "\f271"
}

.fa-calendar-minus-o:before {
	content: "\f272"
}

.fa-calendar-times-o:before {
	content: "\f273"
}

.fa-calendar-check-o:before {
	content: "\f274"
}

.fa-industry:before {
	content: "\f275"
}

.fa-map-pin:before {
	content: "\f276"
}

.fa-map-signs:before {
	content: "\f277"
}

.fa-map-o:before {
	content: "\f278"
}

.fa-map:before {
	content: "\f279"
}

.fa-commenting:before {
	content: "\f27a"
}

.fa-commenting-o:before {
	content: "\f27b"
}

.fa-houzz:before {
	content: "\f27c"
}

.fa-vimeo:before {
	content: "\f27d"
}

.fa-black-tie:before {
	content: "\f27e"
}

.fa-fonticons:before {
	content: "\f280"
}

.fa-reddit-alien:before {
	content: "\f281"
}

.fa-edge:before {
	content: "\f282"
}

.fa-credit-card-alt:before {
	content: "\f283"
}

.fa-codiepie:before {
	content: "\f284"
}

.fa-modx:before {
	content: "\f285"
}

.fa-fort-awesome:before {
	content: "\f286"
}

.fa-usb:before {
	content: "\f287"
}

.fa-product-hunt:before {
	content: "\f288"
}

.fa-mixcloud:before {
	content: "\f289"
}

.fa-scribd:before {
	content: "\f28a"
}

.fa-pause-circle:before {
	content: "\f28b"
}

.fa-pause-circle-o:before {
	content: "\f28c"
}

.fa-stop-circle:before {
	content: "\f28d"
}

.fa-stop-circle-o:before {
	content: "\f28e"
}

.fa-shopping-bag:before {
	content: "\f290"
}

.fa-shopping-basket:before {
	content: "\f291"
}

.fa-hashtag:before {
	content: "\f292"
}

.fa-bluetooth:before {
	content: "\f293"
}

.fa-bluetooth-b:before {
	content: "\f294"
}

.fa-percent:before {
	content: "\f295"
}

.fa-gitlab:before {
	content: "\f296"
}

.fa-wpbeginner:before {
	content: "\f297"
}

.fa-wpforms:before {
	content: "\f298"
}

.fa-envira:before {
	content: "\f299"
}

.fa-universal-access:before {
	content: "\f29a"
}

.fa-wheelchair-alt:before {
	content: "\f29b"
}

.fa-question-circle-o:before {
	content: "\f29c"
}

.fa-blind:before {
	content: "\f29d"
}

.fa-audio-description:before {
	content: "\f29e"
}

.fa-volume-control-phone:before {
	content: "\f2a0"
}

.fa-braille:before {
	content: "\f2a1"
}

.fa-assistive-listening-systems:before {
	content: "\f2a2"
}

.fa-asl-interpreting:before, .fa-american-sign-language-interpreting:before
	{
	content: "\f2a3"
}

.fa-deafness:before, .fa-hard-of-hearing:before, .fa-deaf:before {
	content: "\f2a4"
}

.fa-glide:before {
	content: "\f2a5"
}

.fa-glide-g:before {
	content: "\f2a6"
}

.fa-signing:before, .fa-sign-language:before {
	content: "\f2a7"
}

.fa-low-vision:before {
	content: "\f2a8"
}

.fa-viadeo:before {
	content: "\f2a9"
}

.fa-viadeo-square:before {
	content: "\f2aa"
}

.fa-snapchat:before {
	content: "\f2ab"
}

.fa-snapchat-ghost:before {
	content: "\f2ac"
}

.fa-snapchat-square:before {
	content: "\f2ad"
}

.fa-pied-piper:before {
	content: "\f2ae"
}

.fa-first-order:before {
	content: "\f2b0"
}

.fa-yoast:before {
	content: "\f2b1"
}

.fa-themeisle:before {
	content: "\f2b2"
}

.fa-google-plus-circle:before, .fa-google-plus-official:before {
	content: "\f2b3"
}

.fa-fa:before, .fa-font-awesome:before {
	content: "\f2b4"
}

.fa-handshake-o:before {
	content: "\f2b5"
}

.fa-envelope-open:before {
	content: "\f2b6"
}

.fa-envelope-open-o:before {
	content: "\f2b7"
}

.fa-linode:before {
	content: "\f2b8"
}

.fa-address-book:before {
	content: "\f2b9"
}

.fa-address-book-o:before {
	content: "\f2ba"
}

.fa-vcard:before, .fa-address-card:before {
	content: "\f2bb"
}

.fa-vcard-o:before, .fa-address-card-o:before {
	content: "\f2bc"
}

.fa-user-circle:before {
	content: "\f2bd"
}

.fa-user-circle-o:before {
	content: "\f2be"
}

.fa-user-o:before {
	content: "\f2c0"
}

.fa-id-badge:before {
	content: "\f2c1"
}

.fa-drivers-license:before, .fa-id-card:before {
	content: "\f2c2"
}

.fa-drivers-license-o:before, .fa-id-card-o:before {
	content: "\f2c3"
}

.fa-quora:before {
	content: "\f2c4"
}

.fa-free-code-camp:before {
	content: "\f2c5"
}

.fa-telegram:before {
	content: "\f2c6"
}

.fa-thermometer-4:before, .fa-thermometer:before, .fa-thermometer-full:before
	{
	content: "\f2c7"
}

.fa-thermometer-3:before, .fa-thermometer-three-quarters:before {
	content: "\f2c8"
}

.fa-thermometer-2:before, .fa-thermometer-half:before {
	content: "\f2c9"
}

.fa-thermometer-1:before, .fa-thermometer-quarter:before {
	content: "\f2ca"
}

.fa-thermometer-0:before, .fa-thermometer-empty:before {
	content: "\f2cb"
}

.fa-shower:before {
	content: "\f2cc"
}

.fa-bathtub:before, .fa-s15:before, .fa-bath:before {
	content: "\f2cd"
}

.fa-podcast:before {
	content: "\f2ce"
}

.fa-window-maximize:before {
	content: "\f2d0"
}

.fa-window-minimize:before {
	content: "\f2d1"
}

.fa-window-restore:before {
	content: "\f2d2"
}

.fa-times-rectangle:before, .fa-window-close:before {
	content: "\f2d3"
}

.fa-times-rectangle-o:before, .fa-window-close-o:before {
	content: "\f2d4"
}

.fa-bandcamp:before {
	content: "\f2d5"
}

.fa-grav:before {
	content: "\f2d6"
}

.fa-etsy:before {
	content: "\f2d7"
}

.fa-imdb:before {
	content: "\f2d8"
}

.fa-ravelry:before {
	content: "\f2d9"
}

.fa-eercast:before {
	content: "\f2da"
}

.fa-microchip:before {
	content: "\f2db"
}

.fa-snowflake-o:before {
	content: "\f2dc"
}

.fa-superpowers:before {
	content: "\f2dd"
}

.fa-wpexplorer:before {
	content: "\f2de"
}

.fa-meetup:before {
	content: "\f2e0"
}

.sr-only {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0
}

.sr-only-focusable:active, .sr-only-focusable:focus {
	position: static;
	width: auto;
	height: auto;
	margin: 0;
	overflow: visible;
	clip: auto
}
</style>
<!-- //css files -->

<!-- google fonts -->
<link href="resources/css" rel="stylesheet">
<!-- //google fonts -->


</head>
<body style="">
	<div class="signupform">
		<div class="container">
			<!-- main content -->
			<!---728x90--->

			<div class="agile_info">
				<div class="w3l_form">
					<div class="left_grid_info">
						<h1>Manage Your Money</h1>
						<p>Money Manager is an application used to manage your money
							track your incomes investments and expences.</p>
						<img
							src="data:image/png;base64,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"
							alt="">
					</div>
				</div>

				<div class="w3_info">
					<!---728x90--->


					<h2>User Registration</h2>
					<p>Enter your details to SignUp.</p>
					<h5 style="color: red">${error} </h5>
					<form:form action="/user/register" method="post" modelAttribute="register">
						<label>User Name</label>
						<div class="input-group">
							<span class="fa fa-envelope" aria-hidden="true"></span>
							<form:input path="name" type="text"
								placeholder="Enter Your Name" required="required" />
						</div>
						<label>Email Address</label>
						<div class="input-group">
							<span class="fa fa-envelope" aria-hidden="true"></span>
							<form:input path="emailId" type="email" placeholder="Enter Your Email"
								required="required" />
						</div>
						<label>Mobile Number</label>
						<div class="input-group">
							<span class="fa fa-envelope" aria-hidden="true"></span>
							<form:input path="mobileNumber" type="number" id = "phone" name="phone" placeholder="Enter Your Mobile Number"
								required="required" />
						</div>
						<label>DOB</label>
						<div class="input-group  ">
							<form:input path="dateOfBirth" type="date" required="required" />
						</div>
						<label>Gender</label>
						<br>
						<br>
						<div>
							<form:radiobutton path="gender" value="male" checked="checked" />
							Male
							<form:radiobutton path="gender" value="female" />
							Female
						</div>
						<br>
						<label>Password</label>
						<div class="input-group">
							<span class="fa fa-envelope" aria-hidden="true"></span>
							<form:input path="password" type="password" id="password" name="password" placeholder="Enter Your Password"
								required="required" /><br>
								</div>
								<label>Confirm Password <span id='message'></span></label>
						<div class="input-group">
							<span class="fa fa-envelope" aria-hidden="true"></span>
							<form:input path="confirmPassword" type="password" name="confirm_password" id="confirm_password" placeholder="Re-Enter Your Password"
								required="required" /><br>
								</div>
								<div>
						 <br></div>
						
						
						<button class="btn btn-danger btn-block" type="submit" id="submit" >REGISTER</button>
					</form:form>
					<p class="account">
						By clicking Register, you agree to our <a
							href="https://www.signupto.com/legal/">Terms &amp;
							Conditions!</a>
					</p>
					<p class="account1">
						I have an account <a href="/user-login">Login
							here</a>
					</p>

					<!-- 	<form action="/welcome" method="post">
						<label>Email Address</label>
						<div class="input-group">
							<span class="fa fa-envelope" aria-hidden="true"></span> <input
								type="email" placeholder="Enter Your Email" required="">
						</div>

						<label>Password</label>
						<div class="input-group">
							<span class="fa fa-lock" aria-hidden="true"></span> <input
								type="Password" placeholder="Enter Password" required="">
						</div>
				
						<div class="login-check">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i> </i> Remember me</label>
						</div>
						<button class="btn btn-danger btn-block" type="submit">Login</button>
					</form> -->

				</div>
			</div>
			<!-- //main content -->
		</div>
		<!---728x90--->

		<!-- footer -->
		<div class="footer">
			<p>Money Manager. All Rights Reserved | Designed by Team Virtusa</p>
		</div>
		<!-- footer -->
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript">
		$('#password,#confirm_password').on('keyup', function() {
			if ( $('#password').val() == $('#confirm_password').val()) {
				$('#message').html('Matching').css('color', 'green');
			} else
				$('#message').html('Not Matching').css('color', 'red');
			document.getElementById('submit').disabled = "disabled";
		});
		
	</script>
</body>
</html>