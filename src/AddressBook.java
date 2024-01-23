import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    /* UC 7:- Ability to ensure there is no Duplicate
Entry of the same Person in a particular
Address Book - Duplicate Check is done*/
    private List<Person> persons = new ArrayList<>();

    // Method to add a person to the address book
    public void addPerson(Person person) {
        if (!isDuplicate(person)) {
            persons.add(person);
            System.out.println("Person added: " + person.getName());
        } else
        {
            System.out.println("Duplicate entry found. Person not added: " + person.getName());
        }
    }

    // Method to check for duplicate entry using Java streams
    private boolean isDuplicate(Person person) {
        return persons.stream().anyMatch(p -> p.equals(person));
    }

    // Method to get a list of persons with a specific name
    public List<Person> searchPersonsByName(String name) {
        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        Person personOne = new Person("Ruchita Chaudhari");
        Person personTwo = new Person("tanavi");
        Person personThree = new Person("tanavi banait");
        Person personFour=new Person("Ruchita Chaudhari");

        addressBook.addPerson(personOne);
        addressBook.addPerson(personTwo);
        addressBook.addPerson(personThree);
        addressBook.addPerson(personFour); //Duplicate Value

        // Example of searching persons by name
        List<Person> searchResults = addressBook.searchPersonsByName("Ruchita Chaudhari");
        System.out.println("Search results for 'Ruchita Chaudhari': " + searchResults);
    }
}
