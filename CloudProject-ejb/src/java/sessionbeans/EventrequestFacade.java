/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entitybeans.Attendee;
import entitybeans.EventAttendeeMapping;
import entitybeans.Eventrequest;
import entitybeans.Organization;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Ankit
 */
@Stateless
public class EventrequestFacade extends AbstractFacade<Eventrequest> implements EventrequestFacadeLocal {

    @PersistenceContext(unitName = "CloudProject-ejbPU")
    private EntityManager em;

    @PersistenceUnit(unitName = "CloudProject-ejbPU")
    EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventrequestFacade() {
        super(Eventrequest.class);
    }

    @Override
    public boolean generateEventBookingRequest(String event_name, String event_type, String event_desc, int o_id, String start_date, String end_date, String start_time, String end_time, Timestamp x, String status, String room_name) {
        try {

            Eventrequest er = new Eventrequest();
            er.setEventName(event_name);
            er.setEventType(event_type);
            er.setEventDescription(event_desc);
            er.setOId(o_id);
            er.setRoomName(room_name);
            er.setStatus(status);
            er.setCreatedOn(x);
            er.setStartDate(start_date);
            er.setEndDate(end_date);
            er.setStartTime(start_time);
            er.setEndTime(end_time);
            create(er);
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    public String checkAvailability()
//    {
//        
//    }
    ///update status as cancelled
    @Override
    public String cancelEvent(int id) {

        Eventrequest x;
        try {

            List<Eventrequest> arlist = (List<Eventrequest>) emf.createEntityManager().createNamedQuery("Eventrequest.findByEId").setParameter("eId", id).getResultList();
            /*EntityManager emrequest = Eventrequest.
    TypedQuery<Employee> q = em.createQuery("SELECT o FROM Employee AS o WHERE o.name = :name", Employee.class);
    q.setParameter("name", name);
    return q.getSingleResult();
             */
            x = arlist.get(0);
            System.out.println(x.getEId());
            if (x.getEId() == id) {
                String cs = x.getStatus();
                System.out.println(cs);
                x.setStatus("Cancelled");
            }
            edit(x);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Cancelled";
    }

    @Override
    public String editBookingRequest(int eid, String event_name, String event_type, String event_description, String start_date, String end_date, String start_time, String end_time, String status) {
        Eventrequest x;
        try {
            List<Eventrequest> arlist = (List<Eventrequest>) emf.createEntityManager().createNamedQuery("Eventrequest.findByEId").setParameter("eId", eid).getResultList();
            x = arlist.get(0);
            x.setEventName(event_name);
            x.setEventType(event_type);
            x.setEventDescription(event_description);
            //       x.setOId(oid);
            x.setStartDate(start_date);
            x.setEndDate(end_date);
            x.setStartTime(start_time);
            x.setEndTime(end_time);
            //       x.setCreatedOn(t);
            x.setStatus(status);
            edit(x);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Updated Event Booking Details";
    }

    @Override
    public String updateBookingStatusByAdmin(int id) {
        Eventrequest x;
        try {

            List<Eventrequest> arlist = (List<Eventrequest>) emf.createEntityManager().createNamedQuery("Eventrequest.findByEId").setParameter("eId", id).getResultList();

            x = arlist.get(0);
            System.out.println(x.getEId());
            String cs = x.getStatus();
            System.out.println(cs);
            x.setStatus("Approved");
            edit(x);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Updated Event Status as APPROVED EVENT";

    }

    @Override
    public String deleteEventByAdmin(int id) {
        Eventrequest x;
        try {

            List<Eventrequest> arlist = (List<Eventrequest>) emf.createEntityManager().createNamedQuery("Eventrequest.findByEId").setParameter("eId", id).getResultList();

            x = arlist.get(0);
            System.out.println(x.getEId());
            //if(x.getEId()==id)
            //  {
            //
            remove(x);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Deleted Event";
    }

    @Override
    public List<Eventrequest> getUpcomingEventList(int aid) {
        int flag = 0;
        List<Eventrequest> arlist = null;
        List<Eventrequest> arlist2 = null;
        List<EventAttendeeMapping> arlist3 = null;
        try {
            arlist = (List<Eventrequest>) emf.createEntityManager().createNamedQuery("Eventrequest.findAll").getResultList();
            arlist2 = new ArrayList<>(arlist.size());
            arlist3 = (List<EventAttendeeMapping>) emf.createEntityManager().createNamedQuery("EventAttendeeMapping.findByAid").setParameter("aid", aid).getResultList();
            System.out.println(arlist);
            for (int i = 0; i < arlist.size(); i++) {
                if (arlist.get(i).getStatus().equals("Approved")) {
                    for (int j = 0; j < arlist3.size(); j++) {
                        if ((arlist3.get(j).getAid() == aid) && (arlist3.get(j).getEid() == arlist.get(i).getEId())) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) {
                        flag = 0;
                        continue;
                    }
                    System.out.println("MMM");
                    arlist2.add(arlist.get(i));
                }
            }
            System.out.println(arlist2 + "WHY?");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arlist2;
    }

    public List<Eventrequest> getMyEvents(int oid) {
        List<Eventrequest> arlist = null;
        try {
            arlist = (List<Eventrequest>) emf.createEntityManager().createNamedQuery("Eventrequest.findByOId").setParameter("oId", oid).getResultList();

            System.out.println(arlist);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arlist;
    }

    public boolean checkAvailability(String dat, String st, String et, String room) {
        Eventrequest x;
        int i, flag = 1;
        try {
            System.out.println("DFSIOJ");
            List<Eventrequest> arlist = (List<Eventrequest>) emf.createEntityManager().createNamedQuery("Eventrequest.findByRoomName").setParameter("roomName", room).getResultList();
            System.out.println("DFSIOJ22");
            int curstart = Integer.parseInt(st.replace(":", ""));
            int curend = Integer.parseInt(et.replace(":", ""));
            System.out.println("current" + curstart + " " + curend);

            for (i = 0; i < arlist.size(); i++) {
                if (arlist.get(i).getStartDate().equals(dat) && arlist.get(i).getRoomName().equals(room)) {
                    int tempstart = Integer.parseInt(arlist.get(i).getStartTime().replace(":", ""));
                    int tempend = Integer.parseInt(arlist.get(i).getEndTime().replace(":", ""));
                    if (tempend <= curstart) {
                        continue;
                    } else if (tempstart >= curend) {
                        continue;
                    } else {
                        System.out.println("clash" + tempstart + " " + tempend);
                        flag = 0;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Some erroe in chek availibilty comparisons");
        }

        if (flag == 1) {
            return true;
        } else if (flag == 0) {
            return false;
        } else {
            System.out.println("some error no flag set 0/1");
            return false;
        }
    }

    @Override
    public List<Eventrequest> getAllEvents() {
        List<Eventrequest> arlist = null;
        try {
            arlist = (List<Eventrequest>) emf.createEntityManager().createNamedQuery("Eventrequest.findAll").getResultList();
            System.out.println(arlist);
//      for(int i=0;i<arlist.size();i++)
//            {
////                System.out.println(arlist.get(i) + "DDDXXX" + arlist.get(i).getEId());
////                Eventrequest x = arlist.get(i);
//           //     arlist2.add(obj);
//               
//            }
            System.out.println(arlist + "YHW?");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arlist;
    }
}
