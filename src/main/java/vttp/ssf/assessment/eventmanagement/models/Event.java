package vttp.ssf.assessment.eventmanagement.models;

public class Event {
    
    // unique identifier for an event
    private Integer eventId;

    private String eventName;

    // max size of event 
    private Integer eventSize;

    // in milliseconds
    private long eventDate;

    // no of participants who have registered to participate 
    private Integer participants;
}
