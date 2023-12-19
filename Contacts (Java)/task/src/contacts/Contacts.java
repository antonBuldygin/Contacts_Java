package contacts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Contacts {


    List<GeneralContact> contacts;

    public Contacts() {
        this.contacts = new ArrayList<>();
    }

    public String add(Scanner scanner) {

        System.out.print("Enter the type (person, organization): ");
        String type = scanner.nextLine();

        if (type.equals("person")) {

            Contact contact = new Contact();
            contact.setCreated(LocalDateTime.now());
            contact.setEdited(LocalDateTime.now());

            System.out.print("Enter the name: ");
            contact.setName(scanner.nextLine());

            System.out.print("Enter the surname: ");
            contact.setSurname(scanner.nextLine());

            System.out.print("Enter the birth date: ");
            String birthDateinput = scanner.nextLine();

            if (numberBirthdate(birthDateinput)) {
                contact.setBirthDay(birthDateinput);
            } else contact.setBirthDay("[no data]");

            System.out.print("Enter the gender (M, F): ");
            String gender = scanner.nextLine();
            if (gender.equals("M") || gender.equals("F")) {
                contact.setGender(gender);
            } else {
                contact.setGender("[no data]");
            }


            System.out.print("Enter the number: ");
            String numberInput = scanner.nextLine();
            if (numberCheck(numberInput)) {
                contact.setPhoneNumber(numberInput);
            } else {
                System.out.println("Wrong number format!");
                contact.setPhoneNumber("[no number]");
            }
            System.out.println("The record added.");
            contact.setId(contacts.size() + 1);
            contacts.add(contact);
        }


        if (type.equals("organization")) {

            Organization contact = new Organization();

            contact.setCreated(LocalDateTime.now());
            contact.setEdited(LocalDateTime.now());

            System.out.print("Enter the organization name: ");
            contact.setName(scanner.nextLine());

            System.out.print("Enter the address: ");
            contact.setAddress(scanner.nextLine());

            System.out.print("Enter the number: ");
            String numberInput = scanner.nextLine();
            if (numberCheck(numberInput)) {
                contact.setPhoneNumber(numberInput);
            } else {
                System.out.println("Wrong number format!");
                contact.setPhoneNumber("[no number]");
            }
            System.out.println("The record added.");
            contact.setId(contacts.size() + 1);
            contacts.add(contact);
        }


        return "The record added.\n\n";
    }

    public List<GeneralContact> search(String scanner) {
        return contacts.stream().filter(t -> t.searchName().toLowerCase().contains(scanner.toLowerCase())).collect(Collectors.toList());


    }

    public String count() {
        return String.format("The Phone Book has %d records.", contacts.size());
    }

    public List<GeneralContact> list() {
        return contacts;

    }

    public String remove(int i) {
        contacts.remove(i - 1);
        return "The record removed!";

    }

    public String editContact(int record, String field) {
        Contact contact = (Contact) contacts.get(record - 1);

        Scanner scanner1 = new Scanner(System.in);

        if (field.equals("name")) {
            System.out.print("Enter the name:");
            contact.setName(scanner1.nextLine());
        }

        if (field.equals("surname")) {
            System.out.print("Enter the surname:");
//            contact.setSurname(scanner1.nextLine());
        }

        if (field.equals("number")) {
            System.out.print("Enter the number:");
            String s = scanner1.nextLine();
            if (numberCheck(s)) {
                contact.setPhoneNumber(s);
            } else {
                System.out.println("Wrong number format!");
                contact.setPhoneNumber("[no number]");
            }
        }

        if (field.equals("birth")) {
            System.out.print("Enter the birth date: ");
            String birthDateinput = scanner1.nextLine();

            if (numberBirthdate(birthDateinput)) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                contact.setBirthDay(birthDateinput);
            } else contact.setBirthDay("[no data]");
        }

        if (field.equals("gender")) {

            System.out.print("Enter the gender (M, F): ");
            String gender = scanner1.nextLine();
            if (gender.equals("M") || gender.equals("F")) {
                contact.setGender(gender);
            } else {
                contact.setGender("[no data]");
            }
        }
        scanner1.close();
        contacts.set(record - 1, contact);
        return "The record updated!\n";
    }

    public String editOrganization(int record, String field) {
        Organization contact = (Organization) contacts.get(record - 1);
        Scanner scanner1 = new Scanner(System.in);
        if (field.equals("number")) {
            System.out.print("Enter the number:");
            String s = scanner1.nextLine();
            if (numberCheck(s)) {
                contact.setPhoneNumber(s);
            } else {
                System.out.println("Wrong number format!");
                contact.setPhoneNumber("[no number]");
            }
        }
        if (field.equals("address")) {
            System.out.print("Enter the address: ");
            contact.setAddress(scanner1.nextLine());
        }
        scanner1.close();
        contacts.set(record - 1, contact);
        return "The record updated!\n";
    }

    public boolean numberCheck(String number) {
        Pattern compile = Pattern.compile("[+]?(([(]?[\\w]{1,}[)]?)|([\\w]+)([ -][(][\\w]{2,}[)])*)([ -][0-9a-zA-Z]{2,})*");
        Matcher matcher = compile.matcher(number);
        boolean b = matcher.matches();
        return b;
    }


    public boolean numberBirthdate(String number) {
        Pattern compile = Pattern.compile("[\\d]{4}-[\\d]{2}-[\\d]{2}");
        Matcher matcher = compile.matcher(number);
        boolean b = matcher.matches();
        return b;
    }
}
