/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entitybeans.Attendee;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ankit
 */
@Local
public interface AttendeeFacadeLocal {

    void create(Attendee attendee);

    void edit(Attendee attendee);

    void remove(Attendee attendee);

    Attendee find(Object id);

    List<Attendee> findAll();

    List<Attendee> findRange(int[] range);

    int count();
    public boolean createUser( String name, String email,String pass,String usertype,Timestamp x);
    public String loginUser(String email,String pass);
    public String editUserProfile(String name,String email,String password,String user_type,Timestamp x,String oldemail,int userid);
    
}
