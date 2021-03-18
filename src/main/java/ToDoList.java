import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ToDoList {

    public static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/mm/yyyy");
    List<TodoItem> currentList ;
    Scanner scanner = new Scanner(System.in);

    public ToDoList() {
        this.currentList = new ArrayList<TodoItem>();
        fillListForDebugging();
    }

    /**
     * create task lists.
     */
    public void fillListForDebugging() {
        try {
            TodoItem item1 = new TodoItem("Assignment", FORMAT.parse("12/06/2020"), "3 pm", "India", "Done", "Individual");
            TodoItem item2 = new TodoItem("MailCheck", FORMAT.parse("16/03/2021"), "5 pm", "Sweden", "Not Done", "Group");
            TodoItem item3 = new TodoItem("ProjectWork", FORMAT.parse("10/09/2022"), "9 pm", "Paris", "Done", "Individual");
            TodoItem item4 = new TodoItem("HomeWork", FORMAT.parse("01/12/2019"), "2 pm", "London", "Done", "Group");
            currentList.add(item1);
            currentList.add(item2);
            currentList.add(item3);
            currentList.add(item4);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Getting input from the user.
     */
    public String getInput(String dataName) {
        System.out.println("Enter the " + dataName + ": ");
        return scanner.nextLine();
    }

    /**
     * Update Title, Date, Time, Location, Status, Category  in task list.
     */
    public boolean updateTask(String rowNumber, String itemNumber, String newData) {

        int userInput = validateInteger(rowNumber, 1, currentList.size());
        int index = userInput - 1;
        TodoItem homework = currentList.get(index);
        int indexx = Integer.parseInt(itemNumber);

        switch (indexx) {
            case 0:
                homework.setTheTitle(newData);
                System.out.print("Updated new Title." + "\n");
                break;

            case 1:
                homework.setTheDate(validateDate(newData));
                break;

            case 2:
                homework.setTheTime(newData);
                System.out.print("Updated new Time." + "\n");
                break;

            case 3:
                homework.setTheLocation(newData);
                System.out.print("Updated new Location." + "\n");
                break;

            case 4:
                homework.setTheStatus(newData);
                System.out.print("Updated new Status." + "\n");
                break;

            case 5:
                homework.setTheCategory(newData);
                System.out.print("Updated new Project." + "\n");
                break;
        }
        return true;
    }

    /**
     * Add new tasks to the list.
     */
    public void add(String title, String date, String time, String location, String status, String category) {

        TodoItem item = new TodoItem();
        item.setTheTitle(title);
        item.setTheDate(validateDate(date));
        item.setTheTime(time);
        item.setTheLocation(location);
        item.setTheStatus(status);
        item.setTheCategory(category);
        currentList.add(item);
        System.out.println("Task Added!");
    }

    /**
     * Prints list of Menu items for the user to select one option.
     */
    public int printMenu() {
        System.out.println();
        System.out.println("Welcome to the Data.ToDoList" + "\n" +
                "Pick an Option from the Main Menu:" + "\n" +
                "----------------------" + "\n" +
                "Main Menu" + "\n" +
                "----------------------" + "\n" +
                "1. Add a task" + "\n" +
                "2. Delete a task" + "\n" +
                "3. Delete all tasks" + "\n" +
                "4. List all tasks" + "\n" +
                "5. Sort tasks" + "\n" +
                "6. Search for a task by Project category" + "\n" +
                "7. Update the items" + "\n" +
                "8. Save the tasks in a file" + "\n" +
                "9. Read the tasks from file" + "\n" +
                "10.Exit the program" + "\n");

        String choices = getInput("choice");
        int choice = validateInteger(choices, 0, 10);
        return choice;
    }


    /**
     * Prints the list of existing tasks and newly added tasks .
     */
    public void showList() {
        System.out.println();
        System.out.println("----------------------" + "\n" +
                "To-Do List" + "\n" +
                "----------------------");
        int number = 0;
        for (TodoItem item : currentList) {
            System.out.println(++number + ". " + item);
        }
        System.out.println("----------------------");
    }


    /**
     * Validate Integer entered by the user.
     */
    public int validateInteger(String numberAsString, int min, int max)
    {
        while (true) {
            try {
                int result = Integer.parseInt(numberAsString);
                if ((result > max) || (result < min)) {
                    numberAsString = getInput("please enter a number in this range from min to max");
                } else {
                    return result;
                }

            } catch (Exception e) {
                numberAsString = getInput(" correct number please...."+" " + e);
            }
        }
    }


    /**
     * Validate date entered by the user.
     */
    public Date validateDate(String strDate) {
        try {
            Date javaDate = FORMAT.parse(strDate);
            System.out.println(strDate + " is valid date format");
            System.out.print("Updated new Date." + "\n");
            return javaDate;
        } catch (Exception e) {
            System.out.println(strDate + " " + "is Invalid Date format" + "\n");
            return null;
        }
    }

    /**
     * Delete particular tasks from the list .
     */
    public void removeItem(String indexNumber) {
        int index = validateInteger(indexNumber, 1, currentList.size());
        if ((index - 1) < 0 || index > currentList.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to " + currentList.size());
        } else {
            currentList.remove(index - 1);
            System.out.println("----------------------");
            System.out.println("Task Removed!");
        }
    }

    /**
     * Delete all tasks from the list .
     */
    public void removeAllTasks(String choice) {

        if (choice.equals("Yes")) {
            currentList.removeAll(currentList);
            System.out.println("All tasks deleted!");
        } else if (choice.equals("No"))
            System.out.println("Tasks not deleted");
    }

    /**
     * Sort the tasks by Title,Date,Time,Location,Status,Category .
     */
    public boolean sortTasks(String indexNumber) {

        int index = validateInteger(indexNumber, 1, 6);
        switch (index) {
            case 1:
                Collections.sort(currentList, new TitleComparable());
                showList();
                break;
            case 2:
                Collections.sort(currentList, new DateComparable());
                showList();
                break;
            case 3:
                Collections.sort(currentList, new TimeComparable());
                showList();
                break;
            case 4:
                Collections.sort(currentList, new LocationComparable());
                showList();
                break;
            case 5:
                Collections.sort(currentList, new StatusComparable());
                showList();
                break;
            case 6:
                Collections.sort(currentList, new ProjectComparable());
                showList();
                break;
        }
        System.out.println("Successfully sorted task ");
        return false;
    }


    /**
     * Search particular or group of tasks by project Category .
     */
    public void searchTasks(String projectName) {

        ArrayList<TodoItem> result = new ArrayList<TodoItem>();
        boolean search_flag = false;

        for (TodoItem item : currentList) {
            if (item.getCategory().equalsIgnoreCase(projectName)) {
                result.add(item);
                System.out.println(result.toString());
                search_flag = true;
            }
        }
        if (search_flag == false) {
            System.out.println("Invalid input...The task you are searching is not in our project Category");
        }
    }


    /**
     * Creates new file and write the tasks list in to new file.
     */
    public boolean writeData(File filePath) throws IOException {

        FileWriter writer = new FileWriter(filePath);
        BufferedWriter writers = new BufferedWriter(writer);
        for (TodoItem items : currentList)
            if (items != null)
                writer.write(items.toString() + "\n");
        writer.close();
        return true;
    }

    /**
     * Read the tasks list from the file.
     */
    public ArrayList<TodoItem> readData(File file) throws Exception {

        ArrayList<TodoItem> items = new ArrayList<>();

        FileReader fos = new FileReader(file);
        BufferedReader reader = new BufferedReader(fos);

        String line = null;

        while ((line = reader.readLine()) != null) {
            TodoItem newitems = new TodoItem();
            String lines[] = line.split(", ");
            newitems.setTheTitle(lines[0]);
            newitems.setTheDate(FORMAT.parse(lines[1]));
            newitems.setTheTime(lines[2]);
            newitems.setTheLocation(lines[3]);
            newitems.setTheStatus(lines[4]);
            newitems.setTheCategory(lines[5]);

            items.add(newitems);
        }
        System.out.println(items);
        reader.close();
        return items;
    }

    /**
     *  Getting input from the user to update the task items (Title, Date, Time, Location, Status, Category) in list of tasks.
     *  based on the choice selected by the user.
     */
    public void updateItemInMain() {
        System.out.print("Update  : Title, Date, Time, Location, Status, Category");
        showList();
        System.out.print("--------");
        String rowNumber = getInput("row number you want to update");
        String itemNumber = getInput("item number you want to update: 0)title, 1)date(dd/mm/yyyy), 2)Time, 3)Location, 4)Status, 5)Category");
        String newData = getInput("data you want to update");
        updateTask(rowNumber, itemNumber, newData);
    }

    /**
     *  Getting input from the user to add the task items (Title, Date, Time, Location, Status, Category) in list of tasks.
     */
    public void addInMain() {
        System.out.println("Add a task");
        System.out.println("----------------------");
        String title = getInput("title");
        String date = getInput("date");
        String time = getInput("time");
        String status = getInput("status");
        String location = getInput("location");
        String category = getInput("category");
        add(title, date, time, location, status, category);
    }

    /**
     *  Getting input from the user to remove particular the task from list of tasks based on the choice selected by user.
     */
    public void removeItemInMain() {
        System.out.println("Delete a task");
        System.out.println("----------------------");
        showList();
        String indexNumber = getInput(" task number that you want to remove");
        removeItem(indexNumber);
    }

    /**
     *  Getting input from the user to remove all the task from list of tasks based on the choice selected by user.
     */
    public void removeAllTasksInMain() {

        System.out.println("Remove all tasks");
        System.out.println("----------------------");
        showList();
        String choice = getInput("choice...Are you sure you'd like to delete all tasks? 'Yes' or 'No':");
        removeAllTasks(choice);
    }

    /**
     *  Getting input from the user to search and display the paricular/ group of task from list of tasks based on the project
     *  category given by user.
     */
    public void searchTasksInMain() {

        System.out.println("Search tasks by Project category");
        System.out.println("----------------------");
        String projectName = getInput("Project category you want to search");
        searchTasks(projectName);
    }

    /**
     *  Getting input from the user to sort and display the list of tasks based on the item selected by user.
     */
    public void sortTasksInMain() {

        System.out.print("Sort by : 1) Title, 2) Date, 3) Time, 4) Location, 5) Status, 6) Category" + "\n");
        System.out.print("--------");
        String indexNumber = getInput(" Item number you want to sort by");
        sortTasks(indexNumber);
    }

    /**
     *  Creating a new file and writing the list of tasks in to the file.
     */
    public void writeDataInMain() throws Exception {

        File filePath = new File("NewDataFile.txt");
        writeData(filePath);
    }

    /**
     *  Reading list of tasks from file.
     */
    public void readDataInMain() throws Exception {
        File file = new File("NewDataFile.txt");
        readData(file);
    }

    /**
     * Returns the size of the TodoList.
     */

    public int size() {
        return currentList.size();
    }

    public List<TodoItem> getList() {
        return currentList;
    }

}

























