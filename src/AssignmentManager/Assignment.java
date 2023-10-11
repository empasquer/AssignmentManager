package AssignmentManager;

import java.time.LocalDateTime;


public class Assignment {

    private String name;
    private LocalDateTime deadline;

    public Assignment(String name, LocalDateTime deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }
}
