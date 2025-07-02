package entities;

import java.util.ArrayList;

public class EventSystem {
    private ArrayList<Event> events;

    public EventSystem() {
    }

    public void addEvent(Event event) {
        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);
    }

    // Search for an event by name
    public String searchEvent(String name) {
        if (events.isEmpty() || events == null) {
            return "No events found.";
        } else {
            StringBuilder result = new StringBuilder();
            for (Event event : events) {
                if (event.getName().equalsIgnoreCase(name)) {
                    result.append("Event found: ").append(event.getName()).append(", Location: ").append(event.getLocation()).append(", Date: ").append(event.getDate()).append(", Type: ").append(event.getEventType()).append(", Description: ").append(event.getDescription()).append("\nParticipants:\n");
                    for (Participant participant : event.getParticipants()) {
                        result.append(" - ").append(participant.getName()).append(" (").append(participant.getEmail()).append(")\n");
                    }
                }
            }
            return result.toString();
        }
    }

    // List all events in the system
    public String toString() {
        StringBuilder result = new StringBuilder();

        int eventNumber = 1;

        if (events == null || events.isEmpty()) {
            return "No events found.";
        } else {
            for (Event event : events) {
                result.append("Event ").append(eventNumber).append(": ").append(event.getName()).append(", Location: ").append(event.getLocation()).append(", Date: ").append(event.getDate()).append(", Type: ").append(event.getEventType()).append(", Description: ").append(event.getDescription()).append("\nParticipants:\n");
                for (Participant participant : event.getParticipants()) {
                    result.append(" - ").append(participant.getName()).append(" (").append(participant.getEmail()).append(")\n");
                }
                eventNumber++;
            }
            return result.toString();
        }
    }
}