package InterfaceManager;

import java.util.ArrayList;

public class OptionGroup {
    private ArrayList<Option> options;
     public OptionGroup(ArrayList<Option> options){
         this.options = options;
     }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void addOption(Option option){
         options.add(option);
    }
}
