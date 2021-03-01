import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Mainc {
    public static void main(String[] args) throws Exception {

        ToDoList1 listObj = new ToDoList1();


        int menuItem = -1;
        while (menuItem != 8) {
            menuItem = listObj.printMenu();
            switch (menuItem) {
                case 1:
                    listObj.addItem();
                    break;
                case 2:
                    listObj.removeItem();
                    break;
                case 3:
                    listObj.removeAllTasks();
                    break;
                case 4:
                    listObj.showList();
                    break;
                case 5:
                    listObj.sortTasks();
                    break;
                case 6:
                    listObj.searchTasks();
                    break;
                case 7:
                    listObj.updateItem();
                    break;
                case 8:
                    listObj.writeObject();
                    break;
                case 9:
                    listObj.readObject();
                    break;
                case 10:
                    System.out.println("Goodbye!");
                default:
                    System.out.println("Enter a valid option");
            }
        }

    }

}
