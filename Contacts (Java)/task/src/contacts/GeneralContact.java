package contacts;

import java.time.LocalDateTime;

public class GeneralContact {

    private int id;
    private String name;
    private String phoneNumber;
    private LocalDateTime created;
    private LocalDateTime edited;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    private String contactName= contactName();

    public String contactName() {
        return id + ". " + name;

    }

    public String searchName() {
        return id + ". " + name+ " "+ phoneNumber;

    }


    public GeneralContact(int id, String name, String phoneNumber, LocalDateTime created, LocalDateTime edited) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.created = created;
        this.edited = edited;
    }

    public GeneralContact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }


}
