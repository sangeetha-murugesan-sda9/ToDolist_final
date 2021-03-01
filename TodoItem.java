
import java.io.Serializable;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TodoItem implements Serializable
{

    private String theTitle;
    private Date theDate;
    private String theTime;
    private String theLocation;
    private String theStatus;
    private String theCategory;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    TodoItem(String title, Date date, String time, String location, String status, String category) {

        theTitle = title;
        theDate = date;
        theTime = time;
        theLocation = location;
        theStatus = status;
        theCategory = category;
    }

    public TodoItem(){}


    public void setTheCategory(String theCategory) {
        this.theCategory = theCategory;
    }
    public void setTheTitle(String theTitle) {
        this.theTitle = theTitle;
    }
    public void setTheStatus(String theStatus) {
        this.theStatus = theStatus;
    }
    public void setTheDate(Date theDate) { this.theDate = theDate; }
    public void setTheLocation(String theLocation) {
        this.theLocation = theLocation;
    }
    public void setTheTime(String theTime){this.theTime = theTime; }



    public String getTitle() {

        return theTitle;
    }

    public Date getDate() {

        return theDate;
    }

    public String getTime() {

        return theTime;
    }

    public String getLocation() {

        return theLocation;
    }

    public String getStatus() {

        return theStatus;
    }

    public String getCategory() {

        return theCategory;
    }

    @Override
    public String toString() {

        return theTitle + ", " + format.format(theDate) + ", " + theTime + ", " + theLocation + ", " + theStatus + ", " + theCategory;
    }


}





