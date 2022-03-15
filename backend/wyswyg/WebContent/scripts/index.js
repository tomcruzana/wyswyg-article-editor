const searchForm = document.querySelector("#search_form");
const loginBtn = document.querySelector(".login-btn");

const cardDeck = document.querySelector(".card-deck");
const card = document.querySelector(".card");

const xhttp = new XMLHttpRequest();

searchForm.q.addEventListener("input", e=>{
  console.log(e.target.value);
});

loginBtn.addEventListener("click", e=>{
  location.href = "loginform.html";
});

// searchForm.addEventListener("submit", (e) => {
//   console.log("send");

//   xhttp.onreadystatechange = function () {
//     if (this.readyState == 4 && this.status == 200) {
//       cardDeck.innerHTML = this.responseText;
//     }
//   };
//   xhttp.open("GET", "q", true);
//   xhttp.send();
// });

