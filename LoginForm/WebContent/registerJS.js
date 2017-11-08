


function emailValid()
{
	var email = document.getElementById("rEmail").value;
	var error = document.getElementById("errormail");
	var re = /[^\s@]+@[^\s@]+\.com/;
	
	if(email == "" || email == null){
		error.innerHTML = "Email is required";
		error.style.color = "red";
	}
	else
	{
		if(re.test(email))
		{
			error.innerHTML = "Email";
			error.style.color = "green";
		}
		else
		{
			error.innerHTML = "Invalid Email";
			error.style.color = "red";
		}
	}
}

function passwordValid(){
	var email = document.getElementById("rPassword").value;
	var error1 = document.getElementById("errorpass1");
	var error2 = document.getElementById("errorpass2");
	var error3 = document.getElementById("errorpass3");
	var error4 = document.getElementById("errorpass4");
	var error5 = document.getElementById("errorpass5");
	
	var re = null;
	var re0 = /[A-Z]/g;
	var re1 = /[a-z]/g;
	var re2 = /[0-9]/g;
	
	
	if(email == "" || email == null)
	{
		error1.innerHTML = "password required"
		error1.style.color = "red"
	}
	else
	{
		
		if(re0.test(email))
		{
			error2.innerHTML = "capital letter"
			error2.style.color = "green"
		}
		else
		{
			error2.innerHTML = "capital letter"
			error2.style.color = "red"
		}
		
		if(re1.test(email))
		{
			error3.innerHTML = "small letter"
			error3.style.color = "green"
		}
		else
		{
			error3.innerHTML = " small letter"
			error3.style.color = "red"
		}
		
		if(re2.test(email))
		{
			error4.innerHTML = "one digit"
			error4.style.color = "green"
		}
		else
		{
			error4.innerHTML = "one digit"
			error4.style.color = "red"
		}
		
		error1.innerHTML = "password"
		error1.style.color = "green"
	}
		
	
}

function ConfirmRePassword(){
	var email = document.getElementById("rPassword").value;
	var Cemail = document.getElementById("rEPassword").value;
	var error = document.getElementById("errorpass");
	
	if(email == Cemail)
	{
		error.innerHTML = "Re-Password";
		error.style.color = "green";
	}
	else
	{
		error.innerHTML = "Re-password not matched";
		error.style.color = "red";
	}
}

function validMobileNo(){
	var Mno = document.getElementById("rMno").value;
	var error = document.getElementById("errorMno");
	var re = /^[7-9][0-9]{9}/;
	
	if(Mno == "" || Mno == null){
		error.innerHTML = "Mobile number Required";
		error.style.color = "red";
	}
	else
	{
		if(re.test(Mno))
		{
			error.innerHTML = "Mobile no";
			error.style.color = "green";
		}
		else
		{
			error.innerHTML = "Invalid Mobile no";
			error.style.color = "red";
		}
	}
	
	
}
