import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Key Value
 *  1 -> 1,2,3,4,5
 *  2 -> 2,4,5,6,8
 *  3 -> 2,4,57,9
 *
 *  o/p - 1,3,5,7,9
 *  All Odd keys unique odd values
 *
 */

public class Practice {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        map.put(1, List.of(1,2,3,3,4,5));
        map.put(2, List.of(2,4,5,6,8));
        map.put(3, List.of(2,4,57,9));

        map.entrySet().stream().filter(e -> e.getKey() % 2 != 0).forEach( k -> {
            List<Integer> currValue = k.getValue().stream().distinct().filter(e -> e%2 != 0).collect(Collectors.toList());
            System.out.println(k.getKey() +" : ");
            System.out.print(currValue);
            System.out.println();
        });
    }


}

