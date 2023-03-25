
let SignupForm = async (event) => {
    event.preventDefault()

    let sign_obj = {
        userName: document.querySelector('#userName').value,
        userEmail: document.querySelector('#userEmail').value,
        password: document.querySelector('#password').value,
        userRole: document.querySelector('#userRole').value,
    }

    let Sign_strigify = JSON.stringify(sign_obj);
    console.log(Sign_strigify);

    let API_url = `http://localhost:8081/userRegister`;

    let response = await fetch(API_url, { method: 'POST', body: Sign_strigify, headers: { 'Content-Type': 'application/json' } })

    let json_res_data = await response.json();

    console.log(json_res_data)

    document.querySelector("#userName").value = "";
    document.querySelector("#userEmail").value = null;
    document.querySelector("#password").value = "";
    // document.querySelector("#userRole").value = "User Role";


}


let LoginForm = async () => {
    event.preventDefault()

    let Login_obj = {
        password: document.querySelector('#password-L').value,
        emailId: document.querySelector('#emailId-L').value,
    }

    let Login_strigify = JSON.stringify(Login_obj);
    // console.log(Login_strigify);

    let API_url = `http://localhost:8081/login`;

    let response = await fetch(API_url, { method: 'POST', body: Login_strigify, headers: { 'Content-Type': 'application/json' } })

    let json_res_data = await response.json();

    console.log(json_res_data)

    window.location.href = "sprint.html";

}

