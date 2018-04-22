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
import sessionbeans.EventrequestFacadeLocal;
import sessionbeans.OrganizationFacadeLocal;

/**
 *
 * @author Ankit
 */
public class testing2 extends HttpServlet {

    @EJB
    EventrequestFacadeLocal er;

    @EJB
    EventrequestFacadeLocal efl;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet organizationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet organizationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            java.util.Date date = new java.util.Date();
            Timestamp x = new Timestamp(date.getTime());

//MyEvents
//UpdateEventRequest
//        String val9 = er.editBookingRequest(2, "Execute", "Execute 17.1","Programming Competition", 2,"22-04-2017","22-04-2017","10:00:00","01:00:00",x,"Pending");
//        out.println(val9);
//createEvent
//          boolean val8=er.generateEventBookingRequest("nukkad natak", "drama/play","play",2,"20-1-2017","20-2-2017","2:00:00", "3:00:00", x, "Pending", "Audi");
//          out.println(val8+"Generated Request Successfully!! ");    
//cancelEvent
//          String val6=efl.cancelEvent(4);
//             System.out.println(val6+"yooooyoyooyooyE!!!");
//editOrganizationProfile  
//        String m= ofl.editOrganizationProfile(6,"radiance","9888987689","Priya sharma","radiance@gmail.com","rad1234",x);
//        System.out.println("Updated successfully");
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
