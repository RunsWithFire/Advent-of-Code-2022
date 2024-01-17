import java.util.*;

public class Day5 {
    // Starting stacks
    public static Stack<String> stack1 = new Stack<String>();
    public static Stack<String> stack2 = new Stack<String>();
    public static Stack<String> stack3 = new Stack<String>();
    public static Stack<String> stack4 = new Stack<String>();
    public static Stack<String> stack5 = new Stack<String>();
    public static Stack<String> stack6 = new Stack<String>();
    public static Stack<String> stack7 = new Stack<String>();
    public static Stack<String> stack8 = new Stack<String>();
    public static Stack<String> stack9 = new Stack<String>();

    public static void day5(List<String> input) {
        SetupStacks();
        for (String input_line : input) {
            // Get all the values
            input_line = input_line.substring(5);
            int space1_ind = input_line.indexOf(" ");
            int num_moves = Integer.parseInt(input_line.substring(0, space1_ind));
            int from_ind = input_line.indexOf("f");
            String op_line = input_line.substring(from_ind+5);
            int space2_ind = op_line.indexOf(" ");
            String stack_name_from = op_line.substring(0, space2_ind);
            String stack_name_to = op_line.substring(space2_ind+4);

            Stack<String> stack_from = GetStackFromName(stack_name_from);
            Stack<String> stack_to = GetStackFromName(stack_name_to);
            
            // By using a temp stack we can keep the crates
            // in order for the Part 2 requirement.
            Stack<String> temp_stack = new Stack<String>();
            for (int i=0; i<num_moves; i++) {
                String popped_string = stack_from.pop();
                temp_stack.push(popped_string);
            }
            for (int i=0; i<num_moves; i++) {
                String popped_string = temp_stack.pop();
                stack_to.push(popped_string);
            }
        }

        RevealMessage();
    }

    // Used in Part 1
    public static void RevealMessage() {
        System.out.println(stack1.pop() + stack2.pop() + stack3.pop() + stack4.pop() + stack5.pop() + stack6.pop() + stack7.pop() + stack8.pop() + stack9.pop());
    }

    // Used in Part 1
    public static Stack<String> GetStackFromName(String name) {
        switch (name) {
            case "1":
                return stack1;
            case "2":
                return stack2;
            case "3":
                return stack3;
            case "4":
                return stack4;
            case "5":
                return stack5;
            case "6":
                return stack6;
            case "7":
                return stack7;
            case "8":
                return stack8;
            case "9":
                return stack9;
        }
        return null;
    }

    // Setup Stacks as defined by problem statement.
    public static void SetupStacks() {
        // Stack 1
        stack1.push("R");
        stack1.push("N");
        stack1.push("P");
        stack1.push("G");

        // Stack 2
        stack2.push("T");
        stack2.push("J");
        stack2.push("B");
        stack2.push("L");
        stack2.push("C");
        stack2.push("S");
        stack2.push("V");
        stack2.push("H");

        // Stack 3
        stack3.push("T");
        stack3.push("D");
        stack3.push("B");
        stack3.push("M");
        stack3.push("N");
        stack3.push("L");

        // Stack 4
        stack4.push("R");
        stack4.push("V");
        stack4.push("P");
        stack4.push("S");
        stack4.push("B");

        // Stack 5
        stack5.push("G");
        stack5.push("C");
        stack5.push("Q");
        stack5.push("S");
        stack5.push("W");
        stack5.push("M");
        stack5.push("V");
        stack5.push("H");

        // Stack 6
        stack6.push("W");
        stack6.push("Q");
        stack6.push("S");
        stack6.push("C");
        stack6.push("D");
        stack6.push("B");
        stack6.push("J");

        // Stack 7
        stack7.push("F");
        stack7.push("Q");
        stack7.push("L");

        // Stack 8
        stack8.push("W");
        stack8.push("M");
        stack8.push("H");
        stack8.push("T");
        stack8.push("D");
        stack8.push("L");
        stack8.push("F");
        stack8.push("V");

        // Stack 9
        stack9.push("L");
        stack9.push("P");
        stack9.push("B");
        stack9.push("V");
        stack9.push("M");
        stack9.push("J");
        stack9.push("F");
    }
}