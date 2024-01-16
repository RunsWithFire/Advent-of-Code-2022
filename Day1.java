import java.util.*;

class Day1 {
    public static void day1(List<String> input) {
        int max_cals1 = 0;
        int max_elf1 = 1;
        int max_cals2 = 0;
        int max_elf2 = 1;
        int max_cals3 = 0;
        int max_elf3 = 1;
        int cur_cals = 0;
        int cur_elf = 1;
        for (String input_line : input) {
            if (input_line.length() == 0) {
                if (cur_cals > max_cals1) {
                    max_elf3 = max_elf2;
                    max_cals3 = max_cals2;
                    max_elf2 = max_elf1;
                    max_cals2 = max_cals1;
                    max_elf1 = cur_elf;
                    max_cals1 = cur_cals;
                } else if (cur_cals > max_cals2 ) {
                    max_elf3 = max_elf2;
                    max_cals3 = max_cals2;
                    max_elf2 = cur_elf;
                    max_cals2 = cur_cals;
                } else if (cur_cals > max_cals3 ) {
                    max_elf3 = cur_elf;
                    max_cals3 = cur_cals;
                }
                cur_elf++;
                cur_cals = 0;
                continue;
            }

            cur_cals = cur_cals + Integer.parseInt(input_line);
        }
        // need to check the last one since it doesn't end on an empty line.
        if (cur_cals > max_cals1) {
            max_elf3 = max_elf2;
            max_cals3 = max_cals2;
            max_elf2 = max_elf1;
            max_cals2 = max_cals1;
            max_elf1 = cur_elf;
            max_cals1 = cur_cals;
        } else if (cur_cals > max_cals2 ) {
            max_elf3 = max_elf2;
            max_cals3 = max_cals2;
            max_elf2 = cur_elf;
            max_cals2 = cur_cals;
        } else if (cur_cals > max_cals3 ) {
            max_elf3 = cur_elf;
            max_cals3 = cur_cals;
        }

        System.out.println("Max Elves: " + max_elf1 + " > " + max_elf2 + " > " + max_elf3);
        System.out.println("Max Cals: " + (max_cals1 + max_cals2 + max_cals3));
    }
}