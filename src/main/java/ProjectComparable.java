import java.util.Comparator;

public class ProjectComparable implements Comparator<TodoItem>{

    @Override
    public int compare(TodoItem objOne, TodoItem objTwo)
    {
        return objOne.getCategory().compareTo(objTwo.getCategory());
    }
}
