public class Mainc {

    public static void main(String[] args) throws Exception {

        ToDoList listObj = new ToDoList();

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
                    listObj.writedata();
                    break;
                case 9:
                    listObj.readdata();
                    break;
                case 10:
                    System.out.println("Goodbye!");
                default:
                    System.out.println("Enter a valid option");
            }
        }

    }

}
