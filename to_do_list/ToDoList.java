package Mini_project.to_do_list;
import java.util.ArrayList;

public class ToDoList {
    private ArrayList<tasks> tasks ;

    public ToDoList(){
        tasks = new ArrayList<>();
    }
    public void addTask(String description){
        tasks.add(new tasks(description));
        System.out.println("Tasks to be added:  "+description);
    }

    public void viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks in the list");
        }
        else{
            System.out.println("Your tasks: ");
            for(int i = 0; i< tasks.size(); i++){
                System.out.println((i+1)+". "+tasks.get(i));
            }
        }

    }

    public void markTaskAsCompleted(int tasknumber){
        if(tasknumber > 0 && tasknumber<=tasks.size()){
            tasks.get(tasknumber-1).markAsCompleted();
            System.out.println("Task marked as completed: "+ tasks.get(tasknumber-1).getdescription());
        }
        else{
            System.out.println("Invalid task number: ");
        }
    }

    public void deleteTask (int tasknumber){
        if(tasknumber>0 && tasknumber<=tasks.size()){
            System.out.println("Tasks deleted: "+ tasks.get(tasknumber-1).getdescription());
            tasks.remove(tasknumber-1);
        }
        else{
            System.out.println("Invalid task number");
        }
    }
}
