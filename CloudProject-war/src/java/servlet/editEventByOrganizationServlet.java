/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entitybeans.Eventrequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbeans.EventrequestFacadeLocal;

/**
 *
 * @author Ankit
 */
public class editEventByOrganizationServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String event_name = request.getParameter("event_name");
            String event_type = request.getParameter("event_type");
            String event_description = request.getParameter("event_description");
            String start_date = request.getParameter("start_date");
            String end_date = request.getParameter("end_date");
            String start_time = request.getParameter("start_time");
            String end_time = request.getParameter("end_time");
            String o_id = (String) session.getAttribute("orgid");
            String evid = request.getParameter("edit_event");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editEventByOrganizationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editEventByOrganizationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            efl.editBookingRequest(Integer.parseInt(evid), event_name, event_type, event_description, start_date, end_date, start_time, end_time, "Pending");
            List<Eventrequest> mylist2 = efl.getAllEvents();
            session.setAttribute("organization_event_list", mylist2);
            request.getRequestDispatcher("organizationHome.jsp").forward(request, response);
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
