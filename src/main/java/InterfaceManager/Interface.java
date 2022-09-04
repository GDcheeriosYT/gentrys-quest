package InterfaceManager;

import Input.InputManager;
import ConsoleMethods.ConsoleMethods;
import Settings.Setting;

import java.util.ArrayList;

public class Interface {
    private String interfaceInfo;
    private OptionGroup options;
    private ArrayList<Setting> settings;
    private InputType inputType;
    private boolean backIsDynamic;

    public Interface(String interfaceInfo, OptionGroup options, InputType inputType, boolean backIsDynamic){
        this.interfaceInfo = interfaceInfo;
        this.options = options;
        this.inputType = inputType;
        this.backIsDynamic = backIsDynamic;
    }

    public Interface(String interfaceInfo, ArrayList<Setting> settings, InputType inputType, boolean backIsDynamic){
        this.interfaceInfo = interfaceInfo;
        this.settings = settings;
        this.inputType = inputType;
        this.backIsDynamic = backIsDynamic;
    }

    public void display(){
        ConsoleMethods.clearConsole();
        System.out.println(interfaceInfo + "\n");
        if (options.getOptions().size() != 0){
            for (Option option: options.getOptions()){
                System.out.println((options.getOptions().indexOf(option) + 1) + ". " + option.getOptionName());
            }
            if(backIsDynamic) System.out.println((options.getOptions().size() + 1) + ". back");
        }
        else{
            for (Setting setting: settings){
                System.out.println((settings.indexOf(setting) + 1) + ". " + setting);
            }
            if(backIsDynamic) System.out.println((settings.size() + 1) + ". back");
        }
    }

    public OptionGroup getOptions() {
        return options;
    }

    public ArrayList<Setting> getSettings() {
        return settings;
    }
}