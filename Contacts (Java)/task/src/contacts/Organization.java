package contacts;

import java.time.LocalDateTime;

public class Organization extends GeneralContact {

    private int id;
    private String name;
    private String address;
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

    public Organization(int id, String name, String phoneNumber, LocalDateTime created, LocalDateTime edited) {
        super(id, name, phoneNumber, created, edited);
    }

    public Organization() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public LocalDateTime getEdited() {
        return edited;
    }

    @Override
    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

    @Override
    public String toString() {
        return "Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Number: " + phoneNumber + "\n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + edited + "\n";
    }

    public String contactName() {
        return id + ". " + name ;

    }
    public String searchName() {
        return id + ". " + name+ " "+ phoneNumber;

    }
}
