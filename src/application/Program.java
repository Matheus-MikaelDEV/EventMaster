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
            System.out.println("1 - Add Event\n2 - Search Event\n3 - List Events\n4 - Exit");
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
                    // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 4);
    }
}