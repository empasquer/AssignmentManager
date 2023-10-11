package AssignmentManager;

import java.util.Comparator;

public class SortAssignments implements Comparator<Assignment> {
    public int compare(Assignment a, Assignment b)
    {
        return a.getDeadline().compareTo(b.getDeadline());
    }

}
