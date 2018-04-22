/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entitybeans.Eventrequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbeans.AttendeeFacadeLocal;
import sessionbeans.EventrequestFacadeLocal;

/**
 *
 * @author shaurya
 */
public class loginUserServlet extends HttpServlet {

    @EJB
    AttendeeFacadeLocal af;

    @EJB
    EventrequestFacadeLocal efl;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginUserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            //        out.println(email);
            //        out.println(pass);
            System.out.println("PPPPP");
            String val2 = af.loginUser(email, pass);
            System.out.println(val2 + "BLABLABAL");

            //       out.println(mylist);
            List<String> list = Arrays.asList(val2.split(","));
            //       System.out.println(mylist);
            if (val2 == "false") {
                out.println("<a href = \"index(2).html\">Invalid Login Credientials.Please Click to Login Again</a>");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("name", list.get(0));
                session.setAttribute("useremail", list.get(1));
                session.setAttribute("userid", list.get(2));
                List<Eventrequest> mylist = efl.getUpcomingEventList(Integer.parseInt(list.get(2)));
//                session.setAttribute("attendee_event_list", mylist);
                //    request.getRequestDispatcher("attendeeHome.jsp").forward(request, response);
                if (email.equals("admin@gmail.com") && pass.equals("admin")) {
                    System.out.println("LLALALAAL");
                    List<Eventrequest> mylist2 = efl.getAllEvents();
                    session.setAttribute("admin_event_list", mylist2);
                    request.getRequestDispatcher("adminHome.jsp").forward(request, response);
                } else {
                    session.setAttribute("attendee_event_list", mylist);
                    request.getRequestDispatcher("attendeeHome.jsp").forward(request, response);
                }
            }

            //  response.sendRedirect("loginUser.jsp?foo=bar");
        } catch (Exception e) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
