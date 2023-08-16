<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" class="container">
		<tr>
			<td>#</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성자번호</td>
			<td>만든날</td>
			<td>수정일</td>
		</tr>
		<tbody id="content">

		</tbody>
	</table>
	<button onclick="location.href='/views/table_1/update?biNum=${param.biNum}'">수정하기</button>
	<button onclick="tb1Delete()">삭제하기</button>
	<script>
		function tb1Delete() {
			const table = {
					biNum : ${param.biNum}
			}
			const json = JSON.stringify(table);
			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/table_1/delete');
			xhr.onreadystatechange = function (){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						if(xhr.responseText == 1){
							alert('delete Complete');
							location.href = '/views/table_1/list';
						}
					}
				}
			}
			xhr.send(json);
		}
		window.addEventListener('load', function() {
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/table_1/view?biNum=${param.biNum}');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						const obj = JSON.parse(xhr.responseText);
						let html = '';
						html += '<tr>';
						html += '<td>' + obj.biNum + '</td>';
						html += '<td>' + obj.biTitle + '</td>';
						html += '<td>' + obj.biContent + '</td>';
						html += '<td>' + obj.uiName + '</td>';
						html += '<td>' + obj.uiNum + '</td>';
						html += '<td>' + obj.credat + '</td>';
						html += '<td>' + obj.lmodat + '</td>';
						html += '</tr>';
						document.querySelector('#content').innerHTML = html;
					}
				}
			}
			xhr.send();
		})
	</script>
</body>
</html>