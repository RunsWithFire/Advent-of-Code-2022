import java.io.*;
import java.util.*;

class InputHelpers {
    public static List<String> readInputToListString(String filename) {
        List<String> inputList = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                inputList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(filename + " not found!");
            e.printStackTrace();
        }

        return inputList;
    } 
}