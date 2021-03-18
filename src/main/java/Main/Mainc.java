package Main;
import Data.*;

public class Mainc{

    public static void main(String[] args) throws Exception
    {
        ToDoList listObj = new ToDoList();
        Caller caller = new Caller();

        int menuItem = -1;
        while (menuItem != 8) {
            menuItem = listObj.printMenu();
            switch (menuItem) {
                case 1:
                    caller.addInMain();
                    break;
                case 2:
                    caller.removeItemInMain();
                    break;
                case 3:
                    caller.removeAllTasksInMain();
                    break;
                case 4:
                    listObj.showList();
                    break;
                case 5:
                    caller.sortTasksInMain();
                    break;
                case 6:
                    caller.searchTasksInMain();
                    break;
                case 7:
                    caller.updateItemInMain();
                    break;
                case 8:
                    caller.writeDataInMain();
                    break;
                case 9:
                    caller.readDataInMain();
                    break;
                case 10:
                    System.out.println("Goodbye!");
                default:
                    System.out.println("Enter a valid option");
            }
        }
    }

}
