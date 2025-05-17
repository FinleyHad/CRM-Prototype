import java.time.LocalDateTime;
import java.util.*;

public class Communication 
{
    //Information on the entity being added
    private static int nextId = 1;
    private int id;
    private String type;
    private LocalDateTime date;
    private String notes;
    private List<String> tags;
    private int customerId;

    //Allows for set interaction between the bussines and costumer
    public Communication(String type, LocalDateTime date, String notes, List<String> tags, int customerId) 
    {
        this.id = nextId++;
        this.type = type;
        this.date = date;
        this.notes = notes;
        this.tags = tags;
        this.customerId = customerId;
    }

    public int getId() 
    {
        return id;
    }

    public String getType() 
    {
        return type;
    }

    public LocalDateTime getDate() 
    {
        return date;
    }

    public String getNotes() 
    {
        return notes;
    }

    public List<String> getTags() 
    {
        return tags;
    }

    public int getCustomerId() 
    {
        return customerId;
    }
    
    @Override
    public String toString() {
        return String.format("Communication #%d: %s with Customer %d on %s\nTags: %s\nNotes: %s\n",
                id, type, customerId, date, tags.toString(), notes);
    }
}
