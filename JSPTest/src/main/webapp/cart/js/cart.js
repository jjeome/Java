/**
 * cart.js
   JSPTest/cart/cart.jsp
 */
 
function cartList(result){
	console.log(result) //(2) [{...},{...}]
	//아이디값이 template인 애를 가져옴
	let cartTemplate = document.querySelector('#template');
	let basket = document.querySelector('#basket');
	
	for(let i =0; i<result.length; i++){
		//첫번째 div태그
		let rowDiv = cartTemplate.childNodes[1].cloneNode(true);
		
		rowDiv.setAttribute('data-id', result[i].num);
		rowDiv.querySelector('div.pname span').textContent = result[i].productNm;
		rowDiv.querySelector('div.basketprice input[name="p_price"]').value = result[i].price;
		rowDiv.querySelector('div.basketprice').childNodes[2].textContent = result[i].price;
		rowDiv.querySelector('div.num input').value = result[i].qty;
		rowDiv.querySelector('div.sum').textContent = (result[i].price * result[i].qty);
		//input이라는 같은타입 중에서 첫번재 input태그를 가져옴
		rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('id','p_num'+result[i].num);
		rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('onkeyup','javascript:changePnum('+result[i].num+')');
		rowDiv.querySelector('div.num>div.updown>span:nth-of-type(1)').setAttribute('onclick','javascript:changePnum('+result[i].num+')');	
		rowDiv.querySelector('div.num>div.updown>span:nth-of-type(2)').setAttribute('onclick','javascript:changePnum('+result[i].num+')');	
		basket.append(rowDiv);
		
	}	
}
 
function changePnum(num){
	//이벤트 발생할때마다 이벤트 객체 발생
	let currentItem = event.target;
	let currentQty = currentItem.closest('.updown').childNodes[1].value;
	let currentPrice = currentItem.closest('.subdiv').childNodes[1].childNodes[1].value;
	console.log(currentQty, currentPrice);
	
	if(currentItem.classList[2] == 'down'){
		changeQty = parseInt(currentQty) -1;
		currentItem.closest('.updown').childNodes[1].value = changeQty;
	} else {
		changeQty = parseInt(currentQty) +1;
		currentItem.closest('.updown').childNodes[1].value = changeQty;
	}
	
	//ajax
	fetch('../cartUpdate.do', {
		method: 'post',
		headers: {'Content-type':'application/x-www-form-urlencoded'},
		body: 'num='+num+'&qty='+changeQty
	})
	.then(result => result.text())
	.then(result => console.log(result))
	.catch(err => console.log(err))
}


function makeList(){
	// ajax. XMLHttpRequest.
	fetch('../cartList.do') //호출하고 싶은 url넣어주기
	//정상 실행된다면 then안의 메소드 실행
	//json 타입으로 parsing - .json()
	//.then(function(result){}) 정규 표현식
	.then(result => result.json()) //람다식 표현식
	//.then(result => console.log(result)) //기능을 console.log자리에 이제 넣으면 됨
	//매개값으로 함수가 들어가면 됨
	.then(cartList)
	//에러가 발생되면 catch안의 메소드 실행
	.catch(err => console.log(err))
}

makeList();