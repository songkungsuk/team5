<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	제목 : <input type="text" id="biTitle"><br>
	내용 : <input type="text" id="biContent"><br>
	번호 : <input type="number" id="uiNum"><br>
	이름 : <input type="text" id="uiName"><br>
	<button onclick="addTable()">등록</button>
</div>
<script>
	function addTable(){
		const param = {
				biTitle : document.querySelector('#biTitle').value,
				biContent : document.querySelector('#biContent').value,
				uiNum : document.querySelector('#uiNum').value,
				uiName : document.querySelector('#uiName').value,
		}
		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST','/table_2/insert');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					console.log(xhr.responseText);
					if(xhr.responseText === '1'){
						alert('등록 완료 ');
						location.href='/views/table_2/list';
					}else {
						console.log(xhr.responseText);
						alert('등록 시 오류 발생');
					}
				}
			}
		}
		xhr.send(json);
	}
</script>
</body>
</html>
