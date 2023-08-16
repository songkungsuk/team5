<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<input type="text" placeholder="title" id="biTitle"> <br>
		<textarea rows="30" cols="40" placeholder="Content" id="biContent"></textarea>
		<br> <input type="text" placeholder="uiNum" id="uiNum"> <br> <input type="text" placeholder="uiName" id="uiName"> <br>
	</div>
	<button onclick="updateTable1()">게시글 수정</button>
	<script>
	function updateTable1(){
		table = {
			biTitle : document.querySelector('#biTitle').value,
			biContent : document.querySelector('#biContent').value,
			uiNum : document.querySelector('#uiNum').value,
			uiName : document.querySelector('#uiName').value,
			biNum : ${param.biNum}
		}
		const json = JSON.stringify(table);
		const xhr = new XMLHttpRequest();
		xhr.open('POST', '/table_1/update');
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onreadystatechange = function (){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					if(xhr.responseText == 1){
						alert('update Complete');
						location.href='/views/table_1/list';
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
					for(let key in obj){
						if(document.querySelector('#'+ key)){
							document.querySelector('#'+ key).value = obj[key];
						}
					}
					document.querySelector('#biContent').innerText = obj.biContent;
					
				}
			}
		}
		xhr.send();
	})
</script>
</body>
</html>