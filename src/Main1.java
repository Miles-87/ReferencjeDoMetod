import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main1 {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("ADAM", 10),
                new Person("EWA", 15),
                new Person("IZA", 21),
                new Person("TOMASZ", 24),
                new Person("IGOR", 26),
                new Person("PIOTR", 30));

        // RELACJA W STYLU:
        // elementStrumienia -> Interfejs.metoda(elementStrumienia)

        // Taka releacje mozesz zastapic referencja do statycznej metody
        // ktora zwraca  to samo co metoda w interfejsie i przyjmuje taki
        // sam argument jak metoda w interfejsie

        // Jak wyglada taka relacja?
        // KlasaMetodyStatycznej::metodaStatyczna
        people
                .stream()
                // .filter(p -> p.getAge() >= 18)
                .filter(PersonManager::isAdult)
                // .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .sorted(PersonManager::compareByName)
                // .forEach(p -> System.out.println(p));
                .forEach(PersonManager::showOnlyName);

        // filter jako argument przyjmuje implementacje interfejsu Predicate
        Predicate<Person> p1 = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return false;
            }
        };

        Comparator<Person> cmp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        };

        Consumer<Person> cons = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        };
    }
}
