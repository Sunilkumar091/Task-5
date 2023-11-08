import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void displayContact() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}

public class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            contact.displayContact();
            System.out.println();
        }
    }

    public void updateContact(String name, String phoneNumber, String email) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contact = new Contact(name, phoneNumber, email);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Address Book System");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Contact newContact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(newContact);
                    break;
                case 2:
                    addressBook.displayContacts();
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to update: ");
                    name = scanner.nextLine();
                    System.out.print("Enter the new Phone Number: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter the new Email: ");
                    email = scanner.nextLine();

                    addressBook.updateContact(name, phoneNumber, email);
                    break;
                case 4:
                    System.out.print("Enter the name of the contact to delete: ");
                    name = scanner.nextLine();
                    addressBook.deleteContact(name);
                    break;
                case 5:
                    System.out.println("Exiting Address Book System");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}