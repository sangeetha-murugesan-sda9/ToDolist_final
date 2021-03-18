import java.util.Comparator;

public class TitleComparable implements Comparator<TodoItem> {

    @Override
    public int compare(TodoItem objOne, TodoItem objTwo) {
        return objOne.getTitle().compareTo(objTwo.getTitle());
    }
}
