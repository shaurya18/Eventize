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
                <form class="register-form" method="POST" action="userServlet">
                    <input type="text" placeholder="name" name = "name"/>
                    <input type="password" placeholder="password" name = "password"/>
                    <input type="email" placeholder="email address" name="email"/>
                    <input type="text" placeholder="phone" name = "phone"/>     
                    <button>Edit</button>
                    <p class="message"></p>
                </form>
                <form class="login-form" method="POST" action="userServlet">
                    <input type="text" placeholder="name" name = "name"/>
                    <input type="password" placeholder="password" name = "password"/>
                    <input type="email" placeholder="email address" name="email"/>
                    <input type="text" placeholder="phone" name = "phone"/> 
                    <button>Edit</button>
                    <p class="message"></p>
                </form>
            </div>
        </div>
        <script src="js/jquerymin.js"></script>
        <script src="js/index.js"></script>
    </body>
</html>