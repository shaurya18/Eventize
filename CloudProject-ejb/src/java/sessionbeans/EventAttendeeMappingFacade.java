/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entitybeans.EventAttendeeMapping;
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
public class EventAttendeeMappingFacade extends AbstractFacade<EventAttendeeMapping> implements EventAttendeeMappingFacadeLocal {

    @PersistenceContext(unitName = "CloudProject-ejbPU")
    private EntityManager em;

    @PersistenceUnit(unitName = "CloudProject-ejbPU")
    private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventAttendeeMappingFacade() {
        super(EventAttendeeMapping.class);
    }

    public String registerForEvent(int aid, int eid) {
        try {
            EventAttendeeMapping at = new EventAttendeeMapping();

            at.setAid(aid);
            at.setEid(eid);
            create(at);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Successfully Registered !";
    }

}
