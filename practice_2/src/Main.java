import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    private static void printHumans(Object arr[]) {
        for (Object o : arr) {
            System.out.println(((Human) o).getLastName());
        }
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        Human danil = new Human("Danil", "Kuzin", LocalDate.of(2001, 4, 13), 55);
        Human denis = new Human("Denis", "Ponomarev", LocalDate.of(2001, 8, 25), 62);
        Human sergey = new Human("Sergey", "Robot", LocalDate.of(1950, 2, 2), 65);
        Human alexey = new Human("Alexey", "Rob", LocalDate.of(1965, 6, 10), 50);
        Stream<Human> stream = Stream.of(danil, denis, sergey, alexey);
        Object arr[] = stream.sorted(Comparator.comparingInt(o -> (int) ((Human) o).getLastName().charAt(((Human) o).getLastName().length() - 1))).toArray();
        printHumans(arr);
        stream = Stream.of(danil, denis, sergey, alexey);
        arr = stream.filter((human) -> human.getAge() > human.getWeight()).toArray();
        printHumans(arr);
        stream = Stream.of(danil, denis, sergey, alexey);
        arr = stream.sorted(Comparator.comparingLong(o -> ((Human) o).getBirthDate().toEpochDay())).toArray();
        printHumans(arr);
        stream = Stream.of(danil, denis, sergey, alexey);
        Optional<Human> mult = stream.reduce((a, b) -> new Human(a.getAge() * b.getAge()));
        System.out.println(mult.get().getAge());
    }
}
