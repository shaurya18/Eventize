/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entitybeans.Eventrequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbeans.EventrequestFacadeLocal;
import java.lang.String;
import java.util.List;

/**
 *
 * @author Ankit
 */
public class createEventServlet extends HttpServlet {

    @EJB
    EventrequestFacadeLocal erfl;

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
        HttpSession session = request.getSession();
        String event_name = request.getParameter("event_name");
        String event_type = request.getParameter("event_type");
        String event_description = request.getParameter("event_description");
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        String room_name = request.getParameter("room_name");
        String o_id = (String) session.getAttribute("orgid");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createEventServlet</title>");
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet createEventServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            java.util.Date date = new java.util.Date();
            Timestamp t = new Timestamp(date.getTime());

            boolean check = erfl.checkAvailability(start_date, start_time, end_time, room_name);
            if (check == false) {
                out.println("Can't create Event at these timings.Please enter some other timings" + request.getContextPath() + "</h1>");
                request.getRequestDispatcher("createEvent.jsp").include(request, response);
            } else {
                boolean val = erfl.generateEventBookingRequest(event_name, event_type, event_description, Integer.parseInt(o_id), start_date, end_date, start_time, end_time, t, "Pending", room_name);

                if (val) {
                    System.out.println("JXERBWKVBKEB!!!");
                    String x = (String) session.getAttribute("orgid");
                    List<Eventrequest> mylist2 = erfl.getMyEvents(Integer.parseInt(x));
                    session.setAttribute("organization_event_list", mylist2);
                    request.getRequestDispatcher("organizationHome.jsp").include(request, response);
                    //        out.println("You are successfully registered !");
                }
            }
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
