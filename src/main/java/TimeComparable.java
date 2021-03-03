import java.util.Comparator;


public class TimeComparable implements Comparator<TodoItem> {

    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
}

