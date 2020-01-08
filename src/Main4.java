import java.util.List;

public class Main4 {
    public static void main(String[] args) {

        // ostatni rodzaj relacji to relacja w stylu
        // elementStrumienia -> OBIEKT.metoda(elementStrumienia)

        // taka relacje zastapisz za pomoca referencji:
        // OBIEKT::metoda

        List<Person> people = List.of(
                new Person("ADAM", 10),
                new Person("EWA", 15),
                new Person("IZA", 21),
                new Person("TOMASZ", 24),
                new Person("IGOR", 26),
                new Person("PIOTR", 30));

        people
                .stream()
                .filter(p -> p.getAge() > 19)
                // zwroc uwage ponizej - tutaj jest taka relacja
                // OBIEKT to System.out
                // .forEach(p -> System.out.println(p));
                .forEach(System.out::println);

    }
}
