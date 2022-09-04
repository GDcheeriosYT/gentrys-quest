package InterfaceManager.GameInterfaces;

import InterfaceManager.*;
import Settings.*;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SettingsInterface extends Interface{

    public SettingsInterface(ArrayList<Setting> settings, ArrayList<Setting> ){
        super("settings", settings, InputType.INT, true);
    }

    public void handleInput(int input) {
        if(input < super.getSettings().size()){
            switch (super.getSettings().get(input - 1).getType()) {
                case NUMBER -> {
                }
                case STRING -> {
                }
                case TOGGLE -> {
                    super.getSettings().get(input - 1).toggleSetting();
                }
            }
        }
    }
}