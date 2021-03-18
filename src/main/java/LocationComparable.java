
import java.util.Comparator;

public class LocationComparable implements Comparator<TodoItem>{

    @Override
    public int compare(TodoItem objOne, TodoItem objTwo)
    {
        return objOne.getLocation().compareTo(objTwo.getLocation());
    }
}
