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
                <form class="register-form" method="POST" action="editEventByOrganizationServlet">
                    <input type="text" placeholder="name" name = "name"/>
                    <input type="password" placeholder="password" name = "password"/>
                    <input type="email" placeholder="email address" name="email"/>
                    <input type="text" placeholder="phone" name = "phone"/>     
                    <button>Edit Event</button>
                    <p class="message"></p>
                </form>
                <form class="login-form" method="POST" action="editEventByOrganizationServlet">
                    <input type="text" placeholder="event name" name = "event_name"/>
                    <input type="text" placeholder="event type" name = "event_type"/>
                    <input type="text" placeholder="event description" name = "event_description"/>
                    <input type="text" placeholder="start date" name = "start_date"/>
                    <input type="text" placeholder="end date" name = "end_date"/>
                    <input type="text" placeholder="start time" name = "start_time"/>
                    <input type="text" placeholder="end time" name = "end_time"/>
                    <input type="hidden" name = "edit_event" value = "<%=request.getParameter("edit_event")%>"/>
                    <button>Edit Event</button>
                    <p class="message"></p>
                </form>
            </div>
        </div>
        <script src="js/jquerymin.js"></script>
        <script src="js/index.js"></script>
    </body>
</html>