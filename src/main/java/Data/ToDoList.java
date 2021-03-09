package Data;
import comparableStuff.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ToDoList {

    public static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private List<TodoItem> currentList;
    Scanner scanner = new Scanner(System.in);

    public ToDoList() {
        this.currentList = new ArrayList<>();
        fillListForDebugging();
    }

    /**
     * create task lists.
     */
    public void fillListForDebugging() {
        try {
            TodoItem item1 = new TodoItem("homework1", FORMAT.parse("12/06/2020"), "3 pm", "India", "Done", "Individual");
            TodoItem item2 = new TodoItem("homework2", FORMAT.parse("16/03/2021"), "5 pm", "Sweden", "Not Done", "Group");
            TodoItem item3 = new TodoItem("homework3", FORMAT.parse("10/09/2022"), "9 pm", "Paris", "Done", "Individual");
            TodoItem item4 = new TodoItem("homework4", FORMAT.parse("01/12/2019"), "2 pm", "London", "Done", "Group");
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
        System.out.println("Enter the task " + dataName + ": ");
        return scanner.nextLine();
    }

    /**
     * Update Title, Date, Time, Location, Status, Category  in task list.
     */
    public void updateItemInMain()  {
        System.out.print("Update  : Title, Date, Time, Location, Status, Category");
        showList();
        System.out.print("--------");
        String rownumber = getInput("(number) Which row do you want to update?");
        String itemnumber = getInput("item number you want to update: 0)title, 1)date, 2)Time, 3)Location, 4)Status, 5)Category");
        String newdata = getInput("data you want to update");
        updateTask(rownumber, itemnumber, newdata);
    }

    public boolean updateTask(String rownumber, String itemnumber, String newdata) {
        int userinput = validateInteger(rownumber);
        int index1 = userinput - 1;
        TodoItem homework = currentList.get(index1);

        int indexx = validateInteger(itemnumber);

        switch (indexx) {
            case 0:
                homework.setTheTitle(newdata);
                System.out.print("Updated new Title." + "\n");
                break;

            case 1:
                homework.setTheDate(validateDate(newdata));
                System.out.print("Updated new Date." + "\n");
                break;

            case 2:
                homework.setTheTime(newdata);
                System.out.print("Updated new Time." + "\n");
                break;

            case 3:
                homework.setTheLocation(newdata);
                System.out.print("Updated new Location." + "\n");
                break;

            case 4:
                homework.setTheStatus(newdata);
                System.out.print("Updated new Status." + "\n");
                break;

            case 5:
                homework.setTheCategory(newdata);
                System.out.print("Updated new Project." + "\n");
                break;
        }
        System.out.println("Successfully Updated");
        return true;
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
                "10. Exit the program" + "\n");

        String choices = getInput("choice");
        int choice = validateInteger(choices);
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
     * Getting input data item from the user to add a new task.
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
     * Validate integer input from user.
     */

    public int validateInteger(String number) {
        try {
            int max = 10;
            int min = 1;
            int result = Integer.parseInt(number);
            if ((result > max) || (result < min)) {
                System.out.println("please enter a number in this range from min to max");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("please enter a correct number"+ e);
        } return Integer.parseInt(number);
    }

    /**
     * Validate date input from user.
     */

    public Date validateDate(String strDate) {

        SimpleDateFormat FORMAT = new SimpleDateFormat("MM/dd/yyyy");
        try {
            if (!strDate.trim().equals("")) {
                Date javaDate = FORMAT.parse(strDate);
                System.out.println(strDate + " is valid date format");
                return javaDate;
            }
        } catch (ParseException e) {
            System.out.println(strDate + " is Invalid Date format");
        }
        return null;
    }

    /**
     * Add new tasks to the list.
     */
    public void add(String title, String date, String time, String location, String status, String category)  {

        //Date newdate = validateDate(date);
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
     * Delete particular tasks from the list .
     */
    public void removeItemInMain() {
        System.out.println("Delete a task");
        System.out.println("----------------------");
        showList();
        String indexnumber = getInput("to remove (Enter number)");
        removeItem(indexnumber);
    }

    public void removeItem(String indexnumber) {

        int index = validateInteger(indexnumber);
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
    public void removeAllTasksInMain() {

        System.out.println("Remove all tasks");
        System.out.println("----------------------");
        showList();
        String choice = getInput("Are you sure you'd like to delete all tasks? 'Yes' or 'No':");
        removeAllTasks(choice);
    }

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
    public void sortTasksInMain() {

        System.out.print("Sort by : 1) Title, 2) Date, 3) Time, 4) Location, 5) Status, 6) Category" + "\n");
        System.out.print("--------");
        String indexnumber = getInput("number you want to sort by");
        sortTasks(indexnumber);

    }

    public boolean sortTasks(String indexnumber) {

        int index = validateInteger(indexnumber);
        if ((index - 1) < 0 || index > currentList.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to " + currentList.size());
        } else {
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
            }System.out.println("Successfully sorted task ");
        }
        return false;
    }

    /**
     * Search particular or group of tasks by project Category .
     */
    public void searchTasksInMain() {

        System.out.println("Search tasks by Project category");
        System.out.println("----------------------");
        String projectname = getInput("Project category you want to search");
        searchTasks(projectname);
    }

    public void searchTasks(String projectname) {

        ArrayList<TodoItem> result = new ArrayList<TodoItem>();
        boolean search_flag = false;

        for (TodoItem item : currentList) {
            if (item.getCategory().equalsIgnoreCase(projectname)) {
                result.add(item);
                System.out.println(result.toString());
                search_flag = true;
            }
        }
        if (search_flag == false)
        {
            System.out.println("Invalid input...The task you are searching is not in our project Category");
        }
    }

    /**
     * Creates new file and write the tasks list in to new file.
     */
    public void writeDataInMain() throws Exception {

        File filepath = new File("NewDataFile.txt");
        writeData(filepath);
    }

    public boolean writeData(File filepath) throws IOException {

        FileWriter writer = new FileWriter(filepath);
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
    public void readDataInMain() throws Exception {
        File file = new File("NewDataFile.txt");
        readData(file);
    }

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
     * Returns the size of the TodoList.
     */
    public int size() {
        return currentList.size();
    }

    public List<TodoItem> getList() {
        return currentList;
    }

}

























