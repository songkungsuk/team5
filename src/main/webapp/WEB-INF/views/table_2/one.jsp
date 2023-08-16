<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
번호 : <span id="biNum">${param.biNum}</span><br>
제목 : <span id="biTitle"></span><br>
내용 : <span id="biContent"></span><br>
이름 : <span id="uiName"></span><br>
가입일 : <span id="credat"></span><br>
<button onclick="goPage('/views/table_2/update?biNum=${param.biNum}')">수정</button>
<button onclick="deleteTable()">삭제</button>
<script>
	window.addEventListener('load',function(){
		const xhr = new XMLHttpRequest();
		xhr.open('GET','/table_2/one?biNum=' + ${param.biNum});
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const obj = JSON.parse(xhr.responseText);
					for(const key in obj){
						if(document.querySelector('#' + key)){
							document.querySelector('#' + key).innerText = obj[key];
						}
					}
				}
			}
		}
		xhr.send();
	})
	function deleteTable(){
    const param = {
        biNum: ${param.biNum}
    }

		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST','/table_2/delete');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					if(xhr.responseText === '1'){
						alert('삭제 완료');
					}else{
						alert('이미 삭제된 게시물입니다.');
					}
					location.href='/views/table_2/list';
				}else{
					alert('삭제 시 오류 발생');
				}
			}
		}
		xhr.send(json);
	}
	function goPage(url){
		location.href = url;
	}
</script>
</body>
</html>