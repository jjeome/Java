<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>
	<h3>회원등록</h3>
	<form name="addFrm" action="addMemberAjax.do" method="post">
		아이디: <input type="text" name="id"><br> 이름: <input
			type="text" name="name"><br> 이메일: <input type="text"
			name="mail"><br> 비밀번호: <input type="password"
			name="passwd"><br> <input type="submit" value="저장">

	</form>

	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>비밀번호</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>

	<script>
	//Ajax 비동기 방식 처리
		//처리 결과가 코드 순서대로가 아닌 시간적으로 순차적으로 처리됨
		//처리 시간 아낄 수 있음
		/*
		setTimeout(function(){
			console.log('A');
		}, 2000);
	
		setTimeout(function(){
			console.log('B');
		}, 3000);

		setTimeout(function(){
			console.log('C');
		}, 1000);
		
	//Ajax 동기 방식 처리
		setTimeout(function({
			console.log("A");
			
			setTimeout(function(){
				console.log('B');
				
				setTimeout(function(){
					console.log('C');
				}, 1000);
				
			}, 3000);
			
		}, 2000);	
		*/
		
	//비동기 방식 처리 예제
		let i = 0;
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'memberJson.do');
		//send를 해줘야 처리가 실행됨
		xhtp.send();
		//on~ : 이벤트와 관련된 속성들
		//콜백함수 - 함수가 이벤트가 발생할 때 호출됨
		//onreadystatechange : 서버에 페이지 요청하고 결과 받는 정보
		//readystate 값이 4면 종료.
		xhtp.onreadystatechange = callBackThree;
		
		//출력할 필드 배열에 저장
		let fields = ['id', 'name', 'mail', 'passwd']
		function callBackThree(){
			if(this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText);
				console.log(data);
				let tbody = document.getElementById('list');
				
				//데이터 건수 반복
				for(let obj of data){
					makeTr(obj);
					
					tr = makeTr(obj);
					
					/*
					for(let obj of data){
					//tr td,td,td,td
					let tr = document.createElement('tr');
					
					//필드 개수 반복
					for(let field of fields){
						let td1 = document.createElement('td');
						td1.innerText = obj[field];
						//tr에 td를 붙여줌
						tr.append(td1);
					}
					
					let td1 = document.createElement('td');
					td1.innerText = obj.id;
					let td2 = document.createElement('td');
					td2.innerText = obj.name;
					let td3 = document.createElement('td');
					td3.innerText = obj.mail;
					let td4 = document.createElement('td');
					td4.innerText = obj.passwd;					
					tr.append(td1, td2, td3, td4);
					*/
					// tbody 하위요소로 tr을 붙임
					tbody.append(tr);
				}
			}
		}// end of callBackTrhee;
		
		//데이터 한건 tr 생성
		function makeTr(obj){
			let tr = document.createElement('tr');
			
			//필드 개수 반복
			for(let field of fields){
				let td1 = document.createElement('td');
				td1.innerText = obj[field];
				//tr에 td를 붙여줌
				tr.append(td1);
			}
			//삭제 버튼
			let td1 = document.createElement('td');
			let btn = document.createElement('button');
			btn.innerText = '삭제';
			// 클릭이벤트
			btn.addEventListener('click', deleteCallBack);
			
			//만든 버튼을 td에 하위요소로.
			td1.append(btn);
			//만든 td를 tr의 하위요소로.
			tr.append(td1);
			
			return tr;
		}
		
		//버튼이벤트의 콜백함수는 기본적으로 매개값으로 e(이벤트)가 들어옴
		function deleteCallBack(e){
			//이벤트의 콜백함수는 이벤트를 받는 대상을 가리킴
			//this: 이벤트 받는 대상 (this == button)
			console.log(this);
			
			let delId = this.parentElement.parentElement.firstElementChild.innerText;
			
			let delAjx = new XMLHttpRequest();
			delAjx.open('post', 'removeMemberAjax.do');
			delAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			delAjx.send('id='+delId);
			delAjx.onload = function(){
				let result = JSON.parse(delAjx.responseText);
				if(result.retCode == 'Success'){
					//e.target으로 대상을 가리킴
					e.target.parentElement.parentElement.remove();							
				} else {
					alert('처리중 에러 발생');
				}
			}	
		}
		
		
		function callBackTwo(){
			if (this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText);
				console.log(data);
				
				//ul태그 만드는 것
				let ul = document.createElement('ul');;
				for(let obj of data){
					let li = document.createElement('li');
					//<li>hong, 15</li>만든것
					li.innerHTML = obj.name + ', '+obj.age;
					//ul의 하위요소로 
					ul.append(li);
				}
				console.log(ul);
				document.querySelector('body').append(ul);
			}
		}
		
		function callBackOne() {
			if (this.readyState == 4 && this.status == 200) {
				//JSON.parse(): json 문자열을 object타입으로 parsing해줌
				let data = JSON.parse(this.responseText);
				console.log(data);
				//name을 p태그로 만듬(html)
				let name = document.createElement('p');
				name.innerText = data.name;
				//age를 p태그로 만듬(html)
				let age = document.createElement('p');
				age.innerText = data.age;
				//body태그안에 name과 age 출력
				document.querySelector('body').append(name, age);

				//최종 완료 상태일 때
				//console.log(xhtp.responseText);
				//완료 상태를 화면에 그리고 싶을 때
				//document.querySelector('body').append(xhtp.responseText);
			}
		}
		
		//form 전송이벤트 실행되면 ajax실행
		document.forms.addFrm.onsubmit = function(e){
			//페이지 기본 전송기능 차단
			e.preventDefault();
			let url = document.forms.addFrm.getAttribute('action');
			let id = document.forms.addFrm.id.value;
			let name = document.forms.addFrm.name.value;
			let pass = document.forms.addFrm.passwd.value;
			let mail = document.forms.addFrm.mail.value;
			let param= 'id= '+id+'&name='+name+'&passwd='+pass+'&mail='+mail;
			
			let addAjx = new XMLHttpRequest();
			addAjx.open('post', url);
			addAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			
			addAjx.send(param);//id=user1&passwd=1234&name=Hong&mail=email@com
			addAjx.onload = function(){
				console.log(addAjx.responseText);
				//json -> object
				let data = JSON.parse(addAjx.responseText);				
				
				//tbody태그의 id(list)
				document.getElementById('list').append(makeTr(data));
			}
		}
		
	</script>
</body>
</html>



























