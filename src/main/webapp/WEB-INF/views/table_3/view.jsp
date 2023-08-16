<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h3>view</h3>
		<table border="1">
			<tr>
				<th>번호</th>
				<td id="biNum"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td id="biTitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td id="biContent"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td id="uiName"></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td id="credat"></td>
			</tr>
		</table>
		<button onclick="location.href='/views/table_3/update?biNum=${param.biNum}'">수정</button>
		<button onclick="deleteBoard()">삭제</button>
	</div>
	<script>
		function deleteBoard() {
			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/t3-info/delete?biNum=${param.biNum}');
			xhr.onreadystatechange = function() {
				if(xhr.readyState === 4) {
					if(xhr.status === 200) {
						console.log(xhr.response);
						if(xhr.response === '1') {
							alert('삭제 완료');
							location.href='/views/table_3/list';	
						} else {
							alert('삭제 오류');
							location.href='/views/table_3/list';
						}
					}
				}
			}
			xhr.send();
		}
		
		window.addEventListener('load', function() {
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/t3-info/view?biNum=${param.biNum}');
			xhr.onreadystatechange = function() {
				if(xhr.readyState === 4) {
					if(xhr.status === 200) {
						console.log(xhr.responseText);
						const obj = JSON.parse(xhr.responseText);
						document.querySelector('#biNum').innerText = obj.biNum;
						document.querySelector('#biTitle').innerText = obj.biTitle;
						document.querySelector('#biContent').innerText = obj.biContent;
						document.querySelector('#uiName').innerText = obj.uiName;
						document.querySelector('#credat').innerText = obj.credat;
					}
				}
			}
			xhr.send();
		});
	</script>
</body>
</html>