import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ToDoList1 {

    public static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private List<TodoItem> currentList;


    public ToDoList1() {
        currentList = new ArrayList<>();
        fillListForDebugging();
    }


    public void fillListForDebugging() {
        try {
            TodoItem item1 = new TodoItem("homework1", FORMAT.parse("12/06/2020"), "3 pm", "India", "Done", "Individual");
            TodoItem item2 = new TodoItem("homework2", FORMAT.parse("12/06/2021"), "5 pm", "Sweden", "Not Done", "Group");
            TodoItem item3 = new TodoItem("homework3", FORMAT.parse("12/06/2022"), "9 pm", "Paris", "Done", "Individual");
            TodoItem item4 = new TodoItem("homework4", FORMAT.parse("12/06/2019"), "2 pm", "London", "Done", "Group");
            currentList.add(item1);
            currentList.add(item2);
            currentList.add(item3);
            currentList.add(item4);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void updateItem() throws ParseException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Update  : Title, Date, Time, Location, Status, Category");
        showList();
        System.out.print("--------");
        System.out.print("Which row do you want to update? (Enter number): ");
        int userInput = scanner.nextInt();
        scanner.nextLine(); //clean the scanner Integer.parseInt("23"); -> 23
        int index = userInput - 1;

        TodoItem homework = currentList.get(index);

        System.out.println("what do you want to update: 0)title, 1)date, 2)Time, 3)Location, 4)Status, 5)Category");
        userInput = scanner.nextInt();
        scanner.nextLine();

        switch (userInput) {
            case 0:
                System.out.print("Enter the new title: ");
                homework.setTheTitle(scanner.nextLine());
                System.out.print("Updated new Title");
                break;

            case 1:
                System.out.print("Enter the new Date: ");
                homework.setTheDate(FORMAT.parse(scanner.nextLine()));
                System.out.print("Updated new Date");
                break;

            case 2:
                System.out.print("Enter the new time: ");
                homework.setTheTime(scanner.nextLine());
                System.out.print("Updated new Time");
                break;

            case 3:
                System.out.print("Enter the new Location: ");
                homework.setTheLocation(scanner.nextLine());
                System.out.print("Updated new Location");
                break;

            case 4:
                System.out.print("Enter the new Status: ");
                homework.setTheStatus(scanner.nextLine());
                System.out.print("Updated new Status");
                break;

            case 5:
                System.out.print("Enter the new Project: ");
                homework.setTheCategory(scanner.nextLine());
                System.out.print("Updated new Project");
                break;
        }

        System.out.println("Successfully Updated");

    }


    public int printMenu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to the ToDoList");
        System.out.println("Pick an Option from the Main Menu:");
        System.out.println("----------------------");
        System.out.println("Main Menu");
        System.out.println("----------------------");
        System.out.println("1. Add a task");
        System.out.println("2. Delete a task");
        System.out.println("3. Delete all tasks");
        System.out.println("4. List all tasks");
        System.out.println("5. Sort tasks ");
        System.out.println("6. Search for a task by Project category");
        System.out.println("7. Update the items");
        System.out.println("8. Save the tasks in a file");
        System.out.println("9. Read the tasks from file");
        System.out.println("10. Exit the program");
        System.out.println();
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        return choice;

    }

    public void showList() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("To-Do List");
        System.out.println("----------------------");
        int number = 0;
        for (TodoItem item : currentList) {
            System.out.println(++number + ". " + item);
        }
        System.out.println("----------------------");


    }

    public void addItem() throws ParseException {

        TodoItem item = new TodoItem();

        System.out.println("Add a task");
        System.out.println("----------------------");

        System.out.print("Enter the task title: ");
        Scanner scanner = new Scanner(System.in);
        item.setTheTitle(scanner.nextLine());

        System.out.print("Enter the task date (dd/mm/yyyy hh:mm): ");
        Date date = FORMAT.parse(scanner.nextLine()); //localDate
        item.setTheDate(date);

        System.out.print("Enter the task time: ");
        item.setTheTime(scanner.nextLine());

        System.out.print("Enter the task location: ");
        item.setTheLocation(scanner.nextLine());

        System.out.print("Enter the task Status: ");
        item.setTheStatus(scanner.nextLine());

        System.out.println("Enter the task category (optional - press enter to skip): ");
        item.setTheCategory(scanner.nextLine());

        currentList.add(item);
        System.out.println("Task Added!");


    }

    public void removeItem() {
        System.out.println("Delete a task");
        System.out.println("----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("What do you want to remove? (Enter number): ");
        int index = scanner.nextInt();
        if ((index - 1) < 0 || index > currentList.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to " + currentList.size());
        } else {
            currentList.remove(index - 1);
        }
        System.out.println("----------------------");
        System.out.println("Task Removed!");


    }

    public void removeAllTasks() {

        System.out.println("Remove all tasks");
        System.out.println("----------------------");
        showList();

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Are you sure you'd like to delete all tasks? 'Yes' or 'No': ");
        String choice = keyboard.nextLine();
        if (choice.equals("Yes")) {
            currentList.removeAll(currentList);
            System.out.println("All tasks deleted!");
        } else if (choice.equals("No"))
            System.out.println("Tasks not deleted");

    }

    public void sortTasks() {


        //ask user what do you want to sort by:

        Scanner scanner = new Scanner(System.in);
        System.out.print("Sort by : 1) Title, 2) Date, 3) Time, 4) Location, 5) Status, 6) Category");
        System.out.print("--------");
        System.out.print("What do you want by? (Enter number): ");
        int index = scanner.nextInt();
        if ((index - 1) < 0 || index > currentList.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to " + currentList.size());
        } else {

        }
        //Using Switch case to select index:

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
    }


    public void searchTasks() {
        System.out.println("Search tasks by Project category");
        System.out.println("----------------------");
        System.out.println("Enter the Project category you want to search");
        Scanner keyboard = new Scanner(System.in);

        ArrayList<TodoItem> result = new ArrayList<TodoItem>();
        String projectname = keyboard.nextLine();
        boolean search_flag = false;

        for (TodoItem items : currentList) {
            if (items.getCategory().equalsIgnoreCase(projectname)) {
                // match found
                result.add(items);
                System.out.println(result.toString());// stop the loop if we found a match
                search_flag = true;
            }
        }
        if (search_flag == false)
        {
                System.out.println("Invalid input...The task you are searching is not in our project Category");
        }
    }
   // Write as object
    public void writeObject() throws Exception {
        File file = new File("NewDataFile.txt");
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(fileoutputstream);
         writer.writeObject(currentList);
        /* for (TodoItem items : currentList)
           if (items != null)
               writer.writeObject(items.toString());*/

        fileoutputstream.close();
        writer.close();
    }

    // read as object
    public ArrayList<TodoItem> readObject() throws Exception {
        ArrayList<TodoItem> items = new ArrayList<>();
        File file = new File("NewDataFile.txt");
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(f);
        items = (ArrayList<TodoItem>) reader.readObject();
        System.out.println(items);

        f.close();
        reader.close();

        return items;
    }
}
























