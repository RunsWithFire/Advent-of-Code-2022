import java.util.*;

public class Day6 {
    public static void day6(List<String> input) {
        String signal = input.get(0);
        int marker = 0;
        for (int i=3; i<signal.length(); i++) {
            boolean is_good = true;

            Set<String> set = new HashSet<String>();
            // Part 1 Logic
            // for (int j=0; j<4; j++) {
            // Part 2 Logic
            for(int j=0; j<14; j++) {
                String new_code = Character.toString(signal.charAt(i-j));
                if (set.contains(new_code)) {
                    is_good = false;
                    break;
                }
                set.add(new_code);
            }
            
            if (is_good) {
                marker = i+1;
                break;
            }
        }

        System.out.println(marker);
    }
}