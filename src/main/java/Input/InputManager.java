package Input;

import ConsoleMethods.ConsoleMethods;

import java.util.ArrayList;

public class InputManager {
    public InputManager(){
        //empty constructor lol
    }

    public static String getStringInput(String input){
        String inputString = ConsoleMethods.getStringInput(input);
        return inputString;
    }

    public static int getIntInput(String input, ArrayList<Integer> allowedInputs){
        int inputInt = ConsoleMethods.getIntInput(input, allowedInputs);
        return inputInt;
    }
}