package Mini_project.to_do_list;

public class tasks {
    private String description;
    private boolean isCompleted;

    public tasks(String description){
        this.description = description;
        this.isCompleted = false;
    }

    public String getdescription(){
        return description;
    }

    public boolean isCompleted(){
        return isCompleted;
    }

    public void markAsCompleted(){
        this.isCompleted = true;
    }

    @Override
    public String toString(){
        return (isCompleted ? "[Completed]" : "[Pending]")+description;
    }
}
