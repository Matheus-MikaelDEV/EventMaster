package entities;

import entities.enums.EventType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private String location;
    private LocalDateTime date;
    private EventType eventType;
    private String description;

    private List<Participant> participants = new ArrayList<>();

    public Event(String name, String location, LocalDateTime date, EventType eventType, String description) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.eventType = eventType;
        this.description = description;
    }

    public Event(String name) {
        this.name = name;
    }

    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getDescription() {
        return description;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}