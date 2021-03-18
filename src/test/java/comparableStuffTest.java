import Data.TodoItem;
import comparableStuff.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.*;

public class comparableStuffTest
{
    public static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static TodoItem item1;
    private static TodoItem item2;
    private static TodoItem item3;
    private static TodoItem item4;

    @BeforeAll
    public static void beforeAll() throws ParseException, IOException
    {
        item1 = new TodoItem("MailCheck", FORMAT.parse("12/06/2020"), "3 pm", "India", "Done", "Individual");
        item2 = new TodoItem("Assignment", FORMAT.parse("16/03/2021"), "5 pm", "Sweden", "Not Done", "Group");
        item3 = new TodoItem("ProjectWork", FORMAT.parse("10/09/2022"), "9 pm", "Paris", "Done", "Individual");
        item4 = new TodoItem("Presentation", FORMAT.parse("01/12/2019"), "2 pm", "London", "Done", "Group");
    }

    @Test
    public void testComparingTaskByTitleWhenComparingBiggerElement()
    {
        ItemComparable titleComparable = new ItemComparable('f');
        int actual = titleComparable.compare(item1, item2);
        assertTrue(actual > 0);
        assertEquals(true, actual > 0);
    }

    @Test
    public void testComparingTaskByTitle()
    {
        ItemComparable compareTitle = new ItemComparable('f');
        int actual = compareTitle.compare(item2, item1);
        assertTrue(actual < 0);
        assertEquals(true, actual < 0);
    }

    @Test
    public void testComparingTaskByDate()
    {
        ItemComparable dateComparable = new ItemComparable('a');
        int actual = dateComparable.compare(item1, item2);
        assertTrue(actual < 0);
        assertEquals(true, actual < 0);
    }

    @Test
    public void testComparingTaskByTime()
    {
        ItemComparable compareTime = new ItemComparable('e');
        int actual = compareTime.compare(item3, item4);
        assertTrue(actual > 0);
        assertEquals(true, actual > 0);
    }

    @Test
    public void testComparingTaskByLocation()
    {
        ItemComparable compareLocation = new ItemComparable('c');
        int actual = compareLocation.compare(item4, item3);
        assertTrue(actual < 0);
        assertEquals(true, actual < 0);
    }

    @Test
    public void testComparingTaskByStatus()
    {
        ItemComparable compareStatus = new ItemComparable('d');
        int actual = compareStatus.compare(item1, item2);
        assertTrue(actual < 0);
        assertEquals(true, actual < 0);
    }

    @Test
    public void testComparingTaskByCategory()
    {
        ItemComparable projectComparable = new ItemComparable('b');
        int actual = projectComparable.compare(item3, item4);
        assertTrue(actual > 0);
        assertEquals(true, actual > 0);
    }
}



