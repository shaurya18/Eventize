/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entitybeans.Attendee;
import entitybeans.Organization;
import java.sql.Timestamp;
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
public class OrganizationFacade extends AbstractFacade<Organization> implements OrganizationFacadeLocal {

    @PersistenceContext(unitName = "CloudProject-ejbPU")
    private EntityManager em;

    @PersistenceUnit(unitName = "CloudProject-ejbPU")
    EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrganizationFacade() {
        super(Organization.class);
    }

    @Override
    public boolean createOrganization(String name, String phone, String contactPerson, String email, String pass, Timestamp x) {
        try {
            Organization o = new Organization();
            o.setEmail(email);
            o.setName(name);
            o.setPassword(pass);
            o.setContactPerson(contactPerson);
            o.setPhone(phone);
            o.setCreatedOn(x);
            create(o);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String loginOrganization(String email, String pass) {
        String name = "";
        String orgid = "";
        boolean flag = false;
        try {

            List<Organization> arlist = emf.createEntityManager().createNamedQuery("Organization.findAll").getResultList();
            for (Organization obj : arlist) {
                if (obj.getEmail().equals(email) && obj.getPassword().equals(pass)) {
                    flag = true;
                    name = obj.getName();
                    orgid = obj.getOid().toString();
                    break;
                }

            }
        } catch (Exception e) {
        }
        if (flag) {
            return name + "," + orgid;
        }
        return "false";
    }

    //EditOrgnizationProfile()
    @Override
    public String editOrganizationProfile(int oid, String name, String phone, String contact_person, String email, String password, Timestamp t) {
        Organization xy;
        try {

            List<Organization> arlist = (List<Organization>) emf.createEntityManager().createNamedQuery("Organization.findByOid").setParameter("oid", oid).getResultList();
            xy = arlist.get(0);
            System.out.println(xy.getOid());

            if (xy.getOid() == oid) {
                xy.setEmail(email);
                xy.setName(name);
                xy.setPassword(password);
                xy.setPhone(phone);
                xy.setCreatedOn(t);
                xy.setContactPerson(contact_person);
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
