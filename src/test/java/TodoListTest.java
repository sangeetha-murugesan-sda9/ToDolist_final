import Data.ToDoList;
import Data.TodoItem;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class TodoListTest {

    public static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static File file;

    @Test
    public void beforeAllTests() throws ParseException, IOException {
        ArrayList<TodoItem> list = new ArrayList<>();
        file = new File("TestWriteDataFile.txt");

            TodoItem item1 = new TodoItem("homework1", FORMAT.parse("12/06/2020"), "3 pm", "India", "Done", "Individual");
            TodoItem item2 = new TodoItem("homework2", FORMAT.parse("16/03/2021"), "5 pm", "Sweden", "Not Done", "Group");
            TodoItem item3 = new TodoItem("homework3", FORMAT.parse("10/09/2022"), "9 pm", "Paris", "Done", "Individual");
            TodoItem item4 = new TodoItem("homework4", FORMAT.parse("01/12/2019"), "2 pm", "London", "Done", "Group");
            list.add(item1);
            list.add(item2);
            list.add(item3);
            list.add(item4);

        ToDoList list1 = new ToDoList();
        list1.add("Assignment1", "12/06/2020", "3 pm", "India", "Done", "Individual");
        ToDoList list2 = new ToDoList();
        list2.add("Assignment2", "12/06/2021", "5 pm", "Sweden", "Not Done", "Group");
        ToDoList list3 = new ToDoList();
        list3.add("Mailing", "12/06/2022", "9 pm", "Paris", "Done", "Individual");
        ToDoList list4 = new ToDoList();
        list4.add("Evaluation", "12/06/2019", "2 pm", "London", "Done", "Group");
    }

    @Test
    public void testAddItemToList() throws ParseException, IOException {

        ToDoList lists= new ToDoList();
        int existingsize = lists.size();

        String expectedtitle = "Assignment5";
        String Stringdate = "17/08/2020";
        String expectedtime = "9 pm";
        String expectedlocation = "Årsta";
        String expectedstatus = "Ongoing";
        String expectedcategory = "MDF";
        lists.add(expectedtitle, Stringdate, expectedtime, expectedlocation, expectedstatus, expectedcategory);
        System.out.println(lists.size());
        assertEquals(existingsize + 1, lists.size());
        lists.showList();
    }

    @Test
    public void testUpdateTitle()  {
        ToDoList list1 = new ToDoList();
        list1.add("Assignment1", "12/06/2020", "3 pm", "India", "Done", "Individual");
        String rownumber = "1";
        String itemnumber = "0";
        String newtitle = "NewAssignment";
        assertTrue(list1.updateTask(rownumber, itemnumber, newtitle));
        assertEquals(newtitle,list1.getList().get(0).getTitle());
    }

    @Test
    public void testUpdateDate() throws ParseException {
        ToDoList list1 = new ToDoList();
        String rownumber = "1";
        String itemnumber = "1";
        String newdate = "01/01/2022";
        assertTrue(list1.updateTask(rownumber, itemnumber,newdate));
        assertEquals(FORMAT.parse(newdate),list1.getList().get(0).getDate());
    }

    @Test
    public void testUpdateTime() {
        ToDoList list1 = new ToDoList();
        String rownumber = "1";
        String itemnumber = "2";
        String  newtime = "5 pm";
        assertTrue(list1.updateTask(rownumber, itemnumber, newtime));
        assertEquals(newtime,list1.getList().get(0).getTime());
    }

    @Test
    public void testUpdateLocation() {
        ToDoList list1 = new ToDoList();
        String rownumber = "1";
        String itemnumber = "3";
        String  newlocation = "Stockholm";
        list1.updateTask(rownumber, itemnumber, newlocation);
        assertEquals(newlocation,list1.getList().get(0).getLocation());
    }

    @Test
    public void testUpdateStatus(){
        ToDoList list1 = new ToDoList();
        String rownumber = "1";
        String itemnumber = "4";
        String  newStatus = "Done";
        list1.updateTask(rownumber, itemnumber, newStatus);
        assertEquals(newStatus,list1.getList().get(0).getStatus());
    }

    @Test
    public void testUpdateProjectCategory(){
        ToDoList list1 = new ToDoList();
        String rownumber = "1";
        String itemnumber = "5";
        String  newCategory = "MDM";
        list1.updateTask(rownumber, itemnumber, newCategory);
        assertEquals(newCategory,list1.getList().get(0).getCategory());

    }
    @Test
    public void testRemoveAllItemIfChoiceIsNo(){
        ToDoList list = new ToDoList();
        String choice = "No";
        list.removeAllTasks(choice);
        assertEquals(4,list.size());
    }

    @Test //check
    public void testRemoveAllItemIfChoiceIsYes(){
        ToDoList list = new ToDoList();
        String choice = "Yes";
        list.removeAllTasks(choice);
        assertEquals(0,list.size());
    }

    @Test
    public void testSortTasks(){
        ToDoList list1 = new ToDoList();
        String index = "1";
        assertFalse(list1.sortTasks(index));
    }

    @Test // check
    public void testSearchTasks(){
        ToDoList list1 = new ToDoList();
        String projectname = "Individual";
        assertEquals(projectname,list1.getList().get(0).getCategory());

    }

    @Test
    public void testWriteData() throws IOException {
        ToDoList list = new ToDoList();
        File filepath = new File("TestWriteDataFile.txt");
        assertTrue(list.writeData(filepath));
    }

}











