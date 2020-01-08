import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("ADAM", 10),
                new Person("EWA", 15),
                new Person("IZA", 21),
                new Person("TOMASZ", 24),
                new Person("IGOR", 26),
                new Person("PIOTR", 30));

        // Relacja ktora tutaj zachodzi
        // elementStrumienia -> elementStrumienia.metoda

        // Taka relacje mozesz zastapic referencja do metody w stylu
        // KlasaElementuStrumienia::metoda
        // to sie nazywa czasamio statyczna referencja do metody niestatycznej

        // powyzsza referencja czesto tyczy sie interfejsu Function i mozemy
        // zastapic implementacje interfejsu Function wlasnie za pomoca
        // tej referencji
        people
                .stream()
                // tutaj masz jako argument map implementacje interfejsu
                // Function, ktory spelnia relacja omawiana w tym przykladzie
                // .map(p -> p.getName());
                .map(Person::getName);

        people
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getName(),
                        p -> p.getAge()
                ));

        people
                .stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Person::getAge
                ));

        people.stream().collect(Collectors.groupingBy(p -> p.getName()));
        people.stream().collect(Collectors.groupingBy(Person::getName));



    }
}
