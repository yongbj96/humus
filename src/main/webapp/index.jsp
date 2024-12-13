<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	 
		<h2>주문내역 입력</h2>
		<form action="/postOneData" method="post">
		    <fieldset>
		        <legend>입력</legend>
		        <p>
		            - 주문 ID: <input type="text" name="index" size="10"><br>
		            - 고객명: <input type="text" name="name" size="10"><br>
					<label for="date">
						- 주문날짜: <input type="date" id="date" name="date" min="2024-12-01" max="2024-12-31"><br>
					</label>
					- 주문상태:
					<input type='radio' name='status' value='0' checked/>처리중
					<input type='radio' name='status' value='1' />배송중
					<input type='radio' name='status' value='2' />완료
		            <input type="submit" value="입력">
		        </p>
		    </fieldset>
		    
		</form>
	<script>
		Date.prototype.addDays = function (days) {
		    var date = this;
		    return new Date(date.setDate(date.getDate() + days));
		};
		
		document.getElementById('date').value = new Date().addDays(1).toISOString().substring(0, 10);
	</script>
	</body>
</html>