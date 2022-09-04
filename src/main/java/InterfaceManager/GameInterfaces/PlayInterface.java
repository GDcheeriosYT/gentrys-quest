package InterfaceManager.GameInterfaces;

import InterfaceManager.*;

import java.util.ArrayList;
import java.util.List;

public class PlayInterface extends Interface {
    static OptionGroup optionGroup = new OptionGroup(new ArrayList<Option>(List.of(
        new Option("travel"),
        new Option("gacha"),
        new Option("inventory")
    )));

    public PlayInterface(){
        super(
            "",
            optionGroup,
            InputType.INT
        );
    }

    public void handleInput(int input){
        switch(input){
            case 1: {

            }
        }
    }
}