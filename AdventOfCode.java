import java.io.*;
import java.util.*;

class AdventOfCode {
    public static void main(String args[]) {
        List<String> input = InputHelpers.readInputToListString("inputs/" + args[0] + ".txt");
        Day2.day2(input);
    }
}