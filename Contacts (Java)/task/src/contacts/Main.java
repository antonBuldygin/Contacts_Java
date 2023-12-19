package contacts;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        boolean flag = true;
        Contacts contacts = new Contacts();

        while (flag) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("[\\s,]+");
            String input = scanner.nextLine();

            switch (input) {
                case "add":

                    contacts.add(scanner);
                    System.out.println();
                    break;
                case "search":
                    boolean flag1 = true;
                    while (flag1) {
                        String action = getAction(scanner, contacts);
                        Pattern compile = Pattern.compile("[\\d]+");
                        Matcher matcher = compile.matcher(action);
                        boolean b = matcher.matches();
                        int counter = 0;
                        if (b) {
                            counter = Integer.parseInt(action);
                            action = "num";
                        }
                        switch (action) {
                            case "back":
                                flag1 = false;
                                break;
                            case "again":
                                break;
                            case ("num"):
                                System.out.println(contacts.list().get(counter - 1));
                                record(contacts,scanner, counter);

                                flag1=false;
                                break;
                            default:
                                break;
                        }
                    }
                    System.out.println();
                    break;

                case "remove":
                    delete(contacts, scanner);
                    break;
//                case "edit":
//
//                    edit(contacts, scanner);
//                    break;
                case "count":
                    System.out.println(contacts.count());
                    System.out.println();
                    break;
                case "list":
                    for (int i = 0; i < contacts.list().size(); i++) {
                        GeneralContact contact = contacts.list().get(i);
                        contact.setId(i + 1);
                        contacts.list().set(i, contact);
                    }
                    for (int i = 0; i < contacts.list().size(); i++) {
                        System.out.println(contacts.list().get(i).contactName());
                    }
                    System.out.println();
                    System.out.print("[list] Enter action ([number], back):  ");
                    scanner.useDelimiter("[\\s,]+");
                    String in = scanner.nextLine();
                    int counter = 0;

                    Pattern compile = Pattern.compile("[\\d]+");
                    Matcher matcher = compile.matcher(in + "");
                    boolean b = matcher.matches();
                    if (b) {
                        counter = Integer.parseInt(in);
                        in = "num";
                    }

                    switch (in) {
                        case "num":
                            System.out.println(contacts.list().get(counter - 1));
                            record(contacts,scanner, counter);
                            System.out.println();
                            break;
                        case "back":
                            break;
                    }
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;

            }
        }
    }

    private static void delete(Contacts contacts, Scanner scanner) {
        if (contacts.list().size() == 0) {

            System.out.print("No records to remove!");
        } else {
            contacts.list().stream().forEach(System.out::println);
            System.out.print("Select a record: ");

            System.out.println(contacts.remove(scanner.nextInt()));
        }
    }

    private static void edit(Contacts contacts, Scanner scanner,int record) {

            if (contacts.list().get(record - 1).getClass().toString().equals("class contacts.Organization")) {

                System.out.print("Select a field (address, number): ");
                String field = scanner.next();
                String edit = contacts.editOrganization(record, field);
                System.out.print(edit);
                System.out.println();
            }
            if (contacts.list().get(record - 1).getClass().toString().equals("class contacts.Contact")) {
                System.out.print("Select a field (name, surname, birth, gender, number): ");
                String field = scanner.next();

                String edit = contacts.editContact(record, field);
                System.out.print(edit);
                System.out.println();
            }
        }


    private static String getAction(Scanner scanner, Contacts contacts) {
        System.out.print("Enter search query: ");
        String search = scanner.nextLine();
        List<GeneralContact> search1 = contacts.search(search);
        System.out.printf("Found %d results:", search1.size());
        System.out.println();
        for (int i = 0; i < search1.size(); i++) {
            GeneralContact contact = search1.get(i);
            contact.setId(i + 1);
            search1.set(i, contact);
        }
        for (int i = 0; i < search1.size(); i++) {
            System.out.println(search1.get(i).contactName());
        }
        System.out.println();
        System.out.print("[search] Enter action ([number], back, again):");
        String action = scanner.nextLine();
        return action;
    }

    private static void record(Contacts contacts, Scanner scanner, int record) {

        boolean flag = true;
        System.out.print("[record] Enter action (edit, delete, menu): ");
        while (flag) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "edit":
                    edit(contacts, scanner, record);
                    break;
                case "delete":
                    delete(contacts, scanner);
                    break;

                case "menu":
                    flag = false;
                    break;

            }
        }
    }
}
