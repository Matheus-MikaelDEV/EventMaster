package entities;

import java.util.ArrayList;

public class EventSystem {
    private ArrayList<Event> events;

    public EventSystem() {
    }

    // Add a new event to the system
    public void addEvent(Event event) {
        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);
    }

    // Remove an event from the system
    public boolean removeEvent(Event event) {
        if (events == null || events.isEmpty()) {
            System.out.println("No events to remove.");
            return false;
        }

        boolean removed = events.removeIf(existingEvent -> existingEvent.getName().equalsIgnoreCase(event.getName()));

        if (!removed) {
            System.out.println("Event not found.");
        }

        return removed;
    }

    //Remove a participant from an event
    public boolean removeParticipant(Event event, Participant participant) {
        if (events != null && !events.isEmpty()) {
            for (Event existingEvent : events) {
                if (existingEvent.getName().equalsIgnoreCase(event.getName())) {
                    boolean removed = existingEvent.getParticipants().removeIf(existingParticipant -> existingParticipant.getName().equalsIgnoreCase(participant.getName()));
                    if (!removed) {
                        System.out.println("Participant not found.");
                    }
                    return removed;
                }
            }
        }
        System.out.println("Event not found.");
        return false;
    }

    // Search for an event by name
    public String searchEvent(String name) {
        boolean found = false;

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
                    found = true;
                }
            }

            if (!found) {
                return "Event not found.";
            }

            return result.toString();
        }
    }

    // Edit an existing event
    public boolean editEvent(Event event) {
        if (events != null && !events.isEmpty()) {
            for (int i = 0; i < events.size(); i++) {
                Event existing = events.get(i);
                if (existing.getName().equalsIgnoreCase(event.getName())) {
                    existing.setLocation(event.getLocation());
                    existing.setDate(event.getDate());
                    existing.setEventType(event.getEventType());
                    existing.setDescription(event.getDescription());
                    return true;
                }
            }
        }
        System.out.println("Event not found.");
        return false;
    }

    // Edit the content of participant event
    public boolean editParticipant(Event event, Participant newParticipant, Participant oldParticipant) {
        if (events != null && !events.isEmpty()) {
            for (Event existingEvent : events) {
                if (existingEvent.getName().equalsIgnoreCase(event.getName())) {
                    for (Participant existingParticipant : existingEvent.getParticipants()) {
                        if (existingParticipant.getName().equalsIgnoreCase(oldParticipant.getName())) {
                            existingParticipant.setName(newParticipant.getName());
                            existingParticipant.setEmail(newParticipant.getEmail());
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println("Participant not found.");
        return false;
    }

    // Add a participant to existing event
    public boolean addParticipantToExistingEvent(Event event, Participant participant) {
        if (events != null && !events.isEmpty()) {
            for (Event existingEvent : events) {
                if (existingEvent.getName().equalsIgnoreCase(event.getName())) {
                    existingEvent.addParticipant(participant);
                    return true;
                }
            }
        }
        System.out.println("Event not found.");
        return false;
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