/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entitybeans.Eventrequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.EventrequestFacade;
import sessionbeans.EventrequestFacadeLocal;

/**
 *
 * @author Ankit
 */
public class testing3 extends HttpServlet {

    @EJB
    EventrequestFacadeLocal erl;

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome admin!!!</h1>");
            out.println("</body>");
            out.println("</html>");

            /*  
            //upcoming events
            Eventrequest y =new Eventrequest();
            List<Eventrequest> mylist=y.getUpcomingEventList();
            out.println("drygkjlgdx");
            int i;
            for(i=0;i<mylist.size();i++)
            {
               out.println("Event Name : "+mylist.get(i).getEventName());
               out.println("Event Type : "+mylist.get(i).getEventType());
               out.println("Event Description : "+mylist.get(i).getEventDescription());
               out.println("Start Date : "+mylist.get(i).getStartDate());
               out.println("End Date : "+mylist.get(i).getEndDate());
               out.println("Start Time  : "+mylist.get(i).getStartTime());
               out.println("End Time : "+mylist.get(i).getEndTime());
               out.println("Room Name: "+mylist.get(i).getRoomName());
               out.println("Status: "+mylist.get(i).getStatus());
               out.println("Organized By :"+mylist.get(i).getOId());
               
               out.println("/n");
              
            }
             */
            //status anything ti approved by admin
            String val8 = erl.updateBookingStatusByAdmin(2);
            System.out.println("val8" + "yoyoyoyo");

            //delete event by admin
//          String val7=efl.deleteEventByAdmin(5); 
//          System.out.println(val7+"yoyoyoyo");
//            
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
