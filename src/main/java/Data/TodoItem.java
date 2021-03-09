package Data;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
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

    public TodoItem(String title, Date date, String time, String location, String status, String category) throws IOException {

        this.theTitle = title;
        this.theDate = date;
        this.theTime = time;
        this.theLocation = location;
        this.theStatus = status;
        this.theCategory = category;
    }
    public TodoItem(){}

    /**
     *  Setter methods for title,date,time,location,status,category.
     */

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

    /**
     *  getter methods for title,date,time,location,status,category.
     */

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
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if(! (obj instanceof TodoItem))
            return false;

        TodoItem otherItem = (TodoItem) obj;
        if(this.theTitle.equals(otherItem.getTitle()) &&
           this.theDate.equals(otherItem.getDate()) &&
           this.theTime.equals(otherItem.getTime()) &&
           this.theLocation.equals(otherItem.getLocation())  &&
           this.theStatus.equals(otherItem.getStatus()) &&
           this.theCategory.equals(otherItem.getCategory()))
            return true;
        else
            return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(theTitle,theDate,theTime,theLocation,theStatus,theCategory);
    }

    @Override
    public String toString() {
        return theTitle + ", " + format.format(theDate) + ", " + theTime + ", " + theLocation + ", " + theStatus + ", " + theCategory;
    }


}





