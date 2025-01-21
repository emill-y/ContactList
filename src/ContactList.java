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
            for (int j = i+1; j < n; j++){
                String first;
                String second;
                if (sortBy == 0){
                    first = contacts.get(i).getFirstName();
                    second = contacts.get(j).getFirstName();
                }
                else if (sortBy == 1){
                    first = contacts.get(i).getLastName();
                    second = contacts.get(j).getLastName();
                }
                else {
                    first = contacts.get(i).getPhoneNumber();
                    second = contacts.get(j).getPhoneNumber();
                }
                if (first.compareToIgnoreCase(second) > 0) {
                    Person temp = contacts.get(i);
                    contacts.set(i, contacts.get(j));
                    contacts.set(j, temp);
                }
                }
        }
        printContacts();
    }

    public Person searchByFirstName(String firstName){
        for (Person person : contacts){
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                return person;
            }
        }
        return null;
    }
    public Person searchByLastName(String lastName){
        for (Person person : contacts){
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                return person;
            }
        }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber){
        for (Person person : contacts){
            if (person.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
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
        switch(key) {
            case 0: System.exit(0);
                break;
            case 1: addContact();
                break;
            case 2:
                sort(0);
                break;
            case 3:
                sort(1);
                break;
            case 4:
                sort(2);
                break;
            case 5:
                listStudents();
                break;
            case 6:
                s.nextLine();
                System.out.println("Enter a First Name:");
                String firstName = s.nextLine();
                Person resultName = searchByFirstName(firstName);
                if(resultName == null){
                    System.out.println(firstName + " is not in the list");
                }
                else{
                    System.out.println(resultName);
                }
                break;
            case 7:
                s.nextLine();
                System.out.println("Enter a Last Name:");
                String lastName = s.nextLine();
                Person result = searchByLastName(lastName);
                if (result ==  null) {
                    System.out.println(lastName + " is not in the list");
                }
                else{
                    System.out.println(result);
                }
                break;
            case 8:
                s.nextLine();
                System.out.println("Enter a Phone Number:");
                String phoneNumber = s.nextLine();
                Person resultNumber = searchByPhoneNumber(phoneNumber);
                if(resultNumber == null){
                    System.out.println(phoneNumber + " is not in the list");
                }
                else {
                    System.out.println(resultNumber);
                }
                break;
            default:
                break;
        }
        run();
    }

    public static void main(String[] args){
        ArrayList<Person> contacts = new ArrayList<Person>();
        Student ella = new Student("Ella", "Young", "6502938476", 10);
        Student david = new Student("David", "Elder", "8573928390", 12);
        contacts.add(ella);
        contacts.add(david);
        ContactList newList = new ContactList(contacts);
        newList.run();
    }
}
