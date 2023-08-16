<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/include/head.jsp" />
</head>
<body>
	<table border="1" class="container">
		<tr>
			<td>#</td>
			<td>제목</td>
			<td>작성자</td>
			<td>만든날</td>
		</tr>
		<tbody id="content">

		</tbody>
	</table>
	<br>
	<button onclick="location.href='/views/table_1/insert'" class="container">추가하기</button>
	<script>
		window.addEventListener('load', function () {
			const xhr = new XMLHttpRequest();
			xhr.open('GET','/table_1/list')
			xhr.onreadystatechange = function (){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						const obj = JSON.parse(xhr.responseText);
						let html ='';
						for(let table of obj){
							html += '<tr>';
							html += '<td>' + table.biNum +'</td>';
							html += '<td><a href="/views/table_1/view?biNum='+table.biNum+'">' + table.biTitle +'<a></td>';
							html += '<td>' + table.uiName +'</td>';
							html += '<td>' + table.credat +'</td>';
							html += '</tr>';
						}
						document.querySelector('#content').innerHTML = html;
					}
				}
			}
			xhr.send();
		});
	</script>
</body>
</html>