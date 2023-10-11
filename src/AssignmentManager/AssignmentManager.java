package AssignmentManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AssignmentManager {


    ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();


    public static void main(String[] args) {
        new AssignmentManager().run();
    }

    private void run() {
        //add assignment to assignment list with parsed Date
        startProgram();
        addAssignment("Ass1", "12-10-23 11:33");
        addAssignment("Ass2", "20-10-23 12:00");
        addAssignment("Ass3", "31-10-23 00:00");
        addAssignment("Ass4", "10-10-23 11:00");
        addAssignment("Ass5", "10-10-23 11:02");
        // sort the list after adding assignment to the list
        assignmentList.sort(new SortAssignments());
        // display sorted list with formatted date
        printAssignments(assignmentList);
    }

    private void startProgram(){

        //instead of all that shit do whats in the actual assignment haha :/
        String name;
        String deadline;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Add assignment? y/n");
        if (userInput.nextLine().equalsIgnoreCase("y")) {
            System.out.println("What is the name of the assignment?");
            name = userInput.nextLine();
            System.out.println("What is the deadline for this assignment? (Format: dd-mm-yy hh:mm)");
            deadline = userInput.nextLine();

            addAssignment(name, deadline);
        }
        if (userInput.nextLine().equalsIgnoreCase("n")) {
            System.out.println("See list? y/n");

            if (userInput.nextLine().equalsIgnoreCase("y")) {
                printAssignments(assignmentList);
            } else {
                System.exit(1);
            }
        }

    }


    private void printAssignments(ArrayList<Assignment> assList) {
        for (Assignment assignment : assList) {
            // format date into human language

            System.out.printf("Assignment: %s |", assignment.getName());
            System.out.printf("%s%tB %<td, %<tY at %<tH:%<tM%n", "  Deadline: ", assignment.getDeadline());
        }

    }

    private void addAssignment(String name, String deadline) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(deadline, formatter);

        Assignment ass = new Assignment(name, dateTime);
        assignmentList.add(ass);
    }

}
