/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitybeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ankit
 */
@Entity
@Table(name = "eventrequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventrequest.findAll", query = "SELECT e FROM Eventrequest e")
    , @NamedQuery(name = "Eventrequest.findByEId", query = "SELECT e FROM Eventrequest e WHERE e.eId = :eId")
    , @NamedQuery(name = "Eventrequest.findByEventName", query = "SELECT e FROM Eventrequest e WHERE e.eventName = :eventName")
    , @NamedQuery(name = "Eventrequest.findByEventType", query = "SELECT e FROM Eventrequest e WHERE e.eventType = :eventType")
    , @NamedQuery(name = "Eventrequest.findByEventDescription", query = "SELECT e FROM Eventrequest e WHERE e.eventDescription = :eventDescription")
    , @NamedQuery(name = "Eventrequest.findByOId", query = "SELECT e FROM Eventrequest e WHERE e.oId = :oId")
    , @NamedQuery(name = "Eventrequest.findByStartDate", query = "SELECT e FROM Eventrequest e WHERE e.startDate = :startDate")
    , @NamedQuery(name = "Eventrequest.findByEndDate", query = "SELECT e FROM Eventrequest e WHERE e.endDate = :endDate")
    , @NamedQuery(name = "Eventrequest.findByStartTime", query = "SELECT e FROM Eventrequest e WHERE e.startTime = :startTime")
    , @NamedQuery(name = "Eventrequest.findByEndTime", query = "SELECT e FROM Eventrequest e WHERE e.endTime = :endTime")
    , @NamedQuery(name = "Eventrequest.findByCreatedOn", query = "SELECT e FROM Eventrequest e WHERE e.createdOn = :createdOn")
    , @NamedQuery(name = "Eventrequest.findByStatus", query = "SELECT e FROM Eventrequest e WHERE e.status = :status")
    , @NamedQuery(name = "Eventrequest.findByRoomName", query = "SELECT e FROM Eventrequest e WHERE e.roomName = :roomName")})
//public class Eventrequest implements Serializable,Comparable<Eventrequest> {

public class Eventrequest implements Serializable {

    

    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "e_id")
    private Integer eId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "event_name")
    private String eventName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "event_type")
    private String eventType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "event_description")
    private String eventDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "o_id")
    private int oId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "start_date")
    private String startDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "end_date")
    private String endDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "start_time")
    private String startTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "end_time")
    private String endTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "room_name")
    private String roomName;

    public Eventrequest() {
    }

    public Eventrequest(Integer eId) {
        this.eId = eId;
    }

    public Eventrequest(Integer eId, String eventName, String eventType, String eventDescription, int oId, String startDate, String endDate, String startTime, String endTime, Date createdOn, String status, String roomName) {
        this.eId = eId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.oId = oId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdOn = createdOn;
        this.status = status;
        this.roomName = roomName;
    }

    public Integer getEId() {
        return eId;
    }

    public void setEId(Integer eId) {
        this.eId = eId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getOId() {
        return oId;
    }

    public void setOId(int oId) {
        this.oId = oId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    
    /*@Override
    public int compareTo(Eventrequest er) 
    {
         return getCreatedOn().compareTo(er.getCreatedOn());
    }*/
    
    
   
//    public ArrayList<Eventrequest> getPendingEventList()
//    {
//    ArrayList<Eventrequest> x=null;
//     
//    return x;
//    }
//    
//    public ArrayList<Eventrequest> getCancelledEventList()
//    {
//    ArrayList<Eventrequest> x=null;
//     
//    
//   
//    return x;
//    }
//    
//    public Eventrequest getEventDetails(int id)
//    {
//    List<Eventrequest> x=null;
//    
//    Eventrequest er;           
//    x=emf.createEntityManager().createNamedQuery("Eventrequest.findByEId").setParameter("eId",id).getResultList();
//
//    er=x.get(0);
//   
//    return er;
//    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eId != null ? eId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventrequest))
        {
            return false;
        }
        
        Eventrequest other = (Eventrequest) object;
        if ((this.eId == null && other.eId != null) || (this.eId != null && !this.eId.equals(other.eId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitybeans.Eventrequest[ eId=" + eId + " ]";
    }


    
}
