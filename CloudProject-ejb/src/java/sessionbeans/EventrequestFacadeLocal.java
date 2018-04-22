/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entitybeans.Eventrequest;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ankit
 */
@Local
public interface EventrequestFacadeLocal {

    void create(Eventrequest eventrequest);

    void edit(Eventrequest eventrequest);

    void remove(Eventrequest eventrequest);

    Eventrequest find(Object id);
 
    List<Eventrequest> findAll();

    List<Eventrequest> findRange(int[] range);

    int count();

    public String updateBookingStatusByAdmin(int id);
    
     public String cancelEvent(int id);
   
     public String deleteEventByAdmin(int id);
    
    public boolean generateEventBookingRequest(String event_name,String event_type,String event_desc,int o_id,String start_date,String end_date,String start_time,String end_time,Timestamp x,String status,String room_name);
    
    public String editBookingRequest(int eid,String event_name,String event_type,String event_description,String start_date,String end_date,String start_time,String end_time,String status);
    
    public List<Eventrequest> getUpcomingEventList(int aid);
    
    public List<Eventrequest> getMyEvents(int oid);
    
    public boolean checkAvailability(String dat,String st,String et,String room);
    
    public List<Eventrequest> getAllEvents();
}