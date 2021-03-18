package Data;
import java.io.File;
import java.util.Scanner;

public class Caller {

    Scanner scanner = new Scanner(System.in);
    ToDoList list = new ToDoList();

    /**
     *  Getting input from the user.
     */
    public String getInputFromUser(String dataName) {
        System.out.println("Enter the " + dataName + ": ");
        return scanner.nextLine();
    }

    /**
     *  Getting input from the user to update the task items (Title, Date, Time, Location, Status, Category) in list of tasks.
     *  based on the choice selected by the user.
     */
    public void updateItemInMain() {
        System.out.print("Update  : Title, Date, Time, Location, Status, Category");
        list.showList();
        System.out.print("--------");
        String rowNumber = getInputFromUser("row number you want to update");
        String itemNumber = getInputFromUser("item number you want to update: 0)title, 1)date, 2)Time, 3)Location, 4)Status, 5)Category");
        String newData = getInputFromUser("data you want to update");
        list.updateTask(rowNumber, itemNumber, newData);
    }

    /**
     *  Getting input from the user to add the task items (Title, Date, Time, Location, Status, Category) in list of tasks.
     */
    public void addInMain() {
        System.out.println("Add a task");
        System.out.println("----------------------");
        String title = getInputFromUser("title");
        String date = getInputFromUser("date");
        String time = getInputFromUser("time");
        String status = getInputFromUser("status");
        String location = getInputFromUser("location");
        String category = getInputFromUser("category");
        list.add(title, date, time, location, status, category);
    }

    /**
     *  Getting input from the user to remove particular the task from list of tasks based on the choice selected by user.
     */
    public void removeItemInMain() {
        System.out.println("Delete a task");
        System.out.println("----------------------");
        list.showList();
        String indexNumber = getInputFromUser(" task number that you want to remove");
        list.removeItem(indexNumber);
    }

    /**
     *  Getting input from the user to remove all the task from list of tasks based on the choice selected by user.
     */
    public void removeAllTasksInMain() {

        System.out.println("Remove all tasks");
        System.out.println("----------------------");
        list.showList();
        String choice = getInputFromUser("choice...Are you sure you'd like to delete all tasks? 'Yes' or 'No':");
        list.removeAllTasks(choice);
    }

    /**
     *  Getting input from the user to search and display the paricular/ group of task from list of tasks based on the project
     *  category given by user.
     */
    public void searchTasksInMain() {

        System.out.println("Search tasks by Project category");
        System.out.println("----------------------");
        String projectName = getInputFromUser("Project category you want to search");
        list.searchTasks(projectName);
    }

    /**
     *  Getting input from the user to sort and display the list of tasks based on the item selected by user.
     */
    public void sortTasksInMain() {

        System.out.print("Sort by : 1) Title, 2) Date, 3) Time, 4) Location, 5) Status, 6) Category" + "\n");
        System.out.print("--------");
        String indexNumber = getInputFromUser(" Item number you want to sort by");
        list.sortTasks(indexNumber);
    }

    /**
     *  Creating a new file and writing the list of tasks in to the file.
     */
    public void writeDataInMain() throws Exception {

        File filePath = new File("NewDataFile.txt");
        list.writeData(filePath);
    }

    /**
     *  Reading list of tasks from file.
     */
    public void readDataInMain() throws Exception {
        File file = new File("NewDataFile.txt");
        list.readData(file);
    }

}
