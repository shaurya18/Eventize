/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbeans.OrganizationFacadeLocal;

/**
 *
 * @author Ankit
 */
public class editOrganizationProfileServlet extends HttpServlet {

    @EJB
    OrganizationFacadeLocal ofl;

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
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String contact_person = request.getParameter("contact_person");
        String userid = (String) session.getAttribute("orgid");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editOrganizationProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editOrganizationProfileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            java.util.Date date = new java.util.Date();
            Timestamp t = new Timestamp(date.getTime());

            String m = ofl.editOrganizationProfile(Integer.parseInt(userid), name, phone, contact_person, email, pass, t);
            if (m.equals("false")) {
                //    HttpSession session=request.getSession();  
                //    session.setAttribute("name",name);
                request.getRequestDispatcher("organizationHome.jsp").forward(request, response);
                //out.println("<a href = \"attendeeHome.jsp?name=\"name\"\">Invalid id.Please Click here to return to your profile.</a>");
            } else {
                session.setAttribute("name", name);
                request.getRequestDispatcher("organizationHome.jsp").forward(request, response);
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
