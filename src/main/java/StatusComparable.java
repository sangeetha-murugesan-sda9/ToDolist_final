import java.util.Comparator;

public class StatusComparable implements Comparator<TodoItem>{

    @Override
    public int compare(TodoItem objOne, TodoItem objTwo)
    {
        return objOne.getStatus().compareTo(objTwo.getStatus());
    }
}
