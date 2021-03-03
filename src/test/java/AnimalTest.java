import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest
{
    ArrayList<Integer> list;
    //File file;


    @BeforeAll
    public static void setUp()
    {
        //start the server
        // create file
        // mock up
    }

    @AfterAll
    public static void tearDown()
    {
        // close the server
        // delete all files, ....
    }

    @BeforeEach
    public void beforeEachTest()
    {
        list = new ArrayList<>();
        list.add(7);
        list.add(100);
        list.add(13);

        //file = new File("nour.txt");
    }

    @AfterEach
    public void afterEachTest()
    {
        //file.delete();
    }




    @Test
    public void testGetName()
    {
        String expectedName = "a";
        Animal a = new Animal(expectedName, 22);

        String actualValue = a.getName();
        assertEquals(expectedName, actualValue);

        //assertEquals(true, true);

    }



    @Test
    public void testRemoving()
    {
        // test removing
        list.remove(1) ; // remove 100

        assertEquals(2, list.size());
        assertEquals(7, list.get(0));
        assertEquals(13, list.get(1));

    }


    @Test
    public void testSize()
    {
        assertEquals(3, list.size());
    }













}
