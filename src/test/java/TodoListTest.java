import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class TodoListTest {
    public static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    ArrayList<TodoItem> list;

    @BeforeEach
    public void beforeEachTest() throws ParseException, IOException {
        list = new ArrayList<>();

        TodoItem item1 = new TodoItem("Assignment1", FORMAT.parse("12/06/2020"), "3 pm", "India", "Done", "Individual");
        TodoItem item2 = new TodoItem("Assignment2", FORMAT.parse("12/06/2021"), "5 pm", "Sweden", "Not Done", "Group");
        TodoItem item3 = new TodoItem("Mailing", FORMAT.parse("12/06/2022"), "9 pm", "Paris", "Done", "Individual");
        TodoItem item4 = new TodoItem("Evaluation", FORMAT.parse("12/06/2019"), "2 pm", "London", "Done", "Group");
        list.add(0, item1);
        list.add(1, item2);
        list.add(2, item3);
        list.add(3, item4);
    }

    @Test
    public void testRemoveitem() throws ParseException, IOException {
        list.remove(0);
        assertEquals(3, list.size());
    }

    @Test
    public void testRetrivingdatafromlist() {
        assertEquals(4, list.size());
        assertEquals("Assignment1", list.get(0).getTitle());
        assertEquals("9 pm", list.get(2).getTime());
        assertEquals("Sweden", list.get(1).getLocation());
        assertEquals("Not Done", list.get(1).getStatus());
        assertEquals("Group", list.get(3).getCategory());
        assertNotNull("Test not null", list.get(2).getCategory());
    }

    @Test
    public void testaddnewitem() throws ParseException, IOException {
        System.out.println(list.size());
        int existingsize = list.size();
        TodoItem item5 = new TodoItem("Testresults", FORMAT.parse("15/09/2019"), "15:09 pm", "Gothenberg", "Ongoing", "Group");
        list.add(0, item5);
        assertEquals(existingsize + 1, list.size());
        System.out.println(list.size());
    }

    @Test
    public void test_indexOflistitem() {
        // Checking index of an item
        int pos = list.indexOf(list.get(2));
        assertEquals(2, pos);
    }

    @Test
    public void test_islistEmpty() {
        // Checking if array list is empty
        assertFalse(list.isEmpty());
    }

}











