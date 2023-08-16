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
		<h3>list</h3>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<tbody id="tBody"></tbody>
		</table>
		<button onclick="location.href='/views/table_3/insert'">등록</button>
	</div>
	<script>
		window.addEventListener('load', function() {
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/t3-info/list');
			xhr.onreadystatechange = function() {
				if(xhr.readyState === 4) {
					if(xhr.status === 200) {
						console.log(xhr.responseText);
						const list = JSON.parse(xhr.responseText);
						let html = '';
						for(const obj of list) {
							html += '<tr>';
							html += '<td>' + obj.biNum + '</td>';
							html += '<td><a href="/views/table_3/view?biNum=' + obj.biNum + '">' + obj.biTitle + '</a></td>';
							html += '<td>' + obj.biContent + '</td>';
							html += '<td>' + obj.uiName + '</td>';
							html += '<td>' + obj.credat + '</td>';
							html += '</tr>';
						}
						document.querySelector('#tBody').innerHTML = html;
					}
				}
			}
			xhr.send();
		});
	</script>
</body>
</html>