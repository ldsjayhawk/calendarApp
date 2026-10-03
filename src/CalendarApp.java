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

        while (choice != 8){

            System.out.println("Welcome!");
            System.out.println("1. Create a task");
            System.out.println("2. Edit or Complete a task");
            System.out.println("3. Delete a task");
            System.out.println("4. View tasks");
            System.out.println("5. Save tasks to file");
            System.out.println("6. Load tasks from file");
            System.out.println("7. Print Schedule");
            System.out.println("8. Exit");
            
            System.out.println("Please enter choice: ");
            choice = userInput.nextInt();
            userInput.nextLine();

            switch(choice) {
                case 1:
                    addTask();
                    break;
                        
                // case 2:
                //     editTask();
                //     break;

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

        boolean complete = false;
            
        Task newTask = new Task(title, priority, due, complete);
        
        tasks.add(newTask);
                
        
        System.out.println(newTask.title + " task added");
    }
    
    // static void editTask() {
    //     viewTasks();

    //     System.out.println("Enter task # to edit: ");
    //     int taskNum = userInput.nextInt();
    //     userInput.nextLine();

    //     System.out.println("Select item to edit: ");
    //     System.out.println("1. Title");
    //     System.out.println("2. Priority");
    //     System.out.println("3. Due Date");
    //     System.out.println("4. Colmpletion");
            
    //     System.out.println("Please enter choice: ");
    //     int editChoice = userInput.nextInt();
    //     userInput.nextLine();

    //         switch(editChoice) {
    //             case 1:
    //         //     for doc in docs:
    //     //          data = doc.to_dict()
    //     //         if selected_item == data["upc"]:
    //     //             edit_choice = display_edit_menu(selected_item)
                    
    //                 break;
                        
    //             case 2:

    //             break;

    //             case 3:

    //                 break;

    //             case 4:

    //                 break;
    //         }
    //         System.out.println("Task edited");




        // System.out.println("Enter new task: ");
        // String editedTask().NextLine();

        // tasks.set(tasks.indexOf(taskNum),);
        // System.out.println("Edit");





//     for doc in docs:
//         data = doc.to_dict()
//         if selected_item == data["upc"]:
//             edit_choice = display_edit_menu(selected_item)

//             if edit_choice == "1":
//                 print('Enter new UPC:')
//                 new_upc = input()
//                 db.collection("users").document(user_id).collection('inventory').document(selected_item).update({"upc":new_upc})

//             elif edit_choice == "2":
//                 print('Enter new item name: ')
//                 new_name = input()
//                 db.collection("users").document(user_id).collection('inventory').document(selected_item).update({"name":new_name})

//             elif edit_choice == "3":
//                 print('Enter new item quantity: ')
//                 qty = input()
//                 new_qty = int(qty)
//                 db.collection("users").document(user_id).collection('inventory').document(selected_item).update({"quantity":new_qty})

//             elif edit_choice == "4":
//                 print('Enter storage location: ')
//                 new_location = input()
//                 db.collection("users").document(user_id).collection('inventory').document(selected_item).update({"location":new_location})

//             # elif edit_choice == "5":
//             #     print('Enter expiration date: ')
//             #     new_expiration = input()
//             #     x["expiration"] = new_expiration

//             else: 
//                 print(f'{edit_choice} is not a valid option.  Please choose again.')
//                 display_edit_menu()

//     display_inventory(user_id)
//     display_menu(user_id)

// def display_edit_menu(selected_item):
//     # enter new item
//     print()
//     print(f'What info would you like to update for {selected_item}?')
//     print("1. UPC")
//     print("2. Name")
//     print("3. Quantity")
//     print("4. Location")
//     # print("5. Expiration")
//     print("Enter Selection")
//     print()
//     edit_choice = input()

//     return edit_choice

    // }
    
        // System.out.println("Complete");

    
    static void deleteTask() {
        // cars.remove(0);
        System.out.println("Delete");
    }
    
    static void viewTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i+1 + ". " + tasks.get(i).title);
            System.out.println(i+1 + ". " + tasks.get(i).priority);
            System.out.println(i+1 + ". " + tasks.get(i).due);
            System.out.println(i+1 + ". " + tasks.get(i).complete);

        }
        System.out.println();
    }
    
    static void saveTasks() {
        Task newTask = new Task("Write this program", 1, LocalDate.of(2026, 10, 3), false);
        tasks.add(newTask);

        try {
            FileWriter myWriter = new FileWriter("taskFile.txt");
            for (Task task : tasks) {
                myWriter.write(task.title + "," + task.priority + "," + task.due + "," + task.complete);
            }
            myWriter.close();
            System.out.println("Tasks saved");
        }catch (IOException e) {
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
            System.out.println(data);
        }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file.");
            e.printStackTrace();
        }
}
    
    static void schedule() {
        System.out.println("Schedule");
    }
    // userInput.close();
}
