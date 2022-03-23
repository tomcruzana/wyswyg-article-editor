const loginForm = document.querySelector("#loginForm");
const showPassCheckBox = document.querySelector(".show-password");
const rememberMeCheckBox = document.querySelector(".remember-me");

// on document load check for user cookies
window.addEventListener("load", function () {
  // destructure cookie data
  const { username, password, rememberMe } = parseCookie(document.cookie);
  loginForm.user_username.value = username;
  loginForm.user_password.value = password;
  rememberMeCheckBox.checked = rememberMe;
});

// submit form
loginForm.submit.addEventListener("click", (e) => {
  e.preventDefault();
  const username = loginForm.user_username.value;
  const password = loginForm.user_password.value;
  if (username == "" || password == "") {
    alert("Please enter your valid username and password");
  } else if (username == "admin" && password == "password123") {
    rememberUser();
    location.href = "login";
  } else {
    alert("Sorry, the username or password is incorrect.\nPlease try again.");
  }
});

// hide or show password field
showPassCheckBox.addEventListener("click", (e) => {
  const type =
    loginForm.user_password.getAttribute("type") === "password"
      ? "text"
      : "password";
  loginForm.user_password.setAttribute("type", type);
});

// remember user cookie
function rememberUser() {
  // if true, create cookie
  if (rememberMeCheckBox.checked) {
    document.cookie = `username=${loginForm.user_username.value}; expires=Fri, 31 Dec 9999 23:59:59 GMT; path=/`;
    document.cookie = `password=${loginForm.user_password.value}; expires=Fri, 31 Dec 9999 23:59:59 GMT; path=/`;
    document.cookie = `rememberMe=true; expires=Fri, 31 Dec 9999 23:59:59 GMT; path=/`;
    alert(document.cookie);
  } else {
    // if false, delete cookie
    document.cookie =
      "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie =
      "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie =
      "rememberMe=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    alert(document.cookie);
  }
}

// the cookie parser
const parseCookie = (str) =>
  str
    .split(";")
    .map((v) => v.split("="))
    .reduce((acc, v) => {
      acc[decodeURIComponent(v[0].trim())] = decodeURIComponent(v[1].trim());
      return acc;
    }, {});
