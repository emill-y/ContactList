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

//    public void sort(int sortBy){
//        int n = contacts.size();
//        for (int i = 0; i < n-1; i++){
//            for (int j = 0; i < n - 1 - i; j++){
//                if (sortBy == 1){
//
//                }
//            }
//        }
//    }

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
}
