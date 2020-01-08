public interface PersonManager {
    static boolean isAdult(Person person) {
        return person.getAge() >= 18;
    }

    static int compareByName(Person per1, Person per2) {
        return per1.getName().compareTo(per2.getName());
    }

    static void showOnlyName(Person person) {
        if (person != null) {
            System.out.println("NAME: " + person.getName());
        }
    }
}
