<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick="location.href='/views/table_2/insert'">등록</button>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>uiNum</th>
			<th>이름</th>
		</tr>
		<tbody id="tBody">
		</tbody>
	</table>
	<script>
		function goPage(num){
			location.href= '/views/table_2/one?biNum=' + num;
		}	
		function getTable(){
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/table_2/list');
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						const list = JSON.parse(xhr.responseText);
						let html = '';
						for(const table of list){
							html += '<tr class="link" onclick="goPage(' + table.biNum + ')">';
							html += '<td>' + table.biNum + '</td>';
							html += '<td>' + table.biTitle + '</td>';
							html += '<td>' + table.biContent + '</td>';
							html += '<td>' + table.uiNum + '</td>';
							html += '<td>' + table.uiName + '</td>';
							html += '</tr>';
						}
						document.querySelector('#tBody').innerHTML = html;
						console.log(html);
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load',getTable);
	</script>
</body>
</html>