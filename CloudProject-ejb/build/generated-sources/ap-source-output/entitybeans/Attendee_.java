package entitybeans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-08T00:52:32")
@StaticMetamodel(Attendee.class)
public class Attendee_ { 

    public static volatile SingularAttribute<Attendee, String> password;
    public static volatile SingularAttribute<Attendee, String> name;
    public static volatile SingularAttribute<Attendee, String> userType;
    public static volatile SingularAttribute<Attendee, Integer> aid;
    public static volatile SingularAttribute<Attendee, Date> createdOn;
    public static volatile SingularAttribute<Attendee, String> email;

}