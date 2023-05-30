import java.util.*;

//Class for contact
class Contacts {
    long number;
    String name;

    Contacts(long number, String name) {
        this.number = number;
        this.name = name;
    }

    void getDetails() {
        System.out.println("Number: " + this.number + " Name: " + this.name);
    }
}

//Class for MissedCall
class MissedCall {

    HashMap<Long, Contacts> contacts;
    ArrayList<Contacts> missCall;
    Scanner sc;
    int choice;

    MissedCall() {

        contacts = new HashMap<Long, Contacts>();
        missCall = new ArrayList<Contacts>();
        sc = new Scanner(System.in);
        Contacts c1 = new Contacts(7870809990l, "Vinay");
        Contacts c2 = new Contacts(9431396888l, "Sai");
        Contacts c3 = new Contacts(7870613328l, "Tej");
        contacts.put(7870809990l, c1);
        contacts.put(9431396888l, c2);
        contacts.put(7870613328l, c3);

        while (true) {
            System.out.println("1.Contact List  \n2.Give Miss Call  \n3.Get Miss Call list  \n4.Remove Contact  \n5.Exit \nEnter Your Choice: ");
            choice = sc.nextInt();
            if (choice == 1)
                showContacts();
            else if (choice == 2) {
                saveMissCall();
            } else if (choice == 3) {
                showMissCall();
            } else if (choice == 4) {
                removeContact();
            } else if (choice == 5) {
                System.out.println("END OF PROGRAM");
                break;
            } else {
                System.out.println("Wrong Choice");
            }

        }

    }

    void showContacts() {
        for (Map.Entry<Long, Contacts> c : this.contacts.entrySet()) {
            c.getValue().getDetails();
        }
    }

    void showMissCall() {
        for (Contacts m : this.missCall) {
            m.getDetails();
        }
    }

    void removeContact() {
        long number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        number = sc.nextLong();
        if (this.contacts.containsKey(number)) {
            this.contacts.remove(number);
            System.out.println("Number: " + number + " Removed");
        } else {
            System.out.println("Number is not there in the contact list");
        }
    }

    void saveMissCall() {
        long number;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Give miss call: ");
        number = sc.nextLong();
        if (this.contacts.containsKey(number)) {
            name = this.contacts.get(number).name;
        } else {
            name = "Private";
        }
        Contacts c = new Contacts(number, name);
        this.missCall.add(c);
        System.out.print("Miss Call: ");
        c.getDetails();
    }
}


//MainClass
public class MissedCallMain {
    public static void main(String arg[]) {
        new MissedCall();
    }
}