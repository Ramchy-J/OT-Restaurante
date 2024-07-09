package entities;

import constants.Status;

import java.time.Instant;

public class ChangeLog extends Base{
    //Attributes
    private int entityID;
    private String entityType;
    private String changeDescription;
    private String previousValue;
    private String newValue;

    //Constructor


    public ChangeLog() {
    }

    public ChangeLog(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, int entityID, String entityType, String changeDescription, String previousValue, String newValue) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.entityID = entityID;
        this.entityType = entityType;
        this.changeDescription = changeDescription;
        this.previousValue = previousValue;
        this.newValue = newValue;
    }

    //Methods

    public int getEntityID() {
        return entityID;
    }

    public void setEntityID(int entityID) {
        this.entityID = entityID;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getChangeDescription() {
        return changeDescription;
    }

    public void setChangeDescription(String changeDescription) {
        this.changeDescription = changeDescription;
    }

    public String getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(String previousValue) {
        this.previousValue = previousValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
