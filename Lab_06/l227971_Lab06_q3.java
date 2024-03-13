import java.util.List;
import java.util.ArrayList;

interface TaskRepository 
{
    void addTask(String task);
    List<String> getTasks();

    public String getTask(String taskName);
}

class DatabaseTaskRepository implements TaskRepository 
{
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) 
    {
        tasks.add(task);
        System.out.println("Task has been Added");
    }

    public List<String> getTasks() 
    {
        System.out.println("All tasks are below:\n");
        return tasks;
    }

    // get specific task
    public String getTask(int index) 
    {
        return tasks.get(index);
    }

    // get specific task by name
    public String getTask(String task) 
    {
        for (String t : tasks) 
        {
            if (t.equals(task)) 
            {
                return t;
            }
        }
        return null;
    }
}

class FileTaskRepository implements TaskRepository 
{
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) 
    {
        tasks.add(task);
        System.out.println("Task Added Successfully!");
    }

    public List<String> getTasks() 
    {
        System.out.println("All taska are below:\n");
        return tasks;
    }

    // get specific task
    public String getTask(int index) 
    {
        return tasks.get(index);
    }

    // get specific task by name
    public String getTask(String task) 
    {
        for (String t : tasks) 
        {
            if (t.equals(task)) 
            {
                return t;
            }
        }
        return null;
    }
}

class Project 
{
    private TaskRepository taskRepository;

    public Project(TaskRepository taskRepository) 
    {
        this.taskRepository = taskRepository;
    }

    public void addTask(String task) 
    {
        taskRepository.addTask(task);
    }

    public List<String> getTasks() 
    {
        return taskRepository.getTasks();
    }

    // get task by name
    public String getTask(String task) 
    {
        return taskRepository.getTask(task);
    }
}

class NotificationService 
{
    private TaskRepository taskRepository;

    public NotificationService(TaskRepository taskRepository) 
    {
        this.taskRepository = taskRepository;
    }

    public void notify(String task) 
    {
        taskRepository.addTask(task);
        System.out.println("Notification sent: " + task);
    }
}

public class l227971_Lab06_q3 
{
    public static void main(String[] args) 
    {
        TaskRepository taskRepository = new DatabaseTaskRepository();
        Project project = new Project(taskRepository);
        NotificationService notificationService = new NotificationService(taskRepository);

        project.addTask("SDA Lab 1 - Submission");
        notificationService.notify("SDA Lab 2 - Submission");

        System.out.println(project.getTask("SDA Lab 2 - Submission"));

        System.out.println(project.getTasks());
    }
}