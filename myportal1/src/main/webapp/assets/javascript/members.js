function checkForm(frm){
	console.log(frm);
	
	var name=frm.name.value.trim();
	var password = frm.password.value.trim();
	var email =frm.email.value.trim();
	var gender =frm.gender.value;
	var check = frm.check.value;
	
	//RODO:추가 검증
	if(name.length < 3){
		alert("이름은 3자리 이상 입력하세여");
		frm.name.focus();
	}else if(password.length <8){
		alert("비밀번호는 8자리 이상이여야 한다");
		frm.password.focus();
		
	}else if(email.length <10){
		alert("이메일은 10자리 이상 입력하세여");
		frm.email.focus();
	}else if(check !="t"){
	alert("이메일 중복 체크해주세여");
	}
	else if(gender !='M' && gender !='F'){
		alert("성별을 입력하지 않았습니다");
	}else{
		return true;
	}
	return false; //onsubit 이벤트에서 true여야 전송
}

function checkemail(emailField,url ){
	console.log("email field:" ,emailField.value);

	//Ajax 호출
	
	if (emailField.value.trim().length ==0){
	alert("이메일 입력해주세여");
	return;
}
	$.ajax({
		url:url,
		type: "GET",
		dataType: "json",
		data:{
			email: emailField.value.trim()
		},
		success: function(result){
			console.log("Result:",result);
			//check
			if(result.data ==true){
			emailField.form.check.value ="f";
			alert("이미 가입된 이메일입니다");
			}else{
			emailField.form.check.value ="t";
			alert("가입 가능이메일입니다");
			}
		},
		error: function(xhr,status,error){
		console.error("Status:",status);
		console.error("Xhr:",xhr);
		console.error("Error:",error);
		
		emailField.form.check.value ="f";
		}
		});
}