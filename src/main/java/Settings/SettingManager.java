package Settings;

import java.util.ArrayList;

public class SettingManager {
    private static ArrayList<Setting> storedSettings;

    public SettingManager(){
        //empty constructor lol
    }

    public ArrayList<Setting> getSettings() {
        return storedSettings;
    }

    public static void populateSettings(ArrayList<Setting> settings){
        storedSettings = settings;
    }
}
