import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    /* UC 7:- Ability to ensure there is no Duplicate
Entry of the same Person in a particular
Address Book - Duplicate Check is done*/
    public List<Person> persons = new ArrayList<>();
    private Map<String, List<Person>> cityDictionary = new HashMap<>(); //UC9
    private Map<String, List<Person>> stateDictionary = new HashMap<>();//UC9

    // Method to add a person to the address book
    public void addPerson(Person person) {
        if (!isDuplicate(person)) {
            persons.add(person);
            System.out.println("Person added: " + person.getName());
        } else {
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
   //UC8
   // Method to search persons by city
  public List<Person> searchPersonsByCity(String city) {
       return persons.stream()
               .filter(person -> person.getCity().equals(city))
               .collect(Collectors.toList());
   }

    // Method to search persons by state
    public List<Person> searchPersonsByState(String state) {
        return persons.stream()
                .filter(person -> person.getState().equals(state))
                .collect(Collectors.toList());
    }

//UC9:- Method to add a person to the address book and update dictionaries


       public void addPersons (Person pers) {
            if (!isDuplicate(pers)) {
                persons.add(pers);
                //updateCityDictionary(pers);
                updateStateDictionary(pers);
                System.out.println("Person added: " + pers.getName());
            } else {
                System.out.println("Duplicate entry found. Person not added: " + pers.getName());
            }
        }

        // Method to update the city dictionary
       /* public void updateCityDictionary(Person person) {
            cityDictionary.computeIfAbsent(person.getCity(), k -> new ArrayList<>()).add(person);
        }*/

        // Method to update the state dictionary
        public void updateStateDictionary(Person person) {
            stateDictionary.computeIfAbsent(person.getState(), k -> new ArrayList<>()).add(person);
        }

        // Method to view persons by city using Java streams
        public List<Person> viewPersonsByCity(String city) {
            return cityDictionary.getOrDefault(city,Collections.emptyList());
        }

        // Method to view persons by state using Java streams
        public List<Person> viewPersonsByState(String state) {
            return stateDictionary.getOrDefault(state, Collections.emptyList());
        }
        //UC10:-
        // Method to count persons by city
        public long countPersonsByCity(String city) {
            return persons.stream()
                    .filter(person -> person.getCity().equals(city))
                    .count();
        }

    // Method to count persons by state
    public long countPersonsByState(String state) {
        return persons.stream()
                .filter(person -> person.getState().equals(state))
                .count();
    }


}








