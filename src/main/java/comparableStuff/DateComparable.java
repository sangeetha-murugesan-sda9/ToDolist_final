package comparableStuff;

import Data.TodoItem;
import java.util.Comparator;

public class DateComparable implements Comparator<TodoItem>
{
    @Override
    public int compare(TodoItem o1, TodoItem o2)
    {
        return o1.getDate().compareTo(o2.getDate());
    }
}
