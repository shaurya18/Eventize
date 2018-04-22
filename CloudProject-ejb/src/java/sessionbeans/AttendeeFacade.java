/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entitybeans.Attendee;
import java.sql.Timestamp;
import java.util.ArrayList;
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
public class AttendeeFacade extends AbstractFacade<Attendee> implements AttendeeFacadeLocal {

    @PersistenceContext(unitName = "CloudProject-ejbPU")
    private EntityManager em;

    @PersistenceUnit(unitName = "CloudProject-ejbPU")
    EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AttendeeFacade() {
        super(Attendee.class);
    }

    @Override
    public boolean createUser(String name, String email, String pass, String usertype, Timestamp x) {
        try {

            Attendee at = new Attendee();
            at.setName(name);
            at.setEmail(email);
            at.setPassword(pass);
            at.setUserType(usertype);
            at.setCreatedOn(x);
            create(at);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String loginUser(String email, String pass) {
        String name = "";
        String id = "";
        boolean flag = false;
        try {
            List<Attendee> arlist = emf.createEntityManager().createNamedQuery("Attendee.findAll").getResultList();
            for (Attendee obj : arlist) {
                if (obj.getEmail().equals(email) && obj.getPassword().equals(pass)) {
                    flag = true;
                    name = obj.getName();
                    id = obj.getAid().toString();
                    break;
                }
            }

        } catch (Exception e) {
        }
        if (flag) {
            return name + "," + email + "," + id;
        }
        return "false";
    }

    @Override
    public String editUserProfile(String name, String email, String password, String user_type, Timestamp t, String oldemail, int userid) {
        Attendee xy;
        try {
            List<Attendee> arlist = (List<Attendee>) emf.createEntityManager().createNamedQuery("Attendee.findByAid").setParameter("aid", userid).getResultList();
            xy = arlist.get(0);
            System.out.println(xy.getAid());

            if (xy.getAid() == userid) {
                xy.setEmail(email);
                xy.setName(name);
                xy.setPassword(password);
                xy.setUserType(user_type);
                xy.setCreatedOn(t);
                edit(xy);
            } else {
                return "false";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "Updated Successfully";
    }
}
