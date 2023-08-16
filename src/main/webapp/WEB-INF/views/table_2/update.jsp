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
	번호: ${param.biNum}<br>
	제목 : <input type="text" id="biTitle"><br>
	내용 : <input type="text" id="biContent"><br>
	번호 : <input type="number" id="uiNum"><br>
	이름 : <input type="text" id="uiName"><br>
	<button onclick="updateTable()">수정</button>
</div>
	<script>
		function updateTable(){
			const param = {
					biNum : ${param.biNum},
					biTitle : document.querySelector('#biTitle').value,
					biContent : document.querySelector('#biContent').value,
					uiNum : document.querySelector('#uiNum').value,
					uiName : document.querySelector('#uiName').value,
			}
			const json = JSON.stringify(param);
			const xhr = new XMLHttpRequest();
			xhr.open('POST','/table_2/update');
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						console.log(xhr.responseText);
						if(xhr.responseText === '1'){
							alert('수정 완료');
							location.href='/views/table_2/list';
						}else{
							alert('수정 실패');
						}
					}else{
						console.log(xhr.responseText);
						alert('수정시 오류 발생');
					}
				}
			}
			xhr.send(json);
		}
		window.addEventListener('load',function(){
			const xhr = new XMLHttpRequest();
			xhr.open('GET','/table_2/one?biNum=${param.biNum}');
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						const table = JSON.parse(xhr.responseText);
						console.log(table);
						for(const key in table){
							if(document.querySelector('#' + key)){
								document.querySelector('#' + key).value = table[key];
							}
						}
					}
				}
			}
			xhr.send();
		})
	</script>
</body>
</html>