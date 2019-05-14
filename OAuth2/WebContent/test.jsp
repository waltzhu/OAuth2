<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/base64.js"></script>
<title>test.jsp</title>
</head>
<script type="text/javascript">
	
	function ajaxTest() {
		var type = "1001";
		$.ajax({
			type : "post",
			url : "test/welCome",
			dataType : "json",
			data : {reqType : type} ,
			success : function(data) {
				$("#div1").html(data.uuid + "<br>" + 
						data.welMsg + "<br>"+
						data.dateTime);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
			}
		});
	}
	
	function ajaxTest1() {
		var type = "1001";
		var reqMsg = " ak test not allow visit";
		var ak = $.cookie('ak') ;
		alert(ak+"---ak");
		
		$.ajax({
			type : "post",
			url : "api/map?access_token="+ak,
			dataType : "json",
			data : {"reqType" : type, "reqMsg" : reqMsg} ,
			success : function(data) {
				$("#div1").html(data.uuid + "<br>" + 
						data.welMsg + "<br>"+
						data.dateTime);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
			}
		});
	}
	function ajaxTest2() {
		$.cookie('ak', "");
		$.cookie('code',"");
	}
	
	function ajaxTest3() {
		var clientId = "my-trusted-client";
		//var redirectUrl = "http://127.0.0.1:9080/index.html";
		var redirectUrl = "http://localhost:8080/springMVC/index.html";
		var para = prompt("clientId#redirectUrl","MwonYjDKBuPtLLlK#http://localhost:8080/springMVC/index.html");
		var paraMap = para.split("#"); 
		clientId = paraMap[0];
		redirectUrl = paraMap[1];
		console.log("args:" + clientId + "---" + redirectUrl);
		alert("args:" + clientId + "---" + redirectUrl);
		
		window.location.href = "oauth/authorize?client_id="
				+clientId+"&response_type=code&scope=read&redirect_uri="
				+redirectUrl;
	}
	
	function ajaxTest4() {
		var para = prompt("clientId#redirectUrl","MwonYjDKBuPtLLlK#http://localhost:8080/springMVC/index.html");
		var paraMap = para.split("#"); 
		clientId = paraMap[0];
		redirectUrl = paraMap[1];
		var code = $.cookie('code');
// 		var clientId = "my-trusted-client";
// 		var redirectUrl = "http://127.0.0.1:9080/index.html";
		var client_secret="secret";
		var grant_type="authorization_code";
		//var su="TXdvbllqREtCdVB0TExsSzpzZWNyZXQ=";
		var b = new Base64();  
        var su = b.encode(clientId+":"+client_secret); 
        console.log(su);
		$.ajax({
			type : "post",
			url : "oauth/token",
			dataType : "json",
			data : {"client_id" : clientId, "client_secret" : client_secret,"grant_type" : grant_type, "redirect_uri" : redirectUrl,"code":code} ,
// 			beforeSend:function(xhr){
// 				xhr.setRequestHeader('Authorization', "Basic "+ su);
// 			},
			success : function(data) {
				$("#div4").html(data.access_token + "<br>" + 
						data.refresh_token + "<br>"+
						data.expires_in);
				$.cookie('ak', data.access_token);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
			}
		});
	}
	
	function ajaxTest5() {
		$.ajax({
			type : "post",
			url : "/logout",
			dataType : "text",
			success : function(data) {
				$("#div2").html("yi log out");
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
			}
		});
	}
</script>
<body>
<center>
	Test.jsp-----Hello World  
	<div id="div1"></div>
	<div id="div2"></div>
	<button type="button" style="display: none" onclick="ajaxTest()">Welcome</button>  <button type="button" style="display: none" onclick="ajaxTest5()">log  out</button>	<br><br>
	<button type="button" onclick="ajaxTest1()">no auth test</button>	<button type="button" onclick="ajaxTest2()">clear ak</button><br><br>
	<button type="button" onclick="window.location.href='auth.jsp?clientId=bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0'">uname/password mode</button><br><br>
	<button type="button" onclick="ajaxTest3()">auth mode</button>
	<button type="button" onclick="ajaxTest4()">get token</button>
	<br>
	<div id="div3"></div>
	<div id="div4"></div>
	</center>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#div1").html("hehe");
			var searchStr = location.search.substr(1);  
			if(searchStr){
				var searchs = searchStr.split("&"); 
				$("#div2").html("ui request param:" + searchs[0] + "and "+searchs[1] );
				alert("1");
				$.cookie('ak', searchs[0]);
				$.cookie('rk', searchs[1]);
				alert("2");
				var code = searchs[0].split("="); 
				alert("code.length---"+code.length);
				alert("code---"+code);
				if(code.length == 2){
					$("#div3").html("<h3>i get the auth code:" + code[1] +"</h3>");
					$.cookie('code', code[1]);
					$.cookie('ak', "");
					$.cookie('rk', "");
				}
			}
			
		});
	</script>
</body>
</html> 