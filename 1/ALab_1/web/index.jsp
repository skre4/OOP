<!doctype html>
<html lang="ru">
<head>
 <meta charset="UTF-8">
 <meta name="viewport"
 content="width=device-width, user-scalable=no, initial-scale=1.0, 
maximum-scale=1.0, minimum-scale=1.0">
 <meta http-equiv="X-UA-Compatible" content="ie=edge">
 <title>Document</title>
 <link href="views/css/source.css" rel="stylesheet">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-
beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-
BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
crossorigin="anonymous">
</head>
<body>
<header class="d-flex justify-content-center py-3">
 <ul class="nav nav-pills">
 <li class="nav-item"><a class="nav-link active" 
href="/web?name=">General</a></li>
 <li class="nav-item"><a class="nav-link" 
href="/web?name=contact">Contacts</a></li>
 <li class="nav-item"><a class="nav-link" href="/web?name=about">About 
us</a></li>
 <li class="nav-item"><a class="nav-link" 
href="/web?name=back">Feedback</a></li>
 <li class="nav-item"><a class="nav-link" 
href="/web?name=services">Services</a></li>
 </ul>
</header>
<div class="container">
<form action="/form" method="POST">
 <div class="test">
 <div class="questions">
 <ul>
 <li class="question"><p><h1>5 + 3 : </h1></p><input 
type="text" name="question"></li>
 <li class="question"><p>Capital of Russia</p><input 
type="text" name="question"></li>
 <li class="question"><p>Capital of France</p><input 
type="text" name="question"></li>
 <li class="question"><p>2 + 2 * 2 : </p><input type="text" 
name="question"></li>
 <li class="btn"><p></p><input type="submit"></li>
 </ul>
 </div>
 </div>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-
beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-
b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" 
crossorigin="anonymous"></script>
</body>
</html>