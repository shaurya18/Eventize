/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitybeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ankit
 */
@Entity
@Table(name = "event_attendee_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventAttendeeMapping.findAll", query = "SELECT e FROM EventAttendeeMapping e")
    , @NamedQuery(name = "EventAttendeeMapping.findById", query = "SELECT e FROM EventAttendeeMapping e WHERE e.id = :id")
    , @NamedQuery(name = "EventAttendeeMapping.findByEid", query = "SELECT e FROM EventAttendeeMapping e WHERE e.eid = :eid")
    , @NamedQuery(name = "EventAttendeeMapping.findByAid", query = "SELECT e FROM EventAttendeeMapping e WHERE e.aid = :aid")})
public class EventAttendeeMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eid")
    private int eid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aid")
    private int aid;

    public EventAttendeeMapping() {
    }

    public EventAttendeeMapping(Integer id) {
        this.id = id;
    }

    public EventAttendeeMapping(Integer id, int eid, int aid) {
        this.id = id;
        this.eid = eid;
        this.aid = aid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventAttendeeMapping)) {
            return false;
        }
        EventAttendeeMapping other = (EventAttendeeMapping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitybeans.EventAttendeeMapping[ id=" + id + " ]";
    }
    
}
