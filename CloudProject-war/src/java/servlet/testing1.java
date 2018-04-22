/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entitybeans.EventAttendeeMapping;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.AttendeeFacadeLocal;
import sessionbeans.EventAttendeeMappingFacadeLocal;
import sessionbeans.EventrequestFacadeLocal;
import sessionbeans.OrganizationFacadeLocal;

/**
 *
 * @author Ankit
 */
public class testing1 extends HttpServlet {

    @EJB
    AttendeeFacadeLocal af;
    @EJB
    OrganizationFacadeLocal fl;
    @EJB
    EventrequestFacadeLocal efl;
    @EJB
    EventAttendeeMappingFacadeLocal emr;

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
            out.println("<title>Servlet test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet test at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            //register  //boolean val = af.createUser(2, "asddd", "aaa@gggg.com", "passsdsf");
            //login boolean val2=af.loginUser(55,"autugugy", "aghdghnvhaa@gggg.com", "pctyhfjhfasssdsf");
            //System.out.println(val2);
            //register  
            boolean val3;
            // boolean val2=af.loginUser("sha", "s@gmail.com", "shasha");
            // System.out.println(val2);
            java.util.Date date = new java.util.Date();
            Timestamp t = new Timestamp(date.getTime());
            //   val3 = fl.createOrganization("knuth","2589321478","r singh","knuth@gmail.com", "knu",t);
            // System.out.println(val3);

            // boolean val4=fl.loginOrganization("techrock","96632587","Raj Singhal", "raj@gmail.com", "yoyo");
            //System.out.println(val4+"YIPEE!!!");
            boolean v = efl.checkAvailability("02-05-2017", "09:00", "10:00", "LT1");
            System.out.println(v + "yoyoyoyo");

            //gen event req 
            //boolean val5 = efl.generateEventBookingRequest("IEEE","Orientation","research related",3,"25-06-2017","5-06-2017","17:00:00","17:00:00",t,"Pending","LT1");
            //   System.out.println(val5+"YAY!!!");
            //cancel event
            ////String val6=efl.cancelEvent(1);
            ////System.out.println(val6+"yooooyoyooyooyE!!!");
            //delete eveny by admin
            //String val7=efl.deleteEventByAdmin(2); 
            // System.out.println(val7+"yoyoyoyo");
            //status anything ti approved by admin
            // String val8=efl.updateBookingStatusByAdmin(4); 
            //System.out.println("val8"+"yoyoyoyo");
            //String c= emr.registerForEvent(46,2);
            // System.out.println(c+"yo you are registered fr the event");
            //remove id coloumns    
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
