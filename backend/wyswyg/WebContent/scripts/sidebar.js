const logOutBtn = document.querySelector(".logout");

logOutBtn.addEventListener("click", (e) => {
  e.preventDefault();
  const res = confirm("Are you sure you want to log out?");

  if (res) {
    location.href = "login_form.html";
  }
});

window.addEventListener("DOMContentLoaded", () => {
  document.querySelector("#sidebarCollapse").addEventListener("click", () => {
    document.querySelector("#sidebar").classList.toggle("active");
  });
});
