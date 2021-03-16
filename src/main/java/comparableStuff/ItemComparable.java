package comparableStuff;
import Data.TodoItem;
import java.util.Comparator;

public class ItemComparable implements Comparator <TodoItem> {

    private char type;

    public ItemComparable(char type)  {
        this.type = type;
    }

    /**
     *  Compares the title,date,time,location,status,category to sort the list based on the choice selected by
     *  the user.
     */

    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        switch (type) {
            case 'a':
                return o1.getDate().compareTo(o2.getDate());
            case 'b':
                return o1.getCategory().compareTo(o2.getCategory());
            case 'c':
                return o1.getLocation().compareTo(o2.getLocation());
            case 'd':
                return o1.getStatus().compareTo(o2.getStatus());
            case 'e':
                return o1.getTime().compareTo(o2.getTime());
            case 'f':
                return o1.getTitle().compareTo(o2.getTitle());
            default:
                return o1.getDate().compareTo(o2.getDate());
        }
    }

}


