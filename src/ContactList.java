import java.util.ArrayList;
import java.util.Scanner;
public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        System.out.println("Select a type of contact to add:");
        System.out.println("1. Student\n2. Athlete");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.nextLine();
        System.out.println("Please fill in the following information.");
        System.out.println("First Name:");
        String firstName = s.nextLine();
        System.out.println("Last Name:");
        String lastName = s.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = s.nextLine();
        Person person;
        if (num == 1) {
            System.out.println("Grade: ");
            int grade = s.nextInt();
            s.nextLine();
            person = new Student(firstName, lastName, phoneNumber, grade);
        }
        else {
            System.out.println("Sport: ");
            String sport = s.nextLine();
            System.out.println("Are you injured (true/false): ");
            boolean injured = s.nextBoolean();
            person = new Athlete(firstName, lastName, phoneNumber, sport, injured);
        }
        this.contacts.add(person);
    }

    public void printContacts(){
        for (Person person : contacts){
            System.out.println(person.toString());
        }
    }

    public void sort(int sortBy){
        int n = contacts.size();
        for (int i = 0; i < n-1; i++){
            for (int j = 0; i < n - 1 - i; j++){
                char first;
                char second;
                if (sortBy == 1){
                    first = contacts.get(i).getFirstName().charAt(0);
                    second = contacts.get(i).getFirstName().charAt(1);
                }
                else if (sortBy == 2){
                    first = contacts.get(i).getLastName().charAt(0);
                    second = contacts.get(i).getLastName().charAt(1);
                }
                else {
                    first = contacts.get(i).getPhoneNumber().charAt(0);
                    second = contacts.get(i).getPhoneNumber().charAt(1);
                }
                if (first > second) {
                    Person temp = contacts.get(i);
                    contacts.set(i, contacts.get(j));
                    contacts.set(j, temp);
                }
                }
        }
    }

    public Person searchByFirstName(String firstName){
        for (Person person : contacts){
            if (person.getFirstName().equals(firstName)) {
                return person;
            }
        }
        return null;
    }
    public Person searchByLastName(String lastName){
        for (Person person : contacts){
            if (person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber){
        for (Person person : contacts){
            if (person.getPhoneNumber().equals(phoneNumber)) {
                return person;
            }
        }
        return null;
    }

    public void listStudents(){
        for (Person person : contacts){
            if (person instanceof Student){
                System.out.println(person.toString());
            }
        }
    }

    public void run(){
        System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts By Last Name" +
                "\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search By First Name\n7. Search By Last Name\n" +
                "8. Search By Phone Number\n0. Exit");

        Scanner s = new Scanner(System.in);
        int key = s.nextInt();

    }
}
