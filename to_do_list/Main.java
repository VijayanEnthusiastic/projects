package Mini_project.to_do_list;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    ToDoList toDoList = new ToDoList();
    Scanner sc = new Scanner(System.in);

    while(true){
        System.out.println("\n ------- To Do List App --------");
        System.out.println("1. Add tasks");
        System.out.println("2. View tasks");
        System.out.println("3. Mark tasks as Completed");
        System.out.println("4. Delete Tasks");
        System.out.println("5. Exit");

        System.out.print("Enter the choice to be choosed: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter task description: ");
                String description = sc.nextLine();
                toDoList.addTask(description);
                break;

            case 2:
                System.out.println("View Tasks: ");
                toDoList.viewTasks();
                break;
                
            case 3:
                System.out.println("Mark Tasks to be Completed: ");
                int taskToCompleted = sc.nextInt();
                toDoList.markTaskAsCompleted(taskToCompleted);
                break;
                
            case 4:
                System.out.println("Delect Tasks");
                int taskToDelete = sc.nextInt();
                toDoList.deleteTask(taskToDelete);
                break;    
        
            default:
                System.out.println("Invalid choice \nPlease type correct choice");
                sc.close();
                break;
        }




    }
}
}

