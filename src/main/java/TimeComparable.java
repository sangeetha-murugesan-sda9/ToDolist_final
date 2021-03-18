import java.util.Comparator;


public class TimeComparable implements Comparator<TodoItem> {

    @Override
    public int compare(TodoItem objOne, TodoItem objTwo) {
        return objOne.getTime().compareTo(objTwo.getTime());
    }
}

