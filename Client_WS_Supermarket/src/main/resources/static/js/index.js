async function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    // $("#email").text(profile.getEmail());
    var email = profile.getEmail();
    var response = await fetch('http://127.0.0.1:8082/customer-login', {
        method: 'POST',
        body: JSON.stringify({
            "email": email
        }),
        headers: {
            'Content-Type': 'application/json',
        }
    })

    if (response.status == 404 || response.status == 401) {
        const responseData = await response.json()
        errorMessage.innerHTML = 'Không tìm thấy người dùng'
        errorMessage.style.color = 'red'
        console.log(responseData);
    } else if (response.ok) {
        window.location.href = 'http://localhost:8000/'
        errorMessage.innerHTML = 'Có tìm thấy người dùng'

    }
}