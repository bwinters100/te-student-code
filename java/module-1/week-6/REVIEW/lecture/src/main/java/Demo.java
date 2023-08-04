import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 2022, 12, 31);
        LocalDate date = LocalDate.of(2022, 12, 31);

        System.out.println(numbers);
        System.out.println(date);
    }
}