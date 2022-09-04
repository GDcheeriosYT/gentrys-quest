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
    private PlayInterface playInterface = new PlayInterface();
    private SettingsInterface settingsInterface = new SettingsInterface();

    public MainMenuInterface(){
        super("Gentry's Quest", optionGroup, InputType.INT, false);
        this.settings = settings;
    }

    public void handleInput(int input){
        switch (input){
            case 1: {
                new PlayInterface().display();
            }
            case 2: {
                new SettingsInterface().display();
                settings.handleInput();
            }
            case 4:
                System.exit(0);
        }
    }
}
