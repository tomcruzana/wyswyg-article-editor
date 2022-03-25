const deleteCourseBtn = document.querySelector(".delete-page-btn");

deleteCourseBtn.addEventListener("click", (e) => {
  e.preventDefault();
  const cid = e.target.id;
  console.log(cid);
  if (e.target.id == cid) {
    deleteCourseComponents(cid);
  }
});

function deleteCourseComponents(cid) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function () {
    console.log("onload test");
  };
  xhttp.open("POST", "deletecourse");
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("cid=" + cid);
}
