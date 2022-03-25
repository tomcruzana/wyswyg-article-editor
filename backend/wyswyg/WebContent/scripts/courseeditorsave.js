const savePageBtn = document.querySelector("#savePage");

savePageBtn.addEventListener("click", (e) => {
  e.preventDefault();

  // get the updated page title, number and components (contents)
  let pageTitle = document
    .querySelector(".page-title")
    .textContent.replace(/\s\s+/g, " "); //todo: create regex obj for this

  let pageNumber = document
    .querySelector("#pg-n")
    .textContent.replace(/\s\s+/g, " ");

  let pageComponents = document
    .querySelector(".page-components-container")
    .innerHTML.replace(/\s\s+/g, " ");

  // Temp log
  console.log(pageComponents + "\n" + pageNumber + "\n" + pageTitle);

  // persist data using ajax call
  persistPageComponents(pageComponents, pageNumber, pageTitle);

  // Temp log
  console.log("post request called!");
});

function persistPageComponents(pageComponents, pageNumber, pageTitle) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function () {
    console.log("onload test");
  };
  xhttp.open("POST", "savepage");
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send(
    "pagecomponents=" +
      pageComponents +
      "&" +
      "pagetitle=" +
      pageTitle +
      "&" +
      "pagenumber=" +
      pageNumber
  );
}
