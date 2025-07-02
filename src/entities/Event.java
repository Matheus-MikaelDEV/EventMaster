package entities;

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
}