const loginBtn = document.querySelector(".login-btn");
const card = document.querySelector(".card");

loginBtn.addEventListener("click", (e)=>{
    e.preventDefault();
    location.href = "login_form.html";
});

card.addEventListener("click", (e)=>{
    e.preventDefault();
    location.href = "course.html";
});