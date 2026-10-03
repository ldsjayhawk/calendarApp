import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class CalendarApp {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 8) {

            System.out.println();
            System.out.println("Welcome!");
            System.out.println("1. Create a task");
            System.out.println("2. Edit or Complete a task");
            System.out.println("3. Delete a task");
            System.out.println("4. View tasks");
            System.out.println("5. Save tasks to file");
            System.out.println("6. Load tasks from file");
            // System.out.println("7. Print Schedule");
            System.out.println("7. Exit");

            System.out.print("Please enter choice: ");
            choice = userInput.nextInt();
            userInput.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    addTask();
                    break;

                case 2:
                    editTask();
                    break;

                case 3:
                    deleteTask();
                    break;

                case 4:
                    viewTasks();
                    break;

                case 5:
                    saveTasks();
                    break;

                case 6:
                    loadTasks();
                    break;

                // case 7:
                // schedule();
                // break;

                case 7:
                    System.exit(0);
            }
        }
        userInput.close();
    }

    static void addTask() {
        System.out.print("Enter title: ");
        String title = userInput.nextLine();

        System.out.print("Enter priority: ");
        int priority = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Enter due date (yyyy-mm-dd): ");
        String dueText = userInput.nextLine();
        LocalDate due = LocalDate.parse(dueText);

        Boolean complete = false;
        Task newTask = new Task(title, priority, due, complete);
        tasks.add(newTask);

        System.out.println();
        System.out.print(newTask.title + " task added");
        System.out.println();
    }

    static void editTask() {
        viewTasks();

        System.out.print("Which task do you want to edit? ");
        int editChoice = userInput.nextInt() - 1;
        userInput.nextLine();

        Task task = tasks.get(editChoice);

        System.out.println("Which part of the task do you want to edit? ");
        System.out.println("1. Title");
        System.out.println("2. Priority");
        System.out.println("3. Due Date");
        System.out.println("4. Completion");

        System.out.print("Select item to edit: ");
        int editTaskPart = userInput.nextInt();
        userInput.nextLine();
        System.out.println();

        switch (editTaskPart) {
            case 1:
                System.out.print("Enter new title: ");
                String newTitle = userInput.nextLine();
                task.title = newTitle;

                System.out.println("Task edited");
                break;

            case 2:
                System.out.print("Enter new priority: ");
                int newPriority = userInput.nextInt();
                userInput.nextLine();
                task.priority = newPriority;

                System.out.println("Task edited");
                break;

            case 3:
                System.out.print("Enter new due date (yyyy-mm-dd): ");
                String newDueText = userInput.nextLine();
                LocalDate newDue = LocalDate.parse(newDueText);
                task.due = newDue;

                System.out.println("Task edited");
                break;

            case 4:
                if (task.complete) {
                    task.complete = false;
                    System.out.println("Task marked Incomplete");
                } else {
                    task.complete = true;
                    System.out.println("Task marked Complete");
                }

                break;
        }
    }

    static void deleteTask() {
        viewTasks();

        System.out.print("Which task do you want to delete? ");
        int deleteChoice = userInput.nextInt() - 1;
        userInput.nextLine();

        tasks.remove(deleteChoice);
        System.out.println("Task deleted.");
    }

    static void viewTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            int taskNum = i;
            System.out.println();
            System.out.println("Task #" + (taskNum + 1));
            System.out.println("Task: " + tasks.get(i).title);
            System.out.println("Priority: " + tasks.get(i).priority);
            System.out.println("Date Due: " + tasks.get(i).due);
            if (tasks.get(i).complete) {
                System.out.println("Completed: Yes");
            } else {
                System.out.println("Completed: No");
            }

        }
        System.out.println();
    }

    static void saveTasks() {
        try {
            FileWriter myWriter = new FileWriter("taskFile.txt");
            for (Task task : tasks) {
                myWriter.write(task.title + "," + task.priority + "," + task.due + "," + task.complete + "\n");
            }
            myWriter.close();
            System.out.println("Tasks saved");
        } catch (IOException e) {
            System.out.println("Failed to write to document.");
            e.printStackTrace();
        }
    }

    static void loadTasks() {

        File readFile = new File("taskFile.txt");

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(readFile)) {

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] pieces = data.split(",");

                String title = pieces[0];
                int priority = Integer.parseInt(pieces[1]);
                LocalDate due = LocalDate.parse(pieces[2]);
                Boolean complete = Boolean.parseBoolean(pieces[3]);

                Task newTask = new Task(title, priority, due, complete);
                tasks.add(newTask);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file.");
            e.printStackTrace();
        }
        System.out.println("Tasks Loaded.  Select View tasks to view all tasks.");
    }

    // static void schedule() {
    // System.out.println("Schedule");
    // }
    // userInput.close();
}
