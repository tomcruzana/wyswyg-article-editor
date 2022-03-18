// component insert button generator logic
class Component {
  static icbPrefix = "ICB";
  static cPrefix = "C";
  static id = 100;

  static buildComponentCreatorButton() {
    return `<div id="${this.icbPrefix.concat(++this.id)}"class="row my-3">
    <div class="col">
      <div class="text-center component-insert">
        <button
          type="button"
          class="btn component-insert-plus"
          data-toggle="modal"
          data-target="#exampleModalCenter"
        >
          <i class="fa-solid fa-plus"></i>
        </button>
      </div>
    </div>
    </div>`;
  }

  static buildComponent(componentName) {
    return `<div id="${this.cPrefix.concat(
      this.id
    )}" class="component-border my-3">
    <div
      class="btn-group float-right component-btn-group"
      role="group"
      aria-label="Basic example"
    >
      <button type="button" class="btn btn-danger component-trash">
        <i class="fa-solid fa-trash-can"></i>
      </button>
    </div>
    ${componentName}
    </div>`;
  }
}

// component list map
const componentList = new Map();
componentList.set(
  "dateAuthor",
  `<div class="row date-author component">
<div class="col">
  <p class="font-italic m-0" contenteditable="true">
    Date Created: ${new Date().toJSON().slice(0, 10).replace(/-/g, "-")}
  </p>
  <p class="font-italic m-0" contenteditable="true">
    Last Update: ${new Date().toJSON().slice(0, 10).replace(/-/g, "-")}
  </p>
  <p class="font-italic m-0" contenteditable="true">
    Author: John Smith
  </p>
</div>
</div>`
);

componentList.set(
  "whatToLearn",
  `<div class="row what-to-learn component">
<div class="col">
  <h5 contenteditable="true" spellcheck="true" lang="tl">
    What You’ll Learn in This Lesson:
  </h5>
  <ul contenteditable="true" spellcheck="true" lang="tl">
    <li>Image What functions are and what they do</li>
    <li>Image How to define functions</li>
    <li>Image How to call (execute) functions</li>
    <li>Image How functions receive data</li>
    <li>Image How to return values from functions</li>
    <li>Image How to create anonymous functions</li>
  </ul>
</div>
</div>
</div>`
);

componentList.set(
  "imageFigure",
  `<div class="row component">
<div class="col">
  <figure class="figure text-center">
    <img
      src="https://via.placeholder.com/400x300"
      class="figure-img img-fluid rounded"
      alt="A generic square placeholder image with rounded corners in a figure."
    />
    <figcaption class="figure-caption">
      A caption for the above image. Donec rutrum congue leo eget
      malesuada. Nulla quis lorem ut libero malesuada feugiat.
    </figcaption>
  </figure>
</div>
</div>`
);

componentList.set(
  "paragraph",
  `<div class="row paragraph component">
<div class="col">
  <h5 contenteditable="true" spellcheck="true" lang="tl">
    Lorem Ipsum dolor
  </h5>
  <p contenteditable="true" spellcheck="true" lang="tl">
    Curabitur non nulla sit amet nisl tempus convallis quis ac
    lectus. Vestibulum ac diam sit amet quam vehicula elementum sed
    sit amet dui. Mauris blandit aliquet elit, eget tincidunt nibh
    pulvinar a. Vestibulum ac diam sit amet quam vehicula elementum
    sed sit amet dui. Vivamus magna justo, lacinia eget consectetur
    sed, convallis at tellus. Vivamus suscipit tortor eget felis
    porttitor volutpat. Nulla porttitor accumsan tincidunt.
    Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
    posuere cubilia Curae; Donec velit neque, auctor sit amet
    aliquam vel, ullamcorper sit amet ligula. Donec sollicitudin
    molestie malesuada. Quisque velit nisi, pretium ut lacinia in,
    elementum id enim. Praesent sapien massa, convallis a
    pellentesque nec, egestas non nisi.
  </p>
</div>
</div>`
);

componentList.set(
  "video",
  `<div class="row component">
<div class="col">
  <div class="videosizer">
    <div class="embed-responsive embed-responsive-16by9">
      <iframe
        class="embed-responsive-item"
        src="//www.youtube.com/embed/zB4I68XVPzQ"
      ></iframe>
    </div>
  </div>
</div>
</div>`
);

componentList.set(
  "slideshow",
  `<div class="row component">
<div class="col">
  <p>Slideshow component coming soon...</p>
</div>
</div>`
);

componentList.set(
  "blockquote",
  `<div class="row component">
<div class="col">
  <blockquote
    class="blockquote"
    contenteditable="true"
    spellcheck="true"
    lang="tl"
  >
    <p class="mb-0">
      Lorem ipsum dolor sit amet, consectetur adipiscing elits.
      Integer posuere erat a ante.
    </p>
    <footer class="blockquote-footer">
      Someone famous in
      <cite title="Source Title">Source Title</cite>
    </footer>
  </blockquote>
</div>
</div>`
);

