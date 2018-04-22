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
import sessionbeans.OrganizationFacadeLocal;

/**
 *
 * @author shaurya
 */
public class loginOrganizationServlet extends HttpServlet {

    @EJB
    OrganizationFacadeLocal ofl;

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
            out.println("<title>Servlet loginOrganizationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginOrganizationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            out.println(email);
            out.println(pass);

            String val2 = ofl.loginOrganization(email, pass);
            List<String> list = Arrays.asList(val2.split(","));
            List<Eventrequest> mylist = efl.getMyEvents(Integer.parseInt(list.get(1)));
            System.out.println(val2 + "Welcome!!");
            if (val2 == "false") {
                out.println("<a href = \"index(2).html\">Invalid Login Credientials.Please Click to Login Again</a>");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("name", list.get(0));
                session.setAttribute("orgid", list.get(1));
                session.setAttribute("organization_event_list", mylist);
                request.getRequestDispatcher("organizationHome.jsp").forward(request, response);
            }
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
