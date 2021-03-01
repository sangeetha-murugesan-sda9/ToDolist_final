import java.util.Comparator;

public class ProjectComparable implements Comparator<TodoItem>{

    @Override
    public int compare(TodoItem o1, TodoItem o2)
    {
        return o1.getCategory().compareTo(o2.getCategory());
    }
}
