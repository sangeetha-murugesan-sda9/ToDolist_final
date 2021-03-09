package comparableStuff;

import Data.TodoItem;

import java.util.Comparator;

public class StatusComparable implements Comparator<TodoItem>{

    @Override
    public int compare(TodoItem o1, TodoItem o2)
    {
        return o1.getStatus().compareTo(o2.getStatus());
    }
}
