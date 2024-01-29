public class Person  implements  Comparable<Person>{
    /* Java Streams*/
    String name;
    String address;
    String city;
    String state;


    public Person(String name, String address, String city, String state) {
        this.name = name;
        this.address=address;
        this.city=city;
        this.state=state;
    }


    // Override equals method to check for duplicates based on name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name.equals(person.name);
    }
    // Getter for name
    public String getName() { //getter method for Name
        return name;
    }

    public String getAddress() { //getter method for address

        return address;
    }
    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
    //UC11:-
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

}

