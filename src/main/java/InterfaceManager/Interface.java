package InterfaceManager;

import Input.InputManager;
import ConsoleMethods.ConsoleMethods;

public class Interface {
    private String interfaceInfo;
    private OptionGroup options;
    private InputType inputType;

    public Interface(String interfaceInfo, OptionGroup options, InputType inputType){
        this.interfaceInfo = interfaceInfo;
        this.options = options;
        this.inputType = inputType;
    }

    public void display(){
        ConsoleMethods.clearConsole();
        System.out.println(interfaceInfo + "\n");
        for (Option option: options.getOptions()){
            System.out.println((options.getOptions().indexOf(option) + 1) + ". " + option.getOptionName());
        }
    }

    public OptionGroup getOptions() {
        return options;
    }
}