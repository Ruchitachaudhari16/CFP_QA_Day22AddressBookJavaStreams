import java.util.List;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        Person personOne = new Person("Ruchita Chaudhari", "Kharadi", "Goa", "Maharastra");
        Person personTwo = new Person("tanavi", "spring society", "Pune", "MH");
        Person personThree = new Person("tanavi banait", "AABc", "Pune", "M");
        Person personFour = new Person("Ruchita Chaudhari", "Khradi", "bhusawal", "Maharastra");

        addressBook.addPerson(personOne);
        addressBook.addPerson(personTwo);
        addressBook.addPerson(personThree);
        addressBook.addPerson(personFour); //Duplicate Value

        // Example of searching persons by name
        //UC7:- If duplicate entry found it will not  add to addressbook.
        List<Person> searchResults = addressBook.searchPersonsByName("Ruchita Chaudhari");
        System.out.println("Search results for 'Ruchita Chaudhari': " + searchResults);

       //UC 8
        /* Ability to search Person in a City or State across the multiple
AddressBook - Search Result can show multiple person in
the city or state Use Java Streams */

                AddressBook addressBook1 = new AddressBook();
                addressBook1.addPerson(personOne);
                addressBook1.addPerson(personTwo);
                addressBook1.addPerson(personThree);
                AddressBook addressBook2 = new AddressBook();
                addressBook2.addPerson(personOne);
                addressBook2.addPerson(personFour);

                // Add address books to the manager
                AddressBookManager addressBookManager = new AddressBookManager();
                addressBookManager.addAddressBook(addressBook1);
                addressBookManager.addAddressBook(addressBook2);

                // Search persons by city across all address books
                List<Person> searchResultsByCity = addressBookManager.searchPersonsByCityAcrossAddressBooks("Pune");
                System.out.println("Search results for 'Pune': " + searchResultsByCity);

                // Search persons by state across all address books
                List<Person> searchResultsByState = addressBookManager.searchPersonsByStateAcrossAddressBooks("MH");
                System.out.println("Search results for 'MH': " + searchResultsByState);
            }
        }



