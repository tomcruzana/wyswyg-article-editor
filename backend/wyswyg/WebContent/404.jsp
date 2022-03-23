<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.wyswyg.domain.Course, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1" />
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- font awesome -->
    <script
      src="https://kit.fontawesome.com/e4d4c44ee2.js"
      crossorigin="anonymous"
    ></script>

    <link rel="stylesheet" href="styles/index.css" />
    <link rel="stylesheet" href="styles/j-theme.css" />
    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />

    <title>ZXV Learning | Index</title>
  </head>
  <body>
    <nav class="navbar navbar-light j-primary j-shadow justify-content-between">
      <a class="navbar-brand" href="index.html">ZXV Learning</a>

      <form id="search_form" class="form-inline" action="search" method="GET">
        <input
          class="form-control mr-sm-2"
          name="q"
          type="text"
          placeholder="Search"
          aria-label="Search"
        />
        <button class="btn btn-primary my-2 my-sm-0" type="submit">
          <i class="fas fa-search text-white" aria-hidden="true"></i>
        </button>
        <button class="btn btn-warning login-btn ml-5" type="button">
          <i class="fa-solid fa-user"></i> Login
        </button>
      </form>
    </nav>

    <div class="container my-4">
      <!-- course cards -->
      <div class="text-center mt-5">
        <h1>
          <i class="fa-solid fa-circle-exclamation"></i> Error 404 - Page Not
          Found
        </h1>
        <h3>
          The page you are looking for might have been removed, had its name
          changed or is temporarily unavailable.
        </h3>

        <img
          src="https://seranking.com/blog/wp-content/uploads/2021/01/404_01-min.jpg"
          alt="404 cat"
          class="img-thumbnail mt-5"
        />
      </div>
    </div>
    <!-- Optional JavaScript -->
    <script src="scripts/index.js"></script>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
