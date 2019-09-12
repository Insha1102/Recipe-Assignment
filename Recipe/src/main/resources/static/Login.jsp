<html>
<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font><br/>
    <form method="post" action="/login">
        Name : <input type="text" name="name" /><br/>
        Password : <input type="password" name="password" /> 
        <input type="submit" />
    </form>
</body>

</html>