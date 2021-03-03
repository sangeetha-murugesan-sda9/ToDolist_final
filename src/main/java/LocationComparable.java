
import java.util.Comparator;

public class LocationComparable implements Comparator<TodoItem>{

    @Override
    public int compare(TodoItem o1, TodoItem o2)
    {
        return o1.getLocation().compareTo(o2.getLocation());
    }
}
