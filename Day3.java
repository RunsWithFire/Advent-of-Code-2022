import java.util.*;

class Day3 {
    public static Map<String, Integer> value_map = new HashMap<String, Integer>();
    
    public static void day3(List<String> input) {
        InitializeValueMap();
        int score = GetBadgesScore(input);
        System.out.println(score);
    }

    // Used for Part 2
    public static int GetBadgesScore(List<String> input) {
        int score = 0;
        for (int i = 0; i<input.size(); i=i+3) {
            int row_num = i;
            String row = input.get(row_num);
            Set<String> set1 = new HashSet<String>();
            for (int j = 0; j < row.length(); j++) {
                String item = Character.toString(row.charAt(j));
                set1.add(item);
            }

            row_num = i+1;
            row = input.get(row_num);
            Set<String> set2 = new HashSet<String>();
            for (int j = 0; j < row.length(); j++) {
                String item = Character.toString(row.charAt(j));
                set2.add(item);
            }

            row_num = i+2;
            row = input.get(row_num);
            for (int j = 0; j < row.length(); j++) {
                String check = Character.toString(row.charAt(j));
                if (set1.contains(check) && set2.contains(check)) {
                    score = score + value_map.get(check);
                    break;
                }
            }
        }

        return score;
    }

    // Used for Part 1
    public static int GetItemPriorities(List<String> input) {
        int score = 0;
        for (String input_line : input) {
            int line_length = input_line.length();
            String line1 = input_line.substring(0,line_length/2);
            String line2 = input_line.substring(line_length/2);
            
            Set<String> first_set = new HashSet<String>();
            for (int i = 0; i < line1.length(); i++) {
                String item = Character.toString(line1.charAt(i));
                first_set.add(item);
            }

            for (int i = 0; i < line2.length(); i++) {
                String check = Character.toString(line2.charAt(i));
                if (first_set.contains(check)) {
                    score = score + value_map.get(check);
                    break;
                }
            }
        }

        return score;
    }

    public static void InitializeValueMap() {
        int priority = 1;
        int ascii_start_lower = 97; //a
        int ascii_end_lower = 122; //z
        int ascii_start_upper = 65; //A
        int ascii_end_upper = 90; //Z

        for (int i=ascii_start_lower; i<=ascii_end_lower; i++) {
            value_map.put(Character.toString((char) i), priority);
            priority++;
        }
        for (int i=ascii_start_upper; i<=ascii_end_upper; i++) {
            value_map.put(Character.toString((char) i), priority);
            priority++;
        }
    }
}