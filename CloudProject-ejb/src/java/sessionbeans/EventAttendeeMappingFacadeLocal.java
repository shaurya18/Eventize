/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entitybeans.EventAttendeeMapping;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ankit
 */
@Local
public interface EventAttendeeMappingFacadeLocal {

    void create(EventAttendeeMapping eventAttendeeMapping);

    void edit(EventAttendeeMapping eventAttendeeMapping);

    void remove(EventAttendeeMapping eventAttendeeMapping);

    EventAttendeeMapping find(Object id);

    List<EventAttendeeMapping> findAll();

    public String registerForEvent(int aid,int eid);
     
   List<EventAttendeeMapping> findRange(int[] range);

    int count();
    
}
