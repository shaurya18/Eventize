/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entitybeans.Organization;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ankit
 */
@Local
public interface OrganizationFacadeLocal {

    void create(Organization organization);

    void edit(Organization organization);

    void remove(Organization organization);

    Organization find(Object id);

    List<Organization> findAll();

    List<Organization> findRange(int[] range);

    int count();
    
    public boolean createOrganization(String name,String phone,String contactPerson, String email,String pass,Timestamp x);
    public String loginOrganization( String email,String pass);
    public String editOrganizationProfile(int oid,String name,String phone,String contact_person,String email,String password,Timestamp t);   
}
