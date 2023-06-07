async function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var errorMessage = document.getElementById("error-message");

    if (username == "") {
        errorMessage.innerHTML = "Please enter your username";
        errorMessage.style.color = "red";
    } else if (password == "") {
        errorMessage.innerHTML = "Please enter your password";
        errorMessage.style.color = "red";
    } else {
//        errorMessage.innerHTML = "";
//        var response = await fetch('http://127.0.0.1:8080/login', {
//            method: 'POST',
//            body: JSON.stringify({
//                "username": username,
//                "password": password
//            }),
//            headers: {
//                'Content-Type': 'application/json',
//            }
//        })
//        if (response.status == 404 || response.status == 401) {
        if (1===0) {
//            const responseData = await response.json()
            errorMessage.innerHTML = 'Sai thông tin tài khoản, mật khẩu'
            errorMessage.style.color = 'red'
            console.log(responseData);
        } else if (true) {
//            const responseData = await response.json()
//            console.log(responseData.idUser);
            try {
                await fetch('http://127.0.0.1:8000/save-login?idUser=' + 1)
                        .then(response => response.text())
                        .then(data => {
                            console.log(data);
                            return data
                        });
            } catch (err) {
                console.log(err);
            }

            if (responseData.role === 'customer') {
                window.location.href = 'http://localhost:8000'
            } else if (responseData.role === 'manager') {
                window.location.href = 'http://localhost:4001'
            } else {
                window.location.href = 'http://localhost:8099'
            }
        }
    }
}

