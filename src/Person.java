public class Person {
    /* Java Streams*/

    private String name;

    public Person(String name) {
        this.name = name;
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
    public String getName() {
        return name;
    }
}

