import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarApp {

    static ArrayList<Task> tasks = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner menuChoice = new Scanner(System.in);
        int choice = 0;

        while (choice != 8){

            System.out.println("Welcome!");
            System.out.println("1. Create a task");
            System.out.println("2. Edit a task");
            System.out.println("3. Complete a task");
            System.out.println("4. Delete a task");
            System.out.println("5. View tasks");
            System.out.println("6. Save tasks to file");
            System.out.println("7. Print Schedule");
            System.out.println("8. Exit");
            
            System.out.println("Please enter choice: ");
            choice = menuChoice.nextInt();
            
            switch(choice) {
                case 1:
                    addTask();
                    break;
                    
            case 2:
                editTask();
                break;

            case 3:
                completeTask();
                break;

            case 4:
                deleteTask();
                break;

            case 5:
                viewTasks();
                break;

            case 6:
                saveTasks();
                break;

            case 7:
                schedule();
                break;

            case 8:
                break;
        }
        
    }
    menuChoice.close();
}

static void addTask() {
    Task newTask = new Task("create program", 1, LocalDate.of(2026, 12, 31));
    tasks.add(newTask);

    System.out.println("Add");
}
    
static void editTask() {
    System.out.println("Edit");
}

static void completeTask() {
    System.out.println("Complete");
}

static void deleteTask() {
    // cars.remove(0);
    System.out.println("Delete");
}

static void viewTasks() {
    for (int i = 0; i < tasks.size(); i++) {
    System.out.println(tasks.get(i));
}
}

static void saveTasks() {
    System.out.println("Save");
}

static void schedule() {
    System.out.println("Schedule");
}
}
