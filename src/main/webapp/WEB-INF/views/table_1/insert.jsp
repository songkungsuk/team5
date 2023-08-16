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
<input type="text" placeholder="title" id="biTitle"> <br>
<textarea rows="30" cols="40" placeholder="Content" id="biContent"></textarea> <br>
<input type="text" placeholder="uiNum" id="uiNum"> <br>
<input type="text" placeholder="uiName" id="uiName"> <br>
</div>
<button onclick="insertTable1()">게시글 쓰기</button>
<button onclick="location.href='/views/table_1/list'">취소</button>

<script>
	function insertTable1(){
		table = {
				biTitle : document.querySelector('#biTitle').value,
				biContent : document.querySelector('#biContent').value,
				uiNum : document.querySelector('#uiNum').value,
				uiName : document.querySelector('#uiName').value
		}
		let json = JSON.stringify(table);
		const xhr = new XMLHttpRequest();
		xhr.open('POST','/table_1/insert');
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					console.log(xhr.responseText);
					if(xhr.responseText == 1){
						alert('insert Complete');
						location.href='/views/table_1/list';
					}
				}
			}
		}
		xhr.send(json);
	}
</script>
</body>
</html>