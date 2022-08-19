package ConsoleMethods;

import Settings.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMethods {
    public static void timeout(int time, boolean clearConole) throws FileNotFoundException {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        if(clearConole) clearConsole();
    }

    public static void pressEnterToContinue(boolean clearConsole, boolean print){
        if(print) System.out.println("press enter to continue...");
        new Scanner(System.in).nextLine();
        if(clearConsole) clearConsole();
    }

    public static void clearConsole(){
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    public static int getMainMenuInput(String text, ArrayList<Integer> allowedInputs) throws FileNotFoundException {
        Scanner input = null;
        int output = 0;
        boolean goodInput = false;
        while(!goodInput){
            input = new Scanner(System.in);
            System.out.println(text);
            try{
                int scannerInput = input.nextInt();
                for(int input1: allowedInputs){
                    if(input1 == scannerInput){
                        output = input1;
                        goodInput = true;
                        break;
                    }
                }
            }
            catch (InputMismatchException e){
                clearConsole();
            }
        }
        return output;
    }

    public static ArrayList<Integer> rangeArrayListMaker(int min, int max) throws FileNotFoundException {
        ArrayList<Integer> rangeToReturn = new ArrayList<Integer>();
        if(max == Integer.MAX_VALUE) max = 10000;
        for(int i = min; i<=max; i++){
            rangeToReturn.add(i);
        }
        return rangeToReturn;
    }


    public static String getStringInput(String outputText){
        System.out.println(outputText);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
