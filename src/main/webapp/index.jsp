<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	 
		<h2>Redis 테스트!!</h2>
		<form action="/add" method="post">
		    <fieldset>
		        <legend>값 입력</legend>
		        <p>
		            - KEY: <input type="text" name="key" size="10"><br>
		            - VALUE: <input type="text" name="value" size="10"><br>
		            <input type="submit" value="입력">
		        </p>
		    </fieldset>
		    
		</form>
	 
	</body>
</html>