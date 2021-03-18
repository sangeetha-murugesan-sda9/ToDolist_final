import java.util.Comparator;

public class DateComparable implements Comparator<TodoItem>
{
    @Override
    public int compare(TodoItem objOne, TodoItem objTwo)
    {
        return objOne.getDate().compareTo(objTwo.getDate());
    }
}
