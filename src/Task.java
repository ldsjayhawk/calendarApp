import java.time.LocalDate;

public class Task{
    String title;
    int priority;
    LocalDate due;
    boolean complete;

    public Task(String title, int priority, LocalDate due, boolean complete){
        this.title = title;
        this.priority = priority;
        this.due = due;
        this.complete = complete;
    }
}
