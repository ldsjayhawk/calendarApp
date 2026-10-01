import java.time.LocalDate;

public class Task{
    String title;
    int priority;
    LocalDate due;

    public Task(String title, int priority, LocalDate due){
        this.title = title;
        this.priority = priority;
        this.due = due;
    }
}
