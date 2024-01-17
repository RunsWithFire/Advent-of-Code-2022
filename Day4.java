import java.util.*;

public class Day4 {
    public static void day4(List<String> input) {
        int score = 0;
        for (String input_line : input) {
            int comma_ind = input_line.indexOf(",");
            String elf1 = input_line.substring(0, comma_ind);
            String elf2 = input_line.substring(comma_ind+1);

            int min1 = GetMinimum(elf1);
            int max1 = GetMaximum(elf1);
            int min2 = GetMinimum(elf2);
            int max2 = GetMaximum(elf2);
           
            // Part 1 Logic
            // if ((min1 >= min2 && max1 <= max2) || (min2 >= min1 && max2 <= max1)) {
            //     score++;
            // }

            // Part 2 Logic
            if ((min2 >= min1 && min2 <= max1) || (max2 <= max1 && max2 >= min1) || (min1 >= min2 && max1 <= max2)) {
                score++;
            }
        }

        System.out.println("Score: " + score);
    }

    // Used in Part 1 & Part 2
    public static int GetMinimum(String elf) {
        int dash_ind = elf.indexOf("-");
        return Integer.parseInt(elf.substring(0, dash_ind));
    }

    // Used in Part 1 & Part 2
    public static int GetMaximum(String elf) {
        int dash_ind = elf.indexOf("-");
        return Integer.parseInt(elf.substring(dash_ind+1));
    }
}