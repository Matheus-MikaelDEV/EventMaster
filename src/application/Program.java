package application;

import entities.Event;
import entities.EventSystem;
import entities.EventType;
import entities.Participant;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Event Management System!");

        int option = 0;

        EventSystem eventSystem = new EventSystem();

        do {
            // Display menu options
            System.out.println("Chose an option:");
            System.out.println("1 - Add Event\n2 - Search Event\n3 - List Events\n4 - Edit Content\n5 - Exit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    // Add Event
                    System.out.println("Adding an event...");

                    System.out.print("Enter event name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter event location: ");
                    String location = sc.nextLine();
                    System.out.print("Enter event date (YYYY-MM-DD HH:MM): ");
                    String dateInput = sc.nextLine();
                    System.out.print("Enter event type: ");
                    EventType eventType = EventType.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Enter event description: ");
                    String description = sc.nextLine();

                    Event event = new Event(name, location, LocalDateTime.parse(dateInput), eventType, description);

                    // Ask how many participants there will be at the event
                    System.out.printf("How many participants in %s? ", name);
                    int numParticipants = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < numParticipants; i++) {
                        System.out.printf("Enter participant %d name: ", i + 1);
                        String participantName = sc.nextLine();
                        System.out.print("Enter participant email: ");
                        String participantEmail = sc.nextLine();

                        Participant participant = new Participant(participantName, participantEmail);
                        event.addParticipant(participant);

                        System.out.println("Participant added: " + participantName);
                    }

                    // Add event to the system
                    eventSystem.addEvent(event);
                    System.out.println("Event added successfully!");
                    break;
                case 2:
                    // Search Event
                    System.out.println("Searching for an event...");
                    System.out.print("Enter event name to search: ");
                    String searchName = sc.nextLine();
                    String searchResult = eventSystem.searchEvent(searchName);
                    System.out.println(searchResult);
                    break;
                case 3:
                    // List Events
                    System.out.println("Listing all events...");
                    System.out.println(eventSystem);
                    break;
                case 4:
                    // Edit Content
                    System.out.println("Editing content is not implemented yet.");
                    // This could be expanded to allow editing of events, participants, etc.

                    int option2 = 0;

                    do {
                        System.out.println("Chose an option to edit:");
                        System.out.println("1 - Edit Event\n2 - Edit Participant\n3 - Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        option2 = sc.nextInt();
                        sc.nextLine();

                        switch (option2) {
                            case 1:
                                // Edit Event
                                System.out.print("Enter the name of the event to edit: ");
                                String editEventName = sc.nextLine();
                                System.out.print("Enter new event location: ");
                                String newLocation = sc.nextLine();
                                System.out.print("Enter new event date (YYYY-MM-DD HH:MM): ");
                                String newDateInput = sc.nextLine();
                                System.out.print("Enter new event type: ");
                                EventType newEventType = EventType.valueOf(sc.nextLine().toUpperCase());
                                System.out.print("Enter new event description: ");
                                String newDescription = sc.nextLine();

                                Event editEvent = new Event(editEventName, newLocation, LocalDateTime.parse(newDateInput), newEventType, newDescription);
                                eventSystem.editEvent(editEvent);

                                if (eventSystem.editEvent(editEvent) == true) {
                                    System.out.println("Event edited successfully!");
                                } else {
                                    System.out.println("Failed to edit event. Event not found.");
                                }
                                break;
                            case 2:
                                int participantOption = 0;
                                // Edit participant or add a new participant
                                do {
                                    System.out.println("Edit Partcipant or Add New Participant");
                                    System.out.println("1 - Edit Participant\n2 - Add New Participant\n3 - Back to Edit Menu");
                                    System.out.print("Enter your choice: ");
                                    participantOption = sc.nextInt();
                                    sc.nextLine();

                                    switch (participantOption) {
                                        case 1:
                                            System.out.println("Editing a participant...");

                                            System.out.print("Enter the name of event of the participant to edit: ");
                                            String eventNameForParticipant = sc.nextLine();

                                            Event eventForParticipant = new Event(eventNameForParticipant);

                                            System.out.print("Enter the name of the participant to edit: ");
                                            String participantNameToEdit = sc.nextLine();

                                            Participant oldParticipant = new Participant(participantNameToEdit);

                                            System.out.print("Enter Name of the participant to edit: ");
                                            String participantNewNameToEdit = sc.nextLine();
                                            System.out.print("Enter Email of the participant to edit: ");
                                            String participantNewEmailToEdit = sc.nextLine();

                                            Participant participantToEdit = new Participant(participantNewNameToEdit, participantNewEmailToEdit);

                                            eventSystem.editParticipant(eventForParticipant, participantToEdit, oldParticipant);

                                            if (eventSystem.editParticipant(eventForParticipant, participantToEdit, oldParticipant)) {
                                                System.out.println("Participant edited successfully!");
                                            } else {
                                                System.out.println("Failed to edit participant. Participant not found.");
                                            }
                                            break;
                                        case 2:
                                            // Add a new participant
                                            System.out.println("Adding a new participant...");

                                            System.out.print("Enter the name of event for the new participant: ");
                                            String eventNameForNewParticipant = sc.nextLine();

                                            Event eventForNewParticipant = new Event(eventNameForNewParticipant);

                                            System.out.print("Enter participant name: ");
                                            String newParticipantName = sc.nextLine();
                                            System.out.print("Enter participant email: ");
                                            String newParticipantEmail = sc.nextLine();

                                            Participant newParticipant = new Participant(newParticipantName, newParticipantEmail);

                                            eventSystem.addParticipantToExistingEvent(eventForNewParticipant, newParticipant);

                                           if (eventSystem.addParticipantToExistingEvent(eventForNewParticipant, newParticipant)) {
                                                System.out.println("Participant added successfully!");
                                            } else {
                                                System.out.println("Failed to add participant. Event not found.");
                                           }
                                            break;
                                        case 3:
                                            // Back to Edit Menu
                                            System.out.println("Returning to Edit Menu...");
                                            break;
                                        default:
                                            System.out.println("Invalid option. Please try again.");
                                            break;
                                    }
                                } while (participantOption != 3);
                                break;
                            case 3:
                                // Back to Main Menu
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    } while (option2 != 3);

                    break;
                case 5:
                    // Exit
                    System.out.println("Exiting the Event Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 4);
    }
}