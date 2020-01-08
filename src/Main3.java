import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {

        // Referencja do konstruktora
        // Jest to referencja ktora czesto zastepuje Supplier-a

        // w 99% przypadkow zastepowac bedzie konstruktor bezargumentowy

        Optional<Person> op1 = Optional.of(new Person("ADAM", 10));

        // czesto jednak ze zalezy Ci na tym zeby po prostu wygenerowac
        // obiekt danej klasy za pomoca konstruktora bezargumentowego niekoniecznie
        // podajac temu konstruktorowi od razu jakies argumenty
        op1.orElseGet(() -> new Person());
        // taki zapis mozesz zastapic Person::new
        op1.orElseGet(Person::new);

        // okazuje sie ze takich miejsc gdzie po prostu potrzebuejsz wygenerowac
        // obiekt za pomoca konstruktora bezargumentowego jest kilka i mozna
        // upiekszyc kod stosujac wlasnie referencje do konstruktora

        List<Person> people = List.of(
                new Person("ADAM", 10),
                new Person("EWA", 15),
                new Person("IZA", 21),
                new Person("TOMASZ", 24),
                new Person("IGOR", 26),
                new Person("PIOTR", 30));

        people
                .stream()
                .filter(p -> p.getAge() > 10)
                // .collect(Collectors.toCollection(() -> new LinkedHashSet<>()));
                .collect(Collectors.toCollection(LinkedHashSet::new));

        people
                .stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Person::getAge,
                        // kiedy okaze sie ze podczas tworzenia mapy moga zostac
                        // wygenerowanie dwa takie same klucze dla mapy
                        // to wtedy robi sie z nich jeden klucz a dwie wartosci
                        // sa ponizej przekazane i mozesz ustalic jaka bedzie na
                        // ich podstawie wartosc dla tego klucza

                        // (v1, v2) -> Integer.min(v1, v2), // tutaj masz klasyczny
                        // przyklad na referencje do metody pierwszego typu:
                        Integer::min,

                        // kolejny argument to jaki rodzaj mapy chcesz
                        // () -> new LinkedHashMap<>()
                        LinkedHashMap::new
                ));

        // czas pokazac ten 1% kiedy referencja do konstruktora siegnie po konstruktor
        // argumentowy - musi to wyniknac z kontekstu aplikacji, z kontekstu wywolania
        List<String> names = List.of("ADAM", "EWA", "IZA");
        List<Person> peopleFromNames = names
                .stream()
                // z lewej strony przychodzi Ci String
                // z prawej strony oczekujesz Person ktory zostanie wygenerowany
                // za pomoca konstruktora
                // w takiej sytuacji kompilator nie ma wyjscia - musi wybrac
                // taki konstruktor ktory jako argument przyjmuje napis i my taki
                // mamy, jakbysmy nie mieli to blad kompilacji
                .map(Person::new)
                .collect(Collectors.toList());

    }
}
