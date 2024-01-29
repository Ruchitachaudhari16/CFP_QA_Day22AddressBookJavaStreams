
    import java.util.ArrayList;
import java.util.List;
    import java.util.stream.Collectors;

    public class AddressBookManager {
        /* UC 8*/
        public  List<AddressBook> addressBooks = new ArrayList<>();

        // Method to add an AddressBook to the manager
        public void addAddressBook(AddressBook addressBook) {
            addressBooks.add(addressBook);
        }

        // Method to search persons by city across all AddressBooks
        public List<Person> searchPersonsByCityAcrossAddressBooks(String city) {
            return addressBooks.stream()
                    .flatMap(addressBook -> addressBook.searchPersonsByCity(city).stream())
                    .collect(Collectors.toList());
        }

        // Method to search persons by state across all AddressBooks
        public List<Person> searchPersonsByStateAcrossAddressBooks(String state) {
            return addressBooks.stream()
                    .flatMap(addressBook -> addressBook.searchPersonsByState(state).stream())
                    .collect(Collectors.toList());
        }

    }


