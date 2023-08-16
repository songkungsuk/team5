<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h3>update</h3>
		제목 : <input type="text" id="biTitle"><br>
		내용 : <textarea id="biContent"></textarea><br>
		작성자번호 : <input type="number" id="uiNum"><br>
		작성자이름 : <input type="text" id="uiName"><br>
		<button onclick="updateBoard()">수정</button>
	</div>
	<script>
		function updateBoard() {
			const json = JSON.stringify({
				biTitle: document.querySelector('#biTitle').value,
				biContent: document.querySelector('#biTitle').value,
				uiNum: document.querySelector('#uiNum').value,
				uiName: document.querySelector('#uiName').value,
				biNum: ${param.biNum}
			})
			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/t3-info/update?biNum=${param.biNum}');
			xhr.onreadystatechange = function() {
				if(xhr.readyState === 4) {
					if(xhr.status === 200) {
						console.log(xhr.responseText);
						if(xhr.responseText === '1') {
							alert('수정 완료');
							location.href='/views/table_3/list';
						} else {
							alert('수정 오류');
							location.href='/views/tanle_3/list';
						}
					}
				}
			}
			xhr.send(json);
		}
		window.addEventListener('load', function() {
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/t3-info/view?biNum=${param.biNum}');
			xhr.onreadystatechange = function() {
				if(xhr.readyState === 4) {
					if(xhr.status === 200) {
						console.log(xhr.responseText);
						const obj = JSON.parse(xhr.responseText);
						document.querySelector('#biTitle').value = obj.biTitle;
						document.querySelector('#biContent').value = obj.biContent;
						document.querySelector('#uiNum').value = obj.uiNum;
						document.querySelector('#uiName').value = obj.uiName;
					}
				}
			}
			xhr.send();
		});
	</script>
</body>
</html>