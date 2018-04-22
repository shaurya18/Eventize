package entitybeans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-08T00:52:32")
@StaticMetamodel(Organization.class)
public class Organization_ { 

    public static volatile SingularAttribute<Organization, String> password;
    public static volatile SingularAttribute<Organization, String> phone;
    public static volatile SingularAttribute<Organization, String> name;
    public static volatile SingularAttribute<Organization, String> contactPerson;
    public static volatile SingularAttribute<Organization, Integer> oid;
    public static volatile SingularAttribute<Organization, Date> createdOn;
    public static volatile SingularAttribute<Organization, String> email;

}