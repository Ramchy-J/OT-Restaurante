package entities;

import java.util.Date;

public abstract class Base {

    //Attributes

    private Integer entityId;
    private String entityName;
    private Date createdDate;
    private Date modifiedDate;

    //Constructor

    public Base() {
    }

    public Base(Integer entityId, String entityName, Date createdDate, Date modifiedDate) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    //Methods

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
