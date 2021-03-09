package Main;
import Data.*;

public class Mainc
{

    public static void main(String[] args) throws Exception
    {
        ToDoList listObj = new ToDoList();

        int menuItem = -1;
        while (menuItem != 8) {
            menuItem = listObj.printMenu();
            switch (menuItem) {
                case 1:
                    listObj.addInMain();
                    break;
                case 2:
                    listObj.removeItemInMain();
                    break;
                case 3:
                    listObj.removeAllTasksInMain();
                    break;
                case 4:
                    listObj.showList();
                    break;
                case 5:
                    listObj.sortTasksInMain();
                    break;
                case 6:
                    listObj.searchTasksInMain();
                    break;
                case 7:
                    listObj.updateItemInMain();
                    break;
                case 8:
                    listObj.writeDataInMain();
                    break;
                case 9:
                    listObj.readDataInMain();
                    break;
                case 10:
                    System.out.println("Goodbye!");
                default:
                    System.out.println("Enter a valid option");
            }
        }
    }

}
