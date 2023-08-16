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
		<h3>insert</h3>
		제목 : <input type="text" id="biTitle"><br>
		내용 : <textarea id="biContent"></textarea><br>
		작성자번호 : <input type="number" id="uiNum"><br>
		작성자이름 : <input type="text" id="uiName"><br>
		<button onclick="insertBoard()">작성</button>
	</div>
	<script>
		function insertBoard() {
			const json = JSON.stringify({
				biTitle: document.querySelector('#biTitle').value,
				biContent: document.querySelector('#biContent').value,
				uiNum: document.querySelector('#uiNum').value,
				uiName: document.querySelector('#uiName').value
			});
			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/t3-info/insert');
			xhr.onreadystatechange = function() {
				if(xhr.readyState === 4) {
					if(xhr.status === 200) {
						console.log(xhr.responseText);
						if(xhr.responseText === '1') {
							alert('등록 완료');
							location.href='/views/table_3/list';
						} else {
							alert('오류');
							location.href='/views/table_3/list';
						}
					}
				}
			}
			xhr.send(json);
		}
	</script>
</body>
</html>