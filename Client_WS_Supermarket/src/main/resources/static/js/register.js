async function register() {

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var rePassword = document.getElementById("rePassword").value;
    var fullname = document.getElementById("fullname").value;
    var birthday = document.getElementById("birthday").value;
    var tel = document.getElementById("tel").value;
    var address = document.getElementById("address").value;
    var email = document.getElementById("email").value;

    var errorMessage = document.getElementById("error-message");

    if (username == "") {
        errorMessage.innerHTML = "Please enter your username";
        errorMessage.style.color = "red";
    } else if (password == "") {
        errorMessage.innerHTML = "Please enter your password";
        errorMessage.style.color = "red";
    } else if (rePassword == "") {
        errorMessage.innerHTML = "Please enter your re-password";
        errorMessage.style.color = "red";
    } else if (rePassword != password) {
        errorMessage.innerHTML = "Password do not match";
        errorMessage.style.color = "red";
    } else if (fullname == "") {
        errorMessage.innerHTML = "Please enter your fullname";
        errorMessage.style.color = "red";
    } else if (birthday == "") {
        errorMessage.innerHTML = "Please enter your birthday";
        errorMessage.style.color = "red";
    } else if (tel == "") {
        errorMessage.innerHTML = "Please enter your telephone number";
        errorMessage.style.color = "red";
    } else if (address == "") {
        errorMessage.innerHTML = "Please enter your address";
        errorMessage.style.color = "red";
    } else if (email == "") {
        errorMessage.innerHTML = "Please enter your email";
        errorMessage.style.color = "red";
    } else {
        console.log(typeof birthday)
        var check = await fetch('http://localhost:8080/check-username?username=' + username)
        if (check.status == 409) {
            console.log("e")
            errorMessage.innerHTML = "Username is existed";
            errorMessage.style.color = "red";
        }
        else {
            errorMessage.innerHTML = ""
            var customer = await fetch('http://localhost:8082/add-customer', {
                method: 'POST',
                body: JSON.stringify({
                    "name": fullname,
                    "address": address,
                    "email": email,
                    "phoneNumber": tel,
                    "birthday": birthday
                }),
                headers: {
                    'Content-Type': 'application/json',
                }
            })

            if(customer.ok){
                customer = await customer.json()
                console.log(customer)
                var account = await fetch('http://localhost:8080/register',{
                    method:'POST',
                    body:JSON.stringify({
                        "username":username,
                        "password":password,
                        "role":"customer",
                        "idUser":customer.id
                    }),
                    headers: {
                        'Content-Type': 'application/json',
                    }
                })

                if(account.ok){
                    alert("Đăng ký thành công")
                    account = await account.json()
                    console.log(account)
                }
                else{
                    alert("Lỗi thêm account")
                    var del = await fetch('http://localhost:8082/delete-customer?id=' + customer.id,{
                        method: 'DELETE',
                    })

                    if(del.ok){
                        del = await del.json()
                        console.log(del)
                        window.location.href = 'login.html'
                    }
                    else{
                        console.log("del" + del.status)
                    }

                    console.log('account'+ account.status)
                }
            }
            else{
                alert("Lỗi thêm customer")
                console.log("customer" + customer.status)
            }

        }

    }
}