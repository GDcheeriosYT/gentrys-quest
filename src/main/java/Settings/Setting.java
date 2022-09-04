package Settings;

import InterfaceManager.Option;
public class Setting{

    private String name;
    private SettingType type;

    public Setting(String name, SettingType type){
        this.name = name;
        this.type = type;
    }

    public void toggleSetting(){}

    public String getName() {
        return name;
    }

    public SettingType getType() {
        return type;
    }
}