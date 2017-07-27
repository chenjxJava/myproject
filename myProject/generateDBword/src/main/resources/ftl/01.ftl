<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1></h1>
	<#list root?keys as key>
		${key} -----------${map[key]}
	</#list>
</body>
</html>