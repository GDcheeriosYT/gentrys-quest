package InterfaceManager.GameInterfaces;

import InterfaceManager.*;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainMenuInterface extends Interface{
    static JSONObject settings;
    static OptionGroup optionGroup = new OptionGroup(new ArrayList<Option>(List.of(
            new Option("play"),
            new Option("settings"),
            new Option("changelog"),
            new Option("quit")
    )));

    public MainMenuInterface(JSONObject settings){
        super("Gentry's Quest", optionGroup, InputType.INT);
        this.settings = settings;
    }

    public void handleInput(int input){
        switch (input){
            case 1: {
                new PlayInterface().display();
            }
            case 2: {
                new SettingsInterface(settings).display();
            }
            case 4:
                System.exit(0);
        }
    }
}
