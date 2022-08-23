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

    public SettingsInterface(JSONObject settings){
        debug.setToggle(settings.getBoolean("debug"));
        timeout.setToggle(settings.getBoolean("timeout"));
    }

    public void show(){
        OptionGroup options = new OptionGroup(new ArrayList<Option>(List.of(
            new ToggleSetting("debug", debug.getToggled(), new Runnable() {
                @Override
                public void run() {
                    debug.toggleSetting();
                }
            }),
            timeout = new ToggleSetting("timeout", debug.getToggled(), new Runnable() {
                @Override
                public void run() {
                    timeout.toggleSetting();
                }
            }),
            new Option("back", new Runnable() {
                @Override
                public void run() {
                    MainMenuInterface
                }
            })
        )));
    }
}