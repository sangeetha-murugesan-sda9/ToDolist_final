import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TodoItemTest {

    public static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void testgetTitle() throws ParseException, IOException {
        String expectedtitle = "Assignment";
        TodoItem item = new TodoItem(expectedtitle, FORMAT.parse("12/06/2020"), "3 pm", "India", "Done", "Individual");

        String actualValue = item.getTitle();
        assertEquals(expectedtitle, actualValue);
    }

    @Test
    public void testgetDate() throws ParseException, IOException {
       String dateString = "18/09/1989";
       Date expecteddate = FORMAT.parse(dateString);
        TodoItem item = new TodoItem("Assignment", expecteddate, "3 pm", "India", "Done", "Individual");
        Date actualValue = item.getDate();
        assertEquals(expecteddate, actualValue);
    }

    @Test
    public void testgettime() throws ParseException, IOException {
        String expectedtime = "15:20";
        TodoItem item = new TodoItem("Assignment", FORMAT.parse("18/09/1989"), expectedtime, "India", "Done", "Individual");
        String actualValue = item.getTime();
        assertEquals(expectedtime, actualValue);
    }

    @Test
    public void testgetlocation() throws ParseException, IOException {
        String expectedlocation = "Sweden";
        TodoItem item = new TodoItem("Assignment", FORMAT.parse("18/09/1989"), "15:45 pm", expectedlocation, "Done", "Individual");
        String actualValue = item.getLocation();
        assertEquals(expectedlocation, actualValue);
    }

    @Test
    public void testgetStatus() throws ParseException, IOException {
        String expectedStatus = "Ongoing";
        TodoItem item = new TodoItem("Assignment", FORMAT.parse("18/09/1989"), "15:45 pm", "Stockholm", expectedStatus, "Individual");
        String actualValue = item.getStatus();
        assertEquals(expectedStatus, actualValue);
    }

    @Test
    public void testgetcategory() throws ParseException, IOException {
        String expectedcategory = "Individual_project";
        TodoItem item = new TodoItem("Assignment", FORMAT.parse("18/09/1989"), "15:45 pm", "Stockholm", "Done", expectedcategory);
        String actualValue = item.getCategory();
        assertEquals(expectedcategory, actualValue);
    }

    @Test
    public void testsetTheCategory() throws ParseException, IOException {
        System.out.println("set project category");
        String category = "Group project";
        TodoItem item = new TodoItem("Assignment", FORMAT.parse("18/09/1989"), "15:45 pm", "Stockholm", "Done", category);
        item.setTheCategory(category);
        assertEquals(item.getCategory(), category);
    }

    @Test
    public void testsetTheTitle() throws ParseException, IOException {
        System.out.println("set project title");
        String expectedtitle = "Assignment";
        TodoItem item = new TodoItem(expectedtitle, FORMAT.parse("18/09/1989"), "15:45 pm", "Stockholm", "Done", "Group");
        item.setTheTitle(expectedtitle);
        assertEquals(item.getTitle(), expectedtitle);
    }

    @Test
    public void testsetTheDate() throws ParseException, IOException {
        System.out.println("set date");
        String date = "12/09/2020";
        Date newdate = FORMAT.parse(date);
        TodoItem item = new TodoItem("Assignment", newdate, "15:45 pm", "Stockholm", "Done", "Group");
        item.setTheDate(FORMAT.parse(date));
        assertEquals(item.getDate(), newdate);
    }

    @Test
    public void testsetTheTime() throws ParseException, IOException {
        System.out.println("set time");
        String time = "14:25 pm";
        TodoItem item = new TodoItem("Assignment", FORMAT.parse("18/09/2020"), time, "Stockholm", "Done", "Group");
        item.setTheLocation(time);
        assertEquals(item.getTime(), time);
    }

    @Test
    public void testsetTheLocation() throws ParseException, IOException {
        System.out.println("set location");
        String location = "Stockholm";
        TodoItem item = new TodoItem("Assignment", FORMAT.parse("18/09/2020"), "14:25 pm", location, "Done", "Group");
        item.setTheLocation(location);
        assertEquals(item.getLocation(), location);
    }

    @Test
    public void testsetTheStatus() throws ParseException, IOException {
        System.out.println("set status");
        String status = "Mark as Done";
        TodoItem item = new TodoItem("Assignment", FORMAT.parse("18/09/2020"), "14:25 pm", "France", status, "Group");
        item.setTheLocation(status);
        assertEquals(item.getStatus(), status);
    }
}
