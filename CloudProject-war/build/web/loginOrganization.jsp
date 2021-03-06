<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Organization</title>
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <div class="login-page">
            <div class="form">
                <form class="register-form" method="POST" action="registerOrganizationServlet">
                    <input type="text" placeholder="name" name = "name"/>
                    <input type="password" placeholder="password" name = "password"/>
                    <input type="email" placeholder="email address" name="email"/>
                    <input type="text" placeholder="phone" name = "phone"/>
                    <input type="text" placeholder="contact person" name="contact_person"/>      
                    <button>create</button>
                    <p class="message">Already registered? <a href="#">Sign In</a></p>
                </form>
                <form class="login-form" method="POST" action="loginOrganizationServlet">
                    <input type="email" placeholder="email" name = "email"/>
                    <input type="password" placeholder="password" name = "password"/>
                    <button>login</button>
                    <p class="message">Not registered? <a href="#">Create an account</a></p>
                </form>
            </div>
        </div>
        <script src="js/jquerymin.js"></script>
        <script src="js/index.js"></script>
    </body>
</html>