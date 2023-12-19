package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Contact extends GeneralContact {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String contactName;
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;


    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Contact(int id, String name, String surname, String phoneNumber, String birthDay, String gender, LocalDateTime created, LocalDateTime edited) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.gender = gender;
        this.created = created;
        this.edited = edited;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    private String birthDay;
    private String gender;
    private LocalDateTime created;
    private LocalDateTime edited;

    public Contact() {
    }

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Contact(int id, String name, String surname, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + birthDay + "\n" +
                "Gender: " + gender + "\n" +
                "Number: " + phoneNumber + "\n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + edited + "\n";
    }

    public String contactName() {
        return this.id + ". " + this.name + " " + this.surname;

    }
    public String searchName() {
        return this.id + ". " + this.name + " " + this.surname+ " "+ phoneNumber;

    }
}
