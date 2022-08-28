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
}