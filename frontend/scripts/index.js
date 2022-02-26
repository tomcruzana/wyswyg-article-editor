const loginBtn = document.querySelector(".login-btn");

loginBtn.addEventListener("click", (e)=>{
    e.preventDefault();
    location.href = "login_form.html";
});