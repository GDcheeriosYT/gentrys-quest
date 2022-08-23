package InterfaceManager;

import Input.InputManager;
import ConsoleMethods.ConsoleMethods;

public class Interface {
    private String interfaceInfo;
    private OptionGroup options;
    private boolean inputIsInt;

    public Interface(String interfaceInfo, OptionGroup options, boolean inputIsInt){
        this.interfaceInfo = interfaceInfo;
        this.options = options;
        this.inputIsInt = inputIsInt;
    }

    public void display(){
        ConsoleMethods.clearConsole();
        System.out.println(interfaceInfo + "\n");
        for (Option option: options.getOptions()){
            System.out.println((options.getOptions().indexOf(option) + 1) + ". " + option.getOptionName());
        }
        if(inputIsInt) options.getOptions().get(InputManager.getIntInput("\n", ConsoleMethods.rangeArrayListMaker(1, options.getOptions().size()))-1).runMethod();
        else InputManager.getStringInput("\n");
    }
}