componentList.set(
  "codeBlock",
  `<div class="row component">
<div class="col">
  <code contenteditable="true">
    const x = 12; ()->{ console.log("hello, world!"); }
  </code>
  <p></p>
</div>
</div>`
);

componentList.set(
  "citation",
  `<div class="row component">
<div class="col">
  <p contenteditable="true">
    <cite>The Scream</cite> by Edward Munch. Painted in 1893.
  </p>
</div>
</div>`
);

// get the active insert component / trash button through event delegation
// to know where to insert a new component
const pageComponentsContainer = document.querySelector(
  ".page-components-container"
);

let getActiveComponentInsertBtn = document.querySelector("#ICB100");

pageComponentsContainer.addEventListener("click", (e) => {
  // insert component button logic
  if (e.target.className === "fa-solid fa-plus") {
    getActiveComponentInsertBtn = document.querySelector(
      "#" + e.target.parentElement.parentElement.parentElement.parentElement.id
    );
    console.log(
      e.target.parentElement.parentElement.parentElement.parentElement.id
    );
  } else if (e.target.className === "btn component-insert-plus") {
    getActiveComponentInsertBtn = document.querySelector(
      "#" + e.target.parentElement.parentElement.parentElement.id
    );
    console.log(e.target.parentElement.parentElement.parentElement.id);
  }

  // component deletion logic
  if (e.target.className === "btn btn-danger component-trash") {
    // delete component then its component creation button
    const cid = e.target.parentElement.parentElement.id;

    document.querySelector("#" + cid).remove();

    const icbid = "ICB" + cid.substring(1);
    document.querySelector("#" + icbid).remove();
  } else if (e.target.className === "fa-solid fa-trash-can") {
    // same here
    const cid = e.target.parentElement.parentElement.parentElement.id;

    document
      .querySelector(
        "#" + e.target.parentElement.parentElement.parentElement.id
      )
      .remove();

    const icbid = "ICB" + cid.substring(1);
    document.querySelector("#" + icbid).remove();
  }
});

// main component list modal options
const componentListGroup = document.querySelector("#componentListGroup");

componentListGroup.addEventListener("click", (e) => {
  if (e.target.id === "dateAuthorComponent") {
    getActiveComponentInsertBtn.insertAdjacentHTML(
      "beforebegin",
      Component.buildComponentCreatorButton() +
        Component.buildComponent(componentList.get("dateAuthor"))
    );
  } else if (e.target.id === "whatToLearnComponent") {
    getActiveComponentInsertBtn.insertAdjacentHTML(
      "beforebegin",
      Component.buildComponentCreatorButton() +
        Component.buildComponent(componentList.get("whatToLearn"))
    );
  } else if (e.target.id === "imageFigureComponent") {
    getActiveComponentInsertBtn.insertAdjacentHTML(
      "beforebegin",
      Component.buildComponentCreatorButton() +
        Component.buildComponent(componentList.get("imageFigure"))
    );
  } else if (e.target.id === "paragraphComponent") {
    getActiveComponentInsertBtn.insertAdjacentHTML(
      "beforebegin",
      Component.buildComponentCreatorButton() +
        Component.buildComponent(componentList.get("paragraph"))
    );
  } else if (e.target.id === "videoComponent") {
    getActiveComponentInsertBtn.insertAdjacentHTML(
      "beforebegin",
      Component.buildComponentCreatorButton() +
        Component.buildComponent(componentList.get("video"))
    );
  } else if (e.target.id === "slideshowComponent") {
    getActiveComponentInsertBtn.insertAdjacentHTML(
      "beforebegin",
      Component.buildComponentCreatorButton() +
        Component.buildComponent(componentList.get("slideshow"))
    );
  } else if (e.target.id === "blockquoteComponent") {
    getActiveComponentInsertBtn.insertAdjacentHTML(
      "beforebegin",
      Component.buildComponentCreatorButton() +
        Component.buildComponent(componentList.get("blockquote"))
    );
  } else if (e.target.id === "codeBlockComponent") {
    getActiveComponentInsertBtn.insertAdjacentHTML(
      "beforebegin",
      Component.buildComponentCreatorButton() +
        Component.buildComponent(componentList.get("codeBlock"))
    );
  } else if (e.target.id === "citationComponent") {
    getActiveComponentInsertBtn.insertAdjacentHTML(
      "beforebegin",
      Component.buildComponentCreatorButton() +
        Component.buildComponent(componentList.get("citation"))
    );
  }
});
