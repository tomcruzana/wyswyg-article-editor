const loginForm = document.querySelector("#loginForm");

loginForm.submit.addEventListener("click", (e) => {
  e.preventDefault();
  const username = loginForm.user_username.value;
  const password = loginForm.user_password.value;
  if (username == "" || password == "") {
    alert("Please enter your valid username and password");
  } else if (username == "admin" && password == "password123") {
    location.href = "editor.html";
  } else {
    alert("Sorry, the username or password is incorrect.\nPlease try again.");
  }
});
