package InterfaceManager.GameInterfaces;

import InterfaceManager.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenuInterface extends Interface{

    static OptionGroup optionGroup = new OptionGroup(new ArrayList<Option>(List.of(
            new Option("play", PlayInterface),
            new Option("settings", SettingsInterface),
            new Option("changelog", ChangelogInterface),
            new Option("quit", null)
    )));

    public MainMenuInterface(){
        super("Gentry's Quest", optionGroup, InputType.INT);
    }

    public Interface handleInput(int input){
        switch (input){
            case 1:
        }
    }
}
