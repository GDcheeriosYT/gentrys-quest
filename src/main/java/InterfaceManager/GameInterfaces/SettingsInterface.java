package InterfaceManager.GameInterfaces;

import InterfaceManager.*;
import Settings.*;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SettingsInterface {
    private Interface settingsInterface;
    private ToggleSetting debug;
    private ToggleSetting timeout;
    static OptionGroup optionGroup = new OptionGroup(new ArrayList<Option>(List.of(
        new Option("debug"),
        new Option("timeout"),
        new Option("back")
    )));

    public SettingsInterface(JSONObject settings){
        debug.setToggle(settings.getBoolean("debug"));
        timeout.setToggle(settings.getBoolean("timeout"));
        this.settingsInterface = new Interface(
        "settings",
                optionGroup,
                InputType.INT
        );
    }

    public void handleInput(int input) {
        switch(){
            
        }
    }
}