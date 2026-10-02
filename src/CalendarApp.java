import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarApp {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) {
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
            choice = userInput.nextInt();
            userInput.nextLine();

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
        userInput.close();
    }

    static void addTask() {
        System.out.println("Enter title: ");
        String title = userInput.nextLine();

        System.out.println("Enter priority: ");

        int priority = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Enter due date (yyyy-mm-dd): ");
        String dueText = userInput.nextLine();
        LocalDate due = LocalDate.parse(dueText);
            
        Task newTask = new Task(title, priority, due);
        
        tasks.add(newTask);
                
        
        System.out.println(newTask.title + " task added");
    }
    
    static void editTask() {
        tasks.get(0);
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
            System.out.println(i+1 + ". " + tasks.get(i).title);
        }
        System.out.println();
    }
    
    static void saveTasks() {
        System.out.println("Save");
    }
    
    static void schedule() {
        System.out.println("Schedule");
    }
    // userInput.close();
}
