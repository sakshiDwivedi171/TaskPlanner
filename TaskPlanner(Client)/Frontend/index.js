  
  let SignupForm = async (event)=>{
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
  
      let response = await fetch(API_url, { method: 'POST', body:Sign_strigify, headers:{'Content-Type': 'application/json'} })
  
      let json_res_data = await response.json();
  
      console.log(json_res_data)
  
  }
  
  
  let LoginForm = async ()=>{
    event.preventDefault()
  
      let Login_obj = {
          password: document.querySelector('#password-L').value,
          emailId: document.querySelector('#emailId-L').value,
      }
  
      let Login_strigify = JSON.stringify(Login_obj);
      // console.log(Login_strigify);
  
      let API_url = `http://localhost:8081/login`;
  
      let response = await fetch(API_url, { method: 'POST', body:Login_strigify, headers:{'Content-Type': 'application/json'} })
  
      let json_res_data = await response.json();
  
      console.log(json_res_data)

      if(json_res_data.userRole == "admin"){
               window.location.href="task.html";
            }
            else if(json_res_data.userRole == "developer"){
                window.location.href="sprint.html";
             }
             else if(json_res_data.userRole == "project_manager"){
                window.location.href="sprint.html";
             }
            else if(json_res_data.userRole == "tester"){
              window.location.href="sprint.html";
            }
  
    //   getProfile(json_res_data, Login_obj)
  
     
  
  }
  
//   let getProfile= async({token}, {username})=>{
  
//     let profile_Api = `https://masai-api-mocker.herokuapp.com/user/${username}`;
  
//     let res = await fetch(profile_Api, { method: "GET", headers: {Authorization: `Bearer ${token}`} });
  
//     let get_res = await res.json();
  
//     console.log(get_res);
  
//     localStorage.setItem("user-profile", JSON.stringify(get_res));
  
//     let getUser_description = JSON.parse(localStorage.getItem('user-profile'));
  
//     if(getUser_description.description == "admin"){
//        window.location.href="admin.html";
//     }
//     else if(getUser_description.description == "user"){
//       window.location.href="menu.html";
//     }
  
    
//     return get_res;
  
//   }