import Data.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {

    public static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static File file;

    @Test
    public void beforeAll() throws ParseException, IOException {
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


        ToDoList newList = new ToDoList();
        newList.add("Assignment1", "12/06/2020", "3 pm", "India", "Done", "Individual");
        ToDoList list2 = new ToDoList();
        newList.add("Assignment2", "12/06/2021", "5 pm", "Sweden", "Not Done", "Group");
        ToDoList list3 = new ToDoList();
        newList.add("Mailing", "12/06/2022", "9 pm", "Paris", "Done", "Individual");
        ToDoList list4 = new ToDoList();
        newList.add("Evaluation", "12/06/2019", "2 pm", "London", "Done", "Group");
    }

    @Test
    public void testAddItemToList() {

        ToDoList lists = new ToDoList();
        int existingSize = lists.size();

        String expectedTitle = "Assignment5";
        String stringDate = "17/08/2020";
        String expectedTime = "9 pm";
        String expectedLocation = "Årsta";
        String expectedStatus = "Ongoing";
        String expectedCategory = "MDF";
        lists.add(expectedTitle, stringDate, expectedTime, expectedLocation, expectedStatus, expectedCategory);
        System.out.println(lists.size());
        assertEquals(existingSize + 1, lists.size());
        lists.showList();
    }

    @Test
    public void testUpdateTitle() {
        ToDoList list = new ToDoList();
        list.add("Assignment1", "12/06/2020", "3 pm", "India", "Done", "Individual");
        String rowNumber = "1";
        String itemNumber = "0";
        String newTitle = "NewAssignment";
        assertTrue(list.updateTask(rowNumber, itemNumber, newTitle));
        assertEquals(newTitle, list.getList().get(0).getTitle());
    }

    @Test
    public void testUpdateDate() throws ParseException {
        ToDoList list = new ToDoList();
        String rowNumber = "1";
        String itemNumber = "1";
        String newDate = "01/01/2022";
        assertTrue(list.updateTask(rowNumber, itemNumber, newDate));
        assertEquals(FORMAT.parse(newDate), list.getList().get(0).getDate());
    }

    @Test
    public void testUpdateTime() {
        ToDoList list = new ToDoList();
        String rowNumber = "1";
        String itemNumber = "2";
        String newTime = "5 pm";
        assertTrue(list.updateTask(rowNumber, itemNumber, newTime));
        assertEquals(newTime, list.getList().get(0).getTime());
    }

    @Test
    public void testUpdateLocation() {
        ToDoList list = new ToDoList();
        String rowNumber = "1";
        String itemNumber = "3";
        String newLocation = "Stockholm";
        list.updateTask(rowNumber, itemNumber, newLocation);
        assertEquals(newLocation, list.getList().get(0).getLocation());
    }

    @Test
    public void testUpdateStatus() {
        ToDoList list = new ToDoList();
        String rowNumber = "1";
        String itemNumber = "4";
        String newStatus = "Done";
        list.updateTask(rowNumber, itemNumber, newStatus);
        assertEquals(newStatus, list.getList().get(0).getStatus());
    }

    @Test
    public void testUpdateProjectCategory() {
        ToDoList list = new ToDoList();
        String rowNumber = "1";
        String itemNumber = "5";
        String newCategory = "MDM";
        list.updateTask(rowNumber, itemNumber, newCategory);
        assertEquals(newCategory, list.getList().get(0).getCategory());

    }

    @Test
    public void testRemoveAllItemIfChoiceIsNo() {
        ToDoList list = new ToDoList();
        String choice = "No";
        list.removeAllTasks(choice);
        assertEquals(4, list.size());
    }

    @Test
    public void testRemoveAllItemIfChoiceIsYes() {
        ToDoList list = new ToDoList();
        String choice = "Yes";
        list.removeAllTasks(choice);
        assertEquals(0, list.size());
    }

    @Test
    public void testSortTasks() {
        ToDoList list = new ToDoList();
        String index = "1";
        assertFalse(list.sortTasks(index));
    }

    @Test
    public void testSearchTasks() {
        ToDoList list = new ToDoList();
        String projectName = "Individual";
        assertEquals(projectName, list.getList().get(0).getCategory());
    }

    @Test
    public void testWriteData() throws IOException {
        ToDoList list = new ToDoList();
        File filepath = new File("TestWriteDataFile.txt");
        assertTrue(list.writeData(filepath));
    }

    @Test
    public void testValidateInteger() {
        ToDoList list = new ToDoList();
        String number = "1";
        assertEquals(1, list.validateInteger(number, 1, 5));
    }

    @Test
    public void testValidateDate() throws ParseException {
        ToDoList list = new ToDoList();
        String date = "12/03/2021";
        Date newDate = FORMAT.parse(date);
        assertEquals(newDate, list.validateDate(date));
    }

    @Test
    public void testRemoveParticularTaskFromTheList() throws ParseException {
        ToDoList list = new ToDoList();
        String index = "1";
        list.removeItem(index);
        assertEquals(3, list.size());
    }

    @Test
    public void testValidateIntegerShouldThrowIllegalArgumentExceptionWithInValidInteger () {
        ToDoList list = new ToDoList();
        String number = "factor";
        assertThrows(
                Exception.class,
                () -> list.validateInteger(number,1,5)
        );
    }

    @Test
    public void testValidateIntegerShouldNotThrowIllegalArgumentExceptionWithValidInteger () {
        ToDoList list = new ToDoList();
        String number = "1";
        assertDoesNotThrow(
                () -> list.validateInteger(number,1,5));
    }

    @Test
    public void testValidatedateShouldReturnNullWithInValidDate () {
        ToDoList list = new ToDoList();
        String Date = "factor";
        assertNull(list.validateDate(Date));
    }

    @Test
    public void testValidatedateShouldNotThrowParseExceptionWithValidDate () {
        ToDoList list = new ToDoList();
        String date = "12/04/2021";
        assertDoesNotThrow(
        () -> list.validateDate(date));
    }

    @Test
    public void testValidatedateShouldNotReturnNullWithValidDate () {
        ToDoList list = new ToDoList();
        String date = "12/04/2021";
        assertNotNull(list.validateDate(date));
    }
